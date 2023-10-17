import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TicketDto } from 'src/dtos';
import { TicketsTableRestService } from './tickets-table-rest.service';
import { MatDialog } from '@angular/material/dialog';
import { CreateTicketDialogComponent } from 'src/app/dialogs/create-ticket-dialog/create-ticket-dialog.component';

import { delay } from 'rxjs';
import { ConfirmDialogComponent } from 'src/app/dialogs/confirm-dialog/confirm-dialog.component';

@Component({
  selector: 'app-tickets-table',
  templateUrl: './tickets-table.component.html',
  styleUrls: ['./tickets-table.component.css']
})
export class TicketsTableComponent implements OnInit {

  @Input() projectId: number= 0;
  @Input() userEmail: string= "";
  @Input() forProject: boolean= false;
  @Input() forOtherUser: boolean= false;
  tickets: TicketDto[] = [];
  displayedColumns: string[] = ['detail','key', 'name', 'type' , 'createUser', 'assignee', 'createDate', 'deadline', 'projectName'];

  constructor(private ticketService: TicketsTableRestService,private router: Router, public dialog: MatDialog) { }

  ngOnChanges() {
    if(this.forOtherUser && this.userEmail!=undefined){
      this.ticketService.getTicketsForUser(this.userEmail).subscribe((response: TicketDto[])=> {
        this.tickets = response; 
      })
    }
  }

  ngOnInit(): void {
    if(this.forProject){
      this.ticketService.getTicketsForProject(this.projectId).subscribe((response: TicketDto[])=> {
        this.tickets = response; 
      })
    }else if (this.forOtherUser){
      this.ngOnChanges();
    }else {
      this.ticketService.getTicketsForOverview().subscribe((response: TicketDto[])=> {
        this.tickets = response; 
      })
    }
  }

  goToDetail(id: any){
    this.router.navigateByUrl("/TicketDetail", { state: id });
  }

  openCreateWindow(){
    const dialogRef = this.dialog.open(CreateTicketDialogComponent, {
      width: '50%'
    });

    dialogRef.afterClosed().subscribe(async result => {
      await delay(1000);
      this.ngOnInit();
    });
  }

  confirmAndDeleteTicket( id: number ): void {
    const dialogRef = this.dialog.open(ConfirmDialogComponent,{
      data: { 
        text: "Are you sure you want to delete this ticket?"
      }
    });
  
    dialogRef.afterClosed().subscribe(result => {
      if ( !!result ) {
        this.ticketService.deleteTicket(id).subscribe(()=> {
          this.ngOnInit();
        })
      }
    });
  }

}

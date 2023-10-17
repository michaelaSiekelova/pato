import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { TicketDto } from 'src/dtos';
import { CreateTicketDialogComponent } from '../../dialogs/create-ticket-dialog/create-ticket-dialog.component';
import { TicketDetailRestService } from './ticket-detail-rest.service';
import { ChooseUserDialogComponent } from 'src/app/dialogs/choose-user-dialog/choose-user-dialog.component';
import { UpdateDescriptionDialogComponent } from 'src/app/dialogs/update-description-dialog/update-description-dialog.component';
import { DatePickerComponent } from 'src/app/dialogs/date-picker/date-picker.component';
import { max } from 'rxjs';

@Component({
  selector: 'app-ticket-detail',
  templateUrl: './ticket-detail.component.html',
  styleUrls: ['./ticket-detail.component.css']
})
export class TicketDetailComponent implements OnInit {

  ticketId;
  ticket: TicketDto = new TicketDto();

  constructor(private router: Router,private ticketService: TicketDetailRestService,public dialog: MatDialog) {
    this.ticketId = Number(this.router.getCurrentNavigation()?.extras.state);
    if (this.ticketId==undefined || Number.isNaN(this.ticketId)){
        this.backToOverview();
    }
   }
   

  ngOnInit(): void {
    this.ticketService.getTicketById(Number(this.ticketId)).subscribe((response: TicketDto)=> {
      this.ticket = response; 
    })
  }

  backToOverview(): void{
    this.router.navigateByUrl("/Tickets");
  }


  openAssigneeDialog(){
    const dialogRef = this.dialog.open(ChooseUserDialogComponent, {
      data: { 
        projectId: 0,
        ticketId: this.ticketId,
        userForTicket:true,
        userForProject:false
      }
    });
    dialogRef.afterClosed().subscribe(result => {
      this.ngOnInit();
    });
  }

  openUpdateDescritionDialog(){
    const dialogRef = this.dialog.open(UpdateDescriptionDialogComponent, {
      data: { 
        ticketId: this.ticketId,
        description: this.ticket.description
      },
      width: '50%'
    });
    dialogRef.afterClosed().subscribe(result => {
      this.ngOnInit();
    });
  }

  openStartDateWindow(): void {
      const dialogRef = this.dialog.open(DatePickerComponent, {
        data: { 
          ticketStartDate: true,
          ticketEndDate: false,
          ticketDeadline:false,
          projectDeadline:false,
          minDate: undefined,
          maxDate:this.ticket.endDate,
          id:this.ticket.id
        }
      });
      dialogRef.afterClosed().subscribe(result => {
        this.ngOnInit();
      });
    }

    openDeadlineWindow(): void {
    
      const dialogRef = this.dialog.open(DatePickerComponent, {
        data: { 
          ticketStartDate: false,
          ticketEndDate: false,
          ticketDeadline:true,
          projectDeadline:false,
          minDate: this.ticket.endDate,
          maxDate: this.ticket.projectDeadline,
          id:this.ticket.id
        }
      });
      dialogRef.afterClosed().subscribe(result => {
        this.ngOnInit();
      });
    }

    openEndDateWindow(): void {
    
      const dialogRef = this.dialog.open(DatePickerComponent, {
        data: { 
          ticketStartDate: false,
          ticketEndDate: true,
          ticketDeadline:false,
          projectDeadline:false,
          minDate: this.ticket.startDate,
          maxDate: this.ticket.deadline,
          id:this.ticket.id
        }
      });
      dialogRef.afterClosed().subscribe(result => {
        this.ngOnInit();
      });
    }


}

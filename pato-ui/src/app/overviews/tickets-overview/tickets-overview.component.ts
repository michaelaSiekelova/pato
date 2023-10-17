import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CreateTicketDialogComponent } from 'src/app/dialogs/create-ticket-dialog/create-ticket-dialog.component';

@Component({
  selector: 'app-tickets-overview',
  templateUrl: './tickets-overview.component.html',
  styleUrls: ['./tickets-overview.component.css']
})
export class TicketsOverviewComponent implements OnInit {

  constructor(public dialog: MatDialog) { }

  ngOnInit(): void {
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(CreateTicketDialogComponent, {
    });

    dialogRef.afterClosed().subscribe(result => {
      this.ngOnInit();
    });
  }

}

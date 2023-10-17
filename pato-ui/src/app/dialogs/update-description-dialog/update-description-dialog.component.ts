import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { FormBuilder, FormGroup } from '@angular/forms';
import { TicketDto } from 'src/dtos';
import { UpdateDescriptionDialogRestService } from './update-description-dialog-rest.service';

@Component({
  selector: 'app-update-description-dialog',
  templateUrl: './update-description-dialog.component.html',
  styleUrls: ['./update-description-dialog.component.css']
})
export class UpdateDescriptionDialogComponent implements OnInit {

  ticket:TicketDto = new TicketDto();
  form: FormGroup;

  constructor(fb: FormBuilder,private dialogRef: MatDialogRef<UpdateDescriptionDialogComponent> , @Inject(MAT_DIALOG_DATA) public data: any,  private dialogService: UpdateDescriptionDialogRestService) {
    this.ticket.id = this.data.ticketId;
    this.ticket.description = this.data.description;
    this.form = fb.group({
      description : [this.ticket.description]
    })
   }

  ngOnInit(): void {
  }

  saveDialog(){
    const {value, valid} = this.form;
    this.updateModel();
    this.dialogService.updateTicketDescription(this.ticket).subscribe();
    this.dialogRef.close(value); 
  }

  private updateModel(){
    Object.assign(this.ticket, this.form.value)
  }

}

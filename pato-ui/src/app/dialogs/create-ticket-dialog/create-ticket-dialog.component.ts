import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ProjectForSelect, TicketPostDto } from 'src/dtos';
import { CreateTicketDialogRestService } from './create-ticket-dialog-rest.service';

@Component({
  selector: 'app-create-ticket-dialog',
  templateUrl: './create-ticket-dialog.component.html',
  styleUrls: ['./create-ticket-dialog.component.css']
})
export class CreateTicketDialogComponent implements OnInit {

  newTicket: TicketPostDto;
  projects: ProjectForSelect[] = [];
  ticketTypes: string[] = [];
  form: FormGroup;

  constructor(private dialogRef: MatDialogRef<CreateTicketDialogComponent>, @Inject(MAT_DIALOG_DATA) public ticket: TicketPostDto, private dialogService: CreateTicketDialogRestService, fb: FormBuilder) {
    this.newTicket = new TicketPostDto();
    this.form = fb.group({
      name : [this.newTicket.name, [Validators.required, Validators.maxLength(50)]],
      description : [this.newTicket.description, [Validators.required]],
      type : [this.newTicket.type, [Validators.required]],
      projectId : [this.newTicket.projectId,[Validators.required]],
      deadline : [this.newTicket.deadline]
      })
  }

  ngOnInit(): void {
    this.dialogService.getUserProjectsForSelect().subscribe((response: ProjectForSelect[])=> {
      this.projects = response; 
    })
    this.dialogService.getTicketTypesForSelect().subscribe((response: string[])=> {
      this.ticketTypes = response; 
    })
  }

  saveDialog(){
    const {value, valid} = this.form;
    if(valid){
      this.updateModel();
      this.dialogService.createTicket(this.newTicket).subscribe();
      this.dialogRef.close(value);             
    } 
  }

  private updateModel(){
    Object.assign(this.newTicket, this.form.value)
    //this.newTicket= this.form.value;
    console.log(this.newTicket.name);
    console.log(this.newTicket.description);
    console.log(this.newTicket.type);
    console.log(this.newTicket.deadline);
    console.log(this.newTicket.projectId);
  }


 
}

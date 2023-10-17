import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { CreateTaskDialogRestService } from './create-task-dialog-rest.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TaskDto } from 'src/dtos';

@Component({
  selector: 'app-create-task-dialog',
  templateUrl: './create-task-dialog.component.html',
  styleUrls: ['./create-task-dialog.component.css']
})
export class CreateTaskDialogComponent implements OnInit {
  ticketId:number;
  task: TaskDto;
  form: FormGroup;

  constructor(private dialogRef: MatDialogRef<CreateTaskDialogComponent>, @Inject(MAT_DIALOG_DATA) public data: any, private dialogService: CreateTaskDialogRestService, fb: FormBuilder ) { 
    this.ticketId = this.data.ticketId;
    this.task = new TaskDto();
    this.form = fb.group({
      description : [this.task.description, Validators.required]
      })
  }

  ngOnInit(): void {
  }

  saveDialog(){
    const {value, valid} = this.form;
    this.updateModel();
    this.task.ticketId = this.ticketId;
    this.dialogService.createTask(this.task).subscribe();
    this.dialogRef.close(value); 
  }

  private updateModel(){
    Object.assign(this.task, this.form.value)
  }

}

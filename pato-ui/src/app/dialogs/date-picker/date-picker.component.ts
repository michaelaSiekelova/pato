import { Component, Inject, OnInit } from '@angular/core';
import { DatePickerRestService } from './date-picker-rest.service';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { DateAndId } from 'src/dtos';
import { formatDate } from '@angular/common';

@Component({
  selector: 'app-date-picker',
  templateUrl: './date-picker.component.html',
  styleUrls: ['./date-picker.component.css']
})
export class DatePickerComponent implements OnInit {
  ticketStartDate: boolean = false;
  ticketEndDate: boolean = false;
  ticketDeadline: boolean = false;
  projectDeadline: boolean = false;
  id:number= 0;
  form: FormGroup;
  minDate: Date;
  maxDate: Date;
  constructor(fb: FormBuilder,private dialogRef: MatDialogRef<DatePickerComponent> , @Inject(MAT_DIALOG_DATA) public data: any,  private dialogService: DatePickerRestService) { 
    this.ticketDeadline=this.data.ticketDeadline;
    this.ticketEndDate=this.data.ticketEndDate;
    this.ticketStartDate=this.data.ticketStartDate;
    this.projectDeadline=this.data.projectDeadline;
    this.id = this.data.id;
    this.form = fb.group({
      date:  new Date()
    }) 
    this.minDate = this.data.minDate;
    this.maxDate = this.data.maxDate;
  }

  ngOnInit(): void {
    console.log(this.minDate?.toLocaleString());
    console.log(this.maxDate?.toLocaleString());
  }

  saveDialog(){
      if (this.projectDeadline){
        this.dialogService.saveProjectDeadline(this.dataToModel()).subscribe();
      }else if (this.ticketStartDate){
        this.dialogService.saveStartDate(this.dataToModel()).subscribe();
      }else if (this.ticketEndDate){
        this.dialogService.saveEndDate(this.dataToModel()).subscribe();
      }else if (this.ticketDeadline){
        this.dialogService.saveDeadline(this.dataToModel()).subscribe();
      }
      this.dialogRef.close();             
    } 
  


  private dataToModel(): DateAndId{
    return new DateAndId(this.id, this.form?.get('date')?.value);
  }

}

import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { UserDto, UserForChoosePostDto } from 'src/dtos';
import { ChooseUserDialogRestService } from './choose-user-dialog-rest.service';

@Component({
  selector: 'app-choose-user-dialog',
  templateUrl: './choose-user-dialog.component.html',
  styleUrls: ['./choose-user-dialog.component.css']
})
export class ChooseUserDialogComponent implements OnInit {
  userForProject: boolean= false;
  userForTicket: boolean= false;
  ticketId: number= 0;
  projectId: number= 0;
  form: FormGroup;
  selectedUser:UserDto = new UserDto();
  users: UserDto[]=[];
  userDto: UserForChoosePostDto;


  constructor(fb: FormBuilder,private dialogRef: MatDialogRef<ChooseUserDialogComponent> , @Inject(MAT_DIALOG_DATA) public data: any,  private dialogService: ChooseUserDialogRestService) {
    this.userDto = new UserForChoosePostDto();
    this.projectId = this.data.projectId;
    this.ticketId = this.data.ticketId;
    this.userForProject = this.data.userForProject;
    this.userForTicket = this.data.userForTicket;
    this.form = fb.group({
      email : [this.userDto.email],
      name : [this.userDto.name]
    }) 
  }

  ngOnInit(): void {
    if (this.userForTicket){
      this.dialogService.getUsersForTicketToChoose(this.ticketId).subscribe((response: UserDto[])=> {
        this.users = response; 
      })
    }else if (this.userForProject){
      this.dialogService.getUsersForProjectToChoose(this.projectId).subscribe((response: UserDto[])=> {
        this.users = response; 
      })
    }
    
  }

  saveDialog(){
    const {value, valid} = this.form;
    if(valid){
      this.updateModel();
      if (this.userForTicket){
        this.userDto.ticketId=this.ticketId;
        this.dialogService.addUserForTicket(this.userDto).subscribe();
      }else if (this.userForProject){
        this.userDto.projectId = this.projectId;
        this.dialogService.addUserForProject(this.userDto).subscribe();
      }
      this.dialogRef.close(value);             
    } 
  }

  private updateModel(){
    Object.assign(this.userDto, this.form.value)
  }

}

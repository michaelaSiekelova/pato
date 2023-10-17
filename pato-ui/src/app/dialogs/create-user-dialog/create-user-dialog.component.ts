import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { UserPostDto } from 'src/dtos';
import { CreateUserDialogRestService } from './create-user-dialog-rest.service';

@Component({
  selector: 'app-create-user-dialog',
  templateUrl: './create-user-dialog.component.html',
  styleUrls: ['./create-user-dialog.component.css']
})
export class CreateUserDialogComponent implements OnInit {

  form: FormGroup;
  newUser: UserPostDto;
  hide = true;

  constructor(private dialogRef: MatDialogRef<CreateUserDialogComponent>, @Inject(MAT_DIALOG_DATA) public ticket: UserPostDto, private dialogService: CreateUserDialogRestService, fb: FormBuilder) { 
    this.newUser = new UserPostDto();
    this.form = fb.group({
      name : [this.newUser.name, [Validators.required, Validators.maxLength(25)]],
      password : [this.newUser.password, [Validators.required]],
      email : [this.newUser.email, [Validators.required, Validators.email]]
      })
  }

  ngOnInit(): void {
  }

  saveDialog(){
    const {value, valid} = this.form;
    if(valid){
      this.updateModel();
      this.dialogService.createUser(this.newUser).subscribe();
      this.dialogRef.close(value);             
    } 
  }

  private updateModel(){
    Object.assign(this.newUser, this.form.value)
    console.log(this.newUser.name);
    console.log(this.newUser.password);
    console.log(this.newUser.email);
  }

}

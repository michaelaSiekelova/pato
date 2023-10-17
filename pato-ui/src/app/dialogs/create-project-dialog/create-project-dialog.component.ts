import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ProjectDto } from 'src/dtos';
import { CreateProjectDialogRestService } from './create-project-dialog-rest.service';

@Component({
  selector: 'app-create-project-dialog',
  templateUrl: './create-project-dialog.component.html',
  styleUrls: ['./create-project-dialog.component.css']
})
export class CreateProjectDialogComponent implements OnInit {

  project: ProjectDto;
  form: FormGroup;
  minDate: Date;

  constructor(private dialogRef: MatDialogRef<CreateProjectDialogComponent>, @Inject(MAT_DIALOG_DATA) public projectData: ProjectDto, private dialogService: CreateProjectDialogRestService, fb: FormBuilder) {
    this.project = new ProjectDto();
    const currentYear = new Date().getFullYear();
    this.minDate = new Date();
    this.form = fb.group({
      name : [this.project.name, [Validators.required, Validators.maxLength(50)]],
      shortcut : [this.project.shortcut, [Validators.required, Validators.maxLength(10)]],
      deadline : [this.project.deadline]
      })
  }

  ngOnInit(): void {
  }

  saveDialog(){
    const {value, valid} = this.form;
    if(valid){
      this.updateModel();
      this.dialogService.createProject(this.project).subscribe();
      this.dialogRef.close(value);             
    } 
  }

  private updateModel(){
    Object.assign(this.project, this.form.value)
  }

}

import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { AttributeDto } from 'src/dtos';
import { CreateAttributeDialogRestService } from './create-attribute-dialog-rest.service';

@Component({
  selector: 'app-create-attribute-dialog',
  templateUrl: './create-attribute-dialog.component.html',
  styleUrls: ['./create-attribute-dialog.component.css']
})
export class CreateAttributeDialogComponent implements OnInit {

  attribute: AttributeDto;
  form: FormGroup;
  types: String[]=[];
  projectId: number;

  constructor(private dialogRef: MatDialogRef<CreateAttributeDialogComponent>, @Inject(MAT_DIALOG_DATA) public data: any, 
  private dialogService: CreateAttributeDialogRestService, fb: FormBuilder) {
    this.attribute = new AttributeDto();
    this.projectId = this.data.projectId;
    this.form = fb.group({
      name : [this.attribute.name, Validators.required],
      type : [this.attribute.type, Validators.required]
      })
  }

  ngOnInit(): void {
    
    this.dialogService.getAttributeTypes().subscribe((response: String[])=> {
      this.types = response; 
    })
  }

  saveDialog(){
    const {value, valid} = this.form;
    if(valid){
      this.updateModel();
      this.attribute.projectId = this.projectId;
      console.log(this.projectId);
      this.dialogService.createAttribute(this.attribute).subscribe();
      this.dialogRef.close(value);             
    } 
  }

  private updateModel(){
    Object.assign(this.attribute, this.form.value)
  }

}

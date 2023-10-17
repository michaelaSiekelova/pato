import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { AttributeDto, AttributeValueDto } from 'src/dtos';
import { CreateAttributeValueDialogRestService } from './create-attribute-value-dialog-rest.service';

@Component({
  selector: 'app-create-attribute-value-dialog',
  templateUrl: './create-attribute-value-dialog.component.html',
  styleUrls: ['./create-attribute-value-dialog.component.css']
})
export class CreateAttributeValueDialogComponent implements OnInit {

  attributeValue: AttributeValueDto;
  form: FormGroup;
  types: String[]=[];
  projectId: number;
  ticketId:number;
  attributes: AttributeDto[]=[];
  selectedAttribute:AttributeDto = new AttributeDto;

  constructor(private dialogRef: MatDialogRef<CreateAttributeValueDialogComponent>, @Inject(MAT_DIALOG_DATA) public data: any, 
                                                                private dialogService: CreateAttributeValueDialogRestService, fb: FormBuilder) {
    this.attributeValue = new AttributeValueDto();
    this.projectId = this.data.projectId;
    this.ticketId = this.data.ticketId;
    
    this.form = fb.group({
      dateValue : [this.attributeValue.dateValue],
      numberValue : [this.attributeValue.numberValue],
      stringValue : [this.attributeValue.stringValue],
      attribute : [this.selectedAttribute, Validators.required]
      })
    this.form.controls['stringValue'].disable();
    this.form.controls['numberValue'].disable();
    this.form.controls['dateValue'].disable();
   }

  ngOnInit(): void {
    this.dialogService.getAttributesForProject(this.projectId).subscribe((response: AttributeDto[])=> {
      this.attributes = response; 
    })
    for (let entry of this.attributes) {
      console.log(entry.name); 
    }
    this.dialogService.getAttributeTypes().subscribe((response: String[])=> {
      this.types = response; 
    })
  }

  saveDialog(){
    const {value, valid} = this.form;
    if(valid){
      this.updateModel();
      this.attributeValue.ticketId = this.ticketId;
      this.attributeValue.attributeId = this.selectedAttribute.id;
      this.dialogService.createAttributeValue(this.attributeValue).subscribe();
      this.dialogRef.close(value);             
    } 
  }

  private updateModel(){
    Object.assign(this.attributeValue, this.form.value)
  }

  onSelectionChange() {
    this.selectedAttribute = this.form.controls['attribute'].getRawValue();
    this.form.controls['dateValue'].reset();
    this.form.controls['numberValue'].reset();
    this.form.controls['stringValue'].reset();
    switch(this.selectedAttribute.type){
      case 'STRING':
        this.form.controls['dateValue'].disable();
        this.form.controls['numberValue'].disable();
        this.form.controls['stringValue'].enable();
        break;
      case 'FLOAT':
        this.form.controls['dateValue'].disable();
        this.form.controls['numberValue'].enable();
        this.form.controls['stringValue'].disable();
        break;
      case 'DATE':
        this.form.controls['dateValue'].enable();
        this.form.controls['numberValue'].disable();
        this.form.controls['stringValue'].disable();
        break;
    }
  }

}

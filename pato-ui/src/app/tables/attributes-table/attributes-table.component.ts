import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CreateAttributeDialogComponent } from 'src/app/dialogs/create-attribute-dialog/create-attribute-dialog.component';
import { AttributeDto } from 'src/dtos';
import { AttributesTableRestService } from './attributes-table-rest.service';

@Component({
  selector: 'app-attributes-table',
  templateUrl: './attributes-table.component.html',
  styleUrls: ['./attributes-table.component.css']
})
export class AttributesTableComponent implements OnInit {

  @Input() projectId: number = 0;
  attributes: AttributeDto[]=[];
  displayedColumns = ['delete', 'name', 'type']

  constructor(private attributeService: AttributesTableRestService, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.refresh();
  }

  deleteItem(attributeId:number){
    this.attributeService.deleteAttribute(attributeId).subscribe(()=>this.refresh());
    
  }

  openCreateWindow(){
    const dialogRef = this.dialog.open(CreateAttributeDialogComponent, {
      data: { projectId: this.projectId },
    });

    dialogRef.afterClosed().subscribe(result => {
      this.refresh();
    });
  }

  refresh(){
    this.attributeService.getAttributesForProject(this.projectId).subscribe((response: AttributeDto[])=> {
      this.attributes = response; 
      console.log('response : ' + response.length);
      console.log('this.attributes : ' + this.attributes.length);
    })
    console.log('atributy : ' + this.attributes.length);
  }

}

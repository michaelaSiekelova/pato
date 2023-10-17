import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CreateAttributeValueDialogComponent } from 'src/app/dialogs/create-attribute-value-dialog/create-attribute-value-dialog.component';
import { AttributeValueDto } from 'src/dtos';
import { AttributeValuesTableRestService } from './attribute-values-table-rest.service';

@Component({
  selector: 'app-attribute-values-table',
  templateUrl: './attribute-values-table.component.html',
  styleUrls: ['./attribute-values-table.component.css']
})
export class AttributeValuesTableComponent implements OnInit {
  @Input() ticketId: number = 0;
  @Input() projectId: number = 0;
  attributeValues: AttributeValueDto[]=[];
  displayedColumns = ['delete', 'name', 'value'];

  constructor(private attributeService: AttributeValuesTableRestService, public dialog: MatDialog) { }

  ngOnChanges(){
    if (this.ticketId!=undefined && !Number.isNaN(this.ticketId)){
      this.attributeService.getAttributeValuesForTicket(this.ticketId).subscribe((response: AttributeValueDto[])=> {
        this.attributeValues = response; 
      })
    }
  }

  ngOnInit(): void {
    
  }

  deleteItem(attributeId:number){
    this.attributeService.deleteAttribute(attributeId).subscribe(()=>this.ngOnChanges());
  }

  openCreateWindow(){
    const dialogRef = this.dialog.open(CreateAttributeValueDialogComponent, {
      data: { ticketId: this.ticketId, projectId: this.projectId },
    });

    dialogRef.afterClosed().subscribe(result => {
      this.ngOnChanges();
    });
  }

}

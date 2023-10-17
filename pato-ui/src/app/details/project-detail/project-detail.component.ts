import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { CreateProjectDialogComponent } from 'src/app/dialogs/create-project-dialog/create-project-dialog.component';
import { ProjectDto } from 'src/dtos';
import { ProjectDetailRestService } from './project-detail-rest.service';
import { DatePickerComponent } from 'src/app/dialogs/date-picker/date-picker.component';

@Component({
  selector: 'app-project-detail',
  templateUrl: './project-detail.component.html',
  styleUrls: ['./project-detail.component.css']
})
export class ProjectDetailComponent implements OnInit {

  projectId: number;
  project: ProjectDto = new ProjectDto();

  constructor(private router: Router,public dialog: MatDialog , private projectService : ProjectDetailRestService) {
    this.projectId = Number(this.router.getCurrentNavigation()?.extras.state);
    if (this.projectId==undefined || Number.isNaN(this.projectId)){
        this.backToOverview();
    }
   }

  ngOnInit(): void {
    this.projectService.getProjectById(Number(this.projectId)).subscribe((response: ProjectDto)=> {
      this.project = response; 
    })
    console.info("project name after init is: " + this.project.name);
  }

  backToOverview(): void{
    this.router.navigateByUrl("/Projects");
  }

  openDialog(){
    const dialogRef = this.dialog.open(CreateProjectDialogComponent, {
      data: { ticketId: this.projectId },
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

  openDeadlineWindow(): void {
    
    const dialogRef = this.dialog.open(DatePickerComponent, {
      data: { 
        ticketStartDate: false,
        ticketEndDate: false,
        ticketDeadline:false,
        projectDeadline:true,
        minDate: undefined,
        maxDate: undefined,
        id:this.project.id
      }
    });
    dialogRef.afterClosed().subscribe(result => {
      this.ngOnInit();
    });
  }

}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProjectDto } from 'src/dtos';
import { ProjectsTableRestService } from './projects-table-rest.service';
import { CreateProjectDialogComponent } from 'src/app/dialogs/create-project-dialog/create-project-dialog.component';
import { MatDialog } from '@angular/material/dialog';
import { delay } from 'rxjs';
import { ConfirmDialogComponent } from 'src/app/dialogs/confirm-dialog/confirm-dialog.component';

@Component({
  selector: 'app-projects-table',
  templateUrl: './projects-table.component.html',
  styleUrls: ['./projects-table.component.css']
})
export class ProjectsTableComponent implements OnInit {

  projects: ProjectDto[] = [];
  displayedColumns: string[] = ['detail','name', 'shortcut', 'deadline'];

  constructor(private projectService: ProjectsTableRestService,private router: Router, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.projectService.getUserProjects().subscribe((response: ProjectDto[])=> {
      this.projects = response; 
    })
  }

  goToDetail(id: any){
    this.router.navigateByUrl("/ProjectDetail", { state: id });
  }

  openCreateWindow(){
    const dialogRef = this.dialog.open(CreateProjectDialogComponent, {
    });

    dialogRef.afterClosed().subscribe(async result => {
      await delay(1000);
      this.ngOnInit();
    });
  }

  confirmAndDeleteProject( id: number ): void {
    const dialogRef = this.dialog.open(ConfirmDialogComponent,{
      data: { 
        text: "Are you sure you want to delete this project?"
      }
    });
  
    dialogRef.afterClosed().subscribe(result => {
      if ( !!result ) {
        this.projectService.deleteProject(id).subscribe(()=> {
          this.ngOnInit();
        })
      }
    });
  }

}

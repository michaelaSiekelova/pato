import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CreateUserDialogComponent } from 'src/app/dialogs/create-user-dialog/create-user-dialog.component';
import { ProjectLightDto } from 'src/dtos';
import { UsersOverviewRestService } from './users-overview-rest.service';

@Component({
  selector: 'app-users-overview',
  templateUrl: './users-overview.component.html',
  styleUrls: ['./users-overview.component.css']
})
export class UsersOverviewComponent implements OnInit {

  projects: ProjectLightDto[] = [];
  

  constructor(private userOverviewService: UsersOverviewRestService, public dialog: MatDialog) {
    console.log('calling constructor')
   }

  ngOnInit(): void {
    this.userOverviewService.getUserProjectsIds().subscribe((response: ProjectLightDto[])=> {
      this.projects = response; 
    },
    (error: any) => {                              //error() callback
      console.error('Request failed with error');
      console.error(error)
    },
    () => {                                   //complete() callback
      console.error('Request completed')
    })
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(CreateUserDialogComponent, {
    });

    dialogRef.afterClosed().subscribe(result => {
      this.ngOnInit();
    });
  }

}

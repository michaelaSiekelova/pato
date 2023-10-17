import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserDto } from 'src/dtos';
import { UsersTableRestService } from './users-table-rest.service';
import { CreateUserDialogComponent } from 'src/app/dialogs/create-user-dialog/create-user-dialog.component';
import { MatDialog } from '@angular/material/dialog';
import { ChooseUserDialogComponent } from 'src/app/dialogs/choose-user-dialog/choose-user-dialog.component';
import { delay } from 'rxjs';

@Component({
  selector: 'app-users-table',
  templateUrl: './users-table.component.html',
  styleUrls: ['./users-table.component.css']
})
export class UsersTableComponent implements OnInit {

  users:UserDto[] = [];
  displayedColumns: string[] = ['detail','name', 'email'];
  @Input() projectId: number=0;
  @Input() usersInProject: boolean=false;

  constructor(private userService:UsersTableRestService, private router: Router, public dialog: MatDialog) { }

  ngOnInit(): void {
    if (this.usersInProject){
      this.getUsersForProject();
    }else{
      this.getUsersForOverview();
    }
  }

  private getUsersForProject():void{
    this.userService.getUsersForProject(this.projectId).subscribe((response: UserDto[])=> {
      this.users = response; 
    },
    (error: any) => {                              //error() callback
      console.error('Request failed with error');
      console.error(error)
    },
    () => {                                   //complete() callback
      console.info('Request completed')
    })
  }

  private getUsersForOverview():void{
    this.userService.getUsersForOverview().subscribe((response: UserDto[])=> {
      this.users = response; 
    },
    (error: any) => {                              //error() callback
      console.error('Request failed with error');
      console.error(error)
    },
    () => {                                   //complete() callback
      console.info('Request completed')
    })
  }

  goToDetail(id: any){
    this.router.navigateByUrl("/UserDetail", { state: id });
  }

  openCreateWindow(): void {
    if (this.usersInProject){
      const dialogRef = this.dialog.open(ChooseUserDialogComponent, {
        data: { 
          projectId: this.projectId,
          ticketId: 0,
          userForTicket:false,
          userForProject:true
        }
      });
      dialogRef.afterClosed().subscribe(async result => {
        await delay(1000);
        this.ngOnInit();
      });
    }else {
      const dialogRef = this.dialog.open(CreateUserDialogComponent, {
      });
      dialogRef.afterClosed().subscribe(async result => {
        await delay(1000);
        this.ngOnInit();
      });
    }
  }

}

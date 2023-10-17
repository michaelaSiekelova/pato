import { Component, Input, OnInit } from '@angular/core';
import { TaskDto } from 'src/dtos';
import { TasksTableRestService } from './tasks-table-rest.service';
import { MatDialog } from '@angular/material/dialog';
import { CreateTaskDialogComponent } from 'src/app/dialogs/create-task-dialog/create-task-dialog.component';

@Component({
  selector: 'app-tasks-table',
  templateUrl: './tasks-table.component.html',
  styleUrls: ['./tasks-table.component.css']
})
export class TasksTableComponent implements OnInit {

  @Input() ticketId: number = 0;
  tasks:TaskDto[] = [];

  constructor(private taskService:TasksTableRestService, public dialog: MatDialog) { }

  ngOnChanges() {
    if(this.ticketId!=undefined && !Number.isNaN(this.ticketId)){
    this.taskService.getTasksForTicket(this.ticketId).subscribe((response: TaskDto[])=> {
      this.tasks = response; 
    })
  }
  }

  ngOnInit(): void {}

  taskChange(task:TaskDto){
    this.taskService.changeTaskCheck(task).subscribe();
  }

  deleteItem(task:TaskDto){
    this.taskService.deleteTask(task).subscribe(result => {
      this.ngOnChanges();
  });
  }

  openCreateWindow(){
    const dialogRef = this.dialog.open(CreateTaskDialogComponent, {
      data: { ticketId: this.ticketId},
    });

    dialogRef.afterClosed().subscribe(result => {
      this.ngOnChanges();
    });
  }

}

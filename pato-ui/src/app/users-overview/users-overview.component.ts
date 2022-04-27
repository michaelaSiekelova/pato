import { Component, OnInit } from '@angular/core';
import { ProjectLightDto } from 'src/dtos';
import { UsersOverviewRestService } from './users-overview-rest.service';

@Component({
  selector: 'app-users-overview',
  templateUrl: './users-overview.component.html',
  styleUrls: ['./users-overview.component.css']
})
export class UsersOverviewComponent implements OnInit {

  projects: ProjectLightDto[] = [];
  

  constructor(private userOverviewService: UsersOverviewRestService) {
    console.log('calling constructor')
   }

  ngOnInit(): void {
    console.log('calling oninit')
    this.userOverviewService.getUserProjectsIds().subscribe((response: ProjectLightDto[])=> {                           //next() callback
      console.log('response received')
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

}

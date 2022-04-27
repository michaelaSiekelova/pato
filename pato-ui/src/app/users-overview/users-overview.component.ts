import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { OAuthService } from 'angular-oauth2-oidc';
import { ProjectLightDto } from 'src/dtos';
import { KeycloakService } from '../keycloak.service';
import { UsersOverviewRestService } from './users-overview-rest.service';

@Component({
  selector: 'app-users-overview',
  templateUrl: './users-overview.component.html',
  styleUrls: ['./users-overview.component.css']
})
export class UsersOverviewComponent implements OnInit {

  projects: ProjectLightDto[] = [];
  
  

  constructor(private userOverviewService: UsersOverviewRestService, private auth: KeycloakService) {
    console.log('calling constructor')
   }

  ngOnInit(): void {
    console.log('calling oninit');
    const token = this.auth.getAuthToken();
    console.log(token);
    const headers = new HttpHeaders({'Authorization': `Bearer ${token}`});
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

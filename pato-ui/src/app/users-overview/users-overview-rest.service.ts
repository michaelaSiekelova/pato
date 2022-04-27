import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { OAuthService } from 'angular-oauth2-oidc';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsersOverviewRestService {

  baseURL: string = "http://localhost:8080";

  constructor( private http: HttpClient, private oauth: OAuthService ) { }

  getUserProjectsIds() : Observable<any>{
    console.log('calling getUserProjectsIds');
    const token = this.oauth.authorizationHeader();
    console.log(token);
    return this.http.get(this.baseURL + '/api/projectManagement/project/projectIdsByCurrentUser');
  }
}

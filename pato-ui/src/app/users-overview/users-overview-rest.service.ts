import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsersOverviewRestService {

  baseURL: string = "http://localhost:8080";

  constructor( private http: HttpClient ) { }

  getUserProjectsIds() : Observable<any>{
    console.log('calling getUserProjectsIds')
    return this.http.get(this.baseURL + '/api/projectManagement/project/projectIdsByCurrentUser');
  }
}

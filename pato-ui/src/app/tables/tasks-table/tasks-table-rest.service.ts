import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { Observable } from 'rxjs';
import { TaskDto } from 'src/dtos';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TasksTableRestService {

  private baseURL: string = environment.API_URL;

  constructor( private _http: HttpClient, private kc: KeycloakService ) { }

  getTasksForTicket(ticketId: number): Observable<any>{
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.kc.addTokenToHeader(headers)
    return this._http.post(this.baseURL + 'ticketManagement/task/tasksForTicket',ticketId, {headers:headers});
  }

  changeTaskCheck(task: TaskDto){
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.kc.addTokenToHeader(headers)
    return this._http.post(this.baseURL + 'ticketManagement/task/check',task, {headers:headers});
  }

  deleteTask(task: TaskDto){
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.kc.addTokenToHeader(headers)
    return this._http.post(this.baseURL + 'ticketManagement/task/delete',task, {headers:headers});
  }
}

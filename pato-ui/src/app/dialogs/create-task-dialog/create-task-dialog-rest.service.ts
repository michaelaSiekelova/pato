import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { TaskDto } from 'src/dtos';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CreateTaskDialogRestService {

  private baseURL: string = environment.API_URL;

  constructor( private _http: HttpClient, private kc: KeycloakService ) { }

  createTask(task:TaskDto){
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.kc.addTokenToHeader(headers)
    return this._http.post(this.baseURL + 'ticketManagement/task/create', task, {headers:headers});
  }
}

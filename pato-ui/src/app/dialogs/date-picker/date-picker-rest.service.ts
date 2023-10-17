import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { DateAndId } from 'src/dtos';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DatePickerRestService {
  private baseURL: string = environment.API_URL;

  constructor( private _http: HttpClient, private kc: KeycloakService ) { }

  saveStartDate(model:DateAndId){
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.kc.addTokenToHeader(headers)
    return this._http.post(this.baseURL + 'ticketManagement/ticket/startDate', model, {headers:headers});
  }

  saveDeadline(model:DateAndId){
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.kc.addTokenToHeader(headers)
    return this._http.post(this.baseURL + 'ticketManagement/ticket/deadline', model, {headers:headers});
  }

  saveEndDate(model:DateAndId){
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.kc.addTokenToHeader(headers)
    return this._http.post(this.baseURL + 'ticketManagement/ticket/endDate', model, {headers:headers});
  }

  saveProjectDeadline(model:DateAndId){
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.kc.addTokenToHeader(headers)
    return this._http.post(this.baseURL + 'projectManagement/project/deadline', model, {headers:headers});
  }
}

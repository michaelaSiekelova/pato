import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TicketsTableRestService {
  private baseURL: string = environment.API_URL;

  constructor( private _http: HttpClient, private kc: KeycloakService ) { }

  getTicketsForOverview() : Observable<any>{
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.kc.addTokenToHeader(headers)
    return this._http.get(this.baseURL + 'ticketManagement/ticket/ticketsForUser', {headers:headers});
  }

  getTicketsForUser(userEmail: string) : Observable<any>{
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.kc.addTokenToHeader(headers)
    return this._http.post(this.baseURL + 'ticketManagement/ticket/ticketsForUser',userEmail, {headers:headers});
  }

  getTicketsForProject(projectId: number) : Observable<any>{
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.kc.addTokenToHeader(headers)
    return this._http.post(this.baseURL + 'ticketManagement/ticket/ticketsForProject',projectId, {headers:headers});
  }

  deleteTicket(ticketId: number) : Observable<any>{
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.kc.addTokenToHeader(headers)
    return this._http.post(this.baseURL + 'ticketManagement/ticket/delete',ticketId, {headers:headers});
  }
}

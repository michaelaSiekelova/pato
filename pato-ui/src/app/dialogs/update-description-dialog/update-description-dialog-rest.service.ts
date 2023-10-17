import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { Observable } from 'rxjs';
import { TicketDto } from 'src/dtos';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UpdateDescriptionDialogRestService {

  private baseURL: string = environment.API_URL;

  constructor( private _http: HttpClient, private kc: KeycloakService ) { }

  updateTicketDescription(ticket: TicketDto ) {
    console.log("description " + ticket.description);
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.kc.addTokenToHeader(headers)
    return this._http.post(this.baseURL + 'ticketManagement/ticket/updateTicketDescription', ticket, {headers:headers});
  }

}

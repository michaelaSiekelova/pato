import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { Observable } from 'rxjs';
import { UserDto, UserForChoosePostDto } from 'src/dtos';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ChooseUserDialogRestService {

  private baseURL: string = environment.API_URL;

  constructor(private _http: HttpClient, private kc: KeycloakService) { }

  getUsersForTicketToChoose( ticketId:number) : Observable<any>{
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.kc.addTokenToHeader(headers)
    return this._http.post(this.baseURL + 'userManagement/user/forTicket',  ticketId , {headers:headers});
  }

  getUsersForProjectToChoose( projectId:number) : Observable<any>{
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.kc.addTokenToHeader(headers)
    return this._http.post(this.baseURL + 'userManagement/user/forProject',  projectId , {headers:headers});
  }

  addUserForTicket(user:UserForChoosePostDto) : Observable<any>{
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.kc.addTokenToHeader(headers)
    return this._http.post(this.baseURL + 'userManagement/user/choosenForTicket', user,  {headers:headers});
  }

  addUserForProject(user:UserForChoosePostDto) : Observable<any>{
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.kc.addTokenToHeader(headers)
    return this._http.post(this.baseURL + 'userManagement/user/choosenForProject', user, {headers:headers});
  }
}

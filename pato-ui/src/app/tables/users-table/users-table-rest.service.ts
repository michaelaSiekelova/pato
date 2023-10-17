import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UsersTableRestService {

  private baseURL: string = environment.API_URL;

  constructor( private _http: HttpClient, private kc: KeycloakService ) { }

  getUsersForOverview() : Observable<any>{
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.kc.addTokenToHeader(headers)
    return this._http.get(this.baseURL + 'userManagement/user/allUserColleges', {headers:headers});
  }

  getUsersForProject(projectId:number) : Observable<any>{
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.kc.addTokenToHeader(headers)
    return this._http.post(this.baseURL + 'userManagement/user/allUsersForProject', projectId, {headers:headers});
  }
}

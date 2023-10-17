import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProjectsTableRestService {

  private baseURL: string = environment.API_URL;

  constructor( private _http: HttpClient, private kc: KeycloakService ) { }

  getUserProjects() : Observable<any>{
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.kc.addTokenToHeader(headers)
    return this._http.get(this.baseURL + 'projectManagement/project/projectsByCurrentUser', {headers:headers});
  }

  deleteProject(id: number) : Observable<any>{
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.kc.addTokenToHeader(headers)
    return this._http.post(this.baseURL + 'projectManagement/project/delete', id, {headers:headers});
  }
}

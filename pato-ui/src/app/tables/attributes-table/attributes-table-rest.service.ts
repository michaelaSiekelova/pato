import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AttributesTableRestService {
  private baseURL: string = environment.API_URL;

  constructor( private _http: HttpClient, private kc: KeycloakService ) { }

  getAttributesForProject(projectId : number) : Observable<any>{
    console.log('Vola sa to pre projekt : ' + projectId);
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.kc.addTokenToHeader(headers)
    return this._http.post(this.baseURL + 'attributeManagement/attribute/getForProject', projectId, {headers:headers});
  }

  deleteAttribute(attributeId : number) : Observable<any>{
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.kc.addTokenToHeader(headers)
    return this._http.post(this.baseURL + 'attributeManagement/attribute/delete', attributeId, {headers:headers});
  }
}

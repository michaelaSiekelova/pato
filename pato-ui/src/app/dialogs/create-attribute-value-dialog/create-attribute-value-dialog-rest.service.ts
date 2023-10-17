import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { Observable } from 'rxjs';
import { AttributeValueDto } from 'src/dtos';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CreateAttributeValueDialogRestService {
  private baseURL: string = environment.API_URL;

  constructor( private _http: HttpClient, private kc: KeycloakService ) { }

  getAttributeTypes() : Observable<any>{
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.kc.addTokenToHeader(headers)
    return this._http.get(this.baseURL + 'attributeManagement/attribute/types', {headers:headers});
  }

  getAttributesForProject(projectId : number) : Observable<any>{
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.kc.addTokenToHeader(headers)
    return this._http.post(this.baseURL + 'attributeManagement/attribute/getForProject', projectId, {headers:headers});
  }

  createAttributeValue(attribute: AttributeValueDto){
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.kc.addTokenToHeader(headers);
    return this._http.post(this.baseURL + 'attributeManagement/attributeValue/create', attribute, {headers:headers});
  }
}

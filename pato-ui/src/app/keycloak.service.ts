import { Injectable } from '@angular/core';
import { AuthConfig, NullValidationHandler, OAuthService } from 'angular-oauth2-oidc';

@Injectable({
  providedIn: 'root'
})
export class KeycloakService {

  constructor(private oauthService: OAuthService) {
    this.configure();
  }

  authConfig: AuthConfig = {
    issuer: 'http://localhost:8180/auth/realms/pato',
    redirectUri: window.location.origin + "/Users",
    clientId: 'angular-springboot',
    scope: 'openid profile email',
    responseType: 'code',
    // at_hash is not present in JWT token
    disableAtHashCheck: true,
    showDebugInformation: true
  }
    
  public login() {
    this.oauthService.initLoginFlow();
  }
    
  public logoff() {
    this.oauthService.logOut();
  }

  public getUserId(){
  }
  
  private configure() {
    this.oauthService.configure(this.authConfig);
    this.oauthService.tokenValidationHandler = new  NullValidationHandler();
    this.oauthService.loadDiscoveryDocumentAndTryLogin();
  }

  public getAuthToken(): string{
    return this.oauthService.authorizationHeader();
  }
  
}

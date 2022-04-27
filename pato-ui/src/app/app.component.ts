import { Component } from '@angular/core';
import { OAuthService, NullValidationHandler, AuthConfig } from 'angular-oauth2-oidc';
import { KeycloakService } from './keycloak.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'pato-ui';

  constructor(private oauthService: KeycloakService) {
  }

  public login(){
    this.oauthService.login();
  }

  public logoff(){
    this.oauthService.logoff();
  }
}

import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { MainMenuRestService } from './main-menu-rest.service';
import { UserDto } from 'src/dtos';

@Component({
  selector: 'app-main-menu',
  templateUrl: './main-menu.component.html',
  styleUrls: ['./main-menu.component.css']
})
export class MainMenuComponent implements OnInit {


  constructor(private keycloak: KeycloakService, private service : MainMenuRestService) { }

  ngOnInit(): void {
    
  }

  public changePassword(){
    this.keycloak.login({
      action: "UPDATE_PASSWORD",
    })
  }

  public logoff(){
    this.keycloak.logout()
  }

}

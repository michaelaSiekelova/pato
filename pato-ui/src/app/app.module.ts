import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { ProjectsOverviewComponent } from './projects-overview/projects-overview.component';
import { TicketsOverviewComponent } from './tickets-overview/tickets-overview.component';
import { UsersOverviewComponent } from './users-overview/users-overview.component';
import { MainMenuComponent } from './main-menu/main-menu.component';
import { UserBaseInfoComponent } from './user-base-info/user-base-info.component';
import { TicketBaseInfoComponent } from './ticket-base-info/ticket-base-info.component';
import { ProjectBaseInfoComponent } from './project-base-info/project-base-info.component';
import { ProjectsTableComponent } from './projects-table/projects-table.component';
import { UsersTableComponent } from './users-table/users-table.component';
import { TicketsTableComponent } from './tickets-table/tickets-table.component';
import { PermisionsTableComponent } from './permisions-table/permisions-table.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { AttributesTableComponent } from './attributes-table/attributes-table.component';
import { AttributeValuesTableComponent } from './attribute-values-table/attribute-values-table.component';
import { AttachmentsTableComponent } from './attachments-table/attachments-table.component';
import { CommentsTableComponent } from './comments-table/comments-table.component';
import { HistoryTableComponent } from './history-table/history-table.component';
import { WorkflowTableComponent } from './workflow-table/workflow-table.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from "@angular/material/icon";
import {MatListModule} from "@angular/material/list";
import {MatButtonModule} from '@angular/material/button';
import {MatGridListModule} from "@angular/material/grid-list";
import {MatTableModule} from "@angular/material/table";
import {HttpClientModule} from "@angular/common/http";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatTooltipModule} from "@angular/material/tooltip";
import {MatDialogModule} from "@angular/material/dialog";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import {MatSelectModule} from "@angular/material/select";
import {MatCardModule} from '@angular/material/card';
import { OAuthModule } from 'angular-oauth2-oidc';

@NgModule({
  declarations: [
    AppComponent,
    UserProfileComponent,
    ProjectsOverviewComponent,
    TicketsOverviewComponent,
    UsersOverviewComponent,
    MainMenuComponent,
    UserBaseInfoComponent,
    TicketBaseInfoComponent,
    ProjectBaseInfoComponent,
    ProjectsTableComponent,
    UsersTableComponent,
    TicketsTableComponent,
    PermisionsTableComponent,
    ChangePasswordComponent,
    AttributesTableComponent,
    AttributeValuesTableComponent,
    AttachmentsTableComponent,
    CommentsTableComponent,
    HistoryTableComponent,
    WorkflowTableComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    MatButtonModule,
    MatGridListModule,
    MatTableModule,
    HttpClientModule,
    MatPaginatorModule,
    MatFormFieldModule,
    MatTooltipModule,
    MatDialogModule,
    ReactiveFormsModule,
    FormsModule,
    MatInputModule,
    MatSelectModule,
    MatCardModule,
    OAuthModule.forRoot({
      resourceServer: {
          allowedUrls: ['http://localhost:8080/api'],
          sendAccessToken: true
        }
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

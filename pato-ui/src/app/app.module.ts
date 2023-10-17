import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProjectsOverviewComponent } from './overviews/projects-overview/projects-overview.component';
import { TicketsOverviewComponent } from './overviews/tickets-overview/tickets-overview.component';
import { UsersOverviewComponent } from './overviews/users-overview/users-overview.component';
import { MainMenuComponent } from './main-menu/main-menu.component';
import { UserDetailComponent } from './details/user-detail/user-detail.component';
import { TicketDetailComponent } from './details/ticket-detail/ticket-detail.component';
import { ProjectDetailComponent } from './details/project-detail/project-detail.component';
import { ProjectsTableComponent } from './tables/projects-table/projects-table.component';
import { UsersTableComponent } from './tables/users-table/users-table.component';
import { TicketsTableComponent } from './tables/tickets-table/tickets-table.component';
import { AttributesTableComponent } from './tables/attributes-table/attributes-table.component';
import { AttributeValuesTableComponent } from './tables/attribute-values-table/attribute-values-table.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from "@angular/material/icon";
import {MatListModule} from "@angular/material/list";
import {MatButtonModule} from '@angular/material/button';
import {MatGridListModule} from "@angular/material/grid-list";
import {MatTableModule} from "@angular/material/table";
import {HttpClientModule, HTTP_INTERCEPTORS} from "@angular/common/http";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatFormFieldModule, MAT_FORM_FIELD_DEFAULT_OPTIONS} from "@angular/material/form-field";
import {MatTooltipModule} from "@angular/material/tooltip";
import {MatDialogModule} from "@angular/material/dialog";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import {MatSelectModule} from "@angular/material/select";
import {MatCardModule} from '@angular/material/card';
import { OAuthModule } from 'angular-oauth2-oidc';
import { KeycloakAngularModule,  KeycloakService } from 'keycloak-angular';
import { CreateTicketDialogComponent } from './dialogs/create-ticket-dialog/create-ticket-dialog.component';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import {MatExpansionModule} from '@angular/material/expansion';
import { CreateProjectDialogComponent } from './dialogs/create-project-dialog/create-project-dialog.component';
import { CreateAttributeDialogComponent } from './dialogs/create-attribute-dialog/create-attribute-dialog.component';
import { CreateAttributeValueDialogComponent } from './dialogs/create-attribute-value-dialog/create-attribute-value-dialog.component';
import { CreateUserDialogComponent } from './dialogs/create-user-dialog/create-user-dialog.component';
import { ChooseUserDialogComponent } from './dialogs/choose-user-dialog/choose-user-dialog.component';
import { UpdateDescriptionDialogComponent } from './dialogs/update-description-dialog/update-description-dialog.component';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatRadioModule} from '@angular/material/radio';
import { GanttModule } from '@syncfusion/ej2-angular-gantt';
import { GantChartComponent } from './charts/gant-chart/gant-chart.component';
import { GanttComponent, EditService , FilterService, SortService, SelectionService, ToolbarService,DayMarkersService } from '@syncfusion/ej2-angular-gantt';
import { TasksTableComponent } from './tables/tasks-table/tasks-table.component';
import { CreateTaskDialogComponent } from './dialogs/create-task-dialog/create-task-dialog.component';
import {MatCheckboxModule} from '@angular/material/checkbox';
import { DatePickerComponent } from './dialogs/date-picker/date-picker.component';
import { ConfirmDialogComponent } from './dialogs/confirm-dialog/confirm-dialog.component';

function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: {
        realm: 'pato',
        url: 'http://localhost:8180/auth',
        clientId: 'angular-springboot'
      },
      initOptions: {
        onLoad: 'login-required'
      }
    });
}

@NgModule({
  declarations: [
    AppComponent,
    ProjectsOverviewComponent,
    TicketsOverviewComponent,
    UsersOverviewComponent,
    MainMenuComponent,
    UserDetailComponent,
    TicketDetailComponent,
    ProjectDetailComponent,
    ProjectsTableComponent,
    UsersTableComponent,
    TicketsTableComponent,
    AttributesTableComponent,
    AttributeValuesTableComponent,
    CreateTicketDialogComponent,
    CreateProjectDialogComponent,
    CreateAttributeDialogComponent,
    CreateAttributeValueDialogComponent,
    CreateUserDialogComponent,
    ChooseUserDialogComponent,
    UpdateDescriptionDialogComponent,
    GantChartComponent,
    TasksTableComponent,
    CreateTaskDialogComponent,
    DatePickerComponent,
    ConfirmDialogComponent
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
    MatNativeDateModule,
    MatTableModule,
    HttpClientModule,
    MatPaginatorModule,
    MatRadioModule,
    MatFormFieldModule,
    GanttModule,
    MatTooltipModule,
    MatDialogModule,
    MatDatepickerModule,
    ReactiveFormsModule,
    FormsModule,
    MatInputModule,
    MatSelectModule,
    MatSlideToggleModule,
    MatCardModule,
    KeycloakAngularModule,
    MatCheckboxModule,
    FormsModule, ReactiveFormsModule,MatExpansionModule,
    OAuthModule.forRoot({
      resourceServer: {
          allowedUrls: ['http://localhost:8080/api'],
          sendAccessToken: true
        }
    })
  ],
  providers: [
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      multi: true,
      deps: [KeycloakService]
    },
    {provide: MAT_FORM_FIELD_DEFAULT_OPTIONS, useValue: {appearance: 'fill'}},
    EditService , FilterService, SortService, SelectionService,ToolbarService,DayMarkersService 
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProjectsOverviewComponent} from "./overviews/projects-overview/projects-overview.component";
import {TicketsOverviewComponent} from "./overviews/tickets-overview/tickets-overview.component";
import {UsersOverviewComponent} from "./overviews/users-overview/users-overview.component";
import { ProjectDetailComponent } from './details/project-detail/project-detail.component';
import { TicketDetailComponent } from './details/ticket-detail/ticket-detail.component';
import {UserDetailComponent} from "./details/user-detail/user-detail.component";

const routes: Routes = [
  {path: 'Projects', component:ProjectsOverviewComponent},
  {path: 'Tickets', component: TicketsOverviewComponent},
  {path: 'Users', component: UsersOverviewComponent},
  {path: 'MyProfile', component: UserDetailComponent},
  {path: 'TicketDetail', component: TicketDetailComponent},
  {path: 'UserDetail', component: UserDetailComponent},
  {path: 'ProjectDetail', component: ProjectDetailComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

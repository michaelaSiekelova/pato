import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProjectsOverviewComponent} from "./projects-overview/projects-overview.component";
import {TicketsOverviewComponent} from "./tickets-overview/tickets-overview.component";
import {UsersOverviewComponent} from "./users-overview/users-overview.component";
import {UserProfileComponent} from "./user-profile/user-profile.component";

const routes: Routes = [
  {path: 'Projects', component:ProjectsOverviewComponent},
  {path: 'Tickets', component: TicketsOverviewComponent},
  {path: 'Users', component: UsersOverviewComponent},
  {path: 'MyProfile', component: UserProfileComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

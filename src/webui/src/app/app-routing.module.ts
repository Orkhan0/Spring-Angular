import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {DashboardComponent} from './pages/dashboard/dashboard.component';
import {ProjectComponent} from './pages/project/project.component';
import {IssueComponent} from "./pages/issue/issue.component";
import {AppLayoutComponent} from "./_layout";

const routes: Routes = [
  {
    path: '', component: AppLayoutComponent,
    children: [
      {path: 'issue', component: IssueComponent},
      {path: 'dashboard', component: DashboardComponent},
      {path: 'project', component: ProjectComponent},
      {path: '', redirectTo: '/dashboard', pathMatch: 'full'},
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}


// import { NgModule } from '@angular/core';
// import { Routes, RouterModule } from '@angular/router';
// import { DashboardComponent } from './pages/dashboard/dashboard.component';
// import { ProjectComponent } from './pages/project/project.component';
// import {IssueComponent} from "./pages/issue/issue.component";
//
// const routes: Routes = [
//   {path : 'issue' , component : IssueComponent },
//   {path : 'dashboard' , component : DashboardComponent },
//   {path : 'project' , component : ProjectComponent },
//   { path: '',   redirectTo: '/dashboard', pathMatch: 'full' },
// ];
//
// @NgModule({
//   imports: [RouterModule.forRoot(routes)],
//   exports: [RouterModule]
// })
// export class AppRoutingModule { }


import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {TranslateLoader, TranslateModule} from "@ngx-translate/core";
import {TranslateHttpLoader} from "@ngx-translate/http-loader";
import {AppLayoutComponent, FooterComponent, HeaderComponent, SidebarComponent} from "./_layout";
import {DashboardModule} from "./pages/dashboard/dashboard.module";
import {ProjectModule} from "./pages/project/project.module";
import {IssueModule} from "./pages/issue/issue.module";
import {NgxDatatableModule} from "@swimlane/ngx-datatable";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {BsDatepickerModule, BsDropdownModule, CollapseModule, ModalModule, PaginationModule} from "ngx-bootstrap";
import {ToastNoAnimation, ToastNoAnimationModule, ToastrModule} from "ngx-toastr";
import {ApiService} from "./services/api.service";

export const createTranslateLoader = (http: HttpClient) => {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}

@NgModule({
  declarations: [
    AppComponent,
    AppLayoutComponent,
    FooterComponent,
    HeaderComponent,
    SidebarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    DashboardModule,
    ProjectModule,
    IssueModule,
    NgxDatatableModule,
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    CollapseModule.forRoot(),
    BsDropdownModule.forRoot(),
    ModalModule.forRoot(),
    PaginationModule.forRoot(),
    BsDatepickerModule.forRoot(),
    ToastNoAnimationModule,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: createTranslateLoader,
        deps: [HttpClient]
      }
    })
  ],
  providers: [ApiService],
  bootstrap: [AppComponent]
})
export class AppModule { }


// imports: [
//   BrowserModule,
//   AppRoutingModule,
//   DashboardModule,
//   ProjectModule,
//   IssueModule,
//   NgxDatatableModule,
//   BrowserModule,
//   HttpClientModule,
//   AppRoutingModule,
//   BrowserAnimationsModule,
//   CollapseModule.forRoot(),
//   BsDropdownModule.forRoot(),
//   ModalModule.forRoot(),
//   PaginationModule.forRoot(),
//   BsDatepickerModule.forRoot(),
//   ToastNoAnimationModule,
//   TranslateModule.forRoot({
//     loader: {
//       provide: TranslateLoader,
//       useFactory: createTranslateLoader,
//       deps: [HttpClient]
//     }
//
//   }),
//   ToastrModule.forRoot({
//     toastComponent: ToastNoAnimation,
//     maxOpened: 1,
//     autoDismiss: true
//   }),
// ],

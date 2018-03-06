import { AdminAuthService } from './admin-auth.service';
import { AdminService } from './admin.service';
import { StudentService } from './student.service';
import { InstituteService } from "./institute.service";
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from "@angular/forms";
import { HttpModule } from "@angular/http";
import { RouterModule } from "@angular/router";
import { AppComponent } from './app.component';
import { StudentLoginComponent } from './student-login/student-login.component';
import { StudentRegistrationComponent } from './student-registration/student-registration.component';
import { StudentDetailComponent } from './student-detail/student-detail.component';
import { InstituteRegistrationComponent } from './institute-registration/institute-registration.component';
import { InstituteAddAccountComponent } from './institute-add-account/institute-add-account.component';
import { InstituteLoginComponent } from './institute-login/institute-login.component';
import { InstituteAddCourseComponent } from './institute-add-course/institute-add-course.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AdminPanelComponent } from './admin-panel/admin-panel.component';
import { InstituteValidateStudentComponent } from './institute-validate-student/institute-validate-student.component';
import { StudentAuthService } from './student-auth.service';
import { InstituteAuthService } from './institute-auth.service';
import { StudentHomeComponent } from './student-home/student-home.component';
import { StudentPreferenceComponent } from './student-preference/student-preference.component';
import { InstituteHomeComponent } from './institute-home/institute-home.component';
import { StudentAllocationComponent } from './student-allocation/student-allocation.component';
import { InstituteAllocationComponent } from './institute-allocation/institute-allocation.component';
import { StudentAccountRecoveryComponent } from './student-account-recovery/student-account-recovery.component';
import { StudentChangePasswordComponent } from './student-change-password/student-change-password.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentLoginComponent,
    StudentRegistrationComponent,
    StudentDetailComponent,
    InstituteRegistrationComponent,
    InstituteAddAccountComponent,
    InstituteLoginComponent,
    InstituteAddCourseComponent,
    AdminLoginComponent,
    AdminPanelComponent,
    InstituteValidateStudentComponent,
    StudentHomeComponent,
    StudentPreferenceComponent,
    InstituteHomeComponent,
    StudentAllocationComponent,
    InstituteAllocationComponent,
    StudentAccountRecoveryComponent,
    StudentChangePasswordComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot([
      {path:'student-registration',component:StudentRegistrationComponent},
      {path:'student-home',component:StudentHomeComponent,canActivate:[StudentAuthService]},
      {path:'student-login',component:StudentLoginComponent},
      {path:'student-detail',component:StudentDetailComponent,canActivate:[StudentAuthService]},
      {path:'student-login/student-account-recovery',component:StudentAccountRecoveryComponent},
      {path:'student-home/student-change-password',component:StudentChangePasswordComponent,canActivate:[StudentAuthService]},
      {path:'institute-registration',component:InstituteRegistrationComponent},
      {path:'institute-home',component:InstituteHomeComponent,canActivate:[InstituteAuthService]},
      {path:'institute-login',component:InstituteLoginComponent},
      {path:'institute-add-account',component:InstituteAddAccountComponent},      
      {path:'institute-add-course',component:InstituteAddCourseComponent,canActivate:[InstituteAuthService]},
      {path:'admin-login',component:AdminLoginComponent},
      {path:'admin-panel',component:AdminPanelComponent,canActivate:[AdminAuthService]},
      {path:'institute-validate-student',component:InstituteValidateStudentComponent,canActivate:[InstituteAuthService]}
    ])
  ],
  providers: [StudentService,InstituteService,AdminService,StudentAuthService,InstituteAuthService,AdminAuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }

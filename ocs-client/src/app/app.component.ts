import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'Online Counselling System';
  
  instituteId = localStorage.getItem("instituteId");
  formNumber = localStorage.getItem("formNumber");
  adminId = localStorage.getItem("adminId");

  isLoggedin()
  {
    return this.instituteId!=null || this.formNumber!=null || this.adminId!=null
  }
  logout()
  {
    localStorage.removeItem("instituteId");
    localStorage.removeItem("formNumber");
    localStorage.removeItem("adminId")
  }
}

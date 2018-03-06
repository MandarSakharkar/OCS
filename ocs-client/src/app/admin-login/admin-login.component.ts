import { Router } from '@angular/router';
import { AdminService } from './../admin.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  adminId:String;
  password:String;

  constructor(private adminService:AdminService,private router:Router) { }

  ngOnInit() {
  }

  doLogin()
  {
    this.adminService.doAdminLogin(this.adminId,this.password)
    .subscribe(response=>{
      var result = response.json().result;
      console.log(result);
      if(result!=null)
      {
        localStorage.setItem('adminLoginId',result.adminLoginId);
        this.router.navigate(['admin-panel']);
      }
      else
      {
        alert("Invalid Admin login credentials!");
      }
    });
  }

}

import { InstituteService } from './../institute.service';
import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";

@Component({
  selector: 'app-institute-login',
  templateUrl: './institute-login.component.html',
  styleUrls: ['./institute-login.component.css']
})
export class InstituteLoginComponent implements OnInit {

  constructor(private instituteService:InstituteService,private router:Router) { }


  instituteLoginId:String;
  instituteId:Number;
  password:String;

  ngOnInit() {
  }

  doInstituteLogin()
  {
    this.instituteService
    .doInstituteLogin(this.instituteLoginId,this.password)
    .subscribe((response)=>{
      var result = response.json();
      console.log(result);
      if(result.result==null)
      {
          alert("Invalid Login Credentials!");
      }
      else
      {
          localStorage.setItem('instituteId',result.result.instituteId.toString()) ;
          this.router.navigate(['institute-home']);
      }
    });
  }
}

import { Router } from '@angular/router';
import { InstituteService } from './../institute.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'institute-add-account',
  templateUrl: './institute-add-account.component.html',
  styleUrls: ['./institute-add-account.component.css']
})
export class InstituteAddAccountComponent implements OnInit {

    instituteLoginId:Number;
		instituteId:Number = parseInt(localStorage.getItem('instituteId'));
    password:String;
    cspassword:String;

  constructor(private instituteService:InstituteService,private router:Router) { }


  ngOnInit() {
  }

  validateAndAddInstituteAccount()
  {
    this.instituteService
    .addInstituteAccount(this.instituteLoginId,this.instituteId,this.password)
    .subscribe((respose)=>{
      var result = respose.json();
      if(result.result!=0)
      {
        alert("Account added successfully");
        this.router.navigate(['institute-login']);
      }
      else
      {
        alert("Error while adding Account");
      }
    });
  }
}

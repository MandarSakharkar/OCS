import { StudentService } from './../student.service';
import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";

@Component({
  selector: 'student-login',
  templateUrl: './student-login.component.html',
  styleUrls: ['./student-login.component.css']
})
export class StudentLoginComponent implements OnInit {

  constructor(private studentService:StudentService,private router:Router) { }

  formNumber:Number;
  password:String;

  ngOnInit() {
  }

  doLogin()
  {
    this.studentService.login(this.formNumber,this.password).
    subscribe((response)=>{
      var result = response.json()
      if(result.formNumber==undefined)
        alert(result.message);
      else 
      {
        localStorage.setItem('formNumber',this.formNumber.toString()); 
        this.router.navigate(['student-home']);
      }
    });
  }
}

import { StudentService } from './../student.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'student-change-password',
  templateUrl: './student-change-password.component.html',
  styleUrls: ['./student-change-password.component.css']
})
export class StudentChangePasswordComponent implements OnInit {

  constructor(private studentService:StudentService) { }

  formNumber:Number = parseInt(localStorage.getItem('formNumber'));
  password:String;
  confirmPassword:String;

  passwordError:boolean;

  ngOnInit() {
  }
  validatePassword()
  {
    if(this.password==''||this.password!=this.confirmPassword||this.password.length<8)
      this.passwordError=true;
    else
      this.passwordError=false;
  }

  updatePassword()
  {
    this.validatePassword();
    if(this.passwordError)
    {
      alert("Form not submitted due to the mentioned error!\nPlease do correct them!");
    }
    //send request and get response
    else
    this.studentService.changeStudentPassword(this.formNumber,this.password)
    .subscribe(response=>{
      var result = response.json().result;
      if(result==1)
        alert("Password Updated successfully!");
    });
  }
}

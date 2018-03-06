import { StudentService } from './../student.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'student-account-recovery',
  templateUrl: './student-account-recovery.component.html',
  styleUrls: ['./student-account-recovery.component.css']
})
export class StudentAccountRecoveryComponent implements OnInit {

  constructor(private studentService:StudentService) { }
  formNumber:Number;
  emailId:String;
  ngOnInit() {
  }
  recoverAccount()
  {
    this.studentService.recoverStudentAccount(this.formNumber,this.emailId)
    .subscribe(response=>{
      var result = response.json().result;
      if(result==1)
        alert("Your account recovery sent to your email!\nPlease login with those credentials to recover your account");
    });
  }
}

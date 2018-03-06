import { Router } from '@angular/router';
import { StudentService } from './../student.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'student-registration',
  templateUrl: './student-registration.component.html',
  styleUrls: ['./student-registration.component.css']
})
export class StudentRegistrationComponent implements OnInit {

  constructor(private studentService:StudentService,private router:Router) { }

  fullName:String='';
  emailId:String='';
  contactNumber:Number=null;
  password:String='';
  confirmPassword:String='';

  ngOnInit() {
  }

  nameError:boolean;
  emailError:boolean;
  contactError:boolean;
  passwordError:boolean;

  validateName()
  {
    if(this.fullName=='')
      this.nameError=true;
    else
      this.nameError=false;
  }

  validateEmail()
  {
    if(this.emailId==''|| !(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(this.emailId.toString())))
    this.emailError=true;
  else
    this.emailError=false;
  }

  validateContact()
  {
    if(this.contactNumber==null||!(/^\d{10}$/.test(this.contactNumber.toString())))
    this.contactError=true;
  else
    this.contactError=false;
  }

  validatePassword()
  {
    if(this.password==''||this.password!=this.confirmPassword||this.password.length<8)
    this.passwordError=true;
  else
    this.passwordError=false;
  }

  


  validateAndSubmit()
  {
    //validation code here
    this.validateName();
    this.validateEmail();
    this.validatePassword();
    this.validateContact();
    if(this.nameError || this.contactError || this.passwordError || this.emailError)
    {
      alert("Form not submitted due to the mentioned error!\nPlease do correct them!");
    }
    //send request and get response
    else
    this.studentService.
    registerStudent(this.fullName,this.emailId,this.contactNumber,this.password)
    .subscribe((response)=>{
      alert("Your Registration is Successfull!\n Your form number is :"+ response.json().result +" \nLogin with form number and password to apply.");
      this.router.navigate(['student-login']);    
    });
  }


}

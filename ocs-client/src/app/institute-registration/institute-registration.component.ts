import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { InstituteService } from "./../institute.service";
@Component({
  selector: 'institute-registration',
  templateUrl: './institute-registration.component.html',
  styleUrls: ['./institute-registration.component.css']
})
export class InstituteRegistrationComponent implements OnInit {

  constructor(private instituteService:InstituteService,private router:Router) { }

    instituteName:String;
		instituteAddress:String;
		pincode:Number;
		instituteContactNumber:Number;
		instituteEmailId:String;		

  ngOnInit() {
  }

  validateAndSubmitInstituteDetail()
  {
    this.instituteService.registerInstitute
    (this.instituteName,this.instituteAddress,this.pincode,this.instituteContactNumber,this.instituteEmailId)
    .subscribe((response)=>{
      var result = response.json().result;
      alert("Registration Successfull! Your institute id is :"+result
      +"\nUse this id while adding accounts");
        localStorage.setItem('instituteId',result);
        this.router.navigate(['institute-add-account']);
    });
  }

}

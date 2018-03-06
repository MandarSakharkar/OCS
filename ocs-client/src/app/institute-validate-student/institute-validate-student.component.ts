import { InstituteService } from './../institute.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'institute-validate-student',
  templateUrl: './institute-validate-student.component.html',
  styleUrls: ['./institute-validate-student.component.css']
})
export class InstituteValidateStudentComponent implements OnInit {

  constructor(private instituteService:InstituteService) { }

  formNumber:Number;
  adharNumber:Number;
		panNumber:String;
		gender:String;
		category:String;
		dateOfBirth:Date;
		nationality:String;
		address:String;
		pincode:Number;
		eCatRollNumber:Number;
		eCatRank:Number;
		degree:String;
    degreePercentage:Number;
    
		isStudentFound:boolean = false;

  ngOnInit() {
  }

  searchStudent()
  {
      this.instituteService.getStudentDetail(this.formNumber)
      .subscribe(response=>{
        var result = response.json().result;
        console.log(result);
        this.adharNumber=result.adharNumber;
        this.panNumber=result.panNumber;
        this.gender=result.gender;
        this.category=result.category;
        this.dateOfBirth=result.dateOfBirth;
        this.nationality=result.nationality;
        this.address=result.address;
        this.pincode=result.pincode;
        this.eCatRollNumber=result.eCatRollNumber;
        this.eCatRank=result.eCatRank;
        this.degree=result.degree;
        this.degreePercentage=result.degreePercentage;
        
        if(result!=null || result!=undefined)
        this.isStudentFound=true;  
      });
  }

  validateStudent()
  {
    this.instituteService.validateStudent(
        this.formNumber,
        this.adharNumber,
        this.panNumber,
        this.gender,
        this.category,
        this.dateOfBirth,
        this.nationality,
        this.address,
        this.pincode,
        this.eCatRollNumber,
        this.eCatRank,
        this.degree,
        this.degreePercentage
      ).subscribe((response)=>{
				var result = response.json().result;
				if(result==1)
				{
					alert("Student Validated successfully");
				}
				else
				{
					alert("Error while validating details");
				}
      });
	}
}

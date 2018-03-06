import { StudentService } from './../student.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {

		studentName:String;
    	formNumber:Number= Number.parseInt(localStorage.getItem('formNumber'));
		adharNumber:Number;
		gender:String;
		category:String;
		dateOfBirth:Date;
		address:String;
		pincode:Number;
		eCatRollNumber:Number;
		eCatRank:Number;
		degree:String;
		degreePercentage:Number;
		isFormFilled:boolean = false;
    
  constructor(private studentService:StudentService) { }

  ngOnInit() {
		this.loadStudentDetails();
  }

  adharNumberError:boolean;
  dateError:boolean;
  genderError:boolean;
  categoryError:boolean;
  addressError:boolean;
  pincodeError:boolean;
  eCatRollNumberError:boolean;
  eCatRankError:boolean;
  degreeError:boolean;
  degreePercentageError:boolean;
  validateAdharNumber()
  {
	if(this.adharNumber.toString().length!=12)
		this.adharNumberError=true;
	else
		this.adharNumberError=false;
  }
  validateDate()
  {
	if( !(/^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/.test(this.dateOfBirth.toDateString()) ) )
		this.dateError=true;
	else
		this.dateError=false;
  }
  validateGender()
  {
	if(this.gender.length==0)
		this.genderError = true;
	else
		this.genderError = false;	  
  }
  validateCategory()
  {
	if(this.category.length==0)
		this.categoryError = true;
	else
		this.categoryError = false;
  }
  validateAddress()
  {
	if(this.address.length==0)
		this.addressError=true;
	else
		this.addressError=false;
  }
  
  validatePincode()
  {
	if( !(/^[0-9]{6}$/.test(this.pincode.toString()) ) )
		this.pincodeError = true;
	else
		this.pincodeError = false;
  }
  
  validateECatRollNumber()
  {
	if( !(/^[0-9]{6}$/.test(this.eCatRollNumber.toString()) ) )
		this.eCatRollNumberError = true;
	else
		this.eCatRollNumberError = false;
  }
  validateECatRank()
  {
	if(!(/^[0-9]+$/.test(this.eCatRank.toString())))
		this.eCatRankError = true;
	else
		this.eCatRankError = false;
  }
  validateDegree()
  {
		if(this.degree.length==0)
			this.degreeError = true;
		else
			this.degreeError = false;
  }
  validateDegreePercentage()
  {
	if( ! (/(^100(\.0{1,2})?$)|(^([1-9]([0-9])?|0)(\.[0-9]{1,2})?$)/.test(this.degreePercentage.toString()) ) )
		this.degreePercentageError = true;
	else
		this.degreePercentageError = false;	  
  }

  validateAndFillDetail()
  {
      this.studentService.fillDetail(
        this.formNumber,
		    this.adharNumber,
		    this.gender,
		    this.category,
		    this.dateOfBirth,
		    this.address,
		    this.pincode,
		    this.eCatRollNumber,
		    this.eCatRank,
		    this.degree,
        this.degreePercentage
      ).subscribe((response)=>{
				console.log(response.json());
				var result = response.json().result;
				if(result==1)
				{
					alert("Details saved successfully");
				}
				else
				{
					alert("Error while saving details");
				}
      });
	}

validateAndUpdateDetail()
  {
      this.studentService.updateDetail(
        this.formNumber,
		this.adharNumber,
		this.gender,
		this.category,
		this.dateOfBirth,
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
					alert("Details Saved successfully");
				}
				else
				{
					alert("Error while saving details");
				}
      });
	}

	//Load Student Details in case if student already filled it and need to update
	loadStudentDetails()
	{
		this.studentService.getStudentDetails(this.formNumber)
		.subscribe(response=>{
			var result = response.json().result;
			console.log(result);
			this.studentName=result.studentAccount.fullName;
			this.adharNumber=result.adharNumber;
			this.gender=result.gender;
			this.category=result.category;
			this.dateOfBirth=result.dateOfBirth;
			this.address=result.address;
			this.pincode=result.pincode;
			this.eCatRollNumber=result.eCatRollNumber;
			this.eCatRank=result.eCatRank;
			this.degree=result.degree;
			this.degreePercentage=result.degreePercentage;
			
			if(result!=null || result!=undefined)
			this.isFormFilled=true;
		});
	}

	printForm()
	{
		print();
	}
}

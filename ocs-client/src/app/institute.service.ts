import { Injectable } from '@angular/core';
import { Http,Headers,RequestOptions } from "@angular/http";

@Injectable()
export class InstituteService {

  url="http://localhost:8080/ocs_spring_mvc";
  constructor(private http:Http) { }

  registerInstitute(
    instituteName,
		instituteAddress,
		pincode,
		instituteContactNumber,
		instituteEmailId,
  )
  {
    var resultUrl = this.url+"/institute/register";
    const body = {
      instituteName:instituteName,
		  instituteAddress:instituteAddress,
		  pincode:pincode,
		  instituteContactNumber:instituteContactNumber,
		  instituteEmailId:instituteEmailId,
      };
      
  
    const header = new Headers({'content-type':'application/json'})
    const requestOptions =  new RequestOptions({headers:header});
    return this.http.post(resultUrl,body,requestOptions);
  }


  addInstituteAccount(
    instituteLoginId:Number,
		instituteId:Number,
    password:String,
  )
  {
    var resultUrl = this.url+"/institute/account/addnew";
    const body = {
      instituteLoginId:instituteLoginId,
      instituteId:instituteId,
      password:password,
      };

      console.log(body);
      
    const header = new Headers({'content-type':'application/json'})
    const requestOptions =  new RequestOptions({headers:header});
    return this.http.post(resultUrl,body,requestOptions);
  }

  doInstituteLogin(
    instituteLoginId:String,
    password:String,
  )
  {
    var resultUrl = this.url+"/institute/login";
    const body = {
      instituteLoginId:instituteLoginId,
      password:password,
      };
      
  
    const header = new Headers({'content-type':'application/json'})
    const requestOptions =  new RequestOptions({headers:header});
    return this.http.post(resultUrl,body,requestOptions);
  }
  getCourseList()
  {
    var resultUrl = this.url+"/courses/all";
    return this.http.get(resultUrl);
  }
  getInstituteCourseList(instituteId:Number)
  {
    var resultUrl = this.url+"/institute/course/byinstituteid/"+instituteId;
    return this.http.get(resultUrl);
  }
  addInstituteCourse(instituteId:Number,courseId:String,numberOfSeat:Number)
  {
    var resultUrl = this.url+"/institute/course/addnew";
    const institute = {instituteId:instituteId}
    const course = {courseId:courseId}
    const body = {
        institute:institute,
        course:course,
        numberOfSeat:numberOfSeat
      };      
      console.log(body);
    const header = new Headers({'content-type':'application/json'})
    const requestOptions =  new RequestOptions({headers:header});
    return this.http.post(resultUrl,body,requestOptions);
  }


  getStudentDetail(formNumber:Number)
  {
    var resultUrl = this.url+"/institute/student/get/"+formNumber;
    return this.http.get(resultUrl);
  }

  validateStudent(formNumber,
		adharNumber,
		panNumber,
		gender,
		category,
		dateOfBirth,
		nationality,
		address,
		pincode,
		eCatRollNumber,
		eCatRank,
		degree,
    degreePercentage
    )
  {
    var resultUrl = this.url+"/institute/student/validate";
    const studentAccount = {formNumber:formNumber};
    const body = {
    studentAccount:studentAccount,
		adharNumber:adharNumber,
		panNumber:panNumber,
		gender:gender,
		category:category,
		dateOfBirth:dateOfBirth,
		nationality:nationality,
		address:address,
		pincode:pincode,
		eCatRollNumber:eCatRollNumber,
		eCatRank:eCatRank,
		degree:degree,
    degreePercentage:degreePercentage,
    isValidated:1
    };
    
  console.log(formNumber);
  const header = new Headers({'content-type':'application/json'})
  const requestOptions =  new RequestOptions({headers:header});
  return this.http.post(resultUrl,body,requestOptions);
  }

  getCounsellingProcessPhase()
  {
    var resultUrl = this.url+"/student/counsellingphase";
    return this.http.get(resultUrl);
  }

  getAllotmentDetail(formNumber:Number)
  {
    var resultUrl = this.url+"/institute/instituteallotment/student/"+formNumber;
    return this.http.get(resultUrl);
  }

  admitStudent(instituteAllotment)
  {
    var resultUrl = this.url+"/institute/instituteallotment/admitstudent";
    instituteAllotment.isAdmissionConfirmed = 1;
    console.log(instituteAllotment);
    const body = instituteAllotment;
    const header = new Headers({'content-type':'application/json'})
    const requestOptions =  new RequestOptions({headers:header});
    return this.http.post(resultUrl,body,requestOptions);
  }
  getAllotedStudentsByInstituteCourseId(instituteCourseId:Number)
  {
    var resultUrl = this.url+"/institute/instituteallotment/institutecourse/"+instituteCourseId;
    return this.http.get(resultUrl);
  }
}

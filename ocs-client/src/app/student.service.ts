import { Preference } from './student-preference/Preference';
import { Injectable } from '@angular/core';
import { Http,Headers,RequestOptions } from "@angular/http";
@Injectable()
export class StudentService {

  url="http://localhost:8080/ocs_spring_mvc";
  constructor(private http:Http) { }

  registerStudent(fullName,emailId,contactNumber,password)
  {
    var resultUrl = this.url+"/student/register";
    const body={
      fullName:fullName,
      emailId:emailId,
      contactNumber:contactNumber,
      password:password
    }
    const header = new Headers({'content-type':'application/json'})
    const requestOptions =  new RequestOptions({headers:header});
    return this.http.post(resultUrl,body,requestOptions);
  }

  login(formNumber,password)
  {
    var resultUrl = this.url+"/student/login";
    const body={
      formNumber:formNumber,
      password:password
    }
    const header = new Headers({'content-type':'application/json'})
    const requestOptions =  new RequestOptions({headers:header});
    return this.http.post(resultUrl,body,requestOptions);
  }

  fillDetail(formNumber,
		adharNumber,
		gender,
		category,
		dateOfBirth,
		address,
		pincode,
		eCatRollNumber,
		eCatRank,
		degree,
    degreePercentage
    )
  {
    var resultUrl = this.url+"/student/detail/fill";
    const studentAccount = {formNumber:formNumber};
    const body = {
    studentAccount:studentAccount,
		adharNumber:adharNumber,
		gender:gender,
		category:category,
		dateOfBirth:dateOfBirth,
		address:address,
		pincode:pincode,
		eCatRollNumber:eCatRollNumber,
		eCatRank:eCatRank,
		degree:degree,
		degreePercentage:degreePercentage,
    };
    
  const header = new Headers({'content-type':'application/json'})
  const requestOptions =  new RequestOptions({headers:header});
  return this.http.post(resultUrl,body,requestOptions);
  }

  updateDetail(formNumber,
		adharNumber,
		gender,
		category,
		dateOfBirth,
		address,
		pincode,
		eCatRollNumber,
		eCatRank,
		degree,
    degreePercentage
    )
  {
    var resultUrl = this.url+"/student/detail/update";
    const studentAccount = {formNumber:formNumber};
    const body = {
    studentAccount:studentAccount,
		adharNumber:adharNumber,
		gender:gender,
		category:category,
		dateOfBirth:dateOfBirth,
		address:address,
		pincode:pincode,
		eCatRollNumber:eCatRollNumber,
		eCatRank:eCatRank,
		degree:degree,
		degreePercentage:degreePercentage,
    };
    
  console.log(formNumber);
  const header = new Headers({'content-type':'application/json'})
  const requestOptions =  new RequestOptions({headers:header});
  return this.http.post(resultUrl,body,requestOptions);
  }

  getStudentDetails(formNumber:Number)
  {
    var resultUrl = this.url+"/student/detail/get/"+formNumber;
    return this.http.get(resultUrl);
  }

  getCounsellingProcessPhase()
  {
    var resultUrl = this.url+"/student/counsellingphase";
    return this.http.get(resultUrl);
  }

  getCourseList()
  {
    var resultUrl = this.url+"/courses/all";
    return this.http.get(resultUrl);
  }
  getInstituteCourseList(courseId:String)
  {
    var resultUrl = this.url+"/institute/course/bycourseid/"+courseId;
    return this.http.get(resultUrl);
  }

  getPreferencesByFormNumber(formNumber:Number)
  {
    var resultUrl = this.url+"/student/preference/get/"+formNumber;
    return this.http.get(resultUrl);
  }

  savePreference(preference:Preference)
  {
    var resultUrl = this.url+"/student/preference/save";
    console.log(preference);
    const body ={
      preferenceId:preference.getPreferenceId(),
      instituteCourse:preference.getInstituteCourse(),
      studentAccount:{formNumber:preference.getFormNumber()},
      roundNumber:1,
      preferenceNumber:preference.getPreferenceNumber()
    };    
    console.log(preference);

    const header = new Headers({'content-type':'application/json'})
    const requestOptions =  new RequestOptions({headers:header});
    return this.http.post(resultUrl,body,requestOptions);
  }

  deletePreference(preference:Preference)
  {
    var resultUrl = this.url+"/student/preference/delete";
    console.log(preference);
    const body ={
      preferenceId:preference.getPreferenceId()
    };    
    console.log(preference);

    const header = new Headers({'content-type':'application/json'})
    const requestOptions =  new RequestOptions({headers:header});
    return this.http.post(resultUrl,body,requestOptions);
  }

  getInstituteAllotment(formNumber:Number)
  {
    var resultUrl = this.url+"/student/instituteallotment/get/"+formNumber;
    return this.http.get(resultUrl);
  }

  recoverStudentAccount(formNumber:Number,emailId:String)
  {
    var resultUrl = this.url+"/student/account/forgotpassword";
    const body ={
      formNumber:formNumber,
      emailId:emailId
    };    
    
    const header = new Headers({'content-type':'application/json'})
    const requestOptions =  new RequestOptions({headers:header});
    return this.http.post(resultUrl,body,requestOptions);
  }
  changeStudentPassword(formNumber:Number,password:String)
  {
    var resultUrl = this.url+"/student/account/changepassword";
    const body ={
      formNumber:formNumber,
      password:password,
    };    
    
    const header = new Headers({'content-type':'application/json'})
    const requestOptions =  new RequestOptions({headers:header});
    return this.http.post(resultUrl,body,requestOptions);
  }
}

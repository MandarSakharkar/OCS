import { Injectable } from '@angular/core';
import { Http,Headers,RequestOptions } from "@angular/http";

@Injectable()
export class AdminService {

  url="http://localhost:8080/ocs_spring_mvc";
  constructor(private http:Http) { }

  doAdminLogin(
    adminId:String,
    password:String,
  )
  {
    var resultUrl = this.url+"/admin/login";
    const body = {
      adminId:adminId,
      password:password,
      };
      
  
    const header = new Headers({'content-type':'application/json'})
    const requestOptions =  new RequestOptions({headers:header});
    return this.http.post(resultUrl,body,requestOptions);
  }

  addCourse(courseId:String,courseName:String)
  {
    var resultUrl = this.url+"/admin/course/add";
    const body = {
        courseId:courseId,
        courseName:courseName
      };
      
  
    const header = new Headers({'content-type':'application/json'})
    const requestOptions =  new RequestOptions({headers:header});
    return this.http.post(resultUrl,body,requestOptions);
  }

  changeCounsellingPhase(phase:String,round:Number)
  {
    var resultUrl = this.url+"/admin/counsellingphase/change";
    const body = {
      phaseId:1,
      phase:phase,
      round:round
      };
      
  
    const header = new Headers({'content-type':'application/json'})
    const requestOptions =  new RequestOptions({headers:header});
    return this.http.post(resultUrl,body,requestOptions);
  }
  getCounsellingPhase()
  {
    var resultUrl = this.url+"/admin/counsellingphase/get";      
  
    return this.http.get(resultUrl);
  }
  startInstituteAllocation(round:Number)
  {
    var resultUrl = this.url+"/admin/institute/allocate/"+round;
    return this.http.get(resultUrl);
  }
}

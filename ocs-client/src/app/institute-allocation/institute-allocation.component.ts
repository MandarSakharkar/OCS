import { InstituteService } from './../institute.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'institute-allocation',
  templateUrl: './institute-allocation.component.html',
  styleUrls: ['./institute-allocation.component.css']
})
export class InstituteAllocationComponent implements OnInit {

  constructor(private instituteService:InstituteService) { }

  formNumber:Number;
  instituteAllotment;
  instituteCourseList;
  instituteCourse;
  instituteId:Number= parseInt(localStorage.getItem("instituteId"));
  courseAllotmentList;
  ngOnInit() {
    this.getInstituteCourseList();
  }

  getInstituteCourseList()
  {
    this.instituteService.getInstituteCourseList(this.instituteId)
    .subscribe(response=>{
      var result = response.json().result;
      this.instituteCourseList = result;
      console.log(result);
    });
  }

  getAllotmentOfStudent()
  {
    this.instituteService.getAllotmentDetail(this.formNumber)
    .subscribe(response=>{
      var result = response.json().result
      console.log(result);

      if(result.instituteCourse.institute.instituteId==this.instituteId)
        this.instituteAllotment = result;
      else
        alert("Candidate not alloted in this institute");
    });
    console.log(this.instituteAllotment);
  }

  admitStudent()
  {
    this.instituteService.admitStudent(this.instituteAllotment)
    .subscribe(response=>{
      var result = response.json().result;
      console.log(result);
      if(result==1)
        alert("Student Admitted successfully!");
      else
        alert("Error while admitting student!");
    });
  }

  getCourseByInstituteCourse(instituteCourse)
  {
    this.instituteService.getAllotedStudentsByInstituteCourseId(instituteCourse.instituteCourseId)
    .subscribe(response=>{
      this.courseAllotmentList = response.json().result;
      if(this)
      this.instituteCourse = instituteCourse;
      console.log(this.courseAllotmentList);
    });
  }


}

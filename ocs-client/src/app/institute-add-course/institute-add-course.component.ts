import { InstituteService } from './../institute.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'institute-add-course',
  templateUrl: './institute-add-course.component.html',
  styleUrls: ['./institute-add-course.component.css']
})
export class InstituteAddCourseComponent implements OnInit {

  constructor(private instituteService:InstituteService) { }
  
  private courseList;//all courses
  private instituteCourseList;//courses in institute
  
  courseId:String;
  numberOfSeat:Number;
  instituteId= parseInt(localStorage.getItem('instituteId'));
  ngOnInit() 
  {
      this.instituteService.getCourseList()
      .subscribe(response=>{
        this.courseList = response.json().result;
        console.log("courseList",this.courseList); 
      });
      
     
      this.loadInstituteCourseList();
  }

  addInstituteCourse()
  {
    this.instituteService
    .addInstituteCourse(this.instituteId,this.courseId,this.numberOfSeat)
    .subscribe(response=>{
      var result = response.json().result;
      if(result!=0)
      {
        alert("Course added with course id :"+result);
        this.loadInstituteCourseList();
      }
    });
  }

  loadInstituteCourseList()
  {
    this.instituteService.getInstituteCourseList(this.instituteId)
    .subscribe(response=>{
      this.instituteCourseList = response.json().result;
      console.log("instituteCourseList",this.instituteCourseList);
    });
  }
}

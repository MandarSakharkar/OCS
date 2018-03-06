import { StudentService } from './../student.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'student-allocation',
  templateUrl: './student-allocation.component.html',
  styleUrls: ['./student-allocation.component.css']
})
export class StudentAllocationComponent implements OnInit {

  constructor(private studentService:StudentService) { }

  formNumber:Number = parseInt(localStorage.getItem("formNumber"));
  instituteAllotment;
  ngOnInit() {
    this.getAllotment();
  }

  getAllotment()
  {
    this.studentService.getInstituteAllotment(this.formNumber)
    .subscribe(response=>{
        this.instituteAllotment = response.json().result;
        console.log(this.instituteAllotment);
    });
  }

}

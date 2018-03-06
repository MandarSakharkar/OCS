import { StudentService } from './../student.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'student-home',
  templateUrl: './student-home.component.html',
  styleUrls: ['./student-home.component.css']
})
export class StudentHomeComponent implements OnInit {

  counsellingPhase:String;
  constructor(private studentService:StudentService) { }

  ngOnInit() {
    this.getCounsellingPhase();
  }

  formNumber:Number=parseInt(localStorage.getItem('formNumber'));

  getCounsellingPhase()
  {
    this.studentService.getCounsellingProcessPhase()
    .subscribe(response=>{
      var result = response.json().result;
      this.counsellingPhase = result.phase;

      console.log("phase",this.counsellingPhase);   
    });
  }
}
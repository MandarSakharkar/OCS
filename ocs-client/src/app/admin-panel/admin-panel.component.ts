import { AdminService } from './../admin.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.css']
})
export class AdminPanelComponent implements OnInit {

  courseId:String;
  courseName:String;

  phase:String;
  round:Number;

  constructor(private adminService:AdminService) { }

  ngOnInit() {
    this.getPhase();
  }

  addCourse()
  {
    this.adminService.addCourse(this.courseId,this.courseName)
    .subscribe(response=>{
      var result = response.json();
      console.log(result);
    });
  }

  changePhase()
  {
    this.adminService.changeCounsellingPhase(this.phase,this.round)
    .subscribe(response=>{
      var result = response.json().result;
      if(result==1)
        alert("Phase and round updated successfully!");
      else
        alert("Error while updating the phase! Please try again!");
    });
  }

  getPhase()
  {
    this.adminService.getCounsellingPhase()
    .subscribe(response=>{
      var result = response.json().result;
      console.log(result);
      this.phase = result.phase;
      this.round = result.round;
    });
  }

  startInstituteAllocation()
  {
    this.adminService.startInstituteAllocation(this.round)
    .subscribe(response=>{
      var result = response.json().result;
      if(result==0)
      {
        alert("Allocation done successfully");
      }
    });
  }
}

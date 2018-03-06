import { InstituteService } from './../institute.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'institute-home',
  templateUrl: './institute-home.component.html',
  styleUrls: ['./institute-home.component.css']
})
export class InstituteHomeComponent implements OnInit {

  counsellingPhase:String;
  
  constructor(private instituteService:InstituteService) { }

  ngOnInit() {
    this.getCounsellingPhase();
  }
  getCounsellingPhase()
  {
    this.instituteService.getCounsellingProcessPhase()
    .subscribe(response=>{
      var result = response.json().result;
      this.counsellingPhase = result.phase;
      console.log("phase",this.counsellingPhase);
      
    });
  }
}

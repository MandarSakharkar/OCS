import { Preference } from './Preference';
import { StudentService } from './../student.service';
import { Component, OnInit } from '@angular/core';
import { delay } from 'q';

@Component({
  selector: 'student-preference',
  templateUrl: './student-preference.component.html',
  styleUrls: ['./student-preference.component.css']
})
export class StudentPreferenceComponent implements OnInit {

  private courseList;//all courses
  private instituteCourseList;//courses in institute

  courseId:String;
  instituteCourse;
  formNumber:Number=Number.parseInt(localStorage.getItem('formNumber'));
  preferenceNumber:Number;
  instituteName:String;
  
  preferences:Array<Preference> = [];


  constructor(private studentService:StudentService) { }

  ngOnInit() {
    this.studentService.getCourseList()
      .subscribe(response=>{
        this.courseList = response.json().result;
        console.log("courseList",this.courseList); 
      });

      this.getSavedPreferences();
  }

  getSavedPreferences()
  {
    this.studentService.getPreferencesByFormNumber(this.formNumber)
    .subscribe(response=>{
      var results = response.json().result;
      console.log(results);
      for (let index = 0; index < results.length; index++) {
        const element = results[index];
        this.preferences.push(new Preference(element.preferenceId,element.instituteCourse,element.preferenceNumber,this.formNumber));
      }
      this.preferences.sort((a,b)=>{
        var num1:any = a.getPreferenceNumber();
        var num2:any = b.getPreferenceNumber();
        return num1 - num2;
      });
    });
  }

  getInstituteByCourseId()
  {
    console.log("courseId",this.courseId);
    this.studentService.getInstituteCourseList(this.courseId)
    .subscribe(response=>{
      this.instituteCourseList = response.json().result;
      console.log("instituteCourseList",this.instituteCourseList);
    });
  }

  addPreference()
  {
    console.log("course : ",this.instituteCourse.course,"institute :",this.instituteCourse)
    this.preferences.push(new Preference(null,this.instituteCourse,this.preferences.length+1,this.formNumber));
  }

  moveUp(preferenceNumber:Number)
  {
    if(preferenceNumber!=1)
    {
      console.log("Preferences :",this.preferences);
      var key = parseInt(preferenceNumber.toString());
      var index = key - 1;
      console.log("key",key);
      this.preferences[index].setPreferenceNumber(key-1);
      this.preferences[index-1].setPreferenceNumber(key);
      this.preferences.sort(function (a,b) {
          var num1:any = a.getPreferenceNumber();
          var num2:any = b.getPreferenceNumber();
          return num1 - num2;
      });      
    }
  }
  moveDown(preferenceNumber:Number)
  {
    if(preferenceNumber!=this.preferences.length)
    {
      var key = parseInt(preferenceNumber.toString());
      var index = key - 1;
      this.preferences[index].setPreferenceNumber(key+1);
      this.preferences[index+1].setPreferenceNumber(key);
      this.preferences.sort(function (a,b) {
        var num1:any = a.getPreferenceNumber();
        var num2:any = b.getPreferenceNumber();
        return num1 - num2;
    });     
    }
  }

  deletePreference(preference:Preference)
  {
    console.log("Preference to delete :",preference);
    for (const p of this.preferences) {
      if(p.getPreferenceNumber()>preference.getPreferenceNumber())
      {
        var pNumber:any = p.getPreferenceNumber();
        p.setPreferenceNumber(pNumber-1);
      }
    }
    var delElement:any = preference.getPreferenceNumber();
    delElement-=1;
    this.preferences.splice(delElement,1);

    this.studentService.deletePreference(preference)
    .subscribe(response=>{
      if(response.json().result==1)
        alert("Preference Deleted!");
        this.save();
    });
  }

  save()
  {
    var result;
    this.preferences.forEach( (preference:Preference) =>{
      this.studentService.savePreference(preference).subscribe(response=>{
        result = response.json().result;
      });
    });
    if(result!=0)
      alert("Preferences saved successfully!");
  }
}
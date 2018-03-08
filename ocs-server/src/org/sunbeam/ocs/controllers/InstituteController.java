package org.sunbeam.ocs.controllers;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.sunbeam.ocs.entities.Course;
import org.sunbeam.ocs.entities.Institute;
import org.sunbeam.ocs.entities.InstituteAllotment;
import org.sunbeam.ocs.entities.InstituteCourse;
import org.sunbeam.ocs.entities.InstituteLogin;
import org.sunbeam.ocs.entities.Student;
import org.sunbeam.ocs.services.InstituteService;
import org.sunbeam.ocs.utils.Response;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class InstituteController {
	
	@Autowired
	InstituteService instituteService;
	
	
	@PostMapping("/institute/register")
	public Object register(@RequestBody Institute institute)
	{
		Serializable result = instituteService.registerInstitute(institute);
		return new Response(result);
	}
	
	@PostMapping("/institute/login")
	public Object authenticateInstitute(@RequestBody InstituteLogin instituteLogin)
	{
		Object result = instituteService.authenticateInstitute(instituteLogin);
		return new Response(result);
	}
	
	@PostMapping("/institute/account/addnew")
	public Object addInstituteAccount(@RequestBody InstituteLogin instituteLogin)
	{
		return new Response(instituteService.addInstituteAccount(instituteLogin));
	}
	
	@PostMapping("/institute/detail/update")
	public Object updateInstitutDetail(@RequestBody Institute institute)
	{
		return new Response(instituteService.updateInstituteDetails(institute));
	}
	
	//to handle account related models
	
	@PostMapping("/institute/account/changepassword")	
	public Object changeInstitutePassword(@RequestBody InstituteLogin instituteLogin)
	{
		return new Response(instituteService.changeInstitutePassword(instituteLogin));
	}
	
	//to handle course related models
	
	@PostMapping("/institute/course/addnew")
	public Object addCourseInInstitute(@RequestBody InstituteCourse instituteCourse)
	{
		System.out.println(instituteCourse.getInstitute().getInstituteId());
		System.out.println(instituteCourse.getCourse().getCourseId());
		System.out.println(instituteCourse.getNumberOfSeat());
		return new Response(instituteService.addInstituteCourse(instituteCourse));
	}
	
	@PostMapping("/institute/course/update")
	public Object updateCourseInInstitute(@RequestBody InstituteCourse instituteCourse)
	{
		return instituteService.updateInstituteCourse(instituteCourse);
	}
	
	@GetMapping("/courses/all")
	@ResponseBody
	public Object getCourseList()
	{
		/*List<Course>courses  = instituteService.getCourseList();
		List<String> courseIds = new ArrayList<>();
		for (Course course : courses) {
			courseIds.add(course.getCourseId());
		}*/
		return new Response(instituteService.getCourseList());
		
	}
	
	@GetMapping("/institute/course/byinstituteid/{id}")
	public Object getInstituteCourseByInstituteid(@PathVariable("id") int id)
	{
		
		/*List<InstituteCourse> instituteCourses = instituteService.getInstituteCourseByInstituteId(institute.getInstituteId());	
		
		List<String> courses = new ArrayList<>();
		
		for (InstituteCourse instituteCourse : instituteCourses) {
			courses.add(instituteCourse.getCourse().getCourseId());
		}
		return courses;*/
		
		return new Response(instituteService.getInstituteCourseByInstituteId(id));	

	}
	
	@GetMapping("/institute/course/bycourseid/{id}")
	public Object getInstituteCourseByCourseId(@PathVariable("id") String id)
	{
		/*List<InstituteCourse> instituteCourses = instituteService.getInstituteCourseByCourseId(course.getCourseId());
		
		List<Integer> courses = new ArrayList<>();
		
		for (InstituteCourse instituteCourse:instituteCourses) {
			courses.add(instituteCourse.getInstituteCourseId());
		}
		return courses;*/
		return new Response(instituteService.getInstituteCourseByCourseId(id));
	}
	
	@GetMapping("/institute/student/get/{formNumber}")
	public Object getStudentDetails(@PathVariable("formNumber") long formNumber)
	{
		return new Response(instituteService.getStudentDetails(formNumber));
	}
	
	@PostMapping("/institute/student/validate")
	public Object validateStudent(@RequestBody Student student)
	{
		return new Response(instituteService.ValidateStudent(student));		
	}
	
	@GetMapping("/institute/instituteallotment/institutecourse/{id}")
	public Object getInstituteAllotmentByInstituteCourseId(@PathVariable("id") int instituteCourseId)
	{
		return new Response(instituteService.getInstituteAllotmentListByInstituteCourseId(instituteCourseId));
	}
	
	@GetMapping("/institute/instituteallotment/student/{formNumber}")
	public Object getInstituteAllotmentByFormNumber(@PathVariable("formNumber") long formNumber)
	{
		return new Response(instituteService.getInstituteAllotmentByFormNumber(formNumber));
	}
	@PostMapping("/institute/instituteallotment/admitstudent")
	public Object admitStudent(@RequestBody InstituteAllotment instituteAllotment)
	{
		return new Response(instituteService.updateInstituteAllotment(instituteAllotment));
	}
}

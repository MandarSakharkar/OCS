package org.sunbeam.ocs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.sunbeam.ocs.entities.Admin;
import org.sunbeam.ocs.entities.CounsellingProcessPhase;
import org.sunbeam.ocs.entities.Course;
import org.sunbeam.ocs.services.AdminService;
import org.sunbeam.ocs.utils.AccountUtils;
import org.sunbeam.ocs.utils.Response;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping("/admin/addnew")
	public Object addAdmin(@RequestBody Admin admin)
	{
		admin.setPassword(AccountUtils.getMD5Password(admin.getPassword()));
		return new Response(adminService.addAdmin(admin));
	}
	
	@PostMapping("/admin/login")
	public Object authenticateAdmin(@RequestBody Admin admin)
	{
		admin.setPassword(AccountUtils.getMD5Password(admin.getPassword()));
		return new Response(adminService.authenticateAdmin(admin));
	}
	
	@PostMapping("/admin/account/changepassword")
	public Object updateAdminPassword(@RequestBody Admin admin)
	{
		admin.setPassword(AccountUtils.getMD5Password(admin.getPassword()));
		return new Response(adminService.updateAdminPassword(admin));
	}
	
	@PostMapping("/admin/delete")
	public Object deleteAdmin(@RequestBody Admin admin)
	{
		admin.setPassword(AccountUtils.getMD5Password(admin.getPassword()));
		return new Response(adminService.deleteAdmin(admin));
	}
	
	@PostMapping("/admin/counsellingphase/change")
	public Object setCousellingProcessPhase(@RequestBody CounsellingProcessPhase counsellingProcessPhase)
	{
		return new Response(adminService.setCounsellingProcessPhase(counsellingProcessPhase));
	}
	
	@GetMapping("/admin/counsellingphase/get")
	public Object getCousellingProcessPhase()
	{
		return new Response(adminService.getCounsellingProcessPhase());
	}
	
	@GetMapping("/admin/institute/allocate/{round}")
	public Object doInstituteAllotment(@PathVariable("round") int round)
	{
		return new Response(adminService.doInstituteAllocation(round));		
	}

	@PostMapping("/admin/course/add")
	public Object addCourse(@RequestBody Course course)
	{
		return new Response(adminService.AddCourse(course));
	}
	
	

}

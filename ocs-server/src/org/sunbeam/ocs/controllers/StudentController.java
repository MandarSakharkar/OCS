package org.sunbeam.ocs.controllers;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.sunbeam.ocs.dao.StudentDao;
import org.sunbeam.ocs.entities.Preference;
import org.sunbeam.ocs.entities.Student;
import org.sunbeam.ocs.entities.StudentAccount;
import org.sunbeam.ocs.services.StudentService;
import org.sunbeam.ocs.utils.ErrorMessage;
import org.sunbeam.ocs.utils.Response;
import org.sunbeam.ocs.utils.AccountUtils;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

	@Autowired
	StudentService studentService;

	public StudentController() {
	}


	//StudentAccount 

	@PostMapping("/student/login")	
	public Object AuthenticateCandidate(@RequestBody StudentAccount studentAccount)
	{
		studentAccount.setPassword(AccountUtils.getMD5Password(studentAccount.getPassword()));
		studentAccount = studentService.authenticateStudent(studentAccount);

		if(studentAccount!=null)
		{
			return studentAccount;
		}
		else
		{
			return new ErrorMessage("Invalid StudentAccount");
		}
	}

	@PostMapping("/student/register")
	@ResponseBody
	public Object RegisterCandidate(@RequestBody StudentAccount studentAccount)
	{
		System.out.println(studentAccount); 
		/*
		 * getMD5Password is utility in AccountUtils class of this project. 
		 * to convert your plain password to MD5 digest
		 */
		studentAccount.setPassword(AccountUtils.getMD5Password(studentAccount.getPassword()));	
		return new Response((Object)studentService.addStudentAccount(studentAccount));
	}

	@PostMapping("/student/account/changepassword")
	public Object changePassword(@RequestBody StudentAccount studentAccount)
	{
		studentAccount.setPassword(AccountUtils.getMD5Password(studentAccount.getPassword()));
		return new Response(studentService.changeStudentPassword(studentAccount)); 
	}



	//Student Detail

	@PostMapping("/student/detail/fill")
	@ResponseBody
	public Object FillCandidateDetail(@RequestBody Student student)
	{
		
		return new Response(studentService.addStudent(student));
	}

	@PostMapping("/student/detail/update")
	@ResponseBody
	public Object updateCandidateDetail(@RequestBody Student student)
	{
		return new Response(studentService.updateStudent(student));
	}

	@GetMapping("/student/detail/get/{formNumber}")
	public Object getStudent(@PathVariable("formNumber") long formNumber)
	{
		return new Response(studentService.getStudent(formNumber));
	}

	//student preferences


	@PostMapping("/student/preference/save")
	public Object addStudentPreference(@RequestBody Preference preference)
	{
		return new Response(studentService.savePreference(preference));
	}

	@PostMapping("/student/preference/update")
	public Object updateStudentPreference(@RequestBody Preference preference)
	{
		return new Response(studentService.updateStudentPreference(preference));
	}

	@PostMapping("/student/preference/delete")
	public Object deleteStudentPreference(@RequestBody Preference preference)
	{
		return new Response(studentService.deleteStudentPreference(preference));
	}



	@GetMapping("/student/preference/get/{formNumber}")
	public Object getStudentPreferenceByFormNumber(@PathVariable("formNumber") long formNumber)
	{
		return new Response(studentService.getPreferencesByFormNumber(formNumber));
	}

	@GetMapping("/student/counsellingphase")
	public Object getCounsellingPhase()
	{
		return new Response(studentService.getCounsellingProcessPhase());
	}

	@GetMapping("/student/instituteallotment/get/{formNumber}")
	public Object getInstituteAllotment(@PathVariable("formNumber") long formNumber)
	{
		return new Response(studentService.getInstituteAllotmentByFormNumber(formNumber));
	}

	@Autowired
	StudentDao dao;

	@GetMapping("/student/all")
	public Object studentlist()
	{		
		return dao.getStudentsList();
	}

	@PostMapping("/student/account/forgotpassword")
	public Object forgotPassword(@RequestBody StudentAccount studentAccount)
	{
		studentAccount = studentService.getStudentAccount(studentAccount);
		studentAccount.setPassword(AccountUtils.getMD5Password(studentAccount.getFormNumber()+"#abc"));	

		String to = studentAccount.getEmailId(); //student's mail id  
		String from = "kdmldbatu@gmail.com";     //server mail id  
		
		String msg = "Hello! Your form number is "+studentAccount.getFormNumber()+"and new password is" +studentAccount.getFormNumber()+"#abc. Please login with this credentials and change the password";
		String subject = "Reset forgotten password";


		if (this.sendMail(from, "Diamond#3", to, subject, msg)==1)
		{
			studentService.changeStudentPassword(studentAccount);
			return new Response(1);
		}
		else 
			return new Response(0);
	}

	public int sendMail(String from,String password,String to,String sub,String msg){  
		//Get properties object    
		Properties props = new Properties();    
		props.put("mail.smtp.host", "smtp.gmail.com");    
		props.put("mail.smtp.socketFactory.port", "465");    
		props.put("mail.smtp.socketFactory.class",    
				"javax.net.ssl.SSLSocketFactory");    
		props.put("mail.smtp.auth", "true");    
		props.put("mail.smtp.port", "465");    
		//get Session   
		Session session = Session.getDefaultInstance(props,    
				new javax.mail.Authenticator() {    
			protected PasswordAuthentication getPasswordAuthentication() {    
				return new PasswordAuthentication(from,password);  
			}    
		});    
		//compose message    
		try {    
			MimeMessage message = new MimeMessage(session);    
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
			message.setSubject(sub);    
			message.setText(msg);    
			//send message  
			Transport.send(message);    
			return 1;  
		} catch (MessagingException e) {
			e.printStackTrace();
			return 0;
		}    

	}
}

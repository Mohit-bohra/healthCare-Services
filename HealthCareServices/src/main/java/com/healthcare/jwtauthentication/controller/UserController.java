package com.healthcare.jwtauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.jwtauthentication.model.Appointment;
import com.healthcare.jwtauthentication.model.Doctor;
import com.healthcare.jwtauthentication.model.User;
import com.healthcare.jwtauthentication.security.services.AppointmentService;
import com.healthcare.jwtauthentication.security.services.DoctorService;
import com.healthcare.jwtauthentication.security.services.UserLocalService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserController {

	
	@Autowired
	DoctorService userservice;
	
	@Autowired
	UserLocalService service;
	
	@Autowired
	AppointmentService apptservice;
	
	
	  @GetMapping("/test/user")
	  public Iterable<Doctor> findAll() {
		  Iterable<Doctor> doctors = userservice.findAll(); 
		  for (Doctor doctor : doctors) 
		  {
		  if(doctor.getAppts() != null) 
		  {
		  System.out.println("appts --> "+doctor.getAppts().size()); 
		  } 
		  }
		 return userservice.findAll(); 
		 }
	  @PostMapping("/test/create")
		public Appointment save(@RequestBody Appointment appt) {
			return apptservice.save(appt);
              }
	  
}
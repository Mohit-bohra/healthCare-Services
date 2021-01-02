package com.healthcare.jwtauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.jwtauthentication.model.Appointment;
import com.healthcare.jwtauthentication.model.Doctor;
import com.healthcare.jwtauthentication.model.User;
import com.healthcare.jwtauthentication.security.services.AppointmentService;




@CrossOrigin(origins="*")
@RestController
public class AppointmentController {
	
	@Autowired(required=true)
	AppointmentService service;
	
	
	
	@GetMapping("/api/test/appointment")
	public ResponseEntity<Iterable<Appointment>> findAll() {
		
		
		Iterable<Appointment> appts = service.findAll();
	     return ResponseEntity.ok(appts);
	  }
	
	@PostMapping("/api/test/appointment/create")
	public Appointment save(@RequestBody Appointment appt) {
		return service.save(appt);

	}
	/*
	 * @GetMapping("/appointment/{appId}") public Appointment findById(@PathVariable
	 * int appId) { return service.findById(appId);
	 * 
	 * 
	 * }
	 */
	
	
	
	

 

//
//
//@PutMapping("/appointment/update/{appId}/{fee}/{available}")
//public String update(@PathVariable int docId,@PathVariable double fee,@PathVariable LocalDate available)
//{
//	return service.update(docId,fee,available);
//}
	

}

package com.healthcare.jwtauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
public class HealthCareApi {

	@Autowired
	UserLocalService service;
	
	@Autowired
	DoctorService userservice;
	
	
	
	/*
	 * @GetMapping("/test/user")
	 * 
	 * @PreAuthorize("hasRole('USER') or hasRole('ADMIN')") public
	 * ResponseEntity<Iterable<Doctor>> findAllDoctors() {
	 * 
	 * 
	 * Iterable<Doctor> appts = userservice.findAllDoctors(); return
	 * ResponseEntity.ok(appts); }
	 */
	 
	@GetMapping("/test/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Iterable<User>> findAll() {

		System.out.println("in find all");

		Iterable<User> users = service.findAll();

		return ResponseEntity.ok(users);
	}
}
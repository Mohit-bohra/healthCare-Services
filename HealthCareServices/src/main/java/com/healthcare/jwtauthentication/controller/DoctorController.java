package com.healthcare.jwtauthentication.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.jwtauthentication.model.Doctor;
import com.healthcare.jwtauthentication.security.services.DoctorService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/test")
public class DoctorController {
	@Autowired(required = true)
	DoctorService service;

	
	
	  @GetMapping("/doctors") 
	  public Iterable<Doctor> findAll() {
	  Iterable<Doctor> doctors = service.findAll(); 

	 return service.findAll(); 
	 }
	 

	@DeleteMapping({ "/doctors/delete/{docid}" })
	public ResponseEntity<String> delete(@PathVariable("docid") int docid) {

		System.out.println("deleting doctor -> " + docid);
		service.deleteById(docid);
		return ResponseEntity.ok("deleted " + docid);
	}

	@GetMapping("/doctor/{docId}")
	public Optional<Doctor> findById(@PathVariable int docId) {
		return service.findById(docId);

	}

	@PostMapping("/doctors/create")
	public Doctor save(@RequestBody Doctor doctor) {
		return service.save(doctor);

	}

	@PutMapping("/doctors/update/{docid}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable("docid") int docid,@RequestBody Doctor doctor) {
		System.out.println("method called" );

		Optional<Doctor> docdata = service.findById(docid);

		if (docdata.isPresent()) {
			Doctor doctor1 = docdata.get();
			doctor1.setAvailable(doctor.getAvailable());
			
			return new ResponseEntity<>(service.save(doctor1), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

}

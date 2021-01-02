package com.healthcare.jwtauthentication.security.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.jwtauthentication.model.Doctor;
import com.healthcare.jwtauthentication.repository.IDoctorRepository;


@Service
public class DoctorService {
	@Autowired(required=true)
	private IDoctorRepository repository;
	
	
	public Iterable<Doctor> findAll() {
		return repository.findAll();
		
	}
	
		
	public Doctor save(Doctor doctor) {
		return repository.save(doctor);
	}

	
	public String deleteById(int docid) {
		repository.deleteById(docid);
		return "Deleted";
	}
	
	
	
	
   public Optional<Doctor> findById(int docid) {
		
		return repository.findById(docid);
	}
	
	
	/*
	 * public String save(int docid,double fee,LocalDate available,Long
	 * contact,String location) { Doctor doctor=findById(docid); doctor.setFee(fee);
	 * doctor.setAvailable(available); doctor.setContact(contact);
	 * doctor.setLocation(location); repository.save(doctor); return "Updated"
	 * +doctor; }
	 */

	
	

}

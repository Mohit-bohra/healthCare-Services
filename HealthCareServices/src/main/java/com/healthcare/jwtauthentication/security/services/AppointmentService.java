package com.healthcare.jwtauthentication.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.jwtauthentication.model.Appointment;
import com.healthcare.jwtauthentication.repository.IAppointmentRepository;




@Service
public class AppointmentService {
	@Autowired(required=true)
	private IAppointmentRepository repository;
	

	public Iterable<Appointment> findAll() {
		return repository.findAll();
		
	}
	
	
	public Appointment findById(int user_id) {
		return repository.findById(user_id).get();
	}
	
	
	public String deleteById(int appid) {
		repository.deleteById(appid);
		return "Deleted";
	}
	
	
	
	
	public Appointment save(Appointment entity) {
		Appointment newAppointment=repository.save(entity);
		return repository.save(newAppointment);
		}
	
	
	
//	
//	public String update(int appid,LocalDate available) {
//		Appointment appointment=findById(appid);
//		appointment.setAvailable(available);
//		repository.save(appointment);
//		return "Updated" +appointment;
//	}
//	
	

}

package com.healthcare.jwtauthentication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.jwtauthentication.model.Appointment;



@Repository

public interface IAppointmentRepository extends CrudRepository<Appointment, Integer> {

}

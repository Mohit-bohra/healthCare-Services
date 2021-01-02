package com.healthcare.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.jwtauthentication.model.Doctor;


@Repository
public interface IDoctorRepository extends CrudRepository<Doctor, Integer> {
}

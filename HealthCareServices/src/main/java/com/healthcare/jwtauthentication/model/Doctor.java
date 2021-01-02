package com.healthcare.jwtauthentication.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name="doctor")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int docid;
	private String docname;
	private String speciality;
	private LocalDate available;
	private double fee;
	private String location;
	private Long contact;
	
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(
			name="appointment",
			joinColumns = @JoinColumn(name="docid"),
			inverseJoinColumns =@JoinColumn(name="user_id")
		)
	private List<Appointment> appts;
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(int docid, String docname, String speciality, LocalDate available, double fee, String location,
			Long contact, List<Appointment> appts) {
		super();
		this.docid = docid;
		this.docname = docname;
		this.speciality = speciality;
		this.available = available;
		this.fee = fee;
		this.location = location;
		this.contact = contact;
		this.appts = appts;
	}
	public int getDocid() {
		return docid;
	}
	public String getDocname() {
		return docname;
	}
	public void setDocname(String docname) {
		this.docname = docname;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public LocalDate getAvailable() {
		return available;
	}
	public void setAvailable(LocalDate available) {
		this.available = available;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public List<Appointment> getAppts() {
		return appts;
	}
	public void setAppts(List<Appointment> appts) {
		this.appts = appts;
	}
	@Override
	public String toString() {
		return "Doctor [docid=" + docid + ", docname=" + docname + ", speciality=" + speciality + ", available="
				+ available + ", fee=" + fee + ", location=" + location + ", contact=" + contact + ", appts=" + appts
				+ "]";
	}
	

	
}

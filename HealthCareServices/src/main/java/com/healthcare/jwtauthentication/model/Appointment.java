package com.healthcare.jwtauthentication.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appid;
	
	@OneToOne(cascade =CascadeType.ALL,fetch = FetchType.EAGER)
	 @JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	private int fees;
	private LocalDate appdate;
	private int docid;
	
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Appointment(int appid, User user, int fees, LocalDate appdate, int docid) {
		super();
		this.appid = appid;
		this.user = user;
		this.fees = fees;
		this.appdate = appdate;
		this.docid = docid;
	}

	public int getDocid() {
		return docid;
	}
	public void setDocid(int docid) {
		this.docid = docid;
	}
	public int getAppid() {
		return appid;
	}
	public void setAppid(int appid) {
		this.appid = appid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public LocalDate getAppdate() {
		return appdate;
	}
	public void setAppdate(LocalDate appdate) {
		this.appdate = appdate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appdate == null) ? 0 : appdate.hashCode());
		result = prime * result + appid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		if (appdate == null) {
			if (other.appdate != null)
				return false;
		} else if (!appdate.equals(other.appdate))
			return false;
		if (appid != other.appid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Appointment [appid=" + appid + ", user=" + user + ", fees=" + fees + ", appdate=" + appdate + ", docid="
				+ docid + "]";
	}
	
	
	
	
	

}

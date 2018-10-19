package com.app.hib.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(schema="practice")
public class Patient {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pid;
	private String pname;
	
	@ManyToOne
	@JoinColumn(name="fk_doctor_id")
	@JsonBackReference
	private Doctor doctor;
	
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Patient [pid=");
		builder.append(pid);
		builder.append(", pname=");
		builder.append(pname);
	/*	builder.append(", doctor=");
		builder.append(doctor);*/
		builder.append("]");
		return builder.toString();
	}
	
	
	
}

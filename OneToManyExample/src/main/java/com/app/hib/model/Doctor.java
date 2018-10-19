package com.app.hib.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(schema="practice")
public class Doctor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int docId;
	private String docName;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="doctor")
	@JsonManagedReference
	private List<Patient> patientList;
	
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public List<Patient> getPatientList() {
		return patientList;
	}
	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Doctor [docId=");
		builder.append(docId);
		builder.append(", docName=");
		builder.append(docName);
		builder.append(", patientList=");
		builder.append(patientList);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}

package com.app.hib.OneToManyExample;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.app.hib.model.Doctor;
import com.app.hib.model.Patient;

public class HibernateClient { 
	
	public static Doctor getDoctorById(int did) {
		Doctor doctor = null;
		try {
			Configuration cfg = new Configuration().configure();
	        SessionFactory sf = cfg.buildSessionFactory();
	        Session s = sf.openSession();
	        doctor = (Doctor) s.get(Doctor.class, did);
	        /*List<Patient> patient = doctor.getPatientList();
	        System.out.println(patient);*/
	        return doctor;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return doctor;
	}
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println(getDoctorById(1));
       // insertDetails();
    }

	public static void insertDetails() {
		Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        
        Doctor doctor = new Doctor();
        doctor.setDocName("Gurava Reddy");
        
        Doctor doctor1 = new Doctor();
        doctor1.setDocName("Poornima Devi");
        
        Patient patient = new Patient();
        patient.setPname("Maheswara Reddy");
        patient.setDoctor(doctor);
        
        Patient patient1 = new Patient();
        patient1.setPname("Manohar Reddy");
        patient1.setDoctor(doctor);
        
        Patient patient2 = new Patient();
        patient2.setPname("Obula Reddy");
        patient2.setDoctor(doctor1);
        
        
        List<Patient> patientList = new ArrayList<Patient>();
        patientList.add(patient);
        patientList.add(patient1);
        patientList.add(patient2);
        
		doctor.setPatientList(patientList);
        
        s.save(doctor);
        s.save(doctor1);
        
        tx.commit();
	}
}

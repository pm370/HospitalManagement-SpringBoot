package com.pranav.ss.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.pranav.ss.view.JsonViews.CommonJsonView;
import com.pranav.ss.view.JsonViews.PatientJsonView;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patientId;
	
	@JsonView(CommonJsonView.class)
	private String patientName;

	@OneToMany(mappedBy = "patient")
	@JsonView(PatientJsonView.class)
	private List<Appointment> appointments;

	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST}, fetch = FetchType.EAGER)
	@JoinTable(name="patient_doctor", joinColumns = @JoinColumn(name="doctor_id"), 
	inverseJoinColumns = @JoinColumn(name="patient_id"))
	@JsonView(PatientJsonView.class)
	private List<Doctor> doctors;
	
	@Embedded
	private Insurance insurance;
	
	public void setDoctor(Doctor doctor) {
		if(doctors!=null) {
			doctors.add(doctor);
			return;
		}
		doctors=new ArrayList<>();
		doctors.add(doctor);
	}
	
	
}

package com.pranav.ss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.pranav.ss.entity.Patient;
import com.pranav.ss.pojo.PatientPojo;
import com.pranav.ss.service.PatientService;
import com.pranav.ss.view.JsonViews.CommonJsonView;
import com.pranav.ss.view.JsonViews.InsuranceJsonView;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@PostMapping("/save")
	public void savePatient(@RequestBody PatientPojo patientPojo) {
		patientService.savePatient(patientPojo);
	}

	@JsonView(CommonJsonView.class)
	@GetMapping("/find/all")
	public List<Patient> fetchAllPatients() {
		return patientService.fetchAllPatients();
	}
	
	@JsonView(CommonJsonView.class)
	@GetMapping("/find/{id}")
	public String fetchPatientById(@PathVariable("id") Long id) {
		return patientService.fetchPatientById(id);
	}
	
	@JsonView(CommonJsonView.class)
	@GetMapping("/find/{name}")
	public List<Patient> fetchPatientsByName(@PathVariable("name") String name) {
		return patientService.fetchPatientsByName(name);
	}
	
	@JsonView(InsuranceJsonView.class)
	@GetMapping("/find/by/insurance/{provider}")
	public List<Patient> fetchPatientsByInsuranceProvider(@PathVariable("provider") String provider) {
		return patientService.fetchPatientsByInsuranceProvider(provider);
	}
	
	@JsonView(InsuranceJsonView.class)
	@GetMapping("/find/by/insurance/{type}")
	public List<Patient> fetchPatientsByInsuranceType(@PathVariable("type") String type) {
		return patientService.fetchPatientsByInsuranceType(type);
	}
}

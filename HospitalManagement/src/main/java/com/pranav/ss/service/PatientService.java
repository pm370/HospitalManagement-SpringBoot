package com.pranav.ss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranav.ss.entity.Insurance;
import com.pranav.ss.entity.Patient;
import com.pranav.ss.pojo.PatientPojo;
import com.pranav.ss.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepo;

	public void savePatient(PatientPojo patientPojo) {
		Patient patient = new Patient();
		patient.setPatientName(patientPojo.getPatientName());
		Insurance insurance = new Insurance();
		insurance.setInsuranceProvider(patientPojo.getInsuranceProvider());
		insurance.setInsuranceSum(patientPojo.getInsuranceSum());
		insurance.setInsuranceType(patientPojo.getInsuranceType());
		patient.setInsurance(insurance);
		patientRepo.save(patient);
	}

	public List<Patient> fetchAllPatients() {
		return patientRepo.findAll();
	}
	
	public String fetchPatientById(Long id) {
		Patient findById = patientRepo.findById(id).get();
		return findById.getPatientName();
	}
	
	public List<Patient> fetchPatientsByName(String name) {
		return patientRepo.findPatientsByName(name);
	}
	
	public List<Patient> fetchPatientsByInsuranceProvider(String provider) {
		return patientRepo.findPatientsByInsuranceProvider(provider);
	}
	
	public List<Patient> fetchPatientsByInsuranceType(String type) {
		return patientRepo.findPatientsByInsuranceType(type);
	}

}

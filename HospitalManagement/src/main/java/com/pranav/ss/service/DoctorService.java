package com.pranav.ss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranav.ss.entity.Doctor;
import com.pranav.ss.pojo.DoctorPojo;
import com.pranav.ss.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepo;

	public List<Doctor> fetchAllDoctors() {
		return doctorRepo.findAll();
	}

	public String fetchDoctorById(Long id) {
		Doctor findById = doctorRepo.findById(id).get();
		return findById.getDoctorName();
	}

	public List<Doctor> fetchDoctorsByName(String name) {
		return doctorRepo.findDoctorsByName(name);
	}

	public List<Doctor> fetchDoctorsByQualification(String qualification) {
		return doctorRepo.findDoctorsByQualification(qualification);
	}

	public List<Doctor> fetchDoctorsByDepartment(String department) {
		return doctorRepo.findDoctorsByDepartment(department);
	}

	public void saveDoctor(DoctorPojo doctorPojo) {
		Doctor doctor = new Doctor();
		doctor.setDoctorName(doctorPojo.getDoctorName());
		doctor.setDoctorDepartment(doctorPojo.getDoctorDepartment());
		doctor.setDoctorQualification(doctorPojo.getDoctorQualification());
		doctorRepo.save(doctor);
	}
}

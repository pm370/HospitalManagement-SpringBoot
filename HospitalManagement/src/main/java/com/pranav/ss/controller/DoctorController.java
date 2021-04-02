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
import com.pranav.ss.entity.Doctor;
import com.pranav.ss.pojo.DoctorPojo;
import com.pranav.ss.service.DoctorService;
import com.pranav.ss.view.JsonViews.CommonJsonView;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/save")
	public void saveDoctor(@RequestBody DoctorPojo doctorPojo) {
		doctorService.saveDoctor(doctorPojo);
	}
	
	@GetMapping("/find/all")
	@JsonView(CommonJsonView.class)
	public List<Doctor> fetchAllDoctors() {
		return doctorService.fetchAllDoctors();
	}
	
	@GetMapping("/find/{id}")
	@JsonView(CommonJsonView.class)
	public String fetchDoctorById(@PathVariable("id") Long id) {
		return doctorService.fetchDoctorById(id);
	}
	
	@GetMapping("/find/{name}")
	@JsonView(CommonJsonView.class)
	public List<Doctor> fetchDoctorsByName(@PathVariable("name") String name) {
		return doctorService.fetchDoctorsByName(name);
	}
	
	@GetMapping("/find/{qualification}")
	@JsonView(CommonJsonView.class)
	public List<Doctor> fetchDoctorsByQualification(@PathVariable("qualification")String qualification) {
		return doctorService.fetchDoctorsByQualification(qualification);
	}
	
	@GetMapping("/find/{department}")
	@JsonView(CommonJsonView.class)
	public List<Doctor> fetchDoctorsByDepartment(@PathVariable("department") String department) {
		return doctorService.fetchDoctorsByDepartment(department);
	}
	
	
}

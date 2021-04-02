package com.pranav.ss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.pranav.ss.entity.Appointment;
import com.pranav.ss.pojo.AppointmentPojo;
import com.pranav.ss.service.AppointmentService;
import com.pranav.ss.view.JsonViews.AppointmentJsonView;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@PostMapping("/save")
	public void saveAppointment(AppointmentPojo appointmentPojo) {
		appointmentService.saveAppointment(appointmentPojo);
	}
	
	
	@GetMapping("/find/all")
	@JsonView(AppointmentJsonView.class)
	public List<Appointment> fetchAllAppointments() {
		return appointmentService.fetchAllAppointments();
	}
	
	@GetMapping("/find/{id}")
	@JsonView(AppointmentJsonView.class)
	public Appointment fetchAppointmentById(@PathVariable("id") Long id) {
		return appointmentService.fetchAppointmentById(id);
	}
	
	@GetMapping("/find/by/{date}")
	@JsonView(AppointmentJsonView.class)
	public List<Appointment> fetchAppointmentsByDate(@PathVariable("date") String date) {
		return appointmentService.fetchAppointmentsByDate(date);
	}
	
	@GetMapping("/find/by/{time}")
	@JsonView(AppointmentJsonView.class)
	public List<Appointment> fetchAppointmentsByTime(@PathVariable("time") String time) {
		return appointmentService.fetchAppointmentsByTime(time);
	}
	
	@GetMapping("/find/by/{date}/{time}")
	@JsonView(AppointmentJsonView.class)
	public List<Appointment> fetchAppointmentsByDateTime(@PathVariable("date") String date, @PathVariable("time") String time) {
		return appointmentService.fetchAppointmentsByDateTime(date, time);
	}
	
	@GetMapping("/find/by/patient/{id}")
	@JsonView(AppointmentJsonView.class)
	public List<Appointment> fetchAppointmentsByPatientId(@PathVariable("id") Long id) {
		return appointmentService.fetchAppointmentsByPatientId(id);
	}
	
	@GetMapping("/find/by/doctor/{id}")
	@JsonView(AppointmentJsonView.class)
	public List<Appointment> fetchAppointmentsByDoctorId(@PathVariable("id") Long id) {
		return appointmentService.fetchAppointmentsByDoctorId(id);
	}
}

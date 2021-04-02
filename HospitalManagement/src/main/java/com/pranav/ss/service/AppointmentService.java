package com.pranav.ss.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranav.ss.entity.Appointment;
import com.pranav.ss.entity.Doctor;
import com.pranav.ss.entity.Insurance;
import com.pranav.ss.entity.Patient;
import com.pranav.ss.pojo.AppointmentPojo;
import com.pranav.ss.repository.AppointmentRepository;
import com.pranav.ss.repository.DoctorRepository;
import com.pranav.ss.repository.PatientRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepo;

	@Autowired
	private DoctorRepository doctorRepo;
	
	@Autowired
	private PatientRepository patientRepo;
	
	public void saveAppointment(AppointmentPojo appointmentPojo) {
		Appointment appointment = new Appointment();
		Date date = Date.valueOf(appointmentPojo.getAppointmentDate());
		appointment.setAppointmentDate(date);
		Time time = Time.valueOf(appointmentPojo.getAppointmentTime());
		appointment.setAppointmentTime(time);
		Doctor doctor = doctorRepo.findByDoctorName(appointmentPojo.getDoctorName());
		appointment.setDoctor(doctor);
		Patient patient = patientRepo.findByPatientName(appointmentPojo.getPatientName());
		appointment.setPatient(patient);
		appointmentRepo.save(appointment);
	}
	
	public List<Appointment> fetchAllAppointments() {
		return appointmentRepo.findAll();
	}
	
	public Appointment fetchAppointmentById(Long id) {
		Appointment findById = appointmentRepo.findById(id).get();
		return findById;
	}
	
	public List<Appointment> fetchAppointmentsByDate(String date) {
		return appointmentRepo.findAppointmentsByDate(Date.valueOf(date));
	}
	
	public List<Appointment> fetchAppointmentsByTime(String time) {
		return appointmentRepo.findAppointmentsByTime(Time.valueOf(time));
	}
	
	public List<Appointment> fetchAppointmentsByDateTime(String date, String time) {
		return appointmentRepo.findAppointmentsByDateTime(Date.valueOf("2021-03-16"), Time.valueOf("13:30:00"));
	}
	
	public List<Appointment> fetchAppointmentsByPatientId(Long id) {
		return appointmentRepo.findAppointmentsByPatientId(id);
	}
	
	public List<Appointment> fetchAppointmentsByDoctorId(Long id) {
		return appointmentRepo.findAppointmentsByDoctorId(id);
	}
}

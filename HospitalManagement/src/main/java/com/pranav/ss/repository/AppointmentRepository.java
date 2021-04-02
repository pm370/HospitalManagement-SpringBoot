package com.pranav.ss.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pranav.ss.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	@Query("select a from Appointment a where a.appointmentDate=:appointmentDate")
	List<Appointment> findAppointmentsByDate(@Param("appointmentDate") Date date);
	
	@Query("select a from Appointment a where a.appointmentTime=:appointmentTime")
	List<Appointment> findAppointmentsByTime(@Param("appointmentTime") Time time);
	
	@Query("select a from Appointment a where a.appointmentDate=:appointmentDate AND appointmentTime=:appointmentTime")
	List<Appointment> findAppointmentsByDateTime(@Param("appointmentDate") Date date,@Param("appointmentTime") Time time);
	
	@Query("select a from Appointment a where a.patient.patientId=:patientId")
	List<Appointment> findAppointmentsByPatientId(@Param("patientId") Long patientId);
	
	@Query("select a from Appointment a where a.doctor.doctorId=:doctorId")
	List<Appointment> findAppointmentsByDoctorId(@Param("doctorId") Long doctorId);
}

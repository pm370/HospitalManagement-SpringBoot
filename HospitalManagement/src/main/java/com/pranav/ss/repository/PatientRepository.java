package com.pranav.ss.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pranav.ss.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

	@Query("select p from Patient p where p.patientName=:name")
	List<Patient> findPatientsByName(@Param("name") String name);
	
	@Query("select p from Patient p where p.insurance.insuranceProvider=:insuranceProvider")
	List<Patient> findPatientsByInsuranceProvider(@Param("insuranceProvider") String insuranceProvider);
	
	@Query("select p from Patient p where p.insurance.insuranceType=:insuranceType")
	List<Patient> findPatientsByInsuranceType(@Param("insuranceType") String insuranceType);

	Patient findByPatientName(String string);
	
	
}

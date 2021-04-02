package com.pranav.ss.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pranav.ss.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	@Query("select d from Doctor d where d.doctorName=:doctorName")
	List<Doctor> findDoctorsByName(@Param("doctorName") String doctorName);

	@Query("select d from Doctor d where d.doctorQualification=:doctorQualification")
	List<Doctor> findDoctorsByQualification(@Param("doctorQualification") String doctorQualification);
	
	@Query("select d from Doctor d where d.doctorDepartment=:doctorDepartment")
	List<Doctor> findDoctorsByDepartment(@Param("doctorDepartment") String doctorDepartment);

	Doctor findByDoctorName(String string);
}

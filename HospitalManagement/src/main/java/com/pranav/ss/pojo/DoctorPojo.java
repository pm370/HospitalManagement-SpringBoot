package com.pranav.ss.pojo;

import com.pranav.ss.util.Enums.DoctorDepartments;
import com.pranav.ss.util.Enums.DoctorQualifications;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorPojo {

	private String doctorName;
	private DoctorDepartments doctorDepartment;
	private DoctorQualifications doctorQualification;

}

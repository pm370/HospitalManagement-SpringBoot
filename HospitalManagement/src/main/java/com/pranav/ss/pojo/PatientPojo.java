package com.pranav.ss.pojo;

import com.pranav.ss.util.Enums.InsuranceTypes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientPojo {

	private String patientName;
	private String insuranceProvider;
	private InsuranceTypes insuranceType;
	private double insuranceSum;
}

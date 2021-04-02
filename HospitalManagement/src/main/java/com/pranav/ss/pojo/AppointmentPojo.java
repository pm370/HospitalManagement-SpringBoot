package com.pranav.ss.pojo;

import java.sql.Date;
import java.sql.Time;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentPojo {

	private String appointmentDate;
	private String appointmentTime;
	private String doctorName;
	private String patientName;
}

package com.pranav.ss.entity;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fasterxml.jackson.annotation.JsonView;
import com.pranav.ss.util.Enums.InsuranceTypes;
import com.pranav.ss.view.JsonViews.InsuranceJsonView;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Insurance {
	
	@JsonView(InsuranceJsonView.class)
	private String insuranceProvider;
	
	@JsonView(InsuranceJsonView.class)
	@Enumerated(EnumType.STRING)
	private InsuranceTypes insuranceType;
	
	@JsonView(InsuranceJsonView.class)
	private double insuranceSum;
	
}

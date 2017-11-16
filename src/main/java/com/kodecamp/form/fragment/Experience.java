package com.kodecamp.form.fragment;

import java.util.Date;

public class Experience {

	private String company;
	private String designation;
	private Date fromDate;
	private Date toDate;
	private String roll;

	public Experience(final String company, final String designation, final Date fromDate
			,final Date toDate, final String roll) {
		
		
		this.company = company;
		this.designation = designation;
		this.fromDate = fromDate;
		this.roll = roll;
	}

	public String getCompany() {
		return company;
	}

	public String getDesignation() {
		return designation;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public Date getToDate() {
		return toDate;
	}


	public String getRoll() {
		return roll;
	}

}

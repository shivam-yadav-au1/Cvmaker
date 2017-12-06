package com.kodecamp.form.fragment;

import java.util.Date;

public class Experience {

	private String company;
	private String designation;
	private String  fromDate;
	private String toDate;
	private String roll;

	public Experience(final String company, final String designation, final String  fromDate
			,final String toDate, final String roll) {
		
		this.company = company;
		this.designation = designation;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.roll = roll;
	}

	public String getCompany() {
		return company;
	}

	public String getDesignation() {
		return designation;
	}

	public String getFromDate() {
		return fromDate;
	}

	public String getToDate() {
		return toDate;
	}


	public String getRoll() {
		return roll;
	}
	
	@Override
	public String toString() {
		return this.company + " "+this.designation+" "+this.fromDate+" "+toDate+" "+this.roll;
	}

}

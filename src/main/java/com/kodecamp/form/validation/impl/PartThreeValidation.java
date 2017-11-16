package com.kodecamp.form.validation.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kodecamp.form.validation.IPartValidation;
import com.kodecamp.form.validation.IPartValidationResult;
import com.kodecamp.form.validation.IValidationResult;
import com.kodecamp.form.validation.PartValidationResult;
import com.kodecamp.form.validation.ValidationResult;

public class PartThreeValidation implements IPartValidation {
	
	private String companyField ;
	private String designationField;
	private Date fromDateField;
	private Date toDateField;
	private String rollField;
	private List messageList;
	private ValidationResult.Status status;
	
	public PartThreeValidation(final String companyField,final String designationField
			,final Date fromDateField ,final Date toDateField,final String rollField){
		
		this.companyField = companyField;
		this.designationField = designationField;
		this.fromDateField = fromDateField;
		this.toDateField = toDateField;
		this.rollField = rollField;
		
	}
	
	

	@Override
	public IPartValidationResult validateFields() {
		
		System.out.println("PartThreeValidation validateFields() was called .");
		
		messageList = new ArrayList();
		status = ValidationResult.Status.PASS;
		
		IValidationResult vr = new EmptyValidation(new NullValidation()).validate(companyField);
		if(vr.status().equals(ValidationResult.Status.FAIL)) {
			status = ValidationResult.Status.FAIL;
			messageList.add(vr.message());
		}
		
		IValidationResult vr2 = new EmptyValidation(new NullValidation()).validate(designationField);
		if(vr2.status().equals(ValidationResult.Status.FAIL)) {
			status = ValidationResult.Status.FAIL;
			messageList.add(vr2.message());
		}
		
		
		IValidationResult vr3 = new DateValidation(new EmptyValidation(new NullValidation()),fromDateField,toDateField)
				.validate();
		if(vr3.status().equals(ValidationResult.Status.FAIL)) {
			status = ValidationResult.Status.FAIL;
			messageList.add(vr3.message());
		}
		
		
		IValidationResult vr4 = new EmptyValidation(new NullValidation()).validate(rollField);
		if(vr4.status().equals(ValidationResult.Status.FAIL)) {
			status = ValidationResult.Status.FAIL;
			messageList.add(vr4.message());
		}
		
		return new PartValidationResult(messageList,status);
	}

}

package com.kodecamp.form.validation.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.kodecamp.form.validation.IPartValidationResult;
import com.kodecamp.form.validation.IValidationResult;
import com.kodecamp.form.validation.IValidator;
import com.kodecamp.form.validation.PartValidationResult;
import com.kodecamp.form.validation.ValidationResult;
import com.kodecamp.form.validation.ValidationResult.Status;

public class PartOneValidation {

	private String nameField;
	private String professionField;
	private List<String> messageList;
	private ValidationResult.Status status ;

	public PartOneValidation(final String nameField, final String professionField) {
		this.nameField = nameField;
		this.professionField = professionField;
	}

	public IPartValidationResult validateFields() {
		
		messageList = new ArrayList();
	    status = Status.PASS;
		
		IValidationResult vr = new EmptyValidation(new NullValidation()).validate(nameField);

		
		// checking status for name field
		
		if(vr.status().equals(ValidationResult.Status.FAIL)) {
			status = Status.FAIL;
			messageList.add(vr.message()); 
		}
		
		// checking status for profession field
		
		IValidationResult validationResult = new EmptyValidation(new NullValidation()).validate(professionField);
		if(validationResult.status().equals(ValidationResult.Status.FAIL)) {
			status = Status.FAIL;
			messageList.add(validationResult.message());
		}
		
		return new PartValidationResult(messageList,status);
	}

}

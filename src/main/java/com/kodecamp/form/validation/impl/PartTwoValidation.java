package com.kodecamp.form.validation.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.kodecamp.form.validation.IPartValidation;
import com.kodecamp.form.validation.IPartValidationResult;
import com.kodecamp.form.validation.IValidationResult;
import com.kodecamp.form.validation.PartValidationResult;
import com.kodecamp.form.validation.ValidationResult;
import com.kodecamp.form.validation.ValidationResult.Status;

public class PartTwoValidation implements IPartValidation {
	
	private String emailField;
	private String phoneNumberField;
	private String linkField;
	
	private List messageList;
	private ValidationResult.Status status ;
	
	
	public PartTwoValidation(final String emailField ,final String phoneNumberField,String linkField) {
		this.emailField = emailField;
		this.phoneNumberField = phoneNumberField;
		this.linkField = linkField;
	}

	@Override
	public IPartValidationResult validateFields() {
		
		messageList = new ArrayList();
		status = ValidationResult.Status.PASS;
		
		// validation for email field
		IValidationResult vr = new EmailValidation(new EmptyValidation(new NullValidation())).validate(emailField);
		
		if(vr.status().equals(ValidationResult.Status.FAIL)) {
			status = ValidationResult.Status.FAIL;
			messageList.add(vr.message());
			
		}
	
		
		// validation for phone number field
		IValidationResult vr2 = new PhoneNumberValidation(new EmptyValidation(new NullValidation()))
				.validate(phoneNumberField);
		if(vr2.status().equals(ValidationResult.Status.FAIL)) {
			status = ValidationResult.Status.FAIL;
			messageList.add(vr2.message());
		}

		
		
		
		// validation for link field
		IValidationResult vr3 = new EmptyValidation(new NullValidation()).validate(linkField);
		if(vr3.status().equals(ValidationResult.Status.FAIL)) {
			status = ValidationResult.Status.FAIL;
			messageList.add(vr3.message());
		}
		
		
		
		Iterator<String> itr = messageList.iterator();
		while(itr.hasNext()) {
			System.out.println("Value in List :"+itr.next());
		}
		
		return new PartValidationResult(messageList,status);
	}



}

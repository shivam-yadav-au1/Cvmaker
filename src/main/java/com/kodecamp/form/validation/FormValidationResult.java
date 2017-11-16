package com.kodecamp.form.validation;

import java.util.List;

import com.kodecamp.form.validation.ValidationResult.Status;

public class FormValidationResult implements IFormValidationResult {
	
	private IPartValidationResult partValidationResult;
	
	
	
	public FormValidationResult(final IPartValidationResult partValidationResult) {
		this.partValidationResult = partValidationResult;
	}
	
	
	
	@Override
	public Status status() {
		
		return partValidationResult.status();
	}

	@Override
	public List getMessageList() {

		return partValidationResult.getMessageList();
	}

}

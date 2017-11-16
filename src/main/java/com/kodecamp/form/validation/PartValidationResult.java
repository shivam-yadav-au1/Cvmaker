package com.kodecamp.form.validation;

import java.util.List;

import com.kodecamp.form.validation.ValidationResult.Status;

public class PartValidationResult implements IPartValidationResult{
	
	private List messageList;
	private ValidationResult.Status status;
	
	public PartValidationResult(final List messageList,final ValidationResult.Status status) {
		this.messageList = messageList;
		this.status = status;
	}

	@Override
	public List getMessageList() {
	
		return messageList;
	}

	@Override
	public Status status() {
		
		return status;
	}
	
	

}

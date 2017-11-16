package com.kodecamp.form.validation;

import java.util.List;

public interface IPartValidationResult {
	
	public List getMessageList();
	public ValidationResult.Status status();

}

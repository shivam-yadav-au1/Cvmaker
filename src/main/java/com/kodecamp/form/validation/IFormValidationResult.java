package com.kodecamp.form.validation;

import java.util.List;

public interface IFormValidationResult {
	
	public ValidationResult.Status status();
	public List getMessageList();

}

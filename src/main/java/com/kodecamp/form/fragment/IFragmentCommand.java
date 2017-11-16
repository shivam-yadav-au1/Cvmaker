package com.kodecamp.form.fragment;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IFragmentCommand {
	
	public void execute(final HttpServletRequest req,final HttpServletResponse resp);
	public List<String> getStatus();
	public void putStatus(String message);

}

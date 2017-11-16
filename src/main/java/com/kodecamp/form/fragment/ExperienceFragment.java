package com.kodecamp.form.fragment;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExperienceFragment implements IFragmentCommand {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("Experience Fragment");
		
		

	}

	@Override
	public List<String> getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putStatus(String message) {
		// TODO Auto-generated method stub
		
	}

}

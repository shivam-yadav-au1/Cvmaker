package com.kodecamp.form.fragment;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SkillsFragment implements IFragmentCommand {
	
	private List<String> statusMessages;

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("Skill Fragment....");

	}

	@Override
	public List<String> getStatus() {
		// TODO Auto-generated method stub
		return statusMessages;
	}

	@Override
	public void putStatus(String message) {
		statusMessages.add(message);
		
	}

}

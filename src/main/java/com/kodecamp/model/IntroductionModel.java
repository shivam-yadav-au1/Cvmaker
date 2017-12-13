package com.kodecamp.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kodecamp.form.fragment.Introduction;

public class IntroductionModel {
	
	
	private HttpServletRequest req;
	
	public IntroductionModel(final HttpServletRequest req) {
		this.req = req;
	}
	
	private HttpSession getSession() {
		HttpSession session = req.getSession();
		return session;
	}
	
	public void addIntroduction(final String name,final String profession) {
		HttpSession session = getSession();
		
		Introduction intro = (Introduction) session.getAttribute("intro");
		if(intro == null) {
			intro = new Introduction(name,profession);
		}
		session.setAttribute("intro", intro);
		req.setAttribute("intro", intro);
	}
	
	

}

package com.kodecamp.model;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kodecamp.form.fragment.Experience;

public class ExperienceModel {


	private HttpServletRequest req;
	private int index = 0;
	
	public ExperienceModel(final HttpServletRequest req) {
		
		this.req = req;
		
	}
	
	public HttpSession getSession() {
		HttpSession session = req.getSession();
		return session;
		
	}
	
	public void deleteExperience(String index) {
		int experienceListIndex = Integer.parseInt(index);
		
		HttpSession session = getSession();
		Map<Integer,Experience> expMap = (Map<Integer, Experience>) session.getAttribute("expMap");
		if(expMap == null) {
			System.out.println("ExpMap is null so no value to delete .");
		}
		
		expMap.remove(experienceListIndex);
		
	}
	
	public void addExperience(Experience exp) {
		
		HttpSession session = getSession();
		
		
		Map<Integer,Experience> expMap = (Map<Integer, Experience>) session.getAttribute("expMap");
		
		if(expMap == null) {
			expMap = new HashMap<Integer,Experience>();
		}
		index = index +1;
	
		expMap.put(index,exp);
		
		session.setAttribute("expMap", expMap);
		req.setAttribute("expMap", expMap);
		
		
	}
	

	
}

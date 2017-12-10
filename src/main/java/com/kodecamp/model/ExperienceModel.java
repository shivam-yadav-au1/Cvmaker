package com.kodecamp.model;

import java.util.ArrayList;
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
	
	public void deleteExperience(String index) {
		int experienceListIndex = Integer.parseInt(index);
		
		HttpSession session = req.getSession();
		List<Experience> experienceList = (List<Experience>) session.getAttribute("experienceList");
		
		experienceList.remove(experienceListIndex);
	}
	
	public void addExperience(Experience exp) {
		
		HttpSession session = req.getSession();
		
		
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

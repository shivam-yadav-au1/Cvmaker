package com.kodecamp.model;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kodecamp.form.fragment.Skill;

public class SkillModel {

	private HttpServletRequest req;
	private int index = 0;
	
	public SkillModel(final HttpServletRequest req) {
		this.req = req;
	}
	
	private HttpSession getSession() {
		HttpSession session = req.getSession();
		return session;
	}
	
	public void deleteSkill(String id) {
		
		int skillId = Integer.parseInt(id);
		HttpSession session = getSession();
		Map<Integer,Skill> skillMap = (Map<Integer, Skill>) session.getAttribute("skillMap");
		skillMap.remove(skillId);
		session.setAttribute("skillMap", skillMap);
	}
	
	public void addSkill(final Skill skill) {
		
		HttpSession session = getSession();
		
		Map<Integer,Skill> skillMap = (HashMap<Integer, Skill>) session.getAttribute("skillMap");
		if(skillMap == null) {
			skillMap = new HashMap<Integer,Skill>();
		}
		index = index +1;
		skillMap.put(index, skill);
		session.setAttribute("skillMap", skillMap);
		req.setAttribute("skillMap",skillMap);
		
	}
}

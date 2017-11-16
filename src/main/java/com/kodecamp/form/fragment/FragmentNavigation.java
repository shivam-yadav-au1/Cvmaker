package com.kodecamp.form.fragment;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FragmentNavigation {

	private static final String INTRODUCTION = "introduction";
	private static final String CONTACT = "contact";
	private static final String EXPERIENCE = "experience";
	private static final String SKILL = "skill";
	private static final Map<String, FragmentDetails> fragmentDetailsMap = new HashMap<>();
	
	static {
		fragmentDetailsMap.put(INTRODUCTION, new FragmentDetails("/views/introduction_form.jsp",new IndroductionFragment()));
		fragmentDetailsMap.put(CONTACT, new FragmentDetails("/views/contact_form.jsp",new ContactFragment()));
		fragmentDetailsMap.put(EXPERIENCE, new FragmentDetails("/views/experience_form.jsp",new ExperienceFragment()));
		fragmentDetailsMap.put(SKILL, new FragmentDetails("/views/skill_form.jsp",new SkillsFragment()));
	}

	public FragmentNavigation() {

	}

	public static void navigate(final String action, final String fragmentName, final HttpServletRequest req,
			final HttpServletResponse resp) {

	}
	

	// copy constructor or clone method to return new copy
	public static FragmentDetails fragmentView(final String navigationKey) {
		return fragmentDetailsMap.get(navigationKey);
	}

}

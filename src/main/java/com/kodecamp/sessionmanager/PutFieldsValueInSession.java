package com.kodecamp.sessionmanager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kodecamp.form.fragment.Contact;
import com.kodecamp.form.fragment.Experience;
import com.kodecamp.form.fragment.Introduction;
import com.kodecamp.form.fragment.Skill;

public class PutFieldsValueInSession {
	
	HttpServletRequest  req;
	HttpServletResponse resp;
	
	
	public PutFieldsValueInSession(final HttpServletRequest req,final HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
	}
	
	private HttpSession getSession() {
		HttpSession session = this.req.getSession();
		return session;
	}
	

	
	 public  void putValuesInSession() {
		
		
		System.out.println("putValuesInSession() called .");
		HttpSession session = getSession();
		
		Introduction intro = new Introduction(req.getParameter("name"),req.getParameter("profession"));
	
		session.setAttribute("intro", intro);
		req.setAttribute("intro", intro);
		
		
		Contact contact = new Contact(req.getParameter("email"),req.getParameter("phone"),req.getParameter("link"));
		
		session.setAttribute("contact", contact);
		req.setAttribute("contact", contact);
		
		Experience exp = new Experience(req.getParameter("company"),req.getParameter("designation"),req.getParameter("fromDate"),
				req.getParameter("toDate"),req.getParameter("roll"));
		
		session.setAttribute("exp", exp);
		req.setAttribute("exp", exp);
		
		Skill skill = new Skill(req.getParameter("skills"),req.getParameter("profeciency"),req.getParameter("year"),req.getParameter("months"));
		
		session.setAttribute("skill", skill);
		req.setAttribute("skill",skill);
	}

}

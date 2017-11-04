package com.kodecamp.formitem.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class FragmentAction {
	
	
	public FragmentAction() {
		
	}
	
	/*
	 * Perform different action/task on different fragment
	 */
	
	public static void performAction(final String action,final String fragmentName,final HttpServletRequest req) {
		
		switch (fragmentName) {
		case "introduction":
			
			Introduction intro = new Introduction(req.getParameter("name"), req.getParameter("profession"));
			List introList = new ArrayList();
			introList.add(intro);
			break;
			
		case "contact":
			
			Contact contact = new Contact(req.getParameter("email"),req.getParameter("phone"),req.getParameter("link"));
			List contactList = new ArrayList();
			contactList.add(contact);
			
		case "experience":
			
			System.out.println("Date :"+req.getParameter("fromDate"));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date fromDate = null;
			Date toDate = null;
			try {
				fromDate = sdf.parse(req.getParameter("fromDate"));
				toDate = sdf.parse(req.getParameter("toDate"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			Experience experience = new Experience(req.getParameter("company")
					,req.getParameter("designation")
					,fromDate
					,toDate
					,req.getParameter("roll"));
			List expList = new ArrayList();
			expList.add(experience);
			System.out.println("Experience add successfully...");
			
		case "skill":
			
			if("Add More".equals(action)) {
				req.setAttribute("fragmentName", "skill");
			}
			else if("Submit".equals(action)) {
				req.setAttribute("fragmentName", "skill");
			}

		default:
			break;
		}
		
		
	}

}

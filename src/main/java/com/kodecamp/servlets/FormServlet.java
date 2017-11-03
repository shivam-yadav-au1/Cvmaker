package com.kodecamp.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kodecamp.formitem.util.Contact;
import com.kodecamp.formitem.util.Experience;
import com.kodecamp.formitem.util.Introduction;

public class FormServlet extends HttpServlet {

	public FormServlet() {
		System.out.println(getClass().getName());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("doGet() of Class : " + getClass().getName());

		String view = "/views/form.jsp";
		String action = req.getParameter("action");

		String fragmentName = req.getParameter("nextFragmentName") == null ? "introduction"
				: req.getParameter("nextFragmentName");

		req.setAttribute("fragmentName", fragmentName);

		if ("introduction".equals(fragmentName)) {
			
//			System.out.println("Value of action in " + fragmentName + " " + action);
			navigate(action, fragmentName, req, resp);
		}

		if ("contact".equals(fragmentName)) {
		

//			System.out.println("Value of action in " + fragmentName + " " + action);

			navigate(action, fragmentName, req, resp);

		}
		if ("experience".equals(fragmentName)) {
		

//			System.out.println("Value of action in " + fragmentName + " " + action);
			navigate(action, fragmentName, req, resp);
		}
		if ("skill".equals(fragmentName)) {
			

//			System.out.println("Value of action in " + fragmentName + " " + action);

			navigate(action, fragmentName, req, resp);
		}

		req.getServletContext().getRequestDispatcher(view).forward(req, resp);

	}

	private void navigate(final String action, final String fragmentName, final HttpServletRequest req,
			final HttpServletResponse resp) {

		switch (fragmentName) {
		case "introduction":
			if ("Next".equals(action)) {
				req.setAttribute("fragmentName", "contact");
				
			} 
			else if("Save".equals(action)){
				
				Introduction intro = new Introduction(req.getParameter("name"), req.getParameter("profession"));
				List introList = new ArrayList();
				introList.add(intro);
				req.setAttribute("fragmentName", "introduction");
			}

			break;

		case "contact":
			if ("Next".equals(action)) {
				req.setAttribute("fragmentName", "experience");
			} 
			else if("Save".equals(action)){
				
				Contact contact = new Contact(req.getParameter("email"),req.getParameter("phone"),req.getParameter("link"));
				
				List contactList = new ArrayList();
				contactList.add(contact);
				req.setAttribute("fragmentName", "contact");
			}

			break;

		case "experience":
			if ("Next".equals(action)) {
				req.setAttribute("fragmentName", "skill");
			} 
			else if("Add More".equals(action)){
				
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
				
				req.setAttribute("fragmentName", "experience");
			}
			break;
			
		case "skill":
			if("Add More".equals(action)) {
				req.setAttribute("fragmentName", "skill");
			}
			else if("Submit".equals(action)) {
				req.setAttribute("fragmentName", "skill");
			}

		default:
			System.out.println("Default block executed...");
			break;
		}
	}

}

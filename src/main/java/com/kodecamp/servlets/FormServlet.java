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
import com.kodecamp.formitem.util.FragmentNavigation;
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

			FragmentNavigation.navigate(action, fragmentName, req, resp);
		}

		if ("contact".equals(fragmentName)) {

			FragmentNavigation.navigate(action, fragmentName, req, resp);

		}
		if ("experience".equals(fragmentName)) {

			FragmentNavigation.navigate(action, fragmentName, req, resp);
		}
		if ("skill".equals(fragmentName)) {

			FragmentNavigation.navigate(action, fragmentName, req, resp);
		}

		req.getServletContext().getRequestDispatcher(view).forward(req, resp);

	}

}

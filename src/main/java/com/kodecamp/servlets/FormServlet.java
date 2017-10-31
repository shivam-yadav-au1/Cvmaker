package com.kodecamp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {

	public FormServlet() {
		System.out.println(getClass().getName());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("doGet() of Class : " + getClass().getName());

		String view = "/views/form.jsp";

		req.setAttribute("fragmentName",
				req.getParameter("nextFragmentName") == null ? "introduction" : req.getParameter("nextFragmentName"));

		req.getServletContext().getRequestDispatcher(view).forward(req, resp);
	}

}

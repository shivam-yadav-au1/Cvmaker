package com.kodecamp.form.fragment;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndroductionFragment implements IFragmentCommand {
	
	private List<String> statusMessages;

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		System.out.println("Value of request :"+req);
		System.out.println("Value of response :"+resp);
		
		System.out.println("Indroduction fragment command....");

		String name = req.getParameter("name");
		String profession = req.getParameter("profession");
		String action = req.getParameter("action") == null ? (String) req.getAttribute("action")
				: req.getParameter("action");
		
		System.out.println("Value of action in fragment is :"+action);
		
		System.out.println("Value of name in fragment :"+name+" and value of profession :"+profession);

		if ("Save".equals(action)) {
			Introduction intro = new Introduction(name, profession);
			List list = new ArrayList();
			boolean status = list.add(intro);
			if(status) {
				putStatus("Item Saved Successfully...");
				req.setAttribute("fragmentView", "/views/introduction_form.jsp");
				req.setAttribute("messages", "Item Saved Successfully...");
			}
			else {
				
				putStatus("Item not Saved !!!");
				req.setAttribute("messages", "Item NOt Saved !!!");
			}

		}
		

	}

	@Override
	public void putStatus(final String message) {
		// TODO Auto-generated method stub
		statusMessages = new ArrayList<String>();
		statusMessages.add(message);
	}

	@Override
	public List<String> getStatus() {
		// TODO Auto-generated method stub
		return statusMessages;
	}

}

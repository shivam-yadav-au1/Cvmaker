package com.kodecamp.formitem.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FragmentNavigation {

	public FragmentNavigation() {

	}

	public static void navigate(final String action, final String fragmentName, final HttpServletRequest req,
			final HttpServletResponse resp) {
		
		switch (fragmentName) {
		
		// when fragment name is introduction
		
		case "introduction":
			if ("Next".equals(action)) {
				req.setAttribute("fragmentName", "contact");

			} else if ("Save".equals(action)) {

				FragmentAction.performAction(action, fragmentName, req);
				req.setAttribute("fragmentName", "introduction");

			}

			break;
		// when fragment name is contact
			
		case "contact":
			if ("Next".equals(action)) {
				req.setAttribute("fragmentName", "experience");
			} else if ("Save".equals(action)) {

				FragmentAction.performAction(action, fragmentName, req);
				req.setAttribute("fragmentName", "contact");
			}

			break;
			
		// when fragment name is experience
			
		case "experience":
			if ("Next".equals(action)) {
				req.setAttribute("fragmentName", "skill");
			} else if ("Add More".equals(action)) {

				FragmentAction.performAction(action, fragmentName, req);

				req.setAttribute("fragmentName", "experience");
			}
			break;

		// when fragment name is skill
			
		case "skill":
			FragmentAction.performAction(action, fragmentName, req);

		default:
			System.out.println("Default block executed...");
			break;
		}
	}

}

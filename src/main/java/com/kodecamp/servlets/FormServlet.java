package com.kodecamp.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kodecamp.Validation.impl.DateRangeValidation;
import com.kodecamp.Validation.impl.DateValidation;
import com.kodecamp.Validation.impl.EmailValidation;
import com.kodecamp.Validation.impl.EmptyValidator;
import com.kodecamp.Validation.impl.NullValidator;
import com.kodecamp.Validation.impl.PhoneNumberValidation;
import com.kodecamp.form.fragment.Experience;
import com.kodecamp.form.fragment.FragmentDetails;
import com.kodecamp.form.fragment.FragmentNavigation;
import com.kodecamp.form.fragment.IFragmentCommand;
import com.kodecamp.form.fragment.RouteDetails;



import com.kodecamp.validationapi.IValidationResult;
import com.kodecamp.validationapi.ValidationResult;


public class FormServlet extends HttpServlet {


	public FormServlet() {
		System.out.println(getClass().getName());
	}

	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException {
		doGet(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getParameter("action") == null ? (String) req.getAttribute("action")
				: req.getParameter("action");
		
		List messageList = new ArrayList();
		HttpSession session = req.getSession();
		
		
	
		
		//if action is equal to submit
		
		if ("Submit".equals(action)) {
			System.out.println("Submit block executed ....");
			if(partOneValidation(req.getParameter("name"),req.getParameter("profession"),messageList)
					&& partTwoValidation(req.getParameter("email"),req.getParameter("phone"),req.getParameter("link"),messageList) 
					&& partThreeValidation(req.getParameter("company"),req.getParameter("designation"),req.getParameter("fromDate"),req.getParameter("toDate"),req.getParameter("roll"),messageList) 
					&& partFourValidation(req.getParameter("skills"),req.getParameter("profeciency"),req.getParameter("experience"),req.getParameter("months"),messageList)) 
			{
				
				req.setAttribute("messages", messageList);
				
			}else {
				// Fail show error message from messageList
				req.setAttribute("messages", messageList);
			}
					
			
		}
		
		// if Action is equal to Add More
		if("Add More".equals(action)) {
		
			if(partThreeValidation(req.getParameter("company"),req.getParameter("designation"),req.getParameter("fromDate"),req.getParameter("toDate"),req.getParameter("roll"),messageList)) {
				
				Experience exp = new Experience(req.getParameter("company"),req.getParameter("designation")
						,req.getParameter("fromDate"),req.getParameter("toDate"),req.getParameter("roll"));
				
				// Adding experience object in experience List 
				List<Experience> experienceList = (List<Experience>) session.getAttribute("experienceList");
				
					if(experienceList == null) {
						
						System.out.println("experience list is null");
						experienceList = new ArrayList<Experience>();
						
					}
					boolean flag = experienceList.add(exp);
					System.out.println("Item added successfully : "+flag);
					session.setAttribute("experienceList", experienceList);
					req.setAttribute("experienceList", experienceList);
					
					
					Iterator<Experience> itr = experienceList.iterator();
					while(itr.hasNext()) {
						System.out.println(itr.next());
					}
			}
			
		}
		
		req.getServletContext().getRequestDispatcher("/views/form.jsp").forward(req, resp);

	}

	/*
	 * Skills Validation
	 */
	private boolean partFourValidation(final String skillname,final String profeciency,final String experience,final String months,List messageList) {
		
		System.out.println("Part Four Validation called ");
		
		IValidationResult vr = null;
		boolean flag = true;
		
		vr = new EmptyValidator(new NullValidator()).validate(skillname);
		if(vr.status().equals(ValidationResult.Status.FAIL)) {
			flag = false;
			messageList.add(vr.message());
		}
		
		vr = new EmptyValidator(new NullValidator()).validate(profeciency);
		if(vr.status().equals(ValidationResult.Status.FAIL)) {
			flag = false;
			messageList.add(vr.message());
		}
		
		vr = new EmptyValidator(new NullValidator()).validate(experience);
		if(vr.status().equals(ValidationResult.Status.FAIL)) {
			flag = false;
			messageList.add(vr.message());
		}
		
		vr = new EmptyValidator(new NullValidator()).validate(months);
		if(vr.status().equals(ValidationResult.Status.FAIL)) {
			flag = false;
			messageList.add(vr.message());
		}
		
		return flag;
	}
	/*
	 * Experience Validation
	 */
	private boolean partThreeValidation(String company, String designation, String fromDate, String toDate,
			String roll,List messageList) {
		
		System.out.println("Part three Validation called...");
		
		IValidationResult vr = null;
		boolean flag = true;
		
		vr = new EmptyValidator(new NullValidator()).validate(company);
		if(vr.status().equals(ValidationResult.Status.FAIL)) {
			flag = false;
			messageList.add(vr.message());
		}
		
		vr = new EmptyValidator(new NullValidator()).validate(designation);
		if(vr.status().equals(ValidationResult.Status.FAIL)) {
			flag = false;
			messageList.add(vr.message());
		}
		
	
		flag = validateDate(fromDate,toDate,messageList);
		
		
		vr = new EmptyValidator(new NullValidator()).validate(roll);
		if(vr.status().equals(ValidationResult.Status.FAIL)) {
			flag = false;
			messageList.add(vr.message());
		}
		return flag;
	}

	/*
	 * Contact Validation
	 */
	private boolean partTwoValidation(String email, String phone, String link,List messageList) {
		
		System.out.println("Part two Validation...");
		
		IValidationResult vr = null;
		boolean flag = true;
		vr = new EmailValidation(new EmptyValidator(new NullValidator())).validate(email);
		
		if(vr.status().equals(ValidationResult.Status.FAIL)) {
			flag = false;
			messageList.add(vr.message());
		}
		vr = new PhoneNumberValidation(new EmptyValidator(new NullValidator())).validate(phone);
		if(vr.status().equals(ValidationResult.Status.FAIL)) {
			flag = false;
			messageList.add(vr.message());
		}
		vr = new EmptyValidator(new NullValidator()).validate(link);
		if(vr.status().equals(ValidationResult.Status.FAIL)) {
			flag = false;
			messageList.add(vr.message());
		}
		return flag;
	}
	/*
	 * Introduction Validation 
	 */
	private boolean partOneValidation(String name, String profession, List messageList) {
		
		System.out.println("PartOne Valdation called ...");
		
		IValidationResult vr = null;
		boolean flag = true;
		vr = new EmptyValidator(new NullValidator()).validate(name);
		if(vr.status().equals(ValidationResult.Status.FAIL)) {
			flag = false;
			messageList.add(vr.message());
		}
		vr = new EmptyValidator(new NullValidator()).validate(profession);
		if(vr.status().equals(ValidationResult.Status.FAIL)) {
			flag = false;
			messageList.add(vr.message());
		}
		
		return flag;
	}
	/*
	 * Date Validation
	 */
	private boolean  validateDate(String fromDate,String toDate,List messageList) {
		
		
//		System.out.println("Value of toDate : "+toDate);
		IValidationResult vr1 = null;
		IValidationResult vr2 = null;
		
		boolean flag = true;
		vr1 = new DateValidation(new EmptyValidator(new NullValidator())).validate(fromDate);
		vr2 = new DateValidation(new EmptyValidator(new NullValidator())).validate(toDate);
		
		if(vr1.status().equals(ValidationResult.Status.FAIL) && vr2.status().equals(ValidationResult.Status.FAIL)) {
			flag = false;
			messageList.add(vr1.message());
			messageList.add(vr2.message());
			
			
			
		}
		else {
			IValidationResult vr = new DateRangeValidation(fromDate, toDate).validate();
			if(vr.status().equals(ValidationResult.Status.FAIL)) {
				flag = false;
				messageList.add(vr.message());
			}
		}
		return flag;
	}


}

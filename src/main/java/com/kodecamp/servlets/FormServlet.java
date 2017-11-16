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

import com.kodecamp.Validation.impl.DateRangeValidation;
import com.kodecamp.Validation.impl.DateValidation;
import com.kodecamp.Validation.impl.EmailValidation;
import com.kodecamp.Validation.impl.EmptyValidator;
import com.kodecamp.Validation.impl.NullValidator;
import com.kodecamp.Validation.impl.PhoneNumberValidation;
import com.kodecamp.form.fragment.FragmentDetails;
import com.kodecamp.form.fragment.FragmentNavigation;
import com.kodecamp.form.fragment.IFragmentCommand;
import com.kodecamp.form.fragment.RouteDetails;
import com.kodecamp.form.validation.FormValidationResult;
import com.kodecamp.form.validation.IFormValidationResult;
import com.kodecamp.form.validation.IPartValidationResult;

import com.kodecamp.form.validation.impl.PartOneValidation;
import com.kodecamp.form.validation.impl.PartThreeValidation;
import com.kodecamp.form.validation.impl.PartTwoValidation;
import com.kodecamp.validationapi.IValidationResult;
import com.kodecamp.validationapi.ValidationResult;


public class FormServlet extends HttpServlet {


	public FormServlet() {
		System.out.println(getClass().getName());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getParameter("action") == null ? (String) req.getAttribute("action")
				: req.getParameter("action");


		List messageList = new ArrayList();
		if ("Submit".equals(action)) {

			if(partOneVaidation(req.getParameter("name"),req.getParameter("profession"),messageList)
					&& partTwoVaidation(req.getParameter("email"),req.getParameter("phone"),req.getParameter("link"),messageList)
					&& partThreeValidation(req.getParameter("company"),req.getParameter("designation"),req.getParameter("fromDate"),req.getParameter("toDate"),req.getParameter("roll"),messageList)
				) {
				// if success do something 
			}else {
				req.setAttribute("messages", messageList);
			}
					
			
		}
		
		req.getServletContext().getRequestDispatcher("/views/form.jsp").forward(req, resp);

	}

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

	private boolean partTwoVaidation(String email, String phone, String link,List messageList) {
		
		System.out.println("Part two Validation...");
		
		IValidationResult vr = null;
		boolean flag = true;
		vr = new EmptyValidator(new NullValidator(new EmailValidation())).validate(email);
		
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

	private boolean partOneVaidation(String name, String profession, List messageList) {
		
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
	
	private boolean  validateDate(String fromDate,String toDate,List messageList) {
		
		IValidationResult vr1 = null;
		IValidationResult vr2 = null;
		
		boolean flag = true;
		vr1 = new EmptyValidator(new NullValidator()).validate(fromDate);
		vr2 = new EmptyValidator(new NullValidator()).validate(toDate);
		if(vr1.status().equals(ValidationResult.Status.FAIL) && vr2.status().equals(ValidationResult.Status.FAIL)) {
			flag = false;
			messageList.add(vr1.message());
			messageList.add(vr2.message());
			
			
		}
		else {
			IValidationResult vr = new DateRangeValidation(new DateValidation(), fromDate, toDate).validate();
			if(vr.status().equals(ValidationResult.Status.FAIL)) {
				flag = false;
				messageList.add(vr.message());
			}
		}
		return flag;
	}


}

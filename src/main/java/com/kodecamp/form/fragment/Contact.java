package com.kodecamp.form.fragment;

public class Contact {
	
	private String email ;
	private String phone;
	private String link;
	
	public Contact(final String email,final String phone,final String link) {
		
		this.email = email;
		this.phone = phone;
		this.link = link;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getLink() {
		return link;
	}
	
	
}

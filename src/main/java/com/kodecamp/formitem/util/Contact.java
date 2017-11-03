package com.kodecamp.formitem.util;

public class Contact {

	private String email;
	private String phoneNumber;
	private String link;

	public Contact(final String email, final String phoneNumber, final String link) {
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.link = link;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getLink() {
		return link;
	}

}

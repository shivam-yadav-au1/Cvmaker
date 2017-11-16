package com.kodecamp.form.fragment;

public class RouteDetails {
	private String prevous;
	private String next;
	private String current;
	
	public RouteDetails() {
		System.out.println("Constructor : RouteDetails");
	}

	public String getPrevous() {
		return prevous;
	}

	public void setPrevous(String prevous) {
		System.out.println("#### setter invoked...");
		this.prevous = prevous;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getCurrent() {
		return current;
	}

	public void setCurrent(String current) {
		this.current = current;
	}
	
	@Override
	public String toString() {
		return "previouse : " + this.prevous + " next : " + this.next + " current : " + this.current;
	}
	
	
}

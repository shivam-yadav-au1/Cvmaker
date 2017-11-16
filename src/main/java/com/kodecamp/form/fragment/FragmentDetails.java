package com.kodecamp.form.fragment;

public class FragmentDetails {
	private String title;
	private IFragmentCommand command;
	
	public FragmentDetails(final String title, final IFragmentCommand command) {
		this.title = title;
		this.command = command;
	}

	public String getTitle() {
		return title;
	}

	public IFragmentCommand getCommand() {
		return command;
	}
	
	
}

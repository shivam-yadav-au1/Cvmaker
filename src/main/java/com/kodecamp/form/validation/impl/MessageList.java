package com.kodecamp.form.validation.impl;

import java.util.ArrayList;
import java.util.List;

import com.kodecamp.form.validation.IMessageList;

public abstract class MessageList implements IMessageList {
	
	
	private List messageList;
	private String message;
	
	public MessageList() {
		
	}

	@Override
	public void putMessage(String... message) {
		messageList = new ArrayList();
		messageList.add(message);
		
	}


	public List<IMessageList> getMessageList() {
	
		return null;
	}

	


}

package com.kodecamp.model;

import java.util.ArrayList;
import java.util.List;

import com.kodecamp.form.fragment.Experience;

public class DisplayExperience {
	
	private Experience experience;
	private List<Experience> list ;
	
	public DisplayExperience(final Experience experience) {
		this.experience = experience;
		list = new ArrayList<Experience>();
	}
	
	public int getSize() {
		return list.size();
	}
	
	
	
	

}

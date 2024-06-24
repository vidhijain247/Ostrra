package com.example.demo;

public class CheckExists {
	private AllSubject subIF;

	public CheckExists(AllSubject subIF) {
		super();
		this.subIF = subIF;
	}
	
	public boolean check(String tar) {
		String[]subjects=subIF.getSubjectDetails();
		for(String p:subjects) {
			if(p.equalsIgnoreCase(tar))return true;
		}
		return false;
	}
	
}
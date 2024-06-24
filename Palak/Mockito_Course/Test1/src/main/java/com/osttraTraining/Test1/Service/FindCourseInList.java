package com.osttraTraining.Test1.Service;

import java.util.List;

import com.osttraTraining.Test1.Service.*;

public class FindCourseInList {
	private DataService service;
	
	public FindCourseInList(DataService service)
	{
		super();
		this.service = service;
	}
	public boolean findCourseName(String course) {
		List<String> courses = service.dataList();
		boolean found = false;
		if(courses.contains(course)) {
			found = true;
		}
		return found;
	}
	

}

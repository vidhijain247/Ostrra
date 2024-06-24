package com.example.demo;

import java.util.List;
import java.util.Scanner;

public class FindCoursesC {
	private FindCourse fc;
	public FindCoursesC(FindCourse fc) {
		this.fc=fc;
	}
	public boolean isItThere() {
		String[] dl= fc.cour();
		Scanner sc= new Scanner(System.in);
		System.out.println("Which course you want");
		String s= sc.nextLine();
		for(String x : dl)
		{
			if(s.equals(x))
				return true;
		}
		return false;
	}
}

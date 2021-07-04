package c;

import java.util.ArrayList;

public class Student {
	private String Roll;
	private String Name;
	private String department;
	private ArrayList<String[]> courses;
	
	public Student() {
	
	}
		
	public ArrayList<String[]> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<String[]> courses) {
		this.courses = courses;
	}

	public String getRoll() {
		return Roll;
	}

	public void setRoll(String roll) {
		Roll = roll;
	}
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	}

	

	
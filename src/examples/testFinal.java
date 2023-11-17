/*
Created by T. Xia
*/
import java.util.*;

public class testFinal {
	public static void main(String[] args) {
		Undergraduate us = new Undergraduate(12345, "Alice", "01/01/2000", "Java graph");
		
		System.out.println(us.toString());
	}
}

final class Student {
	private int number;
	private String name;
	private String dob;
	
	public Student(int no, String name, String dob) {
		number = no;
		this.name = name;
		this.dob = dob;
	}
	
	public String toString() {
		String s = "Student: " + number + ", " + name + ", " + dob;
		
		return s;
	}
}

class Undergraduate extends Student {
	private String project;
	
	public Undergraduate(int number, String name, String dob, String project) {
		super(number, name, dob);
		
		this.project = project;
	}
	
	public String toString() {
		String s = "Undergraduate " + super.toString() + ", " + project;
		
		return s;
	}
}

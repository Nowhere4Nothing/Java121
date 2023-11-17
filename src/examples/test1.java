import java.util.*;

/*
Created by T. Xia
*/

public class test1 {
	private ArrayList<Postgraduate> pstudents;
	private ArrayList<Undergraduate> ustudents;
	
	private ArrayList<Student> students;
	
	test1() {
		pstudents = new ArrayList<Postgraduate>(1);
		ustudents = new ArrayList<Undergraduate>(1);
		students = new ArrayList<Student>(1);
	}
	
	public void addPost(Postgraduate p) {
		pstudents.add(p);
	}
	
	public void addUnder(Undergraduate u) {
		ustudents.add(u);
	}
	
	public void addStudent(Student s) {
		students.add(s);
	}
	
	public void printPost() {
		for(Postgraduate p:pstudents) 
			System.out.println(p.toString());
	}
	
	public void printUnder() {
		for(Undergraduate u:ustudents)
			System.out.println(u.toString());
	}

	public void printStudents() {
		for(Student s:students)
			System.out.println(s.toString());
	}
	
	public static void main(String[] args) {
		
		test1 data = new test1();
		
		Postgraduate p = new Postgraduate(12345, "David", "01/01/2000", "10 Northfields Avenue, Wollongong", "dv001@uow.edu.au", "How to work on CSIT121");
		data.addStudent(p);
		

		Undergraduate u = new Undergraduate(54321, "Alice", "01/01/2000", "10 Northfields Avenue, Wollongong", "dv001@uow.edu.au", "Market system");

		data.addStudent(u);
		
		PartTime pt = new PartTime(11111, "Peter", "01/01/2002", "23 fj;sdfhas;", "akhd100@uow.edu.au", "Java project", 2);
		
		data.addStudent(pt);
		
		data.printStudents();

	}
}

class Student {
	private int number;
	private String name;
	private String dob;
	private String address;
	private String email;
	
	public Student(int n, String name, String dob, String address, String email) {
		number = n;
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.email = email;
	}
	
	public void setNumber(int n) {
		number = n;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDob() {
		return dob;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String toString() {
		String s = "Number: "+number+", Name: " + name + ", dob" + dob + ", Address: " + address + ", email: " + email;
		return s;
	}
}

class Postgraduate extends Student {
	private String thesis;

	public Postgraduate(int n, String name, String dob, String address, String email, String thesis) {
		super(n, name, dob, address, email);
		
		this.thesis = thesis;
	}
	
	public String toString() {
		String s = "Postgraduate student: " + super.toString() + ", Thesis: " + thesis;
		
		return s;
	}
}

class Undergraduate extends Student {
	private String project;

	public Undergraduate(int n, String name, String dob, String address, String email, String project) {
		super(n, name, dob, address, email);
		
		this.project = project;
	}
	
	public String toString() {
		String s = "Undergraduate student: " + super.toString() + ", Project: " + project;
		
		return s;
	}	
}

class PartTime extends Undergraduate {
	private int totalSubjects;
	
	public PartTime(int n, String name, String dob, String address, String email, String project, int total) {
		super(n, name, dob, address, email, project);
		
		totalSubjects = total;
	}
	
	public String toString() {
		String s = "Part time student: " + super.toString() + ", Total subjects: " + totalSubjects;
		
		return s;
	}	
}	

	
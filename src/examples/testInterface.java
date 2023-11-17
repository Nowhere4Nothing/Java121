/*
Created by T. Xia
*/

public class testInterface {
	public static void main(String[] args) {
		Postgraduate ps = new Postgraduate(12345, "David", "02/03/2000", "PhD", "d001@uow.edu.au", "1 Northfields Avenue, Wollongong", "How to write a thesis");
		
		Postgraduate.setFee(20000);
		
		System.out.println(ps.toString());
		System.out.println("Payment " + ps.getPayment());
		ps.sendEmail("Good day. It is nice to see you in the campus.");
		
		Undergraduate us = new Undergraduate(54321, "Peter", "10/02/2001", "BSc", "p001@uow.edu.au", "10 Moore Street, Wollongong", "Java project", 4);
		
		Undergraduate.setFeeRate(1200);
		
		System.out.println(us.toString());
		System.out.println("Payment " + us.getPayment());
		us.sendLetter("I am pleased to invite you to participate a party.");
		System.out.println("PI=" + Contact.PI);
	}
}

interface Contact {
	double PI = 3.14;
	public default void sendEmail(String message) {
		System.out.println("");
	}
	
	public void sendLetter(String message);
}

interface Payment {
	public double getPayment();
}

abstract class Student implements Contact, Payment {
	private int sNumber;
	private String name;
	private String dob;
	private String degree;
	private String email;
	private String address;
	
	Student() {
		this(0, "", "", "", "", "");
	}
		
	Student(int number, String name, String dob, String degree, String email, String address) {
		sNumber = number;
		this.name = name;
		this.dob = dob;
		this.degree = degree;
		this.email = email;
		this.address = address;
	}
	
	public String toString() {
		String s = "" + sNumber + ", " + name + ", " + dob + ", " + degree + ", " + email + ", " + address;
		
		return s;
	}
	
	public void sendEmail(String message) {
		System.out.printf("Dear %s,\n %s \n Regards, \n UOW \n", name, message);
	}

	public void sendLetter(String message) {
		System.out.printf("UOW \n 20 February 2022 \n Dear %s, \n %s \n Sincerely yours, \n UOW \n", name, message);
	}
}

class Postgraduate extends Student {
	private String thesis;
	private static double fee;
	
	public Postgraduate() {
		this(0, "", "", "", "", "", "");
	}
	
	Postgraduate(int number, String name, String dob, String degree, String email, String address, String thesis) {
		super(number, name, dob, degree, email, address);
		
		this.thesis = thesis;
	}
	
	public static void setFee(double f) {
		fee = f;
	}
	
	public String toString() {
		String s = super.toString() + ", " + thesis;
		
		return s;
	}
	
	public double getPayment() {
		return fee;
	}
}


class Undergraduate extends Student {
	private String project;
	private static double feeRate;
	private int totalSubjects;
	
	public Undergraduate() {
		this(0, "", "", "", "", "", "", 0);
	}
	
	Undergraduate(int number, String name, String dob, String degree, String email, String address, String project, int total) {
		super(number, name, dob, degree, email, address);
		
		this.project = project;
		totalSubjects = total;
	}
	
	public static void setFeeRate(double f) {
		feeRate = f;
	}
	
	public String toString() {
		String s = super.toString() + ", " + project;
		
		return s;
	}
	
	public double getPayment() {
		return feeRate * totalSubjects;
	}
}
/*
Created by T. Xia
*/

public class testPolymorphism {
	public static void main(String[] args) {
		SalariedEmployee se = new SalariedEmployee("AAA", "AAA", "1234567890", 1234.56);
		System.out.println(se.toString());
		
		HourlyEmployee he = new HourlyEmployee("BBB", "BBB", "1234512345", 25.1, 45.5);
		
		System.out.println(he.toString());
		
		Employee [] e = new Employee[2];
		e[0] = se;
		e[1] = he;
		
		for(int i=0; i< e.length; i++) {
			System.out.println("class type: " + e[i].getClass().getName());
			System.out.println(e[i].toString());
		}
		
		for(int i=0; i< e.length; i++) {
			if (e[i] instanceof SalariedEmployee) {
				System.out.println(((SalariedEmployee)e[i]).getWeeklySalary());
			}
		}

	}
}

abstract class Employee {
	private String fname;
	private String lname;
	private String ssn;

	public Employee(String fname, String lname, String ssn) {
		this.fname = fname;
		this.lname = lname;
		this.ssn = ssn;
	}
	
	public String toString() {
		String s = "Empoyee First name: " + fname + ", Last name: " + lname + ", SSN: " + ssn;
		
		return s;
	}
	
	public abstract double earning();
	
}

class SalariedEmployee extends Employee {
	private double weeklySalary;
	
	public SalariedEmployee(String fname, String lname, String ssn, double ws) {
		super(fname, lname, ssn);
		weeklySalary = ws;
	}
	
	public String toString() {
		String s = "Salaried "+ super.toString() + ", Weekly salary: " + weeklySalary;

		return s;
	}
	
	public double earning() {
		return weeklySalary;
	}
	
	public double getWeeklySalary() {
		return weeklySalary;
	}
}

class HourlyEmployee extends Employee {
	private double wage;
	private double hours;
	
	public HourlyEmployee(String fname, String lname, String ssn, double wage, double hours) {
		super(fname, lname, ssn);
		
		this.wage = wage;
		this.hours = hours;
	}
	
	public String toString() {
		String s = "Hourly " + super.toString() + ", Hourly wage: " + wage + ", Hours: " + hours;
		
		return s;
	}
	
	public double earning() {
		if(hours <= 40)
			return wage * hours;
		else
			return wage * 40 + (hours - 40) * wage * 1.5;
	}
}


class CommissionEmployee extends Employee {
	private double grossSales;
	private double commissionRate;
	
	public CommissionEmployee(String fname, String lname, String ssn, double gross, double rate) {
		super(fname, lname, ssn);
		
		grossSales = gross;
		commissionRate = rate;
	}
	
	public String toString() {
		String s = "Commission " + super.toString() + ", Gross sales: " + grossSales + ", Commission rate: " + commissionRate;
		
		return s;
	}
	
	public double earning() {
		return grossSales * commissionRate;
	}
}

class BasePlusCommissionEmployee extends CommissionEmployee {
	private double baseSalary;
	
	BasePlusCommissionEmployee(String fname, String lname, String ssn, double gross, double rate, double base) {
		super(fname, lname, ssn, gross, rate);
		
		baseSalary = base;
	}
	
	public String toString() {
		String s = "Base plus " + super.toString() + ", Base salary: " + baseSalary;
		
		return s;
	}
	
	public double earning() {
		return baseSalary + super.earning();
	}
}



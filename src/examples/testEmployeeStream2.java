//Created by T. Xia

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;

class Employee {
	private String fname;
	private String lname;
	private double salary;
	private String department;
	
	public Employee(String fname, String lname, double salary, String dept) {
		this.fname = fname;
		this.lname = lname;
		this.salary = salary;
		department = dept;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public String getFName() {
		return fname;
	}
	
	public String getLName() {
		return lname;
	}
	
	public String toString() {
		return String.format("%-8s %-8s %8.2f  %s", fname, lname, salary, department);
	}
}

public class testEmployeeStream2 {
	public static void main(String[] args) {
		Employee[] employees={
			new Employee("Jason", "Red", 5000, "IT"),
			new Employee("Ashley", "Green", 7600, "IT"),
			new Employee("Matthew", "Indigo", 3587.5, "Sales"),
			new Employee("James", "Indigo", 4700.77, "Marketing"),
			new Employee("Luke", "Blue", 3200, "Sales"),
			new Employee("Wendy", "Brown", 4236.4, "Markting")
			};
		
		List<Employee> list = Arrays.asList(employees);
		System.out.println("Employee list: ");
		list.stream().forEach(System.out::println);
		
		Function<Employee, String> byfname = Employee::getFName;
		Function<Employee, String> bylname = Employee::getLName;
		
		Comparator<Employee> lf = Comparator.comparing(bylname).thenComparing(byfname);
		
		System.out.printf("\nEmployees in ascending order by last name, then by first name: \n");
		list.stream()
			.sorted(lf)
			.forEach(System.out::println);
			
		System.out.printf("\nEmployees in descending order by last name, then by first name: \n");
		list.stream()
			.sorted(lf.reversed())
			.forEach(System.out::println);
		

	}
}
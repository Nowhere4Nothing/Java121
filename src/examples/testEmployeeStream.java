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
	
	public String toString() {
		return String.format("%-8s %-8s %8.2f  %s", fname, lname, salary, department);
	}
}

public class testEmployeeStream {
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
		

		Predicate<Employee> fTos = e->(e.getSalary() >= 4000 && e.getSalary() <= 6000);
		
		System.out.printf("\nEmployees salary between 4000 and 6000: \n");
		list.stream()
			.filter(fTos)
			.sorted(Comparator.comparing(Employee::getSalary))
			.forEach(System.out::println);
			
		System.out.printf("\nFirst employee salary between 4000 and 6000: \n %s \n", 
			list.stream()
				.filter(fTos)
				.findFirst()
				.get());

	}
}
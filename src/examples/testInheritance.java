public class testInheritance {
	public static void main(String[] args) {
		Postgraduate ps = new Postgraduate(12345, "David", "1 Northfields Avenue, Wollongong", "PhD", "How to write a thesis");
		
		System.out.println(ps.toString());

		Enrolment e = new Enrolment();
		
		Student s1 = new Student(54321, "Alice", "12 AAA Street Wollongong", "BSC");
		
		e.addStudent(s1);
		
		e.print();
	}
}

class Student {
	private int number;
	private String name;
	private String address;
	private String degree;
	protected String dob;
	Student(int number, String name, String address, String degree) {
		this.number = number;
		this.name = name;
		this.address = address;
		this.degree = degree;
	}
	
	public String toString() {
		String s = "";
		s = s + number + ", " + name + ", " + address + ", " + degree;
		return s;
	}
	
}

class Postgraduate extends Student {
	private String title;
	
	Postgraduate(int number, String name, String address, String degree, String title) {
		super(number, name, address, degree);
		this.title = title;
	}
	
	public String toString() {
		String s = super.toString();
		s = s + ", " + title;
		return s;
	}
}

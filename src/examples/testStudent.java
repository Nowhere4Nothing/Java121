
class Student {
	int number;
	String name;
	String dob;
	String email;
	
	Student(int n, String name, String dob, String email) {
		number = n;
		this.name = name;
		this.dob = dob;
		this.email = email;
	}
	
	void print() {
		System.out.println("Number: " + number + ", name: " + name + ", dob: " + dob + ", email: " + email);
	}
}

public class testStudent{
	public static void main(String[] args) {
		Student s= new Student(12345, "aaa", "01/01/2000", "aaa@uow.edu.au");
		
		s.print();
	}
}
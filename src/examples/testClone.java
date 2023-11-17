class Student {
	private int number;
	private String name;
	private String email;
	private String degree;
	
	public Student(int num, String name, String email, String degree) {
		number = num;
		this.name = name;
		this.email = email;
		this.degree = degree;
	}
	
	//Set degree
	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	//Shallow clone
	public Student sclone() {
		return this;
	}
	
	//Deep clone
	public Student dclone() {
		Student s = new Student (number, name, email, degree);
		
		return s;
	}
	
	public String toString() {
		String str = number + ", " + name + ", " + email + "," + degree;
		
		return str;
	}
}
	

public class testClone {
	public static void main(String[] args) {
		Student s1 = new Student(1, "Alice", "a123@uow.edu.au", "BsC");
		
		System.out.println("s1="+s1.toString());
		
		//Do shallow clone of s1
		Student s2 = s1.sclone();
		System.out.println("Shallow clone of s1, s2="+s2.toString());
		
		//change degree of s1
		s1.setDegree("SIT");
		
		//Display s1 and s2
		System.out.println("After shallow clone, reset degree of s1 ......");
		System.out.println("s1="+s1.toString());
		System.out.println("s2="+s2.toString());
		
		System.out.println();
		
		//Do deep clone of s1
		Student s3 = s1.dclone();
		System.out.println("Deep clone of s1, s3="+s3.toString());
		
		//Change degree of s1
		s1.setDegree("MSC");

		//Display s1 and s3
		System.out.println("After deep clone of s1, reset degree of s1 ......");
		System.out.println("s1="+s1.toString());
		System.out.println("s3="+s3.toString());			
	}
}

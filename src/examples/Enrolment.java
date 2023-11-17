import java.util.ArrayList;
public class Enrolment {
	ArrayList<Student> slist;
	
	public Enrolment() {
		slist = new ArrayList<Student>();
		
	}
	
	public void addStudent(Student s) {
		s.dob = "01/01/2000";
		slist.add(s);
	}
	
	public void print() {
		for(Student s:slist) {
			System.out.println(s.toString() + ", " + s.dob);
		}
	}
}

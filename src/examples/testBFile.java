import java.util.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.EOFException;
import java.io.IOException;
import java.nio.file.*;

/*
Created by T. Xia
*/

class Student implements Serializable {
    private int number;
    private String name;
    private String dob;
    private String email;
    private String address;
    private String phone;
    private String degree;
    
    public Student(int number, String name, String dob, String email, String address, String phone, String degree) {
        this.number = number;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.degree = degree;
    }
    
    public void setNumber(int number) { this.number = number; }
    
    public void setName(String name) { this.name = name; }
    
    public void setDOB(String dob) { this.dob = dob; }
    
    public void setEmail(String email) { this.email = email; }
    
    public void setAddress(String address) { this.address = address; }
    
    public void setPhone(String phone) { this.phone = phone; }
    
    public void setDegree(String degree) { this.degree = degree; }
    
    public int getNumber() { return number; }
    
    public String getName() { return name; }
    
    public String getDOB() { return dob; }
    
    public String getEmail() { return email; }
    
    public String getAddress() { return address; }
    
    public String getPhone() { return phone; }
    
    public String getDegree() { return degree; }
}


//Binary file IO
public class testBFile {
	private Scanner in;
	private Formatter out;
	private ArrayList<Student> students;
	
	public testBFile() {
		students = new ArrayList<Student>();
	}
	
	//Add student data into the linked list
	private void addStudentData() {
		Student aStudent;
		aStudent = new Student(100100, "Albert", "13/10/1965", "a100@uni.edu.au", "12 Robert street Woonona NSW 2517", "12345678", "Bacholar of CS");
		students.add(aStudent);
		
		aStudent = new Student(100110, "Alvin", "13/10/1977", "a110@uni.edu.au", "56 Marlo road Wollongong NSW 2500", "11223344", "Bacholar of CS");
		students.add(aStudent);

		aStudent = new Student(100120, "Alice", "17/06/1973", "a120@uni.edu.au", "43 Collaery road Russell Vale NSW 2517", "12345677", "Bachelor of CS");
		students.add(aStudent);

		aStudent = new Student(100150, "Bob", "02/07/1960", "a150@uni.edu.au", "23 Kendall street Wollongong NSW 2500", "12345688", "Bachelor of CS");
		students.add(aStudent);

		aStudent = new Student(100200, "Carl", "02/02/1967", "c200@uni.edu.au", "44 Mount Keira road West Wollongong NSW 2500", "21345687", "Bachelor of IT");
		students.add(aStudent);

		aStudent = new Student(100250, "Douglass", "14/04/1983", "d250@uni.edu.au", "78 Uralba street West Wollongong NSW 2500", "010123456", "Bachelor of CS");
		students.add(aStudent);

		aStudent = new Student(100101, "Peter", "13/11/1976", "p101@uni.edu.au", "77 Gipps road Wollongong NSW 2500", "0102123456", "Bachelor of Physics");
		students.add(aStudent);

		aStudent = new Student(100103, "Ami", "12/09/1985", "a103@uni.edu.au", "51 Mackie street Coniston NSW 2500", "0242211234", "Bachelor of Science");
		students.add(aStudent);

		aStudent = new Student(100107, "Wendy", "12/09/1988", "w107@uni.edu.au", "41 Wall street Wollongong NSW 2500", "0281234567", "Bachelor of Science");
		students.add(aStudent);

		aStudent = new Student(100109, "Michael", "12/09/1990", "m109@uni.edu.au", "112 Smith road Wollongong NSW 2500", "0242201234", "Bachelor of CS");
		students.add(aStudent);

		aStudent = new Student(100125, "Angela", "20/11/1990", "a125@uni.edu.au", "23 Gibsons road Figtree NSW 2525", "0201123456", "Bachelor of Education");
		students.add(aStudent);

		aStudent = new Student(100105, "Robert", "15/01/1986", "r105@uni.edu.au", "66 Risely road Figtree NSW 2525", "0202213123", "Bachelor of CS");
		students.add(aStudent);

		aStudent = new Student(100136, "Aban", "15/01/1990", "a136@uni.edu.au", "187 Princes Highway Wollongong NSW 2500", "0103123456", "Bachelor of IT");
		students.add(aStudent);

		aStudent = new Student(100187, "Eadger", "07/04/1986", "e187@uni.edu.au", "73 Ocean street Wollongong NSW 2500", "0104123321", "Bachelor of Science");
		students.add(aStudent);
	}

	
	public static void main(String[] args) {
		testBFile t = new testBFile();
		//Add student data to the ArrayList
		t.addStudentData();
		
		if(args.length >= 1) {
			int test = Integer.parseInt(args[0]);
			//System.out.println("args[0] = " + args[0]);
			
			switch(test) {
				case 1: //Save object to a binary file
					t.writeBFile();
					break;
				case 2: //Read data from a binary file and save into the container
					t.readBFile();
					System.out.println("---------------After read-------------------");
					t.displayStudents();
					break;
				case 3: //Read strings from keyboard and write to a text file
					t.displayStudents();
					break;
				default: //Others
					System.out.println("No others");
					break;
			}
		}
		else
			System.out.printf("Usage: java testBFile [1 | 2 | 3]\n");
		
	}
	
	
	//Read data from a text file. The delimiters can be , new line, tab.
	public void readBFile() {
		System.out.println("Read data from a stream file.");
		in = new Scanner(System.in); 
		System.out.print("Input a binary file name: "); 
		String name = in.nextLine();
		in.close();
		Path path = Paths.get(name);
		ObjectInputStream fin = null;
		try {
			if(Files.exists(path)) {
				System.out.printf("%s exists. \n", path.getFileName());
			
				if(!Files.isDirectory(path)) { //Not a directory, read data
					fin = new ObjectInputStream(Files.newInputStream(path));

					while(true) { //Read objects
						Student s = (Student) fin.readObject();
						
						//Save the Student object in a container
						students.add(s);
					}
					
				}
				else
					System.out.printf("File %s is a directory.\n", path);
			}
			else
				System.out.printf("File %s does not exist.\n", path);
		}
		catch (EOFException err) {
			System.out.println("No more records.");
			try {
				if(fin != null)
					fin.close();
			}
			catch(IOException e) {
				System.out.printf("Close the file %s failed. Error=%s\n", path, e);
			}
		}
		catch (ClassNotFoundException err) {
			System.out.println("Invalid object type. " + err);
		}
		catch (IOException err) {
			System.out.println("IO exception error. " + err);
		}	
	}
	
	//Save the objects to a binary stream file
	public void writeBFile() {
		System.out.println("Save the objects to a binary stream file.");
		in = new Scanner(System.in); 
		System.out.print("Input an output filename: "); 
		String name = in.nextLine();
		try {
			//Open an output file
			ObjectOutputStream fout = new ObjectOutputStream(Files.newOutputStream(Paths.get(name)));

			for(Student s:students) { //Save all student's objects
				fout.writeObject(s);
			}
			
			fout.close();
		}
		catch (IOException err) {
			System.out.println("IO exception error. " + err);
		}	
	}
	
	//Display students' records
	public void displayStudents() {
		for(Student s:students) {
			System.out.println(s.getNumber() + ", " + s.getName() + ", " + s.getDOB() + ", " + s.getEmail() + ", " + s.getAddress() + ", " + s.getPhone() + ", " + s.getDegree());
		}
	}
}
import java.util.Scanner;

public class testString {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		System.out.print("What is	your name?"); 
		String name = in.next();
		if	(name.equals("John")) {
			System.out.println("I love you, you love me,"); 
			System.out.println("We're a happy family!");
		}
		
		String name2 = "John";
		if	(name2.equals(name)) {
			System.out.println("I love you, you love me,"); 
			System.out.println("We're a happy family!");
		}
		
		System.out.println("A char=" + '\'');
		String s = "h";
		System.out.println("s+1="+s+1);
		String ss = s+1;
		System.out.println("ss=s+1="+ss);
		ss = s+s;
		System.out.println("ss=s+s="+ss);
		char c = 'h';
		char cc;
		System.out.println("c+1="+c+1);
		cc = (char)(c+1);
		System.out.println("cc=c+1=" + cc);
		System.out.println("c+c="+c+c);
		cc = (char)(c + c);
		System.out.println("cc=c+c=" + cc);	
		cc = (char)++c;
		System.out.println(cc+" "+c);
	}
}
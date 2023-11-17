/*
Created by T. Xia
*/
import java.util.*;

public class testException {
	public void arrayException() { //Test array index
		int data[] = {1, 2, 3, 4, 5};
		Scanner in = new Scanner(System.in);
		
		boolean done = false;
		while(!done) {
			System.out.print("Input an index (-100 exit): ");
			int idx = in.nextInt();
			try {
				System.out.println("data[" + idx + "]=" + data[idx]);
			}
			catch (ArrayIndexOutOfBoundsException e) {
				if(idx == -100)
					done = true;
				else
					System.out.println("Index out of bounds. " + e);
			}
		}		
	}
	
	public void arrayException1() throws ArrayIndexOutOfBoundsException { //Test array index
		int data[] = {1, 2, 3, 4, 5};
		Scanner in = new Scanner(System.in);
		
		boolean done = false;
		while(!done) {
			System.out.print("Input an index (-100 exit): ");
			int idx = in.nextInt();
			System.out.println("data[" + idx + "]=" + data[idx]);
			if(idx == -100)
				done = true;
		}		
	}

	public void arrayException2() { //Test array index
		int data[] = {1, 2, 3, 4, 5};
		Scanner in = new Scanner(System.in);
		
		boolean done = false;
		while(!done) {
			System.out.print("Input an index (-100 exit): ");
			int idx = 0;
			try {
				idx = in.nextInt();
				System.out.println("data[" + idx + "]=" + data[idx]);
			}
			catch (ArrayIndexOutOfBoundsException e) {
				if(idx == -100)
					done = true;
				else
					System.out.println("Index out of bounds. " + e);
			}
			catch (InputMismatchException e) {
				System.out.println("Wrong input type. " + e);
				in.next(); //Jump over the string
			}
			catch (Exception e) {
				System.out.println("Another exception. " + e);
			}
		}		
	}

	public void inputException() { //Test input wrong type
		Scanner in = new Scanner(System.in);
		
		boolean done = false;
		while(!done) {
			System.out.print("Input an integer (-100 exit): ");
			try {
				int v = in.nextInt();
				if(v == -100)
					done = true;
				else
					System.out.println("v="+v);
			} catch(InputMismatchException e) {
				System.out.println("Wrong input type. " + e);
				in.next(); //Jump over the string
			}
			
		}
	}
	
	public static void main(String[] args) {
		testException te = new testException();
		int test = 1;

		if(test == 1) {
			System.out.println("Test array index out of bounds.");
			te.arrayException();
		}
		else if(test == 2) {
			System.out.println("Test array index out of bounds with throws.");
			te.arrayException1();
		}
		else if(test == 3) {
			System.out.println("Test array index out of bounds, and type mismatched.");
			te.arrayException2();
		}
		else if(test == 4) {
			System.out.println("Test type mismatched.");
			te.inputException();
		}
	}
}
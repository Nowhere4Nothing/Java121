/*
	Created by TXIA
*/

public class testStatic {
	public static void main(String[] args) {
		Account acc1 = new Account(1, "aaa");
		Account acc2 = new Account(2, "bbb");
		acc1.setInterestRate(0.5);
		
		System.out.println("acc1="+acc1.getNo()+", "+acc1.getName()+", "+acc1.getInterestRate());
		
		System.out.println("acc2="+acc2.getNo()+", "+acc2.getName()+", "+acc2.getInterestRate());
		
		Account acc3 = new Account(acc2);
		System.out.println("acc3="+acc3.getNo()+", "+acc3.getName()+", "+acc3.getInterestRate());
	
	}
}

class Account {
	private final int no;
	private String name;
	private static double interestRate;
	
	public Account(int no, String name) {
		this.no = no;
		this.name = name;
	}

	public Account(Account ac) {
		no = ac.no;
		name = ac.name;
	}
	
	public void setInterestRate(double r) {
		interestRate = r;
	}
	
	//public void setNo(int n) {
	//	no = n;
	//}
	
	public int getNo() {
		return no;
	}
	
	public String getName() {
		return name;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
}
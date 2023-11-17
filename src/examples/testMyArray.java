/*
Created by T. Xia
*/
import java.lang.Cloneable;

class MyArray implements Cloneable {
	private int[] data;
	
	public MyArray(int len) {
		data = new int[len];
	}
	
	public MyArray(int[] d) {
		data = new int[d.length];
		for(int i=0; i<data.length; i++)
			data[i] = d[i];
	}
	
	public void setData(int idx, int v) {
		data[idx] = v;
	}
	
	//Override clone
	public MyArray clone() throws CloneNotSupportedException {
		MyArray m = new MyArray(data.length);
		
		for(int i=0; i<data.length; i++)
			m.data[i] = data[i];
		
		return m;
	}
	
	//Override
	public String toString() {
		String s = "";
		for(int i=0; i<data.length; i++)
			s += data[i] + " ";
		
		return s;
	}
	
	//Override equals
	public boolean equals(MyArray d) {
		boolean same = true;
		if(data.length != d.data.length)
			same = false;
		else
			for(int i=0; i<data.length; i++)
				if(data[i] != d.data[i]) {
					same = false;
					break;
				}
		return same;
	}
}

public class testMyArray {
	public static void main(String[] args) throws CloneNotSupportedException {
		int[] array1 = {1, 2, 3, 4, 5};
		
		MyArray d1 = new MyArray(array1);
		
		MyArray d2 = d1;
		
		System.out.println("d1=" + d1.toString());
		System.out.println("d2=" + d2.toString());
		
		if(d1 == d2) 
			System.out.println("Both d1 and d2 contain the same values.");
		else
			System.out.println("d1 and d2 contain different values.");
			
		
		//Modify d2 element
		d2.setData(2, 10);
		System.out.println("After the modification, we have");
		
		System.out.println("d1=" + d1.toString());
		System.out.println("d2=" + d2.toString());
		if(d1.equals(d2)) 
			System.out.println("Both d1 and d2 contain the same values.");
		else
			System.out.println("d1 and d2 contain different values.");
		
	}
}
		
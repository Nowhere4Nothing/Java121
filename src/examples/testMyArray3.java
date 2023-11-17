/*
Created by T. Xia
*/
import java.lang.Cloneable;
class Item {
	private int num;
	private String name;
	private double price;
	
	public Item() {
		this(0, "", 0.0);
	}
	
	public Item(int num, String name, double price) {
		this.num = num;
		this.name = name;
		this.price = price;
	}
	
	public Item(Item t) {
		num = t.num;
		name = t.name;
		price = t.price;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	//Override equals
	public boolean equals(Item t) {
		if(num == t.num && name.equals(t.name) && price == t.price)
			return true;
		else
			return false;
	}
		
	//Override toString()
	public String toString() {
		String s = "" + num + " " + name + " " + price;
		
		return s;
	}
}
	
class MyArray implements Cloneable {
	private Item[] data;
	
	public MyArray(int len) {
		data = new Item[len];
	}
	
	public MyArray(Item[] d) {
		data = new Item[d.length];
		for(int i=0; i<data.length; i++)
			data[i] = d[i];
	}
	
	public void setData(int idx, Item v) {
		data[idx] = v;
	}
	
	public void setData(int idx, String name, double price) {
		data[idx].setName(name);
		data[idx].setPrice(price);
	}
	
	//Override clone
	public MyArray clone() throws CloneNotSupportedException {
		MyArray m = new MyArray(data.length);
		
		for(int i=0; i<data.length; i++)
			m.data[i] = new Item(data[i]);
		
		return m;
	}
	
	//Override
	public String toString() {
		String s = "";
		for(int i=0; i<data.length; i++)
			s += data[i].toString() + "; ";
		
		return s;
	}
	
	//Override equals
	public boolean equals(MyArray d) {
		boolean same = true;
		if(data.length != d.data.length)
			same = false;
		else
			for(int i=0; i<data.length; i++)
				if(! data[i].equals(d.data[i])) {
					same = false;
					break;
				}
		return same;
	}
}

public class testMyArray3 {
	public static void main(String[] args) throws CloneNotSupportedException {
		Item[] array1 = new Item[5];
		array1[0] = new Item(1, "aaa", 1.1);
		array1[1] = new Item(2, "bbb", 2.1);
		array1[2] = new Item(3, "ccc", 3.1);
		array1[3] = new Item(4, "ddd", 4.1);
		array1[4] = new Item(5, "eee", 5.1);
		
		MyArray d1 = new MyArray(array1);
		
		MyArray d2 = d1.clone();
		
		System.out.println("d1=" + d1.toString());
		System.out.println("d2=" + d2.toString());
		
		if(d1.equals(d2)) 
			System.out.println("Both d1 and d2 contain the same values.");
		else
			System.out.println("d1 and d2 contain different values.");
			
		
		//Modify d2 element
		d2.setData(2, "zzz", 10.1);
		System.out.println("After the modification, we have");
		
		System.out.println("d1=" + d1.toString());
		System.out.println("d2=" + d2.toString());
		if(d1.equals(d2)) 
			System.out.println("Both d1 and d2 contain the same values.");
		else
			System.out.println("d1 and d2 contain different values.");
		
	}
}
		
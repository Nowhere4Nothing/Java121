/*
	Created by T XIA
*/
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class testArrayList {
	private ArrayList<Item> items;
	
	public testArrayList() {
		items = new ArrayList<Item>();
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	//Print out items by using for-loop
	public void printItems() {
		for(Item item:items) {
			System.out.println(item.getNo() + ", " + item.getName() + ", " + item.getPrice());
		}
	}
	
	//Print out items by using iterator
	public void printItems_it() {
		Iterator<Item> it = items.iterator();
		while(it.hasNext()) {
			Item item = it.next();
			System.out.println(item.getNo() + ", " + item.getName() + ", " + item.getPrice());
		}
	}
	
	public boolean findItem(int no) {
		boolean found = false;
		for(Item item:items) {
			if(item.getNo() == no) {//Found the item
				found = true;
				System.out.printf("Item no: %d name: %s price: %02f\n", item.getNo(), item.getName(), item.getPrice());
				break;
			}
		}
		
		return found;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		testArrayList alist = new testArrayList();
				
		int no = 0;
		
		do {
			
			System.out.print("Item no: "); 
			no = in.nextInt();
			if(no != 0) {//More item
				System.out.print("Item name: ");
				String name = in.next();
				System.out.print("Item price: ");
				float price = in.nextFloat();
				
				Item item = new Item(no, name, price);
				
				alist.addItem(item);
			}
		} while (no != 0);

		alist.printItems();
		System.out.println("Print items by using iterator.");
		alist.printItems_it();
		
		//Find an item by a number
		System.out.print("Input an item number: ");
		no = in.nextInt();
		if(! alist.findItem(no))
			System.out.println("Item " + no + " does not exist.");
	}
}

class Item {
	int no;
	String name;
	float price;
	
	public Item(int no, String name, float price) {
		this.no = no;
		this.name = name;
		this.price = price;
	}
	
	public void setNo (int no) {
		this.no = no;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getNo() {
		return no;
	}
	
	public String getName() {
		return name;
	}
	
	public float getPrice() {
		return price;
	}
}
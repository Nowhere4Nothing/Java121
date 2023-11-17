class City implements Cloneable {
	private String name;
	
	public City(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public City clone() throws CloneNotSupportedException {
		return (City) super.clone();
	}
	
	public String toString() {
		return "City name=[" + name + "]";
	}
}

class Person implements Cloneable {
	private String name;
	private int income;
	private City city;
	
	public Person(String name, int income, City city) throws CloneNotSupportedException {
		this.name = name;
		this.income = income;
		//Do the clone
		this.city = city.clone();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getIncome() {
		return income;
	}
	
	public void setIncome(int income) {
		this.income = income;
	}
	
	public City getCity() {
		return city;
	}
	
	public void setCity(City city) throws CloneNotSupportedException {
		this.city = city.clone();
	}
	
	public Person clone() throws CloneNotSupportedException {
		return (Person) super.clone();
	}
	
	public String toString() {
		return "Person name=[" + name + "], income=[" + income + "], " + city;
	}

}

public class testDeepClone {
	public static void main(String[] args) throws CloneNotSupportedException {
		City city = new City("Wollongong");
		Person p1 = new Person("Alice", 50000, city);
		
		System.out.println("Person p1: " + p1);
		
		//Clone p1
		Person p2 = p1.clone();
		System.out.println("Person p2: " + p2);
		
		//Change income and city for p1
		p1.setIncome(70000);
		p1.setCity(new City("Sydney"));
		
		//Display values
		System.out.println("After person p1 income and city changed ......");
		System.out.println("Person p1: " + p1);
		System.out.println("Person p2: " + p2);
	}
}
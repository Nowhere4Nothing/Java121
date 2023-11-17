/*
Created by T. Xia
*/
import java.util.*;

class Animal {
	private int x;
	private int y;
	
	public Animal(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void move() {
		x = x + 0;
		y = y + 0;
	}
	
	public String toString() {
		String s = "X: " + x + " Y: " + y;
		
		return s;
	}
}

class Duck extends Animal {
	private String sound;
	
	public Duck(int x, int y) {
		super(x, y);
		sound = "Quack";
	}
	
	public void move() {
		setX (getX() + 5);
		setY(getY() + 5);
	}
	
	public String toString() {
		String s = "Duck " + super.toString();
		
		return s;
	}
	
	public void makeSound() {
		System.out.println(sound);
	}
}

class Fish extends Animal {
	public Fish(int x, int y) {
		super(x, y);
	}
	
	public void move() {
		setX(getX()+3);
		setY(getY()+3);
	}
	
	public String toString() {
		String s = "Fish " + super.toString();
		
		return s;
	}
}

public class testAnimal {
	private ArrayList<Animal> animals;
	
	public testAnimal() {
		animals = new ArrayList<Animal>();
	}
	
	public void addAnimal(Animal a) {
		animals.add(a);
	}
	
	public void moveAnimal() {
		for(Animal a:animals)
			a.move();
	}
	
	public void displayAnimal() {
		for(Animal a:animals)
			System.out.println(a.toString());
	}
	
	public void soundAnimal() {
		for(Animal a:animals) {
			Duck duck = (Duck) a;
			duck.makeSound();
		}
	}

	public static void main(String[] args) {
		testAnimal test = new testAnimal();
	
		Animal a = new Animal(0, 0);
		test.addAnimal(a);
		
		Animal duck = new Duck(10, 10);
		test.addAnimal(duck);
		System.out.println("-----------Sound--------------");
		Duck duck2 = (Duck)duck;
		duck2.makeSound();
		
		Animal fish = new Fish(20, 20);
		test.addAnimal(fish);
		
		System.out.println("------------Before move------------------");
		test.displayAnimal();
		
		test.moveAnimal();
		
		System.out.println("------------After move------------------");
		test.displayAnimal();
		


	}
}
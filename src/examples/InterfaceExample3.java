// Interface
interface Animal {
  
  public String SLEEP="Zzz"; 
  public void animalSound(); // interface method (does not have a body)
  
  //a default method
  public default void sleep(){
  	System.out.println(SLEEP);
  }
}

//Animal implments the Animal interface
class Animals implements Animal{
	private String sound, type;
	
	public Animals(){
		sound="";
		type="";
	}

	public Animals(String t, String s){
		type=t;
		sound=s;
	}
	
	public String getSound(){
		return sound;
	}
	
	public String getType(){
		return type;
	}
	
    public void animalSound() {
      System.out.println("The "+getType()+" says: " + getSound());
    }
}

//Pig extends Animal class
class Pig extends Animals {
  
  public Pig(){
	  super("Pig", "Wee Wee");
  }
  
  public void sleep() {
	  System.out.println("Huhuhu...");
  }

}

//Duce extends Animal class
class Duck extends Animals {
	
    public Duck(){
  	  super("Duck", "Quack Quack");
    }
}

class InterfaceExample3 {
  public static void main(String[] args) {
	  
	Animal[] animals = new Animal[2];  
	  
    animals[0] = new Pig();  // Create a Pig object
	animals[1] = new Duck();  // Create a Duck object
    
	for(Animal animal:animals){
		animal.animalSound();
		animal.sleep();
	}
  }
}
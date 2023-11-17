// Interface
interface Animal {
  
  public String SLEEP="Zzz"; 
  public void animalSound(); // interface method (does not have a body)
  public void sleep(); // interface method (does not have a body)
}

// Pig "implements" the Animal interface
class Pig implements Animal {

  private String sound;
  
  public Pig(){
	  sound="Wee Wee";
  }
  
  public String getSound(){
	  return sound;
  }
	
  public void animalSound() {
    // The body of animalSound() is provided here
    System.out.println("The pig says: " + getSound());
  }
  public void sleep() {
    // The body of sleep() is provided here
    System.out.println(SLEEP);
  }
}

class Duck implements Animal {
	
	private String sound;
	
    public Duck(){
  	  sound="Quack Quack";
    }
	
    public String getSound(){
  	  return sound;
    }
	
	public void animalSound(){
		System.out.println("The duck says: "+ getSound());
	}
	
    public void sleep() {
      // The body of sleep() is provided here
      System.out.println(SLEEP);
    }
}

class InterfaceExample {
  public static void main(String[] args) {
    Pig myPig = new Pig();  // Create a Pig object
    myPig.animalSound();
    myPig.sleep();
	
	Duck myDuck = new Duck();
	myDuck.animalSound();
	myDuck.sleep();
  }
}
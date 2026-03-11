import java.util.List;
import java.util.ArrayList;
public class PetClinic {
	public static void main(String[] args) {
		//overriding;
		methodoverriding();
	}
	
	private static void methodoverriding() {
		Pet pet = new Dog("Shihtzu"); //pet class only has play() no sound() 
		Animal animal = (Animal)pet; //upcasting to access sound method in pet
		animal.sound();
	}
		
	public static void demo() {
	Dog dog = new Dog("Husky");
	dog.setName("Ivy");
	Pet dog1 = new Dog("Lab");
	Cat cat = new Cat();// no constructor i.e no parameters
	cat.setName("Milo");
	dog.bark();
	//dog1.bark(); //pet interface has no bark method only play()
	List<Pet> pets = new ArrayList<Pet>();
	pets.add(dog);
	pets.add(cat);
	pets.add(dog1);
	pets.forEach((pet)-> pet.play());
	
	
	
       }

	}


	

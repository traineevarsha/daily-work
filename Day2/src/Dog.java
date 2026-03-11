
public class Dog extends Animal implements Pet {
	private String breed;
	
	public void sound() {// overides the superclass animal implementation of sound()
		System.out.println("Dog is making a sound" );
	}

	public Dog(String breed) { // CONSTRUCTOR
		this.breed = breed;
	}
	public String getBreed() {
		return breed;
	}
	@Override
	public void play() {
		System.out.println("Playing with " +getName());
		
	}
	public void bark() {
		System.out.println("Dogis barking");
	}

}

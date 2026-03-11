
public class Cat extends Animal implements Pet {
		public String furcolor;

		@Override
		public void play() {
			System.out.println("Playing with "+getName());
			
		}
		public void meow() {
			System.out.println("Cat is meowing");
		}

	}



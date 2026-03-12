
public class Main {

	public static void main(String[] args) {
		books b1 = new books(1,"ABC","auth1",50.5f);
		books b2 = new books(2,"BCD","auth2",75.5f);
		books b3 = new books(3,"DEF","auth3",222.5f);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		Library lib = new Library();
		
		lib.addbook(b1);
		lib.addbook(b2);
		lib.addbook(b3);
		
		lib.reservebook(1);
		lib.removebook(1);

	}

}

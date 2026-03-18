import java.util.Scanner;

public class LMSMenu {
	Library library;
	Scanner sc = new Scanner(System.in);

	LMSMenu(Library library) {
		this.library = library;
	}

	void displayMenu() {
		System.out.println("Library Management System");
		String options = "Options:\n\t1. Add Book\n\t2. Remove Book\n\t3. Reserve Book\n\t4. Display Books\n\t0. Exit";
		System.out.println(options);
	}

	void start() {
		int choice;

		while (true) {
			displayMenu();
			System.out.print("\nEnter choice: ");

			try {
				choice = sc.nextInt();
				sc.nextLine(); // consume newline

				switch (choice) {
				case 1:
					handleAddition();
					break;
				case 2:
					handleRemoval();
					break;
				case 3:
					handleReservation();
					break;
				case 4:
					library.displayBooks();
					break;
				case 0:
					System.out.println("Exiting...");
					sc.close();
					return;
				default:
					System.out.println("Invalid Choice!!!");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				sc.nextLine();
			}
		}
	}

	void handleAddition() throws Exception {
		int id;
		String author, title;
		float price;

		System.out.print("Enter book title: ");
		title = sc.nextLine();
		if (title.trim().equals("")) {
			throw new Exception("Invalid Book Name");
		}

		System.out.print("Enter book author: ");
		author = sc.nextLine();
		if (author.trim().equals("")) {
			throw new Exception("Invalid Author Name");
		}

		System.out.print("Enter id: ");
		id = sc.nextInt(); //

		if (id <= 0) { //
			throw new Exception("Invalid ID");
		}

		System.out.print("Enter price: ");
		price = sc.nextFloat();
		sc.nextLine();

		library.add(id, title, price, author);
	}

	void handleReservation() throws Exception {
		System.out.print("Enter book name: ");
		String name = sc.nextLine();

		if (name.trim().equals("")) {
			throw new Exception("Invalid Book Name");
		}

		library.reserve(name);
	}

	void handleRemoval() throws Exception {
		System.out.print("Enter id: ");
		int id = sc.nextInt();
		sc.nextLine();

		if (id <= 0) { //
			throw new Exception("Invalid ID");
		}

		library.remove(id);
	}
}
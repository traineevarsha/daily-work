import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);
    Library lib = new Library();

    void start() {

        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Reserve Book");
            System.out.println("4. Display Books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();
            
            try {
            switch (choice) {

                case 1:
                    System.out.print("Enter id: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter price: ");
                    float price = sc.nextFloat();
                    sc.nextLine();

                    books b = new books(id, title, author, price);
                    lib.addbook(b);
                    break;

                case 2:
                    System.out.print("Enter id to remove: ");
                    int removeId = sc.nextInt();
                    sc.nextLine();

                    lib.removebook(removeId);
                    break;

                case 3:
                    System.out.print("Enter id to reserve: ");
                    int reserveId = sc.nextInt();
                    sc.nextLine();

                    lib.reservebook(reserveId);
                    break;

                case 4:
                    lib.displaybooks();
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }catch(Exception ex) {
        	System.out.println("Invalid Input.");
        	sc.nextLine();
		}
	}
 }
}

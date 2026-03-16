import java.util.Scanner;
import java.util.logging.Logger;

public class Menu {

    private static final Logger logger = Logger.getLogger(Menu.class.getName());

    Library lib;
    Scanner sc = new Scanner(System.in);

    Menu(Library lib) {
        this.lib = lib;
    }

    void start() {
        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Reserve Book");
            System.out.println("4. Display Books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        addBook();
                        break;
                    case 2:
                        removeBook();
                        break;
                    case 3:
                        reserveBook();
                        break;
                    case 4:
                        lib.displaybooks();
                        break;
                    case 0:
                        System.out.println("Exiting program...");
                        logger.info("Application exited by user");
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (BookNotAvailableException ex) {
                System.out.println("Exception: " + ex.getMessage());
                logger.warning("Caught custom exception: " + ex.getMessage());
            } catch (Exception ex) {
                System.out.println("Invalid input");
                logger.warning("Input error: " + ex.getMessage());
                sc.nextLine();
            }
        }
    }

    void addBook() {
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
    }

    void removeBook() {
        System.out.print("Enter id to remove: ");
        int id = sc.nextInt();
        sc.nextLine();

        lib.removebook(id);
    }

    void reserveBook() {
        System.out.print("Enter id to reserve: ");
        int id = sc.nextInt();
        sc.nextLine();

        lib.reservebook(id);
        System.out.println("Reservation successful");
    }
}
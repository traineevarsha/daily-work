import java.util.Scanner;

public class Menu {

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
                        return;

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (Exception ex) {

                System.out.println("Invalid input");
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

        lib.addBook(id, title, author, price);
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
    }
}
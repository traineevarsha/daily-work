import java.util.Scanner;

public class Menu {

	Manager manager = new Manager();
	Scanner sc = new Scanner(System.in);

	public void start() {
		while (true) {
			System.out.println("-----------Student Management System------");
			System.out.println(" 1. Add Student");
			System.out.println(" 2. Display");
			System.out.println(" 3. Search Student");
			System.out.println(" 4. Remove Student");
			System.out.println(" 0. exit");
			System.out.println(" Enter your choice");

			try {
				int choice = sc.nextInt();
				sc.nextLine();

				switch (choice) {
				case 1:
					System.out.println("enter id and name");
					int addid = sc.nextInt();
					sc.nextLine();
					String addname = sc.nextLine();
					manager.addStudent(addid, addname);
					break;

				case 2:
					manager.display();
					break;

				case 3:
					System.out.println("enter id to search");
					int searchid = sc.nextInt();
					sc.nextLine();
					manager.searchStudent(searchid);
					break;

				case 4:
					System.out.println("enter id to remove");
					int deleteid = sc.nextInt();
					sc.nextLine();
					manager.removeStudent(deleteid);
					break;

				case 0:
					System.out.println("Exiting ....");
					sc.close();
					break;

				default:
					System.out.println("Please enter valid choice");
				}
			} catch (Exception e) {
				System.out.println("Invalid input please put correct input");
				System.out.println(e.getMessage());
			}
		}
	}

}

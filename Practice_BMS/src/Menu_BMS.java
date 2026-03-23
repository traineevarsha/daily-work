import java.util.Scanner;

public class Menu_BMS {
	BankManager manager = new BankManager();
	Scanner sc = new Scanner(System.in);

	public void start() {
		while (true) {
			System.out.println("\n--- Banking App ---");
			System.out.println("1. Create Account");
			System.out.println("2. Display Accounts");
			System.out.println("3. Search Account");
			System.out.println("4. Delete Account");
			System.out.println("5. Deposit");
			System.out.println("6. Withdraw");
			System.out.println("7. Exit");
			System.out.print("Enter choice: ");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter account number: ");
				int accNo = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter holder name: ");
				String name = sc.nextLine();

				System.out.print("Enter opening balance: ");
				double balance = sc.nextDouble();

				manager.addAccount(accNo, name, balance);
				break;

			case 2:
				manager.display();
				break;

			case 3:
				System.out.print("Enter account number to search: ");
				int searchNo = sc.nextInt();

				manager.searchAccount(searchNo);
				break;

			case 4:
				System.out.print("Enter account number to delete: ");
				int deleteNo = sc.nextInt();

				manager.removeAccount(deleteNo);
				break;

			case 5:
				System.out.print("Enter account number: ");
				int depositNo = sc.nextInt();

				System.out.print("Enter amount to deposit: ");
				double depositAmount = sc.nextDouble();

				manager.deposit(depositNo, depositAmount);
				break;

			case 6:
				System.out.print("Enter account number: ");
				int withdrawNo = sc.nextInt();

				System.out.print("Enter amount to withdraw: ");
				double withdrawAmount = sc.nextDouble();

				manager.withdraw(withdrawNo, withdrawAmount);
				break;

			case 7:
				System.out.println("Exiting...");
				return;

			default:
				System.out.println("Invalid choice");
			}
		}
	}
}
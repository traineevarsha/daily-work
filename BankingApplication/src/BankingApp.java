import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankingApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter initial balance: ");
		int initialBalance = sc.nextInt();

		BankAccount account = new BankAccount(initialBalance);

		// creating thread pool
		ExecutorService executor = Executors.newFixedThreadPool(3);

		while (true) {
			System.out.println("\n1. Check Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Parallel Withdraw");
			System.out.println("5. Exit");
			System.out.print("Enter choice: ");

			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.println("Balance: " + account.getBalance());
				break;

			case 2:
				System.out.print("Enter amount: ");
				int dep = sc.nextInt();
				executor.execute(new DepositTask(account, dep));
				break;

			case 3:
				System.out.print("Enter amount: ");
				int w = sc.nextInt();
				executor.execute(new WithdrawTask(account, w));
				break;

			case 4:
				System.out.println("Running 2 withdrawals of " + (initialBalance / 2));
				executor.execute(new WithdrawTask(account, initialBalance / 2));
				executor.execute(new WithdrawTask(account, initialBalance / 2));
				break;

			case 5:
				System.out.println("Exiting...");
				executor.shutdown();
				sc.close();
				return;

			default:
				System.out.println("Invalid choice");
			}
		}
	}
}
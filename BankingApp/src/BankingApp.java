import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankingApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enetr initial bank balance");
		int initialBalance = sc.nextInt();

		BankAccount account = new BankAccount(initialBalance);

		ExecutorService executor = Executors.newFixedThreadPool(3);

		while (true) {

		}
	}

}

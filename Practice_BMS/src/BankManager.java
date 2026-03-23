import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BankManager {
	ArrayList<Account> accountList = new ArrayList<>();

	public void addAccount(int accNo, String holderName, double balance) {
		loadFromFile();

		for (Account acc : accountList) {
			if (acc.getAccNo() == accNo) {
				System.out.println("Account number already exists");
				return;
			}
		}

		accountList.add(new Account(accNo, holderName, balance));
		saveAllToFile();
		System.out.println("Added successfully");
	}

	public void display() {
		loadFromFile();

		if (accountList.isEmpty()) {
			System.out.println("No accounts");
			return;
		}

		for (Account acc : accountList) {
			System.out.println(acc);
		}
	}

	public void searchAccount(int accNo) {
		loadFromFile();

		for (Account a : accountList) {
			if (a.getAccNo() == accNo) {
				System.out.println(a);
				System.out.println("Search successful");
				return;
			}
		}
		System.out.println("Account not found");
	}

	public void removeAccount(int accNo) {
		loadFromFile();

		boolean removed = accountList.removeIf(account -> account.getAccNo() == accNo);

		if (removed) {
			saveAllToFile();
			System.out.println("Account removed successfully");
		} else {
			System.out.println("Account can't be removed");
		}
	}

	public void deposit(int accNo, double amount) {
		loadFromFile();

		for (Account acc : accountList) {
			if (acc.getAccNo() == accNo) {
				acc.setBalance(acc.getBalance() + amount);
				saveAllToFile();
				System.out.println("Amount deposited successfully, balance = " + acc.getBalance());
				return;
			}
		}
		System.out.println("Couldn't locate account");
	}

	public void withdraw(int accNo, double amount) {
		loadFromFile();

		for (Account a : accountList) {
			if (a.getAccNo() == accNo) {
				if (amount > a.getBalance()) {
					System.out.println("Insufficient balance");
				} else {
					a.setBalance(a.getBalance() - amount);
					saveAllToFile();
					System.out.println("Withdrawal successful, balance = " + a.getBalance());
				}
				return;
			}
		}
		System.out.println("Account not found");
	}

	public void saveAllToFile() {
		try {
			FileWriter writer = new FileWriter("accounts.txt");

			for (Account a : accountList) {
				writer.write(a.getAccNo() + "," + a.getHolderName() + "," + a.getBalance() + "\n");
			}

			writer.close();
		} catch (IOException e) {
			System.out.println("Error updating file");
		}
	}

	public void loadFromFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"));
			String line;

			accountList.clear();

			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				int accNo = Integer.parseInt(data[0]);
				String holderName = data[1];
				double balance = Double.parseDouble(data[2]);

				accountList.add(new Account(accNo, holderName, balance));
			}

			reader.close();
		} catch (IOException e) {
		}
	}
}
package banking.app.banking.service;

import java.util.HashMap;
import java.util.Map;

import banking.app.banking.exception.BankingException;
import banking.app.banking.model.Account;

public class BankService {
	private Map<Integer, Account> accounts = new HashMap<>();

	public void createAccount(int accountNumber, String name, double balance) {
		if (accounts.containsKey(accountNumber)) {
			throw new BankingException("Account already exists");
		}
		accounts.put(accountNumber, new Account(accountNumber, name, balance));
		System.out.println("Account created successfully");

	}

	public Account getAccount(int accountNumber) {
		Account account = accounts.get(accountNumber);
		if (account == null) {
			throw new BankingException("Account not found");
		}
		return account;
	}

	public void deposit(int accountNumber, double amount) {
		getAccount(accountNumber).deposit(amount);
	}

	public void withdraw(int accountNumber, double amount) {
		getAccount(accountNumber).withdraw(amount);
	}
}

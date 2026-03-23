package banking.app.banking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import banking.app.banking.exception.BankingException;

class BankServiceTest {

	private BankService bank;

	@BeforeEach
	void setup() {
		bank = new BankService();
		bank.createAccount(1, "Amit", 1000);
	}

	@Test
	void testDeposit() {
		bank.deposit(1, 500);
		assertEquals(1500, bank.getAccount(1).getBalance());
	}

	@Test
	void testWithdraw() {
		bank.withdraw(1, 300);
		assertEquals(700, bank.getAccount(1).getBalance());
	}

	@Test
	void testAccountNotFound() {
		assertThrows(BankingException.class, () -> bank.getAccount(999));
	}

	@Test
	void testDepositToAnInvalidAccount() {
		assertThrows(BankingException.class, () -> bank.deposit(999, 100));
	}

	@Test
	void testWithdrawInvalidAccount() {
		assertThrows(BankingException.class, () -> bank.withdraw(999, 100));
	}

	@Test
	void testDepositZeroAmount() {
		assertThrows(BankingException.class, () -> bank.deposit(1, 0));
	}

	@Test
	void testDepositNegativeAmount() {
		assertThrows(BankingException.class, () -> bank.deposit(1, -100));
	}

	@Test
	void testWithdrawNegativeAmount() {
		assertThrows(BankingException.class, () -> bank.withdraw(1, -50));
	}

	@Test
	void testDuplicateAccount() {
		assertThrows(BankingException.class, () -> bank.createAccount(1, "Test", 500));
	}
}

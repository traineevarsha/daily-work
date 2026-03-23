package banking.app.banking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import banking.app.banking.model.Account;

class BankServiceTest {

	@Mock
	private AccountRepository repository;

	@InjectMocks
	private BankService bankService;
	private Account account;

	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
		account = new Account(1, "Amit", 1000);
	}

	@Test
	void testDeposit() {
		when(repository.findById(1)).thenReturn(account);// this is for mocking
		bankService.deposit(1, 500);
		assertEquals(1500, account.getBalance());
		verify(repository).save(account);
	}

	@Test
	void testWithdrawInsufficientBalance() {
		when(repository.findById(1)).thenReturn(account);
		assertThrows(IllegalArgumentException.class, () -> bankService.withdraw(1, 2000));
		verify(repository, never()).save(any());
	}
}

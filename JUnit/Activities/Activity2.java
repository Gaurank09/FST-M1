package Activities;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import mainPrograms.BankAccounts;
import mainPrograms.NotEnoughFundsException;


public class Activity2 {
	
	@Test
	public void notEnoughFunds() {
	    // Create an object for BankAccount class
	    BankAccounts accountbalance = new BankAccounts(9);
	    

	    // Assertion for exception
	    assertThrows(NotEnoughFundsException.class, () -> accountbalance.withdraw(10));
	    
	}

	@Test
	public void enoughFunds() {
	    // Create an object for BankAccount class
	    BankAccounts account = new BankAccounts(100);

	    // Assertion for no exceptions
	    assertDoesNotThrow(() -> account.withdraw(100));
	}

}



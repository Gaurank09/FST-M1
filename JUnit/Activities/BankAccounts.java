package mainPrograms;

import mainPrograms.NotEnoughFundsException;

public class BankAccounts {
    private Integer balance;
    
    // Create a constructor
    public BankAccounts(Integer initialBalance) {
        balance = initialBalance;
        System.out.println("Account Balance: " + balance);
    }

    // Add method to calculate
    // balance amount after withdrawal
    public Integer withdraw(Integer amount) {
        if (balance < amount) {
            throw new NotEnoughFundsException(amount, balance);
        }
        balance -= amount;
        return balance;
    }
}
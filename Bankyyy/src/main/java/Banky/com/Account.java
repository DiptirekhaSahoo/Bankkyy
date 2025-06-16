package Banky.com;

public class Account {
 
	    private String accountNumber;
	    private String name;
	    private double balance;

	    public Account(String accountNumber, String name) {
	        this.accountNumber = accountNumber;
	        this.name = name;
	        this.balance = 0.0;
	    }

	    public void deposit(double amount) {
	        this.balance += amount;
	    }

	    public boolean withdraw(double amount) {
	        if (amount <= balance) {
	            balance -= amount;
	            return true;
	        }
	        return false;
	    }

	    public String getAccountNumber() { return accountNumber; }
	    public String getName() { return name; }
	    public double getBalance() { return balance; }

	    @Override
	    public String toString() {
	        return accountNumber + "," + name + "," + balance;
	    }

	    public static Account fromString(String data) {
	        String[] parts = data.split(",");
	        Account acc = new Account(parts[0], parts[1]);
	        acc.balance = Double.parseDouble(parts[2]);
	        return acc;
	    }
	}



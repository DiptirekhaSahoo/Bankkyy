package Banky.com;

import java.util.HashMap;
public class Bank {

	    private HashMap<String, Account> accounts;

	    public Bank() {
	        accounts = new HashMap<>();
	    }

	    public boolean createAccount(String accNo, String name) {
	        if (accounts.containsKey(accNo)) return false;
	        accounts.put(accNo, new Account(accNo, name));
	        return true;
	    }

	    public boolean deposit(String accNo, double amount) {
	        Account acc = accounts.get(accNo);
	        if (acc != null) {
	            acc.deposit(amount);
	            return true;
	        }
	        return false;
	    }

	    public boolean withdraw(String accNo, double amount) {
	        Account acc = accounts.get(accNo);
	        if (acc != null) {
	            return acc.withdraw(amount);
	        }
	        return false;
	    }

	    public boolean transfer(String fromAcc, String toAcc, double amount) {
	        Account from = accounts.get(fromAcc);
	        Account to = accounts.get(toAcc);
	        if (from != null && to != null && from.withdraw(amount)) {
	            to.deposit(amount);
	            return true;
	        }
	        return false;
	    }

	    public HashMap<String, Account> getAccounts() {
	        return accounts;
	    }

	    public void setAccounts(HashMap<String, Account> accounts) {
	        this.accounts = accounts;
	    }
	}


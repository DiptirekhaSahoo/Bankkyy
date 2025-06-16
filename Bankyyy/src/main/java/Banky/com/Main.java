package Banky.com;

import java.util.Scanner;
public class Main {


	    public static void main(String[] args) {
	        Bank bank = new Bank();
	        Scanner scanner = new Scanner(System.in);

	        // Load saved accounts
	        bank.setAccounts(Storage.loadAccounts());

	        while (true) {
	            System.out.println("\n--- BankY Menu ---");
	            System.out.println("1. Create Account");
	            System.out.println("2. Deposit");
	            System.out.println("3. Withdraw");
	            System.out.println("4. Transfer");
	            System.out.println("5. Exit");
	            System.out.print("Choose option: ");

	            int choice = scanner.nextInt();
	            scanner.nextLine(); // consume newline

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter account number: ");
	                    String accNo = scanner.nextLine();
	                    System.out.print("Enter name: ");
	                    String name = scanner.nextLine();
	                    if (bank.createAccount(accNo, name)) {
	                        System.out.println("Account created successfully.");
	                    } else {
	                        System.out.println("Account already exists.");
	                    }
	                    break;

	                case 2:
	                    System.out.print("Enter account number: ");
	                    accNo = scanner.nextLine();
	                    System.out.print("Enter amount to deposit: ");
	                    double deposit = scanner.nextDouble();
	                    if (bank.deposit(accNo, deposit)) {
	                        System.out.println("Deposit successful.");
	                    } else {
	                        System.out.println("Account not found.");
	                    }
	                    break;

	                case 3:
	                    System.out.print("Enter account number: ");
	                    accNo = scanner.nextLine();
	                    System.out.print("Enter amount to withdraw: ");
	                    double withdraw = scanner.nextDouble();
	                    if (bank.withdraw(accNo, withdraw)) {
	                        System.out.println("Withdrawal successful.");
	                    } else {
	                        System.out.println("Insufficient funds or account not found.");
	                    }
	                    break;

	                case 4:
	                    System.out.print("From account: ");
	                    String from = scanner.nextLine();
	                    System.out.print("To account: ");
	                    String to = scanner.nextLine();
	                    System.out.print("Amount to transfer: ");
	                    double amount = scanner.nextDouble();
	                    if (bank.transfer(from, to, amount)) {
	                        System.out.println("Transfer successful.");
	                    } else {
	                        System.out.println("Transfer failed.");
	                    }
	                    break;

	                case 5:
	                    Storage.saveAccounts(bank.getAccounts());
	                    System.out.println("Exiting and saving data.");
	                    return;

	                default:
	                    System.out.println("Invalid choice.");
	            }
	        }
	    }
	}


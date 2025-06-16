package Banky.com;

import java.io.*;
import java.util.HashMap;
public class Storage {

	    private static final String FILE_NAME = "accounts.txt";

	    public static void saveAccounts(HashMap<String, Account> accounts) {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
	            for (Account acc : accounts.values()) {
	                writer.write(acc.toString());
	                writer.newLine();
	            }
	        } catch (IOException e) {
	            System.out.println("Error saving accounts.");
	        }
	    }

	    public static HashMap<String, Account> loadAccounts() {
	        HashMap<String, Account> accounts = new HashMap<>();
	        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                Account acc = Account.fromString(line);
	                accounts.put(acc.getAccountNumber(), acc);
	            }
	        } catch (IOException e) {
	            System.out.println("No previous data found.");
	        }
	        return accounts;
	    }
	}


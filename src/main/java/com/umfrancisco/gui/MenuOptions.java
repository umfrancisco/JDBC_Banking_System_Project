package com.umfrancisco.gui;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.umfrancisco.model.Bank;
import com.umfrancisco.model.Customer;

public class MenuOptions {
	
	public static Bank showBankOptions(Scanner scanner, String bankMenu, List<Bank> banks) {
		while (true) {
			System.out.print(bankMenu);
			System.out.println("-".repeat(40));
			String option = scanner.nextLine();
			System.out.println("-".repeat(40));
			
			if (option.equals("100")) {
				return banks.get(0);
			} else if (option.equals("200")) {
				return banks.get(1);
			} else if (option.equals("300")) {
				return banks.get(2);
			} else {
				System.out.println("Bank number not found...\n");
			}
			
		}
	}
	
	public static void showCustomerOptions(Scanner scanner, String customerMenu, Bank bank) {
		
		String accountManagementMenu = """
				Choose one option:
					1 - Deposit
					2 - Withdraw
					3 - Return
					""";
		
		while (true) {
			System.out.print("Welcome to "+bank.getName()+" Bank\n\n");
			System.out.print(customerMenu);
			String option = scanner.nextLine();
			System.out.println("-".repeat(40));
			
			if (option.equals("1")) {
				System.out.print("Enter your name: ");
				String name = scanner.nextLine();
				System.out.print("Enter a amount: ");
				String amount = scanner.nextLine();
				int randomGeneratedId = new Random().nextInt(1000);
				bank.newBankCustomer(randomGeneratedId, name, Double.parseDouble(amount));
				System.out.println("\nYour bank number is "+randomGeneratedId);
			} else if (option.equals("2")) {
				System.out.println("Existing customer\n");
				System.out.print("Enter your bank number: ");
				String id = scanner.nextLine();
				Customer customer = bank.getCustomer(Integer.parseInt(id));
				showAccountManagementOptions(scanner, accountManagementMenu, customer, bank);
			} else if (option.equals("3")) {
				System.out.println("Goodbye");
				break;
			} else {
				System.out.println("Try again...");
			}
			System.out.println("-".repeat(40));
		}
	}
	
	public static void showAccountManagementOptions(Scanner scanner, String accountManagementMenu, Customer customer, Bank bank) {
		while (true) {
			System.out.println("\n"+customer);
			System.out.print(accountManagementMenu);
			
			String option = scanner.nextLine();
			if (option.equals("1")) {
				System.out.println("-".repeat(40));
				System.out.print("Deposit\n\nEnter a value to deposit: ");
				String value = scanner.nextLine();
				boolean result = bank.deposit(customer, Double.parseDouble(value));
				if (result) {
					System.out.println("Deposit successful!!");
				} else {
					System.out.println("Something went wrong...");
				}
				System.out.println("-".repeat(40));
			} else if (option.equals("2")) {
				System.out.print("Withdraw\n\nEnter a value to withdraw: ");
				String value = scanner.nextLine();
				boolean result = bank.withdraw(customer, Double.parseDouble(value));
				if (result) {
					System.out.println("Withdraw successful!!");
				} else {
					System.out.println("You can not withdraw a value greater than your balance...");
				}
				System.out.println("-".repeat(40));
			} else if (option.equals("3")) {
				break;
			} else {
				System.out.println("Try again...");
			}
		}
	}
}

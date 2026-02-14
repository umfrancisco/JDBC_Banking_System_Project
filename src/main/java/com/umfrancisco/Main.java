package com.umfrancisco;

import java.util.List;
import java.util.Scanner;

import com.umfrancisco.dto.BankService;
import com.umfrancisco.gui.MenuOptions;
import com.umfrancisco.model.Bank;

public class Main {
	public static void main(String[] args) {
		BankService bankService = new BankService();
		List<Bank> banks = bankService.getBanks();
		
		String bs = "";
		for (Bank b : banks) {
			bs += b.getBankNumber()+" - "+b.getName()+"\n";
		}
		String bankMenu = "Hello and Welcome!\nType your bank number:\n"+bs;
		
		String customerMenu = """
				Choose one option:
					1 - New customer
					2 - Existing customer
					3 - Quit
					""";
		
		Scanner scanner = new Scanner(System.in);
		Bank bank = MenuOptions.showBankOptions(scanner, bankMenu, banks);
		MenuOptions.showCustomerOptions(scanner, customerMenu, bank);
		scanner.close();
	}
}

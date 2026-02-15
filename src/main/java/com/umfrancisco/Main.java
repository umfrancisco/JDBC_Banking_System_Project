package com.umfrancisco;

import java.util.List;
import java.util.Scanner;

import com.umfrancisco.domain.Bank;
import com.umfrancisco.gui.MenuOptions;
import com.umfrancisco.service.BankService;

public class Main {
	public static void main(String[] args) {
		BankService bankService = new BankService();
		List<Bank> banks = bankService.getBanks();
		
		String banksStrFormatted = BankService.printBankNumbers(banks);
		String bankMenu = "Hello and Welcome!\nType your bank number:\n"+banksStrFormatted;
		
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

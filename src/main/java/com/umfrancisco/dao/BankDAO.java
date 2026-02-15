package com.umfrancisco.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.umfrancisco.domain.Bank;
import com.umfrancisco.util.DatabaseConnection;

public class BankDAO {
	
	public List<Bank> getBanks() {
		List<Bank> banks = new ArrayList<>();
		try (var conn = DatabaseConnection.getConnection("bank"); var stmt = conn.createStatement();) {
			ResultSet rs = stmt.executeQuery("SELECT * FROM bank");
			while (rs.next()) {
				int number = rs.getInt("bank_number");
				String name = rs.getString("bank_name");
				banks.add(new Bank(number, name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return banks;
	}
	
	public static String printBankNumbers(List<Bank> banks) {
		String banksStrFormatted = "";
		for (Bank b : banks) {
			banksStrFormatted += b.getBankNumber()+" - "+b.getName()+"\n";
		}
		return banksStrFormatted;
	}
}

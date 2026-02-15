package com.umfrancisco.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.umfrancisco.domain.Bank;

public class BankService {
	
	public List<Bank> getBanks() {
		var dataSource = new MysqlDataSource();
		
		dataSource.setServerName("localhost");
		dataSource.setPort(3306);
		dataSource.setDatabaseName("bank");
		
		List<Bank> banks = new ArrayList<>();
		try (var conn = dataSource.getConnection("francisco", "1234"); var stmt = conn.createStatement();) {
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

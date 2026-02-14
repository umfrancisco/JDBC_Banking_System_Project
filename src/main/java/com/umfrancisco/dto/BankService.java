package com.umfrancisco.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.umfrancisco.model.Bank;

public class BankService {
	public static void main(String[] args) {
		List<Bank> banks = new BankService().getBanks();
		System.out.println(banks);
	}
	
	public List<Bank> getBanks() {
		var dataSource = new MysqlDataSource();
		
		dataSource.setServerName("localhost");
		dataSource.setPort(3306);
		dataSource.setDatabaseName("bank");
		
		List<Bank> banks = new ArrayList<>();
		try (var conn = dataSource.getConnection("francisco", "1234"); var stmt = conn.createStatement();) {
			ResultSet rs = stmt.executeQuery("select * from bank");
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
}

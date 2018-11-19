package com.cg.bank.dao;

import java.util.List;

import com.cg.bank.dto.Customer;
import com.cg.bank.dto.Transactions;

public interface ICustomerDAO {
	public void createAccount(Customer customer);
	
	public double deposit(String mobileNo, double amount);
	
	public double withdraw(String mobileNo, double amount);
	
	public double checkBalance(String mobileNo);

	public boolean accountVal(String mobileNo);

	public double fundTransfer(String mobno1, double amt, String mobno2);

	public boolean withdrawVal(String mobileNo, double amount);

	List<Transactions> getTransList(String mobileNo);
	
}

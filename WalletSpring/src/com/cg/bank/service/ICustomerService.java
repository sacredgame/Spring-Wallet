package com.cg.bank.service;

import java.util.List;

import com.cg.bank.dto.Customer;
import com.cg.bank.dto.Transactions;

public interface ICustomerService {

	public void createAccount(Customer customer);
	
	public double deposit(String mobileNo, double amount);
	
	public double withdraw(String mobileNo, double amount);
	
	public double checkBalance(String mobileNo);
	
	public void fundTransfer(String sender, String reciever, double amount);

	public boolean accountVal(String mobileNo);

	public double fundtransfer(String mobno1, double amt, String mobno2);

	public boolean withdrawVal(String mobileNo, double amount);

	public List<Transactions> getTransactions(String mobileNo);
		
}

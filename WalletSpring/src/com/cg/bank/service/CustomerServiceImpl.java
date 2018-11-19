package com.cg.bank.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bank.dao.ICustomerDAO;
import com.cg.bank.dto.Customer;
import com.cg.bank.dto.Transactions;


@Service("customerservice")
@Transactional

public class CustomerServiceImpl implements ICustomerService{
@Autowired
ICustomerDAO customerdao;

	@Override
	public void createAccount(Customer customer) {
		customerdao.createAccount(customer);
	}

	@Override
	public double deposit(String mobileNo, double amount) {
		return customerdao.deposit(mobileNo, amount);		
	}

	@Override
	public double withdraw(String mobileNo, double amount) {
		return customerdao.withdraw(mobileNo, amount);
		
	}

	@Override
	public double checkBalance(String mobileNo) {
		return customerdao.checkBalance(mobileNo);
	}

	@Override
	public void fundTransfer(String sender, String reciever, double amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean accountVal(String mobileNo) {
		return customerdao.accountVal(mobileNo);
		
	}

	@Override
	public double fundtransfer(String mobno1, double amt, String mobno2) {
		return customerdao.fundTransfer(mobno1, amt, mobno2);
	}

	@Override
	public boolean withdrawVal(String mobileNo, double amount) {
		return customerdao.withdrawVal(mobileNo, amount);
	}

	@Override
	public List<Transactions> getTransactions(String mobileNo) {
		return customerdao.getTransList(mobileNo);
	}

}

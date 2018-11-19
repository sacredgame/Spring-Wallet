package com.cg.bank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.bank.dto.Customer;
import com.cg.bank.dto.Transactions;
@Repository("customerdao")
public class CustomerDAOImpl implements ICustomerDAO{
	@PersistenceContext
	EntityManager em;
	
	
	
	@Override
	@Transactional
	public void createAccount(Customer customer) {
		Transactions trans = new Transactions();
		em.persist(customer);	
		trans.setMobileNo(customer.getMobileNo());
		trans.setAmount(0);
		trans.setBalance(customer.getInitialBalance());
		trans.setCd("Credit");
		em.persist(trans);
		em.flush();
	}
	
	@Override
	@Transactional
	public double deposit(String mobileNo, double amount){
		Transactions trans = new Transactions();
		Customer c = em.find(Customer.class, mobileNo);
		double amt = c.getInitialBalance();
		amt = amt+amount;
		c.setInitialBalance(amt);
		trans.setMobileNo(mobileNo);
		trans.setAmount(amount);
		trans.setBalance(amt);
		trans.setCd("Credit");
		em.persist(trans);
		em.flush();
		return amt;
	}

	@Override
	@Transactional
	public double withdraw(String mobileNo, double amount) {
		Transactions trans = new Transactions();
		Customer c = em.find(Customer.class, mobileNo);
		double amt =c.getInitialBalance();
		amt=amt-amount;
		c.setInitialBalance(amt);
		trans.setMobileNo(mobileNo);
		trans.setAmount(amount);
		trans.setBalance(amt);
		trans.setCd("Debit");
		em.persist(trans);
		em.flush();
		return amt;
		
	}

	@Override
	public double checkBalance(String mobileNo) {
		Customer c = em.find(Customer.class, mobileNo);
		return c.getInitialBalance();
	}

	@Override
	public boolean accountVal(String mobileNo) {
		Customer c1= em.find(Customer.class, mobileNo);
		if(c1 != null)
			return true;
		else
			return false;		
	}

	@Override
	@Transactional
	public double fundTransfer(String mobno1, double amt, String mobno2) {
		Transactions trans = new Transactions();
		Customer c= em.find(Customer.class, mobno1);
		Customer c1= em.find(Customer.class, mobno2);
		double amount1 = c.getInitialBalance() - amt;
		double amount2 = c1.getInitialBalance() + amt;
		c.setInitialBalance(amount1);
		c1.setInitialBalance(amount2);
		Transactions trans1 = new Transactions();
		trans.setMobileNo(mobno1);
		trans.setAmount(amt);
		trans.setBalance(amount1);
		trans.setCd("Debit");
		trans1.setMobileNo(mobno2);
		trans1.setAmount(amt);
		trans1.setBalance(amount2);
		trans1.setCd("Credit");
		em.persist(trans);
		em.persist(trans1);
		em.flush();		
		return amount1;
	}

	@Override
	public boolean withdrawVal(String mobileNo, double amount) {
		Customer c = em.find(Customer.class, mobileNo);
		double amt = c.getInitialBalance();
		if(amt-amount<1)
			return false;
		else
			return true;
	}

	@Override
	public List<Transactions> getTransList(String mobileNo) {
		String qr = "select trans from Transactions trans where mobileNo ="+mobileNo;
		TypedQuery<Transactions> query = em.createQuery(qr, Transactions.class);
		List<Transactions> list = query.getResultList();
		return list;
	}
}

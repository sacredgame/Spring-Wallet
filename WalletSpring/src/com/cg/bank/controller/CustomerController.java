package com.cg.bank.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cg.bank.dto.Transactions;
import com.cg.bank.dto.Customer;
import com.cg.bank.service.ICustomerService;

@Controller
public class CustomerController {
	@Autowired
	ICustomerService customerservice;
	@RequestMapping(value="/home")
	public String getAllCust(@ModelAttribute("my") Customer cust) {
		return "AddCustomer";	 
	}
	
	@RequestMapping(value="adddata", method=RequestMethod.POST )
	public String addMobileData(@ModelAttribute("my") Customer cust){
		customerservice.createAccount(cust);
		return "Success";
	}
	
	@RequestMapping(value="/deposit")
	public String getDeposit(@ModelAttribute("depo") Customer cust){
		return "deposit";
	}
	
	@RequestMapping(value="depositamt", method=RequestMethod.POST )
	public ModelAndView depositAmt(@Valid@ModelAttribute("depo") Customer cust){
		if(customerservice.accountVal(cust.getMobileNo())){
			double amt = customerservice.deposit(cust.getMobileNo(), cust.getInitialBalance());
			return new ModelAndView("SuccessD", "newBal", amt);
		}
		else
			return new ModelAndView("AccNotFound", "name", "");
	}
	
	@RequestMapping(value="/withdraw")
	public String getWithdraw(@ModelAttribute("with") Customer cust){
		return "withdraw";
	}
	
	@RequestMapping(value="withdrawamt", method=RequestMethod.POST )
	public ModelAndView withdrawAmt(@Valid@ModelAttribute("with") Customer cust){
		if(customerservice.accountVal(cust.getMobileNo())){
			if(customerservice.withdrawVal(cust.getMobileNo(), cust.getAmount())){
				double amt=customerservice.withdraw(cust.getMobileNo(), cust.getAmount());
				return new ModelAndView("SuccessW", "newBal",amt);
			}
			else
				return new ModelAndView("Failure");
		}
		else
			return new ModelAndView("AccNotFound", "name", "");
	}
	
	@RequestMapping(value="/fundtransfer")
	public String getFundtransfer(@ModelAttribute("fd") Customer cust){
		return "fundtransfer";
	}
	
	@RequestMapping(value="fund", method=RequestMethod.POST )
	public ModelAndView fundtransfer(@Valid@ModelAttribute("fd") Customer cust){
		if(customerservice.accountVal(cust.getMobNo())){
			if(customerservice.accountVal(cust.getMobileNo())){
				if(customerservice.withdrawVal(cust.getMobileNo(), cust.getAmount())){
					double amt1=customerservice.fundtransfer(cust.getMobileNo(), cust.getAmount(), cust.getMobNo());
					return new ModelAndView("SuccessF", "newBal",amt1);
				}
				else
					return new ModelAndView("Failure");				
			}
			else
				return new ModelAndView("AccNotFound" , "name", "sender's");
		}
		else
			return new ModelAndView("AccNotFound" , "name", "receiver's");
	}
	
	@RequestMapping(value="/balancecheck")
	public String getBalance(@ModelAttribute("chk") Customer cust){
		return "CheckBal";
	}
	
	@RequestMapping(value="checkBal", method=RequestMethod.POST )
	public ModelAndView checkbal(@Valid@ModelAttribute("chk") Customer cust){
		if(customerservice.accountVal(cust.getMobileNo())){
			 double amt = customerservice.checkBalance(cust.getMobileNo());
			 return new ModelAndView("CheckBalSuccess", "newBal",amt);
		}
		else
			return new ModelAndView("AccNotFound", "name", "");
	}
	
	@RequestMapping(value="/printTrans")
	public String getTrans(@ModelAttribute("trans") Customer cust){
		return "Print";
	}
	
	@RequestMapping(value="printtrans", method=RequestMethod.POST )
	public ModelAndView transList(@Valid@ModelAttribute("trans") Customer cust){
		if(customerservice.accountVal(cust.getMobileNo())){
			List<Transactions> list = customerservice.getTransactions(cust.getMobileNo());
			 return new ModelAndView("PrintTrans", "list", list);
		}
		else
			return new ModelAndView("AccNotFound", "name", "");
	}
}

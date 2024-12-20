package com.bank.app;

import java.util.Scanner;
import com.bank.dao.*;
import com.bank.dto.Customer;
import com.bank.dto.Transaction;
import com.bank.dto.TransactionID;

public class Deposit {
	public static void deposit(Customer c) 
	{ 
	CustomerDAO cdao=new CustomerDAOImp(); 
	TransactionDAO tdao=new TransactionDAOImp(); 
	Scanner sc=new Scanner(System.in); 
	System.out.println("Enter the amount to be deposited"); 
 
	  double amount=sc.nextDouble(); 
	  c.setBal(c.getBal()+amount); 
	  boolean res=cdao.updateCustomer(c); 
	  if(res) 
	  { 
	   Transaction t=new Transaction(); 
	  
	 t.setTransactionId(TransactionID.generateTransactionId()); 
	   t.setUser(c.getAccno()); 
	   t.setRec_acc(c.getAccno()); 
	   t.setTransaction("CREDITED"); 
	   t.setAmount(amount); 
	   t.setBalance(c.getBal()); 
	   boolean res1=tdao.insertTransaction(t); 
	   if(res) 
	   { 
	    System.out.println("Amount of Rs."+amount+" has been added successfully!"); 
	    System.out.println("Your updated balance is Rs."+c.getBal()); 
	   } 
	   else 
	{ 
	System.out.println("Failed to deposit"); 
	} 
	} 
	}}

package com.bank.app;

import java.util.List;
import java.util.Scanner;
import com.bank.dao.*;
import com.bank.dto.Customer;

public class Welcome {
	public static void main(String[] args) { 
		int choice=0; 
		Scanner sc=new Scanner(System.in); 
		System.out.println("<=====Welcome to New Bank=====>"); 
		do { 
		System.out.println("1. Customer Login"); 
		System.out.println("2. Create a account"); 
		System.out.println("3. Exit"); 
		choice=sc.nextInt(); 
		switch (choice)  

		   { 
		   case 1:{ 
		     Login.login(); 
		    break; 
		   } 
		   case 2:{ 
		    SignUp.signup(); 
		    break; 
		   } 
		   case 3:{ 
		    System.out.println("Exiting the Application. Thank you"); 
		    break; 
		   } 
		   case 4: 
		   { 
		    CustomerDAO cdao=new CustomerDAOImp(); 
		    List<Customer> Lc=cdao.getCustomer(); 
		    for(Customer c:Lc) 
		    { 
		     System.out.println(c); 
		    } 
		} 
		default: System.out.println("Invalid input.Please try again!"); 
		} 
		} while(choice!=3); 
		sc.close(); 
		}
}

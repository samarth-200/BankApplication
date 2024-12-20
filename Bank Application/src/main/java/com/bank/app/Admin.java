package com.bank.app;

import java.util.ArrayList; 
import java.util.Iterator; 
import java.util.List; 
import java.util.Scanner; 
import com.bank.dao.CustomerDAO; 
import com.bank.dao.CustomerDAOImp; 
import com.bank.dao.TransactionDAO; 
import com.bank.dao.TransactionDAOImp; 
import com.bank.dto.Customer; 
import com.bank.dto.Transaction; 
import com.bank.dto.TransactionID; 
public class Admin { 
public static void admin(Customer c) { 
Scanner sc=new Scanner(System.in); 
int choice=0; 
CustomerDAO cdao=new CustomerDAOImp(); 

  TransactionDAO tdao=new TransactionDAOImp(); 
  do { 
   System.out.println("1. Get Account Data"); 
   System.out.println("2. Get Transaction List"); 
   System.out.println("3. Delete any user"); 
   System.out.println("4. Access your account"); 
   System.out.println("5. Back to main menu"); 
   choice=sc.nextInt(); 
   switch(choice) 
   { 
   case 1:{ 
    System.out.println("<=====Customer Data=====>"); 
    List<Customer> customers=cdao.getCustomer(); 
    Iterator<Customer> it=customers.iterator(); 
    while(it.hasNext()) 
    { 
     Customer c1=it.next(); 
     System.out.println(c1); 
    } 
    break; 
   } 
 
 
   case 2: { 
    System.out.println("<=====Transaction Data=====>"); 
    List<Transaction> transactions=tdao.getTransaction(c.getAccno()); 
    Iterator<Transaction> it=transactions.iterator(); 
    while(it.hasNext()) 
    { 
     Transaction t1=it.next(); 
     System.out.println(t1); 
    } 
    break; 
   }  
   case 3: { 
    System.out.println("Enter the account number of the user to be deleted:"); 
    Customer c1=cdao.getCustomer(sc.nextLong()); 
 

 
 
    if(c.getAccno()!=c1.getAccno()) 
 

    { 
     double amount=c1.getBal(); 
     c.setBal(c.getBal()+c1.getBal()); 
     boolean res1=cdao.updateCustomer(c); 

 
 
     if(res1) 
     { 
      Transaction t1=new Transaction(); 
     
 t1.setTransactionId(TransactionID.generateTransactionId()); 
      t1.setUser(c.getAccno()); 
      t1.setRec_acc(c1.getAccno()); 
      t1.setAmount(amount); 
      t1.setTransaction("CREDITED"); 
      t1.setBalance(c.getBal()); 
      boolean res=tdao.insertTransaction(t1); 
 

 
      if(res1&&res) 
      { 
       System.out.println("Proceeding to delete"); 
        cdao.deleteCustomer(c1); 
      } 
      else 
      { 
       System.out.println("Failed to delete"); 
      } 
 
     } 
     else 
     { 
      System.err.println("Failed to delete; amount transfer failed from the customer account"); 
     } 
    } 
    else 
    { 
     System.out.println("Cannot delete the admin data"); 
} 
break; 
} 
case 4: App.options(c); 
break; 
case 5:System.out.println("Going back to main menu"); 
break; 
default:System.out.println("Invalid choice. Enter the correct choice!"); 
} 
} 
while(choice!=5); 
} 
}
package com.bank.app;
import java.util.Scanner; 
import com.bank.dao.CustomerDAO; 
import com.bank.dao.CustomerDAOImp; 
import com.bank.dao.TransactionDAO; 
import com.bank.dao.TransactionDAOImp; 
import com.bank.dto.Customer; 
import com.bank.dto.Transaction; 
import com.bank.dto.TransactionID; 
public class TransferAmount { 
public static void transferAmount(Customer c)
 { 
CustomerDAO cdao=new CustomerDAOImp(); 
Transaction t1=null; 
Transaction t2=null; 

 TransactionDAO tdao=new TransactionDAOImp(); 

  Scanner sc=new Scanner(System.in); 
  System.out.println("Enter the amount to be transferred"); 
  double amount=sc.nextDouble(); 
  System.out.println("Enter the benificiary account number"); 
  long receiver_accno=sc.nextLong();
  Customer receiver=cdao.getCustomer(receiver_accno); 
 
 if(c.getAccno()!=receiver.getAccno()&&c.getBal()>0&&c.getBal()>=amount&&amount>0) 
  { 
   System.out.println("Enter the PIN"); 
   int pin=sc.nextInt(); 
   if(pin==c.getPin()) 
   { 
    c.setBal(c.getBal()-amount); 
    boolean c_res=cdao.updateCustomer(c); 

    if(c_res) 
    { 
     t1=new Transaction(); 
    
 t1.setTransactionId(TransactionID.generateTransactionId()); 
     t1.setUser(c.getAccno()); 
     t1.setRec_acc(receiver.getAccno()); 
     t1.setTransaction("DEBITED"); 
     t1.setAmount(amount); 
     t1.setBalance(c.getBal()); 
     boolean res1=tdao.insertTransaction(t1); 
    } 

    receiver.setBal(receiver.getBal()+amount); 
    boolean receiver_res=cdao.updateCustomer(receiver); 
    if(receiver_res) 
    { 
     { 
      t2=new Transaction(); 
      t2.setTransactionId(t1.getTransactionId()); 
      t2.setUser(receiver.getAccno()); 
      t2.setRec_acc(c.getAccno()); 
      t2.setTransaction("CREDITED"); 
 
      t2.setAmount(amount); 
      t2.setBalance(receiver.getBal()); 
      boolean res1=tdao.insertTransaction(t2); 
     } 
    } 
    //amount is getting credited to receiver account 
    if(c_res&&receiver_res) 
    { 
     System.out.println("Transaction successful"); 
    } 
    else 
    { 
     System.out.println("Transaction failed!!!"); 
    } 
   } 
  } 
  else 
  { 
   System.out.println("Transaction failed!!!"); 
  } 
 } 
}
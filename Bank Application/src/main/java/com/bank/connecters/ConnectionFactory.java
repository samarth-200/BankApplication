package com.bank.connecters;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
public static Connection requestConnection(){
	Connection con=null;
	String url="jdbc:mysql://localhost:3306/bank";
	String user="root";
	String pass="1234";
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,user,pass);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return con;
}
}

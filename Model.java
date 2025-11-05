package com.banking.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.Random;

import com.banking.utils.Credentials;

public class Model {
	private int uid;
	private String uname;
	private int accno;
	private String email;
	private long phn;
	private int balance;
	private String pwd;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res;
	private String npassword;
	
	public String getNpassword() {
		return npassword;
	}
	public void setNpassword(String npassword) {
		this.npassword = npassword;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhn() {
		return phn;
	}
	public void setPhn(long phn) {
		this.phn = phn;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Model() {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(Credentials.url,Credentials.username, Credentials.pwd);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public boolean registerUser()
	{
		try
		{
			String sql="insert into bankapp(uname,accno,email,phone,balance,password)values (?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,uname);
			pstmt.setInt(2, accno);
			pstmt.setString(3,email);
			pstmt.setLong(4, phn);
			pstmt.setInt(5, balance);
			pstmt.setString(6,pwd);
			int x=pstmt.executeUpdate();
			if(x>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			return false;
		}			
	}
	/*
	public boolean loginUser()
	{
		try
		{
			String sql=" select*from bankapp where email=? and password=?";
			pstmt=con.prepareStatement(sql);
		
			pstmt.setString(1, email);;
			pstmt.setString(2, pwd);
			res=pstmt.executeQuery();
			if(res.next()==true)
			{
				accno=res.getInt("accno");
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			return false;
		}			
	}
	*/
	public boolean loginUser() {
	    try {
	        System.out.println("loginUser called with email: " + email + ", pwd: " + pwd);
	        String sql = "select * from bankapp where email=? and password=?";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, email);
	        pstmt.setString(2, pwd);
	        res = pstmt.executeQuery();
	        if (res.next()) {
	            accno = res.getInt("accno");
	            System.out.println("User found with accno: " + accno);
	            return true;
	        } else {
	            System.out.println("User not found or wrong password");
	            return false;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	public boolean Deleteuser()
	{
		try
		{
			String sql="delete from bankapp where accno=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,accno);
			int x=pstmt.executeUpdate();
			if(x>=1)
			{
				return true;
			}
			else
			{
				return false;
			}	 
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public boolean updateuser()
	{
		try {
		String sql="update bankapp set uname=? where accno=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,uname);
		pstmt.setInt(2,accno);
		
		int x=pstmt.executeUpdate();
		if(x>=1)
		{
			return true;
		}
		else
		{
			return false;
		}	
    
	}
		catch(Exception e)
		{
			return false;
		}

	}

	public boolean fetchBalance() {
		try {
			String query="select balance from bankapp where accno=?";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, accno);
			res=pstmt.executeQuery();
			while(res.next()==true)
			{
				balance=res.getInt("balance");
			}
			return true;	
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public boolean changePassword() {
		try {
			String sql="update bankapp set password=? where accno=? and password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,npassword);
			pstmt.setInt(2, accno);
			pstmt.setString(3, pwd);
			int x=pstmt.executeUpdate();
			if(x>0) {
			
			return true;
			
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	// Calculate eligible loan amount (10x income)
	public double calculateEligibleLoan(double income) {
	    return income * 10;
	}

	// Credit loan amount to the account
	public boolean creditLoanToAccount(int accno, double loanAmount) {
	    try {
	        String sql = "UPDATE bankapp SET balance = balance + ? WHERE accno = ?";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setDouble(1, loanAmount);
	        pstmt.setInt(2, accno);
	        int rows = pstmt.executeUpdate();
	        return rows > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	public boolean transferToFriendAccount(int senderAccno, int receiverAccno, double amount) {
	    try {
	        con.setAutoCommit(false);

	        // Check sender's balance
	        String checkSql = "SELECT balance FROM bankapp WHERE accno = ?";
	        pstmt = con.prepareStatement(checkSql);
	        pstmt.setInt(1, senderAccno);
	        res = pstmt.executeQuery();
	        if (!res.next()) {
	            con.rollback();
	            return false; // sender account not found
	        }
	        double senderBalance = res.getDouble("balance");
	        if (senderBalance < amount) {
	            con.rollback();
	            return false; // insufficient funds
	        }

	        // Deduct amount from sender
	        String deductSql = "UPDATE bankapp SET balance = balance - ? WHERE accno = ?";
	        pstmt = con.prepareStatement(deductSql);
	        pstmt.setDouble(1, amount);
	        pstmt.setInt(2, senderAccno);
	        pstmt.executeUpdate();

	        // Add amount to receiver
	        String addSql = "UPDATE bankapp SET balance = balance + ? WHERE accno = ?";
	        pstmt = con.prepareStatement(addSql);
	        pstmt.setDouble(1, amount);
	        pstmt.setInt(2, receiverAccno);
	        int rowCount = pstmt.executeUpdate();
	        if (rowCount == 0) { // receiver not found
	            con.rollback();
	            return false;
	        }

	        con.commit();
	        con.setAutoCommit(true);
	        return true;
	    } catch (Exception e) {
	        try {
	            con.rollback();
	            con.setAutoCommit(true);
	        } catch (Exception ex) {}
	        e.printStackTrace();
	        return false;
	    }
	}
	public boolean transferToFriendAccount1(int senderAccno, int receiverAccno, double amount) {
	    try {
	        con.setAutoCommit(false);

	        String checkSenderSql = "SELECT balance FROM bankapp WHERE accno = ?";
	        pstmt = con.prepareStatement(checkSenderSql);
	        pstmt.setInt(1, senderAccno);
	        res = pstmt.executeQuery();
	        if (!res.next()) {
	            con.rollback();
	            return false;
	        }
	        double senderBalance = res.getDouble("balance");
	        if (senderBalance < amount) {
	            con.rollback();
	            return false;
	        }

	        String deductSql = "UPDATE bankapp SET balance = balance - ? WHERE accno = ?";
	        pstmt = con.prepareStatement(deductSql);
	        pstmt.setDouble(1, amount);
	        pstmt.setInt(2, senderAccno);
	        pstmt.executeUpdate();

	        String addSql = "UPDATE bankapp SET balance = balance + ? WHERE accno = ?";
	        pstmt = con.prepareStatement(addSql);
	        pstmt.setDouble(1, amount);
	        pstmt.setInt(2, receiverAccno);
	        int rows = pstmt.executeUpdate();
	        if (rows == 0) {
	            con.rollback();
	            return false;
	        }

	        con.commit();
	        con.setAutoCommit(true);
	        return true;
	    } catch (Exception e) {
	        try {
	            con.rollback();
	            con.setAutoCommit(true);
	        } catch(Exception ex) {}
	        e.printStackTrace();
	        return false;
	    }
	}

	public String getUserNameByAccno(int accno) {
	    try {
	        String sql = "SELECT uname FROM bankapp WHERE accno = ?";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, accno);
	        res = pstmt.executeQuery();
	        if (res.next()) {
	            return res.getString("uname");
	        }
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	public int getRandomCibilScore() {
	    Random random = new Random();
	    return random.nextInt(601) + 300; // Generates number between 300 and 900 inclusive
	}


	
}

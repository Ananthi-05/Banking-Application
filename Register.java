package com.banking.controller;

import java.io.IOException;

import com.banking.model.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Register")
public class Register  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname=req.getParameter("uname");
		int accno=Integer.parseInt(req.getParameter("accno"));
		String email=req.getParameter("email");
		long phn=Long.parseLong(req.getParameter("phn"));
		int balance=Integer.parseInt(req.getParameter("bal"));
		String pwd=req.getParameter("pwd");
		
		Model m=new Model();
		m.setUname(uname);
		m.setAccno(accno);
		m.setBalance(balance);
		m.setEmail(email);
	    m.setPhn(phn);
		m.setPwd(pwd);
		
		boolean b=m.registerUser();
		if(b==true)
		{
			resp.sendRedirect("/BankingApplication/RegisterSuccess.html");
		}
		else
		{
			resp.sendRedirect("/BankingApplication/RegisterFail.html");
		}
		
		
	}
}

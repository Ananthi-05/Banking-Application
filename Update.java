package com.banking.controller;

import java.io.IOException;

import com.banking.model.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Update")
public class Update extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname=req.getParameter("uname");
		int accno=Integer.parseInt(req.getParameter("accno"));
		Model m=new Model();
		m.setUname(uname);
		m.setAccno(accno);
		boolean b=m.updateuser();
		if(b==true)
		{
			resp.sendRedirect("/BankingApplication/updatesuccess.html");
		}
		else
		{
			resp.sendRedirect("/BankingApplication/Register.html");
		}
		
	}
	
 

 }

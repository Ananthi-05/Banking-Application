package com.banking.controller;

import java.io.IOException;

import com.banking.model.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Delete")
public class Delete extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int accno=Integer.parseInt(req.getParameter("accno"));
		
		Model m=new Model();
		m.setAccno(accno);
		boolean b=m.Deleteuser();
		if(b==true)
		{
			resp.sendRedirect("/BankingApplication/DeleteSuccess.html");
		}
		else
		{
			resp.sendRedirect("/BankingApplication/loginFail.html");
		}
		
	}
	
}




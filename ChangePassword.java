package com.banking.controller;

import java.io.IOException;

import com.banking.model.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/ChangePassword")

public class ChangePassword extends HttpServlet {
	 private HttpSession session;
/*
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session=req.getSession();
		int accno=(int)session.getAttribute("accno");
		
		String opwd=req.getParameter("opwd");
		String npwd=req.getParameter("npwd");
		String cnpwd=req.getParameter("cnpwd");
		
		if(npwd.equals(cnpwd)==true)
		{
			Model m=new Model();
			m.setAccno(accno);
			m.setNpassword(npwd);
			m.setPwd(opwd);
			boolean b=m.changePassword();
			if(b==true)
			{
				resp.sendRedirect("/BankingApplication/PwdChangeSuccess.html");
			}
			else
			{
				resp.sendRedirect("/BankingApplication/PwdChangeFail.html");
			}	
		}
		else
		{
			resp.sendRedirect("/BankingApplication/PwdMismatch.html");
		}		
	}
}
*/
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    session = req.getSession(false); // Don't create new session if absent
    if (session == null) {
        resp.sendRedirect("Login.html");
        return;
    }
    Integer accnoObj = (Integer) session.getAttribute("accno");
    if (accnoObj == null) {
        resp.sendRedirect("Login.html");
        return;
    }
    int accno = accnoObj.intValue();
    String opwd = req.getParameter("opwd");
    String npwd = req.getParameter("npwd");
    String cnpwd = req.getParameter("cnpwd");

    if (npwd.equals(cnpwd)) {
        Model m = new Model();
        m.setAccno(accno);
        m.setNpassword(npwd);
        m.setPwd(opwd);
        boolean b = m.changePassword();
        if (b) {
            resp.sendRedirect("/BankingApplication/PwdChangeSuccess.html");
        } else {
            resp.sendRedirect("/BankingApplication/PwdChangeFail.html");
        }
    } else {
        resp.sendRedirect("/BankingApplication/PwdMismatch.html");
    }
}
}

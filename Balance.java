package com.banking.controller;
import java.io.IOException;

import com.banking.model.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Balance")
public class Balance extends HttpServlet {
    private HttpSession session;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session = req.getSession(false); // Use false to avoid creating new session if not exists
        if (session == null) {
            resp.sendRedirect("Login.html"); // Redirect if session doesn't exist
            return;
        }
        Integer accno = (Integer) session.getAttribute("accno");
        if (accno == null) {
            resp.sendRedirect("Login.html"); // Redirect if accno not found in session
            return;
        }

        Model m = new Model();
        m.setAccno(accno.intValue());
        boolean b = m.fetchBalance();
        if (b) {
            session.setAttribute("balance", m.getBalance());
            resp.sendRedirect("/BankingApplication/BalanceSuccess.jsp");
        } else {
            resp.sendRedirect("/BankingApplication/Balancefail.html");
        }
    }
}


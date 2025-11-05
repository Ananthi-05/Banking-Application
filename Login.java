package com.banking.controller;

import java.io.IOException;
import com.banking.model.Model;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
    private HttpSession session;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pwd = req.getParameter("password");
        System.out.println("Login attempt received with email: " + email + " and password: " + pwd);
        session = req.getSession(true);
     

        Model m = new Model();
        m.setEmail(email);
        m.setPwd(pwd);

        boolean b = m.loginUser();
        System.out.println("Login success? " + b);
        if (b) {
            session.setAttribute("email", m.getEmail());
           session.setAttribute("accno", m.getAccno());
            resp.sendRedirect("/BankingApplication/Home.html");
        } else {
            resp.sendRedirect("/BankingApplication/LoginFail.html");
        }
    }
}


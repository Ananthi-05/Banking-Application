package com.banking.controller;
/*
import java.io.IOException;
import java.io.PrintWriter;

import com.banking.model.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/SendMoneyServlet")
public class SendMoneyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {
            int senderAccno = Integer.parseInt(req.getParameter("senderAccno"));
            int receiverAccno = Integer.parseInt(req.getParameter("receiverAccno"));
            double amount = Double.parseDouble(req.getParameter("amount"));

            Model model = new Model();

            boolean success = model.transferToFriendAccount(senderAccno, receiverAccno, amount);

            out.println("<html><head><title>Transfer Result</title><style>");
            out.println("body { font-family: 'Segoe UI'; background: linear-gradient(120deg, #112D4E 70%, #3F72AF 100%); color: #fff; text-align: center; padding: 40px;}");
            out.println("h2 { color: #fff; }");
            out.println("a { display: inline-block; padding: 12px 32px; background: #3F72AF; color: #fff; text-decoration: none; border-radius: 8px; margin-top: 30px; }");
            out.println("a:hover { background: #112D4E; }");
            out.println("</style></head><body>");
            if (success) {
                out.println("<h2>Transfer Successful</h2>");
                out.println("<p>₹" + amount + " sent from account " + senderAccno + " to account " + receiverAccno + ".</p>");
            } else {
                out.println("<h2>Transfer Failed!</h2>");
                out.println("<p>Check account numbers and ensure sufficient balance.</p>");
            }
            out.println("<a href='Home.html'>Back to Home</a>");
            out.println("</body></html>");
        } catch (Exception e) {
            out.println("<h2>Error: Invalid input or error processing request.</h2>");
            out.println("<a href='SendMoney.html'>Try Again</a>");
        }
    }
}
*/

import java.io.IOException;

import com.banking.model.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/SendMoneyServlet")
public class SendMoneyServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      int senderAccno = Integer.parseInt(req.getParameter("senderAccno"));
      int receiverAccno = Integer.parseInt(req.getParameter("receiverAccno"));
      double amount = Double.parseDouble(req.getParameter("amount"));

      Model model = new Model();

      boolean success = model.transferToFriendAccount1(senderAccno, receiverAccno, amount);
      if (success) {
        String receiverName = model.getUserNameByAccno(receiverAccno);
        req.setAttribute("receiverName", receiverName != null ? receiverName : "Unknown");
        req.setAttribute("receiverAccno", receiverAccno);
        req.setAttribute("amount", amount);
        req.getRequestDispatcher("SendMoneyResult.jsp").forward(req, resp);
      } else {
        resp.setContentType("text/html");
        resp.getWriter().println("<h2>Transfer Failed. Check account details and balance.</h2>");
        resp.getWriter().println("<a href='SendMoney.html'>Try Again</a>");
      }
    } catch(Exception e) {
      resp.setContentType("text/html");
      resp.getWriter().println("<h2>Error: Invalid input.</h2>");
      resp.getWriter().println("<a href='SendMoney.html'>Try Again</a>");
    }
  }
}


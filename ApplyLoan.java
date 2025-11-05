package com.banking.controller;

/*
import java.io.IOException;
import java.io.PrintWriter;

import com.banking.model.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ApplyLoan")
public class ApplyLoan extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accnoStr = req.getParameter("accno");
        String incomeStr = req.getParameter("income");
        String amountStr = req.getParameter("amount");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {
            int accno = Integer.parseInt(accnoStr);
            double income = Double.parseDouble(incomeStr);
            double requested = Double.parseDouble(amountStr);

            Model model = new Model();
            double eligible = model.calculateEligibleLoan(income);

            out.println("<html><head><title>Loan Application Result</title></head><body>");
            out.println("<h2>Loan Application Result</h2>");
            if(requested <= eligible) {
                boolean credited = model.creditLoanToAccount(accno, requested);
                if(credited) {
                    out.println("<p>Congratulations! Your loan is approved.</p>");
                    out.println("<p>Eligible loan: ₹" + eligible + "</p>");
                    out.println("<p>Loan credited: ₹" + requested + "</p>");
                } else {
                    out.println("<p>Error: Account number invalid or balance update failed.</p>");
                }
            } else {
                out.println("<p>Requested loan exceeds eligibility.</p>");
                out.println("<p>Maximum eligible loan: ₹" + eligible + "</p>");
            }
            out.println("<br><a href='Home.html'>Back to Home</a>");
            out.println("</body></html>");
        } catch(NumberFormatException e) {
            out.println("<p>Invalid input provided, please enter numeric values.</p>");
            out.println("<a href='PersonalLoan.html'>Back to Loan Application</a>");
        } 
    }
}
*/

import java.io.IOException;
import java.io.PrintWriter;
import com.banking.model.Model;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ApplyLoan")
public class ApplyLoan extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accnoStr = req.getParameter("accno");
        String incomeStr = req.getParameter("income");
        String amountStr = req.getParameter("amount");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {
            int accno = Integer.parseInt(accnoStr);
            double income = Double.parseDouble(incomeStr);
            double requested = Double.parseDouble(amountStr);

            Model model = new Model();
            double eligible = model.calculateEligibleLoan(income);

            out.println("<html><head><title>Loan Application Result</title><style>");
            out.println("body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background: linear-gradient(120deg, #112D4E 70%, #3F72AF 100%); color: #15395a; text-align: center; padding: 30px; }");
            out.println("h2 { color: #ffffff; font-size: 2.8em; margin-bottom: 30px; }");
            out.println(".success-msg { background: #4672aa; color: #fff; font-weight: bold; font-size: 1.8em; margin: 0 auto 40px; padding: 20px 40px; border-radius: 12px; display: inline-block; box-shadow: 0 5px 15px rgba(0,0,0,0.3); }");
            out.println(".details { font-size: 1.4em; margin-bottom: 30px; color: #d9e4f5; }");
            out.println("a { text-decoration: none; padding: 12px 35px; font-weight: bold; font-size: 1.3em; color: #fff; background: #3f64b7; border-radius: 8px; transition: background 0.25s ease; }");
            out.println("a:hover { background: #112d4e; }");
            out.println("</style></head><body>");
            out.println("<h2>Loan Application Result</h2>");

            if (requested <= eligible) {
                boolean credited = model.creditLoanToAccount(accno, requested);
                if (credited) {
                    out.println("<div class='success-msg'>Congratulations! Your loan is approved.</div>");
                    out.println("<div class='details'>Eligible loan: ₹" + eligible + "</div>");
                    out.println("<div class='details'>Loan credited: ₹" + requested + "</div>");
                } else {
                    out.println("<div class='details'>Account not found or error updating balance.</div>");
                }
            } else {
                out.println("<div class='details'>Requested loan exceeds eligibility.</div>");
                out.println("<div class='details'>Maximum eligible loan: ₹" + eligible + "</div>");
            }
 
            out.println("<br><a href='Home.html'>Back to Home</a>");
            out.println("</body></html>");

        } catch (NumberFormatException e) {
            out.println("<html><head><title>Error</title></head><body>");
            out.println("<p>Invalid input. Please enter valid numeric values.</p>");
            out.println("<a href='PersonalLoan.html'>Back to Loan Application</a>");
            out.println("</body></html>");
        }
    }
}


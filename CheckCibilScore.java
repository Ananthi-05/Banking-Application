package com.banking.controller;


import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import com.banking.model.Model;

@WebServlet("/CheckCibilScore")
public class CheckCibilScore extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int accno = Integer.parseInt(req.getParameter("accno"));
            Model model = new Model();
            int cibilScore = model.getRandomCibilScore();

            req.setAttribute("accno", accno);
            req.setAttribute("cibilScore", cibilScore);
            req.getRequestDispatcher("CheckCibilScoreResult.jsp").forward(req, resp);
        } catch (Exception e) {
            resp.setContentType("text/html");
            resp.getWriter().println("<h2>Error: Invalid account number.</h2>");
            resp.getWriter().println("<a href='CheckCibilScore.html'>Try Again</a>");
        }
    }
}


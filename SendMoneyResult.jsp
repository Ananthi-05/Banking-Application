<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Send Money Result</title>
<style>
  body {
    font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background: linear-gradient(120deg, #112D4E 70%, #3F72AF 100%);
    color: white; text-align:center; padding: 50px;
  }
  h2 {
    font-size: 2.6em; margin-bottom: 30px; color:#DFF6FF;
  }
  .info {
    font-size: 1.4em; margin: 14px 0;
  }
  a {
    display: inline-block; margin-top: 50px;
    padding: 14px 50px; background: #3F72AF; border-radius: 12px;
    text-decoration:none; color:#fff; font-weight: 700; font-size: 1.2em;
  }
  a:hover {
    background: #112D4E;
  }
</style>
</head>
<body>
  <h2>Transfer Successful</h2>
  <div class="info">₹<%= request.getAttribute("amount") %> sent to</div>
  <div class="info">Name: <strong><%= request.getAttribute("receiverName") %></strong></div>
  <div class="info">Account Number: <strong><%= request.getAttribute("receiverAccno") %></strong></div>
  <a href="Home.html">Back to Home</a>
  <a href="Logout.html">Logout</a>
</body>
</html>
    
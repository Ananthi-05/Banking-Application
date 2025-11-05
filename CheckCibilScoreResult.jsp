<%-- 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>CIBIL Score Result</title>
<style>
  body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background: linear-gradient(120deg, #112D4E 70%, #3F72AF 100%);
    color: white;
    padding: 50px;
    text-align: center;
  }
  h2 {
    font-size: 2.6em;
    margin-bottom: 30px;
    color: #DFF6FF;
  }
  .score {
    font-size: 1.8em;
    font-weight: bold;
    margin: 20px 0;
  }
  a {
    display: inline-block;
    margin-top: 50px;
    padding: 14px 50px;
    background: #3F72AF;
    border-radius: 12px;
    text-decoration: none;
    color: #fff;
    font-weight: 700;
    font-size: 1.2em;
  }
  a:hover {
    background: #112D4E;
  }
</style>
</head>
<body>
  <h2>Your CIBIL Score</h2>
  <p>Account Number: <strong><%= request.getAttribute("accno") %></strong></p>
  <p class="score"><%= request.getAttribute("cibilScore") %></p>
  <a href="Home.html">Back to Home</a>
   <a href="Logout.html">Logout</a>
  
</body>
</html>
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>CIBIL Score Result</title>
<style>
    body {
        background: linear-gradient(120deg, #18345c 0%, #1b2b42 80%);
        min-height: 100vh;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        font-family: "Segoe UI", Arial, sans-serif;
    }
    .score-box {
        background: #fff;
        color: #18345c;
        padding: 42px 34px 34px 34px;
        border-radius: 16px;
        box-shadow: 0 8px 32px rgba(0,0,0,0.13);
        min-width: 340px;
        text-align: center;
    }
    h2 {
        color: #295b8a;
        font-size: 1.8em;
        margin-bottom: 26px;
    }
    p {
        margin-bottom: 20px;
        font-size: 1.1em;
    }
    .score {
        color: #38b000;
        font-size: 2.3em;
        font-weight: bold;
        margin-bottom: 38px;
    }
    a {
        display: inline-block;
        text-decoration: none;
        color: #fff;
        background: #295b8a;
        padding: 12px 28px;
        border-radius: 8px;
        font-weight: bold;
        letter-spacing: 0.5px;
        box-shadow: 0 2px 6px rgba(41,91,138,0.09);
        transition: background 0.2s;
        margin-right: 12px;
        margin-bottom: 8px;
    }
    a:hover {
        background: #ffd60a;
        color: #295b8a;
    }
</style>
</head>
<body>
  <div class="score-box">
    <h2>Your CIBIL Score</h2>
    <p>Account Number: <strong><%= request.getAttribute("accno") %></strong></p>
    <p class="score"><%= request.getAttribute("cibilScore") %></p>
    <a href="Home.html">Back to Home</a>
    <a href="Logout.html">Logout</a>
  </div>
</body>
</html>





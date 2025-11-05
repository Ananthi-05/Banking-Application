<%-- 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Loan Application Result - GQT Bank</title>
<style>
  body {
    background: linear-gradient(120deg, #112D4E 70%, #3F72AF 100%);
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    margin: 0;
    color: #15395a;
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
  }
  .result-box {
    background: #fff;
    border-radius: 18px;
    padding: 42px 40px;
    max-width: 420px;
    box-shadow: 0 0 30px rgba(17,45,78,0.15);
    text-align: center;
  }
  .title {
    font-size: 2.6em;
    font-weight: bold;
    color: #3F72AF;
    margin-bottom: 30px;
  }
  .success-msg {
    font-size: 1.8em;
    font-weight: 700;
    color: #3F72AF;
    margin-bottom: 28px;
  }
  .info {
    font-size: 1.2em;
    color: #6389be;
    margin: 14px 0;
  }
  a.back-home {
    display: inline-block;
    margin-top: 34px;
    font-weight: 700;
    font-size: 1.15em;
    text-decoration: none;
    color: #ffffff;
    background-color: #3F72AF;
    padding: 14px 40px;
    border-radius: 12px;
    transition: background-color 0.3s ease;
  }
  a.back-home:hover {
    background-color: #112D4E;
    color: #ffffff;
  }
</style>
</head>
<body>
  <div class="result-box">
    <div class="title">Loan Application Result</div>
    <div class="success-msg">Congratulations! Your loan is approved.</div>
    <div class="info">Eligible loan: ₹<%= request.getAttribute("eligibleLoan") %></div>
    <div class="info">Loan credited: ₹<%= request.getAttribute("creditedLoan") %></div>
    <a href="Home.html" class="back-home">Back to Home</a>
    <a href="Logout.html" >Logout</a>
  </div>
</body>
</html>
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loan Application Result</title>
<style>
    body {
        background: linear-gradient(120deg, #18345c 0%, #1b2b42 80%);
        min-height: 100vh;
        margin: 0;
        padding: 0;
        display: flex;
        align-items: center;
        justify-content: center;
        font-family: "Segoe UI", Arial, sans-serif;
    }
    .result-box {
        background: #fff;
        color: #18345c;
        padding: 44px 36px 36px 36px;
        border-radius: 16px;
        box-shadow: 0 8px 32px rgba(0,0,0,0.15);
        min-width: 340px;
        text-align: center;
    }
    .title {
        font-size: 1.7em;
        color: #295b8a;
        margin-bottom: 22px;
        font-weight: bold;
    }
    .success-msg {
        font-size: 1.2em;
        color: #38b000;
        margin-bottom: 30px;
        font-weight: bold;
    }
    .info {
        font-size: 1.1em;
        margin-bottom: 14px;
        color: #18345c;
        background: #eaf7ee;
        border-radius: 6px;
        padding: 8px 0;
    }
    .back-home, .logout-btn {
        display: inline-block;
        text-decoration: none;
        color: #fff;
        background: #295b8a;
        padding: 12px 28px;
        border-radius: 8px;
        font-weight: bold;
        letter-spacing: 0.5px;
        box-shadow: 0 2px 6px rgba(41,91,138,0.10);
        transition: background 0.2s;
        margin-top: 22px;
        margin-right: 8px;
    }
    .back-home:hover, .logout-btn:hover {
        background: #ffd60a;
        color: #18345c;
    }
</style>
</head>
<body>
  <div class="result-box">
    <div class="title">Loan Application Result</div>
    <div class="success-msg">Congratulations! Your loan is approved.</div>
    <div class="info">Eligible loan: ₹<%= request.getAttribute("eligibleLoan") %></div>
    <div class="info">Loan credited: ₹<%= request.getAttribute("creditedLoan") %></div>
    <a href="Home.html" class="back-home">Back to Home</a>
    <a href="Logout.html" class="logout-btn">Logout</a>
  </div>
</body>
</html>


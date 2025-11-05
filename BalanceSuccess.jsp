<%--
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Balance Fetch</title>
</head>
<body>
<h3>Balance Amount</h3>
<h3><%
out.println(session.getAttribute("balance"));
%>
</h3>
</body>
</html>
--%>
 <%-- 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Balance Fetch - GQT Bank</title>
<style>
  body {
    background: linear-gradient(120deg, #112D4E 70%, #3F72AF 100%);
    font-family: 'Segoe UI', Arial, sans-serif;
    margin: 0;
    color: #112D4E;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
  }
  .balance-box {
    background: #fff;
    border-radius: 16px;
    padding: 42px 38px 36px 38px;
    box-shadow: 0 0 28px rgba(17,45,78,0.13);
    border: 2px solid #3F72AF;
    text-align: center;
    max-width: 380px;
    margin-bottom: 30px;
  }
  h3 {
    color: #3F72AF;
    margin-bottom: 26px;
    font-size: 1.5em;
    letter-spacing: 0.8px;
  }
  .balance-amount {
    font-size: 3em;
    font-weight: bold;
    color: #112D4E;
  }
  .logout-btn {
    display: inline-block;
    background: #3F72AF;
    color: #fff;
    padding: 10px 20px;
    font-weight: bold;
    font-size: 1em;
    border-radius: 7px;
    text-decoration: none;
    transition: background 0.3s ease;
  }
  .logout-btn:hover {
    background: #112D4E;
  }
</style>
</head>
<body>
  <div class="balance-box">
    <h3>Balance Amount</h3>
    <div class="balance-amount">
      <%
        Object balance = session.getAttribute("balance");
        if (balance != null) {
          out.print(balance);
        } else {
          out.print("Balance not available");
        }
      %>
    </div>
    <a href="Logout" class="logout-btn">Logout</a>
  </div>
  
</body>
</html>
--%>
<%-- 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Balance Fetch - GQT Bank</title>
<style>
  body {
    background: #15395a;
    font-family: 'Segoe UI', Arial, sans-serif;
    margin: 0;
    color: #375b8c;
    display: flex;
    flex-direction: column;
    align-items: center;
    min-height: 100vh;
    justify-content: center;
  }
  .balance-box {
    background: #fff;
    border-radius: 22px;
    box-shadow: 0 0 32px rgba(17,45,78,0.12);
    border: 2.5px solid #3f64b7;
    text-align: center;
    max-width: 430px;
    min-width: 340px;
    margin-bottom: 36px;
    padding: 44px 32px 36px 32px;
  }
  .balance-box h3 {
    color: #4672aa;
    font-size: 2em;
    letter-spacing: 1px;
    margin-bottom: 34px;
    font-weight: bold;
  }
  .balance-amount {
    font-size: 3.2em;
    font-weight: bold;
    color: #15395a;
    background: none;
    display: block;
    margin-bottom: 32px;
    letter-spacing: 2.5px;
  }
  .logout-btn,
  .logout-btn:visited,
  .logout-btn:focus,
  .logout-btn:active {
    background: #4672aa;
    color: #fff;
    padding: 14px 36px;
    font-weight: bold;
    font-size: 1.18em;
    border-radius: 9px;
    margin-top: 24px;
    text-decoration: none;
    display: block;
    width: 155px;
    text-align: center;
    outline: none;
    box-shadow: none;
    border: none;
    transition: background 0.2s;
  }
  .logout-btn:hover {
    background: #15395a;
    color: #fff;
  }
</style>
</head>
<body>
  <div class="balance-box">
    <h3>Balance Amount</h3>
    <div class="balance-amount">
      <%
        Object balance = session.getAttribute("balance");
        if (balance != null) {
          out.print(balance);
        } else {
          out.print("Balance not available");
        }
      %>
    </div>
    <a href="Logout" class="logout-btn">Logout</a>
  </div>
</body>
</html>
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Balance Amount</title>
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
    .balance-box {
        background: #fff;
        color: #18345c;
        padding: 40px 32px 32px 32px;
        border-radius: 16px;
        box-shadow: 0 8px 32px rgba(0,0,0,0.15);
        text-align: center;
        min-width: 340px;
    }
    h3 {
        margin-bottom: 24px;
        color: #295b8a;
        font-size: 1.6em;
    }
    .balance-amount {
        font-size: 2em;
        font-weight: bold;
        margin-bottom: 32px;
        color: #38b000;
    }
    .logout-btn {
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
    }
   .logout-btn:hover {
    background: #18345c;
    color: #fff;
}
.logout-btn:focus,
.logout-btn:active {
    background: #295b8a;
    color: #fff;
}
   
</style>
</head>
<body>
  <div class="balance-box">
    <h3>Balance Amount</h3>
    <div class="balance-amount">
      <%
        Object balance = session.getAttribute("balance");
        if (balance != null) {
          out.print(balance);
        } else {
          out.print("Balance not available");
        }
      %>
    </div>
        <a href="Home.html" class="logout-btn">Back to Home</a> <br><br>
        <a href="Logout" class="logout-btn">Logout</a><
    
  </div>
</body>
</html>







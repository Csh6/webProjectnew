<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/20 0020
  Time: 上午 8:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <link rel="stylesheet" href="css/login.css"/>
  <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
  <%--<script type="text/javascript" src="js/login.js"></script>--%>
</head>
<body>
<form action="Servlettry">
  <div class="form" style="background-color: white;">
    <div class="di">
      <h1>LOGIN</h1>
    </div>
    <div class="di" >
      <label for="name" class="sr-only"></label>
      <input type="text" value="${username}" name="username" id="name" class="input" placeholder="账号" required autofocus >
    </div>
    <div class="di" >
      <label for="inputPassword" class="sr-only"></label>
      <input type="password" value="${password}" name="password" id="inputPassword" class="input" placeholder="password" required style="margin-top: 20px;">
    </div>

    <div class="checkbox">
      <label>
        <input type="checkbox" value="remember-me"> 记住密码
      </label>
    </div>
    <div class="di">
      <input id="bt1" class="btn" type="submit" value="登录" />
    </div>

  </div>
</form>
</body>
</html>

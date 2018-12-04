<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/20 0020
  Time: 下午 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/setup.js"></script>
    <link rel="stylesheet" href="css/setup.css" />
</head>
<body>
<div id="container">
    <h1>注册</h1>

    <form action="register">
        <table border="0px" width="359px" height="500px" cellspacing="0" cellspacing="0">
            <tr>
                <td width="80px">用户名</td>
                <td width="170px"><input type="text" id="username" name="username" required autofocus /></td>
                <td width="107px" id="userinfo"></td>
            </tr>
            <tr>
                <td>密  码</td>
                <td><input type="password" id="password" placeholder="密码" name="psw" required style="margin-top: 20px;/></td>
                <td id="pswinfo"></td>
            </tr>
            <tr>
                <td>确认密码</td>
                <td><input type="password" id="checkpassword" placeholder="再次输入密码" name="cpsw" required style="margin-top: 20px;/></td>
                <td id="pinfo"></td>
            </tr>
            <tr>
            <tr>
                <td>手机号</td>
                <td><input type="text" id="telphone" name="telphone" required autofocus  /></td>
                <td id="telinfo"></td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><input type="email" id="email" name="email" required autofocus  /></td>
                <td id="einfo"></td>
            </tr>
            <tr>
                <td>邮编</td>
                <td><input type="text" id="postCard" name="postCard" required autofocus  /></td>
                <td id="poinfo"></td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" value="点击注册" id="btn1"/></td>
            </tr>
        </table>
        ${message}
    </form>
</div>

</body>
</html>


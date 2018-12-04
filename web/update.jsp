<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/26 0026
  Time: 下午 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="../css/second.css"/>
</head>
<body>
<div id="top" >
    <div id="up1">
        <%--<img src="../picture/logo.jpg" width="100%" height="100%" >--%>
    </div>
    <div id="up2">
        <h4>管理员的增删</h4>
    </div>
    <div id="up3">
        <select><option>用户</option></select>
    </div>
</div>
<div id="bottom" >
    <div id="left">
        <ul class="ul2">
            <li><h3>用户与商品信息</h3></li>
            <li ><a href="http://localhost:8088/ShopServlet" style="text-decoration: none">查看商品</a></li>
            <li><a href="http://localhost:8088/add.jsp"style="text-decoration: none">添加商品</a></li>
            <li><a href="http://localhost:8088/update.jsp"  style="text-decoration: none">修改商品</a></li>
            <li><a href="" style="text-decoration: none">类别管理</a></li>
            <li><a href="" style="text-decoration: none">首页类别管理</a></li>
            <li><a href="" style="text-decoration: none">订单信息</a></li>
            <li><a href="" style="text-decoration: none">关于</a></li>

        </ul>
    </div>
    <div id="right" >
        <form action="UpdateServlet" enctype="multipart/form-data">
        <table>
            <tr>
                <td>商品id</td>
                <td>商品名称</td>

            </tr>
            <tr>
                <td><input name="sid" type="text" value="${shop.shop_id}" placeholder="商品id"/></td>
                <td><input name="sName" type="text" value="${shop.shop_name}" placeholder="商品名称"/></td>

            </tr>
            <tr>
                <td>商品介绍</td>
                <td><input type="file"  style="height: 30px ;width: 60px" value="修改照片"/><span>${message}</span></td>
            </tr>
            <tr>
                <td><textarea name="sDes" style="height: 90px;width: 70px">${shop.shop_des}</textarea></td>
                <%--<td><input name="sDes" type="text" value="${shop.shop_des}" style="height: 100px ;width: 70px" /></td>--%>
                <%--<td><input name="sImg" type="text" value="${shop.shop_img}" style=" height: 100px;width: 80px"/>--%>
                <td><textarea name="sImg" style="height: 90px;width: 70px">${shop.shop_img}</textarea></td>
            <tr>

            <tr>
                <td>商品价格</td>
                <td>商品类别ID</td>
            </tr>
            <tr>
                <td><input name="sPrice" type="text" value="${shop.shop_price}" placeholder="商品价格" />
               <td><input type="text" name="scate" value="${shop.shop_Cate_id}"></td>
                <%--<td><select><option name="scate" value="${shop.shop_Cate_id}">商品类别</option></select></td>--%>
            </tr>
            <tr>
                <td>商品库存</td>
                <td>商品是否上架</td>
            </tr>
            <tr>
                <td><input name="sStock" type="text" value="${shop.shop_stock}"/>商品库存</td>
                <%--<td><input name="sIs" type="checkbox"value="${shop.shop_Isgc}"/>是</td>--%>
                <td><input type="text" name="sIs" value="${shop.shop_isgc}"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="确认提交" style="height: 50px ;width: 70px"/>

            </tr>
        </table>
        </form>
    </div>
</div>
<div></div>

</body>
</html>
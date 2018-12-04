<%@ page import="java.util.List" %>
<%@ page import="com.pojos.Shop" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/21 0021
  Time: 下午 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/frist.js"></script>
    <link rel="stylesheet" href="css/first.css"/>
</head>
<body>
<div id="all">
    <div id="top">
        <div id="to1">

        </div>
        <div id="to2">
            <h2>LOGIN系统欢迎${username}的光临</h2>
        </div>
        <div id="to3">

            <a href="index.jsp">重新登录</a>
            <br/>
            <a href="/LoginoutServlet">注销</a>

        </div>
    </div>
    <div id="down" >
        <div id="biaodan">
            <div class="biaodantop"> <h3>用户与商品信息</h3></div>
            <div class="b1">
                    <div class="title">
                        <span>商品列表</span>
                    </div>
                <%--<div class="s1">--%>
                    <ul class="menu">
                        <li id="li2"><a href="http://localhost:8088/add.jsp" style="text-decoration: none">添加商品</a></li>
                        <li id="li3"><a href="http://localhost:8088/update.jsp" style="text-decoration: none">修改商品</a></li>
                        <li><a href="http://localhost:8088/ShopServlet" style="text-decoration: none">删除商品</a></li>
                        <li><a href="" style="text-decoration: none">推荐商品</a></li>
                    </ul>
                <%--</div>--%>

                </div>
            <div class="b2">
                    <div class="title" style="color: black">
                        <span>类别管理</span>
                    </div>

                    <%--<div class="s2">--%>
                        <ul class="menu">
                            <li><a href="" style="text-decoration:none ">添加类别</a></li>
                            <li><a href="" style="text-decoration:none ">删除类别</a></li>
                            <li><a href="http://localhost:8088/CheckServlet" style="text-decoration:none ">修改类别</a></li>
                        </ul>
                    <%--</div>--%>

                </div>
            <div class="b3">
                    <div class="title">
                        <span>订单管理</span>
                    </div>

                   <%--<div class="s3">--%>
                       <ul class="menu">
                           <li><a href="" style="text-decoration:none ">查看订单</a></li>
                           <li><a href="" style="text-decoration:none ">修改订单</a></li>
                           <li><a href="" style="text-decoration:none ">删除订单</a></li>
                       </ul>
                   <%--</div>--%>
                </div>
        </div>
        <div id="div1" class="tableqwe">
            <form action="/ShopServlet">
                <table border="1px"cellpadding="0" cellspacing="0">
                    <tr>
                        <th>商品ID</th>
                        <th>商品名称</th>
                        <th>商品价格</th>
                        <th>商品介绍</th>
                        <th>商品图片</th>
                        <th>商品库存</th>
                        <th>操作选择</th>
                    </tr>
                    <c:forEach items="${pageBeam.shops}" var="allShop">
                        <tr>
                            <td>${allShop.shop_id}</td>
                            <td>${allShop.shop_name}</td>
                            <td>${allShop.shop_price}</td>
                            <td>${allShop.shop_des}</td>
                            <td><img width="100px" height="80px" src="http://localhost:8088/textphoto/${allShop.shop_img}"></td>
                            <td>${allShop.shop_stock}</td>
                            <td>
                                <a href="DeleteServlet?id=${allShop.shop_id}">删除</a>
                                <a href="/CheckServlet?sid=${allShop.shop_id}">修改</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <div style="text-align: center">
                    <nav aria-label="Page navigation">
                        <ul class="pagination" style="">
                            <li>
                                <c:if test="${pageBeam.pageNumber>1}">
                                    <a ref="${pageContext.request.contextPath}/PageServlet?pageNumber=${pageBeam.pageNumber-1}" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </c:if>
                            </li>

                            <c:forEach begin="${pageBeam.startPage}" end="${pageBeam.endpage}" step="1" var="i">
                                <li><a href="${pageContext.request.contextPath}/PageServlet?pageNumber=${i}">${i}</a></li>
                            </c:forEach>

                            <li>
                                <c:if test="${pageBeam.pageNumber<pageBeam.allPages}">
                                <a href="${pageContext.request.contextPath}/PageServlet?pageNumber=${pageBeam.pageNumber+1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                                </c:if>
                            </li>
                        </ul>
                    </nav>
                </div>

            </form>
        </div>
    </div>
</div>
</body>
</html>

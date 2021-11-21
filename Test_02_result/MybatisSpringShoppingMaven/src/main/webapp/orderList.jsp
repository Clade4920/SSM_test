<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>订单列表页面 </title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>
<a href="getAllGoods">继续购物</a>
${requestScope.orderOperationResult}
<c:if test="${!empty orderList}">


        <c:forEach items="${orderList}" var="order">
            <table border="1">
            <form action="deleteOrder" method="post">
            <input type="hidden" name="orderid" value="${order.id}">
            <tr>
                <td>订单编号</td>
                <td>${order.id}</td>
                <td>创建时间</td>
                <td>${order.createdTime}</td>
                <td><input type="submit" value="删除订单" /></td>
            </tr>
            </form>
            </table>

            <table border="1">
                <tr>
                    <td>物品编号</td>
                    <td>物品名称</td>
                    <td>物品价格</td>
                    <td>物品数量</td>
                </tr>
                <c:forEach items="${order.items}" var="item">
                <tr>
                    <td>${item.goods.goodsId}</td>
                    <td>${item.goods.goodsName}</td>
                    <td>${item.goods.price}</td>
                    <td><input type="text" name="quantity" value="${item.quantity}"/></td>
                </tr
                </c:forEach>
            </table>

        </c:forEach>


</c:if>

<c:if test="${empty orderList}">
    订单数据为空，请直接购物！
</c:if>

</body>
</html>

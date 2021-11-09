<%--
  Created by IntelliJ IDEA.
  User: liuliuliu
  Date: 2021/10/9
  Time: 10:48 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改货物</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/modifyGoodsServlet" method="post">
        要修改的货物ID:<input type="text" name="goodsId"><br>
        货物NAME:<input type="text" name="goodsName"><br>
        货物PRICE:<input type="text" name="price"><br>
        <input type="submit" name="action" value="修改">
        <input type="submit" name="action" value="取消">
    </form>
</body>
</html>

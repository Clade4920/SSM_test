<%--
  Created by IntelliJ IDEA.
  User: liuliuliu
  Date: 2021/10/9
  Time: 10:49 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查找货物</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/modifyGoodsServlet" method="post">
        要查找的货物ID:<input type="text" name="goodsId"><br>
        <input type="submit" name="action" value="查找">
        <input type="submit" name="action" value="取消"><br>

        货物NAME:${requestScope.goodsVo.goodsName}<br>
        货物PRICE:${requestScope.goodsVo.price}<br>

    </form>
</body>
</html>

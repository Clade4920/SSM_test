<%--
  Created by IntelliJ IDEA.
  User: liuliuliu
  Date: 2021/10/9
  Time: 10:47 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除货物</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/modifyGoodsServlet" method="post">
        要删除的货物ID:<input type="text" name="goodsId"><br>

        <input type="submit" name="action" value="删除">
        <input type="submit" name="action" value="取消">
    </form>
</body>
</html>

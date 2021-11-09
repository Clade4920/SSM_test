<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>登录页面</title>

</head>
<body>
<h1 align="center">用户购物登录</h1>
<form name="form" action="testLogin" method="post" >
    <table align="center">
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="userpassword"/></td>
        </tr>
        <tr>
            <td><button type="submit" >提交</button></td>
            <td><button type="reset">重置</button> </td>
        </tr>
    </table>
</form>
</body>
</html>

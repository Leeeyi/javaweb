<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/changepassword?id=${sessionScope.sale.id}" method="post">
    <table cellpadding="2" align="center">
        <tr>
            <td align="right">用户ID</td>
            <td>
                <!-- 1.文本输入框控件 -->
                <input type="text" name="name" value=${sessionScope.sale.name} />
            </td>
            <td align="right">&nbsp;&nbsp;&nbsp;用户密码</td>
            <td>
                <!-- 1.文本输入框控件 -->
                <input type="text" name="password" value=${sessionScope.sale.password} />
            </td>
        </tr>
        <tr>
            <td colspan="2"  align="center">
                <!-- 6.提交按钮控件 -->
                <input type="submit" value="提交" />
                <a href="AdminSalesMan.jsp"><input type="button" value="取消" /></a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

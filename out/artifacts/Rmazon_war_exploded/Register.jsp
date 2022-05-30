<%--
  Created by IntelliJ IDEA.
  User: 17567
  Date: 2021/10/30
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>新用户注册</title>
    </head>
    <body>
        <fieldset>
            <legend>注册新用户</legend>
            <!-- 表单数据的提交方式为POST -->
            <form action="${pageContext.request.contextPath}/register" method="post">
                <table cellpadding="2" align="center">
                    <tr>
                        <td align="right">用户:</td>
                        <td>
                            <!-- 1.文本输入框控件 -->
                            <input type="text" name="name" />
                        </td>
                    </tr>
                    <tr>
                        <td align="right">密码:</td>
                        <!-- 2.密码输入框控件 -->
                        <td><input type="password" name="password" /></td>
                    </tr>
                    <tr>
                        <td align="right">性别:</td>
                        <td>
                            <!-- 3.单选输入框控件，由于无法输入value, 所以预先定义好 -->
                            <input type="radio" name="gender" value="男" /> 男
                            <input type="radio" name="gender" value="女" /> 女
                        </td>
                    </tr>
                    <tr>
                        <td align="right">邮箱:</td>
                        <!-- 2.密码输入框控件 -->
                        <td><input type="text" name="email" /></td>
                    </tr>
                    <tr>
                    <tr>
                        <td align="right">电话:</td>
                        <!-- 2.密码输入框控件 -->
                        <td><input type="text" name="telephone" /></td>
                    </tr>
                    <tr>
                    <tr>
                        <td colspan="2"  align="center">
                            <!-- 6.提交按钮控件 -->
                            <input type="submit" value="注册" />
                        </td>
                    </tr>
                </table>
            </form>
        </fieldset>
    </body>

</html>

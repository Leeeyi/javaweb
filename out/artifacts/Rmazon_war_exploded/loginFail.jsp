<%--
  Created by IntelliJ IDEA.
  User: 17567
  Date: 2021/12/12
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>失败</title>
    <style>
        div{text-align: center}
    </style>
</head>
<body>
<div id="divcontent">
    <table width="850px" border="0" cellspacing="0">
        <tr>
            <td style="padding:30px; text-align:center">
                <table width="60%" border="0" cellspacing="0" style="margin-top:70px">
                    <tr>
                        <td style="padding-top:30px">
                            <font style="font-weight:bold; color:#FF0000">用户名或密码错误</font><br />
                            <br />
                            <a href="${pageContext.request.contextPath }/index.jsp">
                                转跳回首页
                            </a>
                        </td>
                    </tr>
                </table>
                <h1>&nbsp;</h1></td>
        </tr>
    </table>
</div>
</body>
</html>

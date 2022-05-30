<%--
  Created by IntelliJ IDEA.
  User: 17567
  Date: 2021/12/20
  Time: 1:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        div{text-align: center}
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/addgoods?salesmanid=${sessionScope.user.id}" method="post" enctype="multipart/form-data">
    <table cellpadding="2" align="center">
        <tr>
            <td align="right">商品名称</td>
            <td>
                <!-- 1.文本输入框控件 -->
                <input type="text" name="name" />
            </td>
            <td align="right">&nbsp;&nbsp;&nbsp;商品价格</td>
            <td>
                <!-- 1.文本输入框控件 -->
                <input type="text" name="price" />
            </td>
        </tr>
    </table>
    <table cellpadding="2" align="center">
        <tr>
            <td align="right">商品库存</td>
            <td>
                <input type="text" name="num" />
            </td>
            <td align="right">&nbsp;&nbsp;&nbsp;商品种类</td>
            <td>
                <input type="text" list="GoodsKind" name="kind"/>
                <datalist id="GoodsKind">
                    <option>电子产品</option>
                    <option>服装</option>
                    <option>食品/饮品</option>
                    <option>化妆品</option>
                    <option>文具</option>
                    <option>日用品</option>
                    <option>图书</option>
                    <option>办公</option>
                    <option>乐器</option>
                    <option>其他</option>
                </datalist>
            </td>
        </tr>
    </table>
    <table cellpadding="2" align="center">
        <tr>
            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;商品图片&nbsp;&nbsp;&nbsp;</td>
            <td>
                <input type="file" name="pic" />
            </td>
        </tr>
    </table>
    <table cellpadding="2" align="center">
            <td align="right">商品描述</td>
            <td>
                <!-- 1.文本输入框控件 -->
                <textarea name="description" cols="30" rows="3" style="WIDTH: 600px;height: 300px"></textarea>
            </td>
        <tr>
            <td colspan="2"  align="center">
                <!-- 6.提交按钮控件 -->
                <input type="submit" value="提交" />
                <a href="Admin_Goods.jsp"><input type="button" value="取消" /></a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    response.setContentType( "text/html;charset=utf-8 ");
    String dec = request.getParameter("dec");
    request.setAttribute("dec", dec);
%>
<form action="${pageContext.request.contextPath}/changegoods?id=${sessionScope.info.id}" method="post">
    <table cellpadding="2" align="center">
        <tr>
            <td align="right">商品名称</td>
            <td>
                <!-- 1.文本输入框控件 -->
                <input type="text" name="name" value=${sessionScope.info.name} />
            </td>
            <td align="right">&nbsp;&nbsp;&nbsp;商品价格</td>
            <td>
                <!-- 1.文本输入框控件 -->
                <input type="text" name="price" value=${sessionScope.info.price} />
            </td>

        </tr>
    </table>
    <table cellpadding="2" align="center">
        <tr>
            <td align="right">商品库存</td>
            <td>
                <!-- 1.文本输入框控件 -->
                <input type="text" name="num" value=${sessionScope.info.num} />
            </td>
            <td align="right">&nbsp;&nbsp;&nbsp;商品种类</td>
            <td>
                <input type="text" list="GoodsKind" name="kind" value=${sessionScope.info.kind} />
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
        <td align="right">商品描述</td>
        <td>
            <!-- 1.文本输入框控件 -->
            <textarea name="description" cols="30" rows="3" style="WIDTH: 600px;height: 300px ">${sessionScope.info.description}</textarea>
        </td>
        </tr>
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

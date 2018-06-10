<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
	<%@ include file="/pages/common/header.jsp" %>
</head>
<body>

	<%@ include file="/pages/common/manager_menu.jsp" %>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>		
			<tr>
				<td>时间简史</td>
				<td>20.00</td>
				<td>霍金</td>
				<td>200</td>
				<td>400</td>
				<td><a href="pages/manager/book_edit.jsp">修改</a></td>
				<td><a href="#">删除</a></td>
			</tr>	
			
			<tr>
				<td>时间简史</td>
				<td>20.00</td>
				<td>霍金</td>
				<td>200</td>
				<td>400</td>
				<td><a href="pages/manager/book_edit.jsp">修改</a></td>
				<td><a href="#">删除</a></td>
			</tr>	
			
			<tr>
				<td>时间简史</td>
				<td>20.00</td>
				<td>霍金</td>
				<td>200</td>
				<td>400</td>
				<td><a href="pages/manager/book_edit.jsp">修改</a></td>
				<td><a href="#">删除</a></td>
			</tr>	
			
			<tr>
				<td>时间简史</td>
				<td>20.00</td>
				<td>霍金</td>
				<td>200</td>
				<td>400</td>
				<td><a href="pages/manager/book_edit.jsp">修改</a></td>
				<td><a href="#">删除</a></td>
			</tr>	
			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
			</tr>	
		</table>
	</div>

	<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>
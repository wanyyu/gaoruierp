<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=utf-8" %>
<%
	String path = request.getContextPath();
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<script type='text/javascript' src=../../js/jquery-3.2.1.js></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-1.7.2.js"></script>
	<link type="text/css" href="<%=path %>/css/css.css" rel="stylesheet"/>
    <link rel="stylesheet" href="<%=path %>/css/pintuer.css">
	<link rel="stylesheet" href="<%=path %>/css/admin.css">
</head>
<body>
<a href="/user/getIndex.html">首页</a>
	<center>
		<form action="" method="post" name="form1">
			采购单编号：<input type="text" name="bid" id="bid" class="input" style="width:250px; line-height:17px;display:inline-block" placeholder="请输入搜索关键字">
			<input type="button" value="查询" onclick="query(1)" class="button border-main icon-search">
			<a class="button border-main icon-plus-square-o" onclick="edit(0)">新增</a>
		</form>
	
	<hr/>
	<span id="page_message"></span>

	</center>

</body>




		<table class='table table-hover text-center'>
			<tr>
				<th>采购单编号</th>
				<th>采购商品名</th>
				<th>供应商</th>
				<th>采购人</th>
				<th>商品数量</th>
				<th>商品价格</th>
				<th>商品总价</th>
				<th>进货日期</th>
				<th>是否到货</th>
				<th>备注</th>
				<th>操作</th>
			</tr>

			<tr>
				<td>${imp.importid}</td>
				<td>${imp.merch.name}</td>
				<td>${imp.proffer.name}</td>
				<td>${imp.user.loginid}</td>
				<td>${imp.num}</td>
				<td>${imp.price}</td>
				<td>${imp.totalmoney}</td>
				<td>${imp.importdate}</td>
				<td>
				<c:if test="${imp.about==0}">未到货</c:if>
				<c:if test="${imp.about==1}">已到货</c:if>
				</td>
				<td>${imp.other}</td>
				<td>
					<a class='button border-main' href='#' onclick='edit(${imp.importid})'>更新</a>
				</td>
			</tr>
		</table>


<script type="text/javascript">
/*
	新增
*/
function edit(importid){
    location.href="/import/toGet/"+importid;
}

</script>
</html>
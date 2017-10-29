<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=utf-8" %>
<%
	String path = request.getContextPath();
	Integer buyId = Integer.parseInt(request.getParameter("buyId"));
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<script type="text/javascript" src="<%=path %>/js/jquery-1.7.2.js"></script>
	<link type="text/css" href="<%=path %>/css/css.css" rel="stylesheet"/>
    <link rel="stylesheet" href="<%=path %>/css/pintuer.css">
	<link rel="stylesheet" href="<%=path %>/css/admin.css">
</head>
<body>
	<center>
		<form action="" method="post" name="form1">
		<input type="hidden" name="buyId" value='<%=buyId %>'>
			采购单编号：<input type="text" name="bid" id="bid" class="input" style="width:250px; line-height:17px;display:inline-block" placeholder="请输入搜索关键字">
			<input type="button" value="查询" onclick="query(1)" class="button border-main icon-search">
			<a class="button border-main icon-plus-square-o" onclick="goIns()">新增</a>
		</form>
	
	<hr/>
	<div id="showTable"></div>
	<hr/>
	<span id="page_message"></span>
	<input class='button border-main' type="button" value="首页" id="first" onclick="query(5)">
	<input class='button border-main' type="button" value="上一页" id="up"  onclick="query(2)">
	<input class='button border-main' type="button" value="下一页" id="end"  onclick="query(3)">
	<input class='button border-main' type="button" value="尾页" id="down"  onclick="query(4)">
	</center>

</body>



/*
	查询
*/

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
				<td>${import.importid}</td>
				<td>${import.merch.name}</td>
				<td>${import.proffer.name}</td>
				<td>${import.user.loginid}</td>
				<td>${import.num}</td>
				<td>${import.price}</td>
				<td>${import.totalmoney}</td>
				<td>${import.importdate}</td>
				<td>
					<c:if test="${import.about}==0">未到货</c:if>
					<c:if test="${import.about}==1">已到货</c:if>
				</td>
				<td>${import.other}</td>
				<td><a class='button border-main' href='#' onclick='goUpd(
	 					)'>更新</a><a class='button border-red' href='#' onclick='goDel(
					)'>删除</a></td>
			</tr>



			<script type="text/javascript">
/*
	新增
*/
function goIns(){
var width = window.screen.width ;
	var height = window.screen.height ;
	window.open("/SSHERP/jsp/buydetail/add.jsp","新增采购单明细",'height=400,width=600,top='+(height-450)/2+',left='+(width-300)/2+',toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
}
/*
	修改
*/
function goUpd(id_key){
var width = window.screen.width ;
	var height = window.screen.height ;
	window.open("<%=path%>/bd_findById?bdid="+id_key,"修改采购单明细",'height=400,width=600,top='+(height-450)/2+',left='+(width-300)/2+',toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
}
/*
	删除
*/
function goDel(id_key){
	if(confirm("确认删除？")){
		$(document).ready(function (){
		$.post("<%=path%>/bd_doDel",{bdid:id_key},function(data){
			if(data.indexOf("true")!=-1){
				alert("删除成功");
				query(0);
			}else{
				alert("删除失败");
			}
		});
		
	});
	}
	
}	
</script>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<span>销售管理</span>
<a href="/user/getIndex.html">首页</a>
	<center>
		<form action="/import/getAllImport.html" method="post" name="form1">
			销售单号：<input type="text" name="saleid" id="bid" class="input" style="width:250px; line-height:17px;display:inline-block" placeholder="请输入搜索关键字">
			<input type="submit" value="查询"  class="button border-main icon-search">
			<a class="button border-main icon-plus-square-o" onclick="edit(0)">新增</a>
		</form>

	<hr/>
	<div class="table_con"><div id="showTable"></div></div>
<%--	<span id="page_message"></span>
	<input class='button border-main' type="button" value="首页" id="first" onclick="query(5)">
	<input class='button border-main' type="button" value="上一页" id="up"  onclick="query(2)">
	<input class='button border-main' type="button" value="下一页" id="end"  onclick="query(3)">
	<input class='button border-main' type="button" value="尾页" id="down"  onclick="query(4)">--%>
	</center>

</body>

	 				<table class='table table-hover text-center'>
						<tr>
							<th width='15%'>销售单号</th>
							<th width='15%'>货品名</th>
							<th width='15%'>销售数量</th>
							<th width='15%'>销售日期</th>
							<th width='15%'>状态</th>
							<th width='25%'>操作</th>
						</tr>
						<c:forEach items="${saleList}" var="sale">
	 				<tr class='table table-hover text-center'>
						<td width='10%'>${sale.saleid}</td>
						<td width='10%'>${sale.merch.name}</td>
						<td width='10%'>${sale.num}</td>
						<td width='20%'><%--<fmt:formatDate value="&ndash;%&gt;--%>${sale.date}"
														<%--pattern="yyyy-MM-dd HH:mm:ss"/>--%></td>
						<td width='10%'>
							<c:if test="${sale.about==0}">未发货</c:if>
							<c:if test="${sale.about==1}">已发货</c:if>
						</td>
	 					<td width='50%'>
							<a class='button border-main' href='#' onclick='edit(${sale.saleid})'>更新</a>
							<input class='button border-red' type='button' value='删除' onclick='delsale(${sale.saleid })'>
						</td>
					</tr>
						</c:forEach>
					</table>
<script type="text/javascript">

    function edit(saleid){
        location.href="/sale/toGetSale/"+saleid;
    }

function delsale(saleid) {
    if (confirm('确认要删除吗？')) {
        $.ajax({
            type: 'POST',
            url: '/sale/delSale/' + saleid,
            dataType: 'json',
            success: function (result) {
                if (result.flag) {
                    alert("删除成功");
                    location.replace(location.href);
                } else alert("删除失败")
            },

            error: function () {
                alert('删除出错');
            },
        })
    }
}
</script>


</html>

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
<span>库存管理</span>
<a href="/user/getIndex.html">首页</a>
	<center>
		<form action="" method="post" name="form1">
			货名：<input type="text" name="bid" id="bid" class="input" style="width:250px; line-height:17px;display:inline-block" placeholder="请输入搜索关键字">
			<input type="button" value="查询"  class="button border-main icon-search">
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
							<th width='10%'>货物编号</th>
							<th width='10%'>货物名</th>
							<th width='20%'>单价</th>
							<th width='10%'>库存</th>
							<th width='20%'>备注</th>
							<th width='30%'>操作</th>
						</tr>
						<c:forEach items="${storeList}" var="store">
	 				<tr class='table table-hover text-center'>
						<td width='10%'>${store.storeid}</td>
						<td width='10%'>${store.merch.name}</td>
						<td width='10%'>${store.merch.cost}</td>
						<td width='10%'>${store.num}</td>
						<td width='10%'>${store.other}</td>
	 					<td width='50%'>
							<input class='button border-red' type='button' value='修改' onclick='edit(${store.storeid })'>
							<input class='button border-main' type='button' value='删除' onclick='delstore(${store.storeid })'>
						</td>
					</tr>
						</c:forEach>
					</table>
<script type="text/javascript">

	//修改页面
    function edit(storeid){
        location.href="/store/getStore/"+storeid;
    }

    //删除
function delstore(storeid) {
    if (confirm('确认要删除吗？')) {
        $.ajax({
            type: 'POST',
            url: '/store/delStore/' + storeid,
            dataType: 'json',
            success: function (result) {
                if (result.flag) {
                    alert("删除成功");
                    location.href="/store/getAllstore";
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

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
<span>采购管理</span>
<a href="/user/getIndex.html">首页</a>
	<center>
		<form action="/import/getAllImport.html" method="post" name="form1">
			编号：<input type="text" name="importid" id="bid" class="input" style="width:250px; line-height:17px;display:inline-block" placeholder="请输入搜索关键字">
			采购员：<input type="text" name="user.loginid" id="username" class="input" style="width:250px; line-height:17px;display:inline-block" placeholder="请输入搜索关键字">
			<input type="submit" value="查询"  class="button border-main icon-search">
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
							<th width='15%'>采购单编号</th>
							<th width='15%'>采购员</th>
							<th width='30%'>采购时间</th>
							<th width='40%'>操作</th>
						</tr>
						<c:forEach items="${importList}" var="imp">
	 				<tr class='table table-hover text-center'>
						<td width='10%'>${imp.importid}</td>
						<td width='10%'>${imp.user.loginid}</td>
						<td width='30%'><%--<fmt:formatDate value="&ndash;%&gt;--%>${imp.importdate}"
														<%--pattern="yyyy-MM-dd HH:mm:ss"/>--%></td>
	 					<td width='50%'>
							<input class='button border-red' type='button' value='删除' onclick='delimport(${imp.importid })'>
							<input class='button border-main' type='button' value='查看采购明细' onclick='showDetail(${imp.importid})'>
						</td>
					</tr>
						</c:forEach>
					</table>
<script type="text/javascript">

function showDetail(importid) {
    location.href="/import/getImport/"+importid;

}
function delimport(importid) {
    if (confirm('确认要删除吗？')) {
        $.ajax({
            type: 'POST',
            url: '/import/delImport/' + importid,
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
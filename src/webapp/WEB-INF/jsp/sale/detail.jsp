<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@page contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
%>
<html>
<head>
	<script type="text/javascript" src="<%=path %>/js/jquery-1.7.2.js"></script>
    <link rel="stylesheet" href="<%=path %>/css/pintuer.css">
	<link rel="stylesheet" href="<%=path %>/css/admin.css">
</head>
	<body>
		<form  method="post" id="formSale" >
			<input type="hidden" name="saleid" value="${sale.saleid}" />
			<input type="hidden" name="date" value="${sale.date}" />
			<br />
			商品名：
			<select class="input" size="1" id="merchid" name="merch.merchid" style="width:250px; line-height:17px;display:inline-block">
				<option value="0">请选择商品</option>
				<c:forEach items="${merch}" var="merch">
					<option value="${merch.merchid}"
							<c:if test="${sale.merch.merchid == merch.merchid}"
							>selected</c:if>
					>${merch.name}</option>
				</c:forEach>
			</select>
			<br />
			销售数量：
			<input type="number" id="num" name="num" class="input" value="${sale.num}" style="width:250px; line-height:17px;display:inline-block"/>
			<br/>
			<%--销售日期：

			<input type="text" id="date" name="date" class="input" value="<fmt:formatDate value="${sale.date}" pattern="yyyy-MM-dd HH:mm:ss"/>"  style="width:250px; line-height:17px;display:inline-block"/>
			<br/>--%>

			货品状态：
			<select class="input" size="1" id="about" name="about" style="width:250px; line-height:17px;display:inline-block">
				<option value="0" <c:if test="${sale.about==0}">selected</c:if>>未发货</option>
				<option value="1" <c:if test="${sale.about==1}">selected</c:if>>已发货</option>
			</select>

			<br/>
			备注：
			<input type="text" id="other" name="other" class="input" value="${imp.other}" style="width:250px; line-height:17px;display:inline-block"/>
			<br/>
			<input type="button" id="btnStu" value="确认"  class="button border-main icon-search">
			<input type="button" value="返回" onclick="back()" class="button border-main icon-search">

		</form>
	</body>
	<script type="text/javascript">
        //返回按钮
        function back(){
            opener.location.reload();
            window.close();//关闭当前页面
        }

            $(function () {


                $("#btnStu").click(function () {

                    if ($("#merchid").val()==0){
                        alert("请选择商品")
                        return false;
                    }

                    if ($("#num").val()==null||$("#num").val()==""){
                        alert("请输入销售数量")
                        return false;
                    }

                    if($("#num").val()<0){

                        alert("请输入正确的销售数量")
					}

                /*    if ($("#date").val()==null||$("#date").val()==""){
                        alert("请输入销售日期")
                        return false;
                    }*/

                    	$.ajax({
                        url:"/sale/edit.html",
                        data:$("#formSale").serialize(),
                        dataType:"json",
                        type:"post",
                        success:function (result) {
                            if (result.flag){
                                alert("操作成功");
                                location.href="/sale/getAllSale.html";
                              /*  var index = parent.layer.getFrameIndex(window.name); // 获取当前页面信息
                                parent.location.replace(parent.location.href); // 刷新父页面
                                parent.layer.close(index); // 关闭当前页面*/
                            }else alert(result.msg);
                        },error: function () {
                           alert('操作出错');
                        }
                    })
                });



            });
	</script>


	 				



</html>
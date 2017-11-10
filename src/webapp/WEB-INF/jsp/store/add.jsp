<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<form  method="post" id="formStore" >
			库存编号：
			<input type="text" id="id" name="storeid" class="input" style="width:250px; line-height:17px;display:inline-block"/>

			商品：
			<select class="input" size="1" id="merchid" name="merch.merchid" style="width:250px; line-height:17px;display:inline-block">
				<option value="0">请选择商品</option>
				<c:forEach items="${merch}" var="merch">
					<option value="${merch.merchid}"
							<c:if test="${imp.merch.merchid == merch.merchid}"
							>selected</c:if>
					>${merch.name}</option>
				</c:forEach>
			</select>
			<br />
			库存量：
			<input type="number" id="num" name="num" class="input"  style="width:250px; line-height:17px;display:inline-block"/>
			<br/>
			备注：
			<input type="text" id="other" name="other" class="input" style="width:250px; line-height:17px;display:inline-block"/>
			<br/>
			<input type="button" id="btnStu" value="确认"  class="button border-main icon-search">
			<input type="button" value="返回" onclick="history.back()" class="button border-main icon-search">

		</form>
	</body>
	<script type="text/javascript">
    /*    //返回按钮
        function back(){
            opener.location.reload();
            window.close();//关闭当前页面
        }*/


            $(function () {


                $("#btnStu").click(function () {

                    if ($("#merchid").val()==0){
                        alert("请选择商品")
                        return false;
                    }

                    if ($("#num").val()==null||$("#num").val()==""){
                        alert("请输入库存量")
                        return false;
                    }

                    if($("#num").val()<0){

                        alert("请输入正确的库存量")
					}



                    	$.ajax({
                        url:"/store/insertStore.html",
                        data:$("#formStore").serialize(),
                        dataType:"json",
                        type:"post",
                        success:function (result) {
                            if (result.flag){
                                alert("操作成功");
                                location.href="/import/getAllStore.html";
                              /*  var index = parent.layer.getFrameIndex(window.name); // 获取当前页面信息
                                parent.location.replace(parent.location.href); // 刷新父页面
                                parent.layer.close(index); // 关闭当前页面*/
                            }else alert("操作失败");
                        },error: function () {
                           alert('操作出错');
                        }
                    })
                });



            });
	</script>


	 				



</html>
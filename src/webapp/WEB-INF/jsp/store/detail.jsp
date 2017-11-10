<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
%>
<html>
<head>
	<%--<script type='text/javascript' src=../../js/jquery-3.2.1.js></script>--%>
	<script type="text/javascript" src="<%=path %>/js/jquery-1.7.2.js"></script>
    <link rel="stylesheet" href="<%=path %>/css/pintuer.css">
	<link rel="stylesheet" href="<%=path %>/css/admin.css">
</head>
	<body>
		<form  method="post" id="formStore" >
			<input type="hidden" name="storeid" value="${store.storeid}" />
			<br />
			货物名：
			<select class="input" size="1" id="merchid" name="merch.merchid" style="width:250px; line-height:17px;display:inline-block">
				<option value="0">请选择货物</option>
				<c:forEach items="${merch}" var="merch">
					<option value="${merch.merchid}"
							<c:if test="${store.merch.merchid == merch.merchid}"
							>selected</c:if>
					>${merch.name}</option>
				</c:forEach>
			</select>
			<br />
			库存：
			<input type="number" id="num" name="num" class="input" value="${store.num}" style="width:250px; line-height:17px;display:inline-block"/>
			<br />
			备注：
			<input type="text" id="other" name="other" class="input" value="${store.other}" style="width:250px; line-height:17px;display:inline-block"/>
			<br/>
			<input type="button" id="btnStu" value="确认"  class="button border-main icon-search">
			<input type="button" value="返回" onclick="back()" class="button border-main icon-search">

		</form>
	</body>
	<script type="text/javascript">

        function back(){
            opener.location.reload();
            window.close();//关闭当前页面
        }

            $(function () {

                $("#btnStu").click(function () {

                    if ($("#merchid").val()==0){
                        alert("请选择货物")
                        return false;
                    }


                    if ($("#num").val()<0){
                        alert("请输入正确的库存")
                        return false;
                    }


                    	$.ajax({
						type: 'POST',
                        url: '/store/updateStore.html',
                        data:$("#formStore").serialize(),
                        dataType:"json",
                        success:function (result) {
                            if (result.flag){
                                alert("编辑成功");
                                location.href="/store/getAllStore.html";
                              /*  var index = parent.layer.getFrameIndex(window.name); // 获取当前页面信息
                                parent.location.replace(parent.location.href); // 刷新父页面
                                parent.layer.close(index); // 关闭当前页面*/
                            }else alert("编辑失败");
                        },error: function () {
                           alert('编辑出错');
                        }
                    })
                });
                //返回按钮



            });
	</script>


	 				



</html>
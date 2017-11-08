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
		<form  method="post" id="formImport" >
			<input type="hidden" name="importid" value="${imp.importid}" />
			<input type="hidden" name="importdate" value="${imp.importdate}" />
			<input type="hidden" name="totalmoney" value="${imp.totalmoney}" />
			<br />
			商品名：
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
			供应商：
                    <select class="input" size="1" id="profferid" name="proffer.profferid" style="width:250px; line-height:17px;display:inline-block">
                        <option value="0">请选择供应商</option>
                        <c:forEach items="${proffer}" var="proffer">
                            <option value="${proffer.profferid}"
									<c:if test="${imp.proffer.profferid == proffer.profferid}"
									>selected</c:if>
							>${proffer.name}</option>
						</c:forEach>
                    </select>
			<br />
			采购人：
			<input type="text" id="loginid" name="loginid" class="input" value="${imp.user.loginid}" style="width:250px; line-height:17px;display:inline-block"/>
			<br />
			采购数量：
			<input type="number" id="num" name="num" class="input" value="${imp.num}" style="width:250px; line-height:17px;display:inline-block"/>
			<br/>
			商品价格：
			<input type="number" id="price" name="price" class="input" value="${imp.price}" style="width:250px; line-height:17px;display:inline-block"/>
			<br/>
			是否到货：
			<select class="input" size="1" id="about" name="about" style="width:250px; line-height:17px;display:inline-block">
				<option value="0" <c:if test="${imp.about==0}">selected</c:if>>未到货</option>
				<option value="1" <c:if test="${imp.about==1}">selected</c:if>>已到货</option>
			</select>

			<br/>
			备注：
			<input type="number" id="other" name="other" class="input" value="${imp.other}" style="width:250px; line-height:17px;display:inline-block"/>
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

                    if ($("#profferid").val()==0){
                        alert("请选择供应商")
                        return false;
                    }





                    if ($("#loginid").val()==null||$("#loginid").val()==""){
                        alert("请输入采购人")
                        return false;
                    }
                    if ($("#num").val()==null||$("#num").val()==""){
                        alert("请输入采购数量")
                        return false;
                    }

                    if($("#num").val()<0){

                        alert("请输入正确的采购数量")
					}

					 if($("#price").val()==null||$("#price").val()==""){
					     alert("请输入价格");
					     return false;
                   	}                                                        

                    	$.ajax({
                        url:"/import/upOrIn.html",
                        data:$("#formImport").serialize(),
                        dataType:"json",
                        type:"post",
                        success:function (result) {
                            if (result.flag){
                                alert("操作成功");
                                location.href="/import/getAllImport.html";
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
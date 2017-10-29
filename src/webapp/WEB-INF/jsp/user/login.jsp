<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>锆瑞进销存系统</title>
    <script type='text/javascript' src=../../js/jquery-3.2.1.js></script>
    <script>
        $(function () {
            $("#loginBtn").click(function () {
                $.ajax({
                    url: "/user/doLogin.html",
                    data: $("#loginForm").serialize(),
                    dataType: "json",
                    type: "post",
                    success: function (result) {
                        if (result.flag == true) {
                            alert('登录成功');
                            location.href = "/user/getIndex.html";
                        } else alert(result.resMsg);
                    }, error: function () {
                        alert("登录错误")
                    }
                });
            });
        });
    </script>
</head>
<body>
<div id="register" class="wrap">
    <div class="shadow">
        <em class="corner lb"></em>
        <em class="corner rt"></em>
        <div class="box">
            <h1>锆瑞进销存系统</h1>
            <form id="loginForm" method="post">
                <table>
                    <tr>
                        <td class="field">登录账号：</td>
                        <td>
                            <input class="text" type="text" id="loginid" name="loginid"/>
                            <span></span>
                        </td>
                    </tr>
                    <tr>
                        <td class="field">登录密码：</td>
                        <td>
                            <input class="text" type="password" id="password" name="password"/>
                            <span></span>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <label class="ui-green">
                                <input type="button" id="loginBtn" value="立即登录">
                                <input type="button" id="regBtn" value="立即注册">
                            </label>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div id="footer">
</div>
</body>
</html>

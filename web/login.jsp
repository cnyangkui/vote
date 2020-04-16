<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title>在线投票系统</title>
    <link type="image/x-icon" href="images/yc.png" rel="shortcut icon"/>
    <title></title>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
    <script type="text/javascript">
        window.onload = function () {
            var input = document.getElementById("loginBox").getElementsByTagName("input");
            for (i = 0; i < input.length; i++) {
                var type = input[i].getAttribute("type");
                if (type == "text" || type == "password") {
                    input[i].onfocus = function () {
                        this.className += " input-text-over";
                    }
                    input[i].onblur = function () {
                        this.className = this.className.replace(/input-text-over/, "");
                    }
                } else if (type == "submit") {
                    input[i].onmouseover = function () {
                        this.className += " input-submit-over";
                    }
                    input[i].onmouseout = function () {
                        this.className = this.className.replace(/input-button-over/, "");
                    }
                }
            }
        }
    </script>
</head>
<body>
<div id="header" class="wrap">
    <img src="images/logo.gif"/>
</div>
<div id="login" class="wrap">
    <div class="main">
        <div class="corner"></div>
        <div class="introduce">
            <h2>源辰信息</h2>
            <p>网上调查系统...</p>
        </div>
        <div class="login">
            <h2>用户登录</h2>
            <form method="post" action="/vote/userLogin">
                <dl id="loginBox">
                    <dt>用户名：</dt>
                    <dd><input type="text" class="input-text" id="userName" name="userName" value=""/></dd>
                    <dt>密　码：</dt>
                    <dd><input type="password" class="input-text" id="passowrd" name="password" value=""/></dd>
                    <dt></dt>
                    <dd><input type="submit" class="input-button" name="submit" value="登录"/> <a
                            href="register.jsp">新用户注册</a>
                    </dd>
                </dl>
            </form>
            <div class="error">
                <c:if test="${status == 'failed'}">
                    用户名或密码错误
                </c:if>
            </div>
        </div>
    </div>
</div>
<div class="wrap">
</div>
<div id="footer" class="wrap">
    源辰信息 &copy; 版权所有
</div>
</body>
</html>

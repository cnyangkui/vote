<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<title>在线投票系统</title>
<link type="image/x-icon" href="images/yc.png" rel="shortcut icon"/>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>


 
<div id="header" class="wrap">
	<img src="images/logo.gif" />
</div>
<div id="navbar" class="wrap">
	<div class="profile">
		您好，a
		<span class="return"><a href="/vote/queryAllVotes">投票列表</a></span>
		<span class="addnew"><a href="add.jsp">添加新投票</a></span>
		
	</div>
	<div class="search">
		<form method="post" action="#">
			<input type="text" name="keywords" class="input-text" value=""/><input type="submit" name="submit" class="input-button" value="" />
		</form>
	</div>
</div>

<div id="vote" class="wrap">
	<h2>参与投票</h2>
	<ul class="list">
		<li>
			<h4>${voteInfo.getVoteName()}</h4>
			<p class="info">共有 ${voteInfo.getOptionNumber()} 个选项，已有 ${voteInfo.getVotedUserNumber()} 个网友参与了投票。</p>
			<form id="form" method="post" action="/vote/voting">
			    <input type="hidden" name="vid" value="${voteInfo.vid}"/>
				<c:if test="${voteInfo.getType() == 1}">
					<ol>
						<c:forEach items="${voteInfo.getOptionList()}" var="item">
							<li><input type="radio" name="options"  value="${item.oid}"/>${item.getOptionName()}</li>
						</c:forEach>
					</ol>
				</c:if>
				<c:if test="${voteInfo.getType() == 2}">
					<ol>
						<c:forEach items="${voteInfo.getOptionList()}" var="item">
							<li><input type="checkbox" name="options"  value="${item.oid}"/>${item.getOptionName()}</li>
						</c:forEach>
					</ol>
				</c:if>
				<p class="voteView">
					<a onclick="submitForm();">
						<input type="image" src="images/button_vote.gif" />
					</a>
					<a href="/vote/queryVoteResult?vid=${voteInfo.getVid()}">
						<img src="images/button_view.gif" />
					</a>
				</p>
			</form>
		</li>
	</ul>
</div>
<div id="footer" class="wrap">
	源辰信息 &copy; 版权所有
</div>
<script>
	function submitForm() {
		document.getElementById("form").submit();
	}
</script>
</body>
</html>

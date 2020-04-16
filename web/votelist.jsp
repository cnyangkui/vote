<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
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
		您好，${sessionScope.currentUser.getUserName()}
		<span class="return"><a href="/vote/queryAllVotes">投票列表</a></span>
		<span class="addnew"><a href="add.jsp">添加新投票</a></span>
	</div>
	<div class="search">
		<form method="post" action="Subject!search.action">
			<input type="text" name="keywords" class="input-text" value=""/><input type="submit" name="submit" class="input-button" value="" />
		</form>
	</div>
</div>

<div id="vote" class="wrap">
	<h2>投票列表</h2>
	<ul class="list">
		<c:if test="${voteList != null}">
			<c:forEach items="${voteList}" var="item">
				<li  class="odd" >
					<h4>
						<a href="/vote/queryVoteResult?vid=${item.vid}">${item.getVoteName()}</a>
					</h4>
					<div class="join"><a href="/vote/queryVote?vid=${item.vid}">我要参与</a></div>
					<p class="info">共有 ${item.getOptionNumber()} 个选项，已有 ${item.getVotedUserNumber()} 个网友参与了投票。</p>
				</li>
			</c:forEach>
		</c:if>
	
	</ul>
</div>
<div id="footer" class="wrap">
	源辰信息 &copy; 版权所有
</div>
</body>
</html>

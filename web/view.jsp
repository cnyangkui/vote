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
		<%--<span class="modify"><a href="votelist.jsp">维护</a></span>--%>
		
	</div>
	<div class="search">
		<form method="post" action="">
			<input type="text" name="keywords" class="input-text" value=""/><input type="submit" name="submit" class="input-button" value="" />
		</form>
	</div>
</div>

<div id="vote" class="wrap">
	<h2>查看投票</h2>
	<ul class="list">
		<li>
			<h4>${voteInfo.getVoteName()}</h4>
			<p class="info">共有 ${voteInfo.getOptionNumber()} 个选项，已有 ${voteInfo.getVotedUserNumber()} 个网友参与了投票。</p>
				<ol>
					<c:forEach items="${voteInfo.getOptionList()}" var="item">
						<li>
							<div class="rate">
								<div class="label-name">
									${item.getOptionName()}
								</div>
								<div class="ratebg"><div class="percent" style="width:<c:if test="${voteInfo.getTotal()==0}">0</c:if>
									<c:if test="${voteInfo.getTotal()!=0}">${item.getCount()/voteInfo.getTotal()*100}</c:if>%"></div></div>
								<p>${item.getCount()}票<span>
									(<c:if test="${voteInfo.getTotal()==0}">0</c:if>
									<c:if test="${voteInfo.getTotal()!=0}">${item.getCount()/voteInfo.getTotal()*100}</c:if>% )</span></p>
							</div>
						</li>
					</c:forEach>
				</ol>
				<div>
					<div class="goback">
						<c:if test="${voted == 1}">
							<a href ="javascript:return false;" onclick="return false;" style="cursor: default;"><i class="edit" style="color: grey;">我要参与</i></a>
						</c:if>
						<c:if test="${voted == 0 || voted == null}">
							<a href="queryVote?vid=${voteInfo.getVid()}">我要参与</a>
						</c:if>
					</div>
				</div>
		</li>
	</ul>
</div>
<div id="footer" class="wrap">
	源辰信息 &copy; 版权所有
</div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script>
	$(function() {
		if ("${msg}") {
			alert("${msg}");
		}
	})
</script>
		<div class="brand">빠리모</div>
			<div class="address-bar" >
				<div class="subLnb"	style="text-align:center">
				<c:choose>
				<c:when test="${empty user}">
					<form action="${pageContext.request.contextPath}/login/login.do" method="post">
						<div class="loginDiv" >
							<table>
								<tr>
									<th>아이디</th>
									<td><input type="text" name="id" /></td>
									<th>패스워드</th>
									<td><input type="password" name="pass" /></td>
								</tr>

							</table>
						</div>
					<%-- <a href="${pageContext.request.contextPath}/login/login.do">로그인</a> --%>
						<input type="submit" value="로그인" />
					</form>
				</c:when>
				<c:otherwise>
					${user.name}님 접속중...
					<a href="${pageContext.request.contextPath}/login/logout.do">로그아웃</a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>

<!-- Navigation -->
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
                <a class="navbar-brand" href="index.html">Business Casual</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class = "themeList">
                        <a href="#">테마별 코디</a>
	                     <ul class="dropdown-menu" style="opacity:0.9;">
							<li><a href="${pageContext.request.contextPath}/board/themeList.do?genderNo=1">남자</a></li>
							<li><a href="${pageContext.request.contextPath}/board/themeList.do?genderNo=2">여자</a></li>
						</ul>
                    </li>
                    <li>
                        <a href="#">오늘의 코디</a>
                    </li>
                    <li>
                        <a href="#">사용자 코디</a>
                    </li>
                    <li>
                        <a href="#">코디 만들기</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

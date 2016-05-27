<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<div class="subLnb">
<c:choose>
	<c:when test="${empty user}">
		<a href="${pageContext.request.contextPath}/login/loginForm.do">로그인</a>
	</c:when>
	<c:otherwise>
		${user.id}님 접속중...
		<a href="${pageContext.request.contextPath}/login/logout.do">로그아웃</a>
	</c:otherwise>
</c:choose>
</div>
<div class="mainLnb">
<%-- 	<a href="${pageContext.request.contextPath}/board/list.do">테마별코디?????????</a> --%>
	<a href="${pageContext.request.contextPath}/board/detail.do?no=1">테마별코디</a>

</div>
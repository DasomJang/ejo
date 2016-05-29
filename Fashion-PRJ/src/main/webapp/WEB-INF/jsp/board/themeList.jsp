<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="header">
			<%@ include file="/WEB-INF/jsp/include/topMenu.jsp"%>
		</div>
		<div class="content">
			<div id="themeList">
				<ul>
					<c:forEach var="theme" items="${thList}">
						<li><a href = "${pageContext.request.contextPath}/board/list.do?themeNo=${theme.themeCode}"><img width="250" height="250" src = "${pageContext.request.contextPath}/file/down.do?filePath=${theme.filePath}&realFileName=${theme.realFileName}&draw=Y"><br />${theme.themeName}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="footer">
			<%@ include file="/WEB-INF/jsp/include/bottom.jsp"%>
		</div>
	</div>
</body>
</html>
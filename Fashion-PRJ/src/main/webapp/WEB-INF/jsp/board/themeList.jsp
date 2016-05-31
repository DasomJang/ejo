<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- ºÎÆ®½ºÆ®·¦ »ðÀÔ -->
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Àû¿ëÇÒ CSS »ðÀÔ -->
<link href="${pageContext.request.contextPath }/css/fashionEjo.css"
	rel="stylesheet">
	
<style>
	.themeImg{
		float : left;
		list-style-type: none;
		margin : 30px;
	}
	.themeImg : nth-child(3){
	
		clear : both;
	}
	.thName{
		margin: 10px;
		text-align: center;
	}
	
	.footer{
		clear : both;
	}
</style>	
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
						<div class = "themeImg">
							<li><a href = "${pageContext.request.contextPath}/board/list.do?themeNo=${theme.themeCode}"><img class ="img-circle" width="300" height="300" src = "${pageContext.request.contextPath}/file/down.do?filePath=${theme.filePath}&realFileName=${theme.realFileName}&draw=Y"><div class = "thName">${theme.themeName}</div></a></li>
						</div>
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
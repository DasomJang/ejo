<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src = "https://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- 부트스트랩 삽입 -->
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
<!-- 적용할 CSS 삽입 -->
<link href="${pageContext.request.contextPath }/css/fashionEjo.css" rel="stylesheet">
<!-- 폰트 적용 -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic"
	rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
	<div class="header">   
		<%@ include file="/WEB-INF/jsp/include/topMenu.jsp" %>
	</div>	
	<div class="content">
			<div id="themeListBoard">
				<ul>
					<c:if test="${!empty thListBoard }">
						<c:forEach begin="0" var = "i" end ="${fn:length(thListBoard)-1}" >
								<li>
									<a href = "${pageContext.request.contextPath}/board/detail.do?boardNo=${thListBoard[i].boardNo}">
										<img width="250" height="250" src = "${pageContext.request.contextPath}/file/down.do?filePath=${thListBoardFile[i].filePath}&realFileName=${thListBoardFile[i].realFileName}&draw=Y">
									</a>
											<form id="rcForm" name="rcForm">
												<input type="hidden" name="boardNo" value="${thListBoard[i].boardNo}" /> 
												<button type = "button" id = "recomBtn">좋아용</button>
											</form>
												(${thListBoard[i].recomCnt}) [${thListBoard[i].commentCnt }] 
								</li>
						</c:forEach>
					</c:if>
				</ul>
			</div>
						
	</div>
	<div class="footer">
		<%@ include file="/WEB-INF/jsp/include/bottom.jsp" %>
	</div>
</div>

<script>

/*
	$(function(){
		
		$("#recomBtn").on("click",function(){
			alert("좋아요 누를때용");

		});
		
		$("#rcForm").submit(function (event) {
			commentReg();
			event.preventDefault();
		});
		
	});
	
	*/
	
	
	function registRecom(){
		var f = document.rcForm;
		alert( f.boardNo.value);
		$.ajax({
			url: "${pageContext.request.contextPath}/board/registRecom.json",
			type: "POST",
			data: {
				boardNo: f.boardNo.value
			}
		})
		.done(function (data) {
			alert("등록되었당");
		});
		
	}
	

</script>
</body>
</html>
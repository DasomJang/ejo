<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 부트스트랩 삽입 -->
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css"
	rel="stylesheet">

<!-- 적용할 CSS 삽입 -->
<link href="${pageContext.request.contextPath }/css/fashionEjo.css"
	rel="stylesheet">


<script src = "https://code.jquery.com/jquery-2.2.4.min.js"></script>

<style>

	.boardImg{
		float : left;
		list-style-type: none;
		margin : 30px;
	}
	
	.boardImg : nth-child(3){
		clear : both;
	}
	
	.boardName{
		margin : 10px;
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
		<%@ include file="/WEB-INF/jsp/include/topMenu.jsp" %>
	</div>	
	<div class="content">
			<div id="themeListBoard">
				<ul>
					<c:if test="${!empty thListBoard }">
						<c:forEach begin="0" var = "i" end ="${fn:length(thListBoard)-1}" >
								<div class = "boardImg">
									<li>
										<a href = "${pageContext.request.contextPath}/board/detail.do?boardNo=${thListBoard[i].boardNo}">
											<img width="250" height="250" src = "${pageContext.request.contextPath}/file/down.do?filePath=${thListBoardFile[i].filePath}&realFileName=${thListBoardFile[i].realFileName}&draw=Y">
										</a>
										<div class = "boardName">
										<i id="recomBtn${thListBoard[i].boardNo}" name="recomBtn" data-boardno="${thListBoard[i].boardNo}" recomcheck = "${thListBoard[i].idRecomCheck}" 
												class = "glyphicon glyphicon-heart-empty"></i>
										Like(<span id="recomCnt${thListBoard[i].boardNo}">${thListBoard[i].recomCnt}</span>) [${thListBoard[i].commentCnt }]
										</div>
									</li>
								</div>
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

	$(function(){
	 	$("[name=recomBtn]").on("click",function(){
			if($(this).attr("recomcheck") == "1"){
				deleteRecom($(this).data("boardno"),$(this));
			}else{
	 			registRecom($(this).data("boardno"),$(this));
			}
			event.preventDefault(); 
	 	});
	 	
	 	if($("[name=recomBtn]").attr("recomcheck") == "1"){
			$("[name=recomBtn]").attr("class", "glyphicon glyphicon-heart");
	 	}
	});
	
 	function registRecom(no,f){
		$.ajax({
			url: "${pageContext.request.contextPath}/board/registRecom.json",
			type: "POST",
			data: {
				boardNo: no
			}
		})
		.done(function (data) {
			$("#recomBtn" + no).attr("recomcheck", data);
			$("#recomBtn" + no).attr("class", "glyphicon glyphicon-heart");
			$("#recomCnt" + no).html(parseInt($("#recomCnt" + no).html()) + 1);
		});
	} 
 	
 	
 	function deleteRecom(no,f){
		$.ajax({
			url: "${pageContext.request.contextPath}/board/deleteRecom.json",
			type: "POST",
			data: {
				boardNo: no
			}
		})
		.done(function (data) {
			$("#recomBtn" + no).attr("recomcheck", data);
			$("#recomBtn" + no).attr("class", "glyphicon glyphicon-heart-empty");
			$("#recomCnt" + no).html(parseInt($("#recomCnt" + no).html()) - 1);
		});
	} 
	
</script>
</body>
</html>
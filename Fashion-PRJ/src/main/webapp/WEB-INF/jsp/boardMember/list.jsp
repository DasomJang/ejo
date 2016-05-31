<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%-- 페이지 관련 부분 추가 --%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src = "https://code.jquery.com/jquery-2.2.4.min.js"></script>

</head>



</head>
<body>
	<div class="container">
		<div class="header">
			<%@ include file="/WEB-INF/jsp/include/topMenu.jsp"%>
		</div>1
		<div class="content">
			<h2>갤러리</h2>
			<hr />
			<c:if test="${!empty list}">
				<c:forEach var="vo" items="${list}">
					<table>
						<tr>
							<td><img width="300" height="400"
								src="${pageContext.request.contextPath}/file/down.do?filePath=${vo.boardMemberFileVO.filePath}&realFileName=${vo.boardMemberFileVO.realFileName}&draw=Y" />
							</td>
						</tr>

						<tr>
							<td>${vo.memberBoardNo}</td>
							<td>
							<button id="recomBtn${vo.memberBoardNo}" name="recomBtn" data-memberBoardNo="${vo.memberBoardNo}" recomcheck="${vo.idRecomCheck}">좋아용</button>
									(<span id="recomCnt${vo.memberBoardNo}">${vo.recomCnt}</span>)  ${vo.idRecomCheck} 
							</td>
							<td>${vo.title}</td>
						</tr>

						<tr>
							<td>${vo.id}</td>
							<td>${vo.regDate}</td>
							<td><a
								href="delete.do?memberBoardNo=${vo.memberBoardNo}">삭제</a></td>
						</tr>

					</table>
				</c:forEach>
			</c:if>


			<a href="registForm.do">사진등록</a>
			
		</div>
	</div>

	<div class="footer">
		<%@ include file="/WEB-INF/jsp/include/bottom.jsp"%>
	</div>


<script>
$(function(){
 	$("[name=recomBtn]").on("click",function(){
		if($(this).attr("recomcheck") == "1"){
			deleteRecom($(this).data("memberboardno"),$(this));
		}else{
 			registRecom($(this).data("memberboardno"),$(this));
		}
		event.preventDefault(); 
 	});
 	
 	if($("[name=recomBtn]").attr("recomcheck") == "1"){
 		$("[name=recomBtn]").css("background", "tomato");
 	}
 	
});

	function registRecom(no,f){
		alert(no);
	$.ajax({
		url: "${pageContext.request.contextPath}/boardMember/registRecom.json",
		type: "POST",
		data: {
			memberBoardNo: no
		}
	})
	.done(function (data) {
		$("#recomBtn" + no).attr("recomcheck", data).css("background", "tomato");
		$("#recomCnt" + no).html(parseInt($("#recomCnt" + no).html()) + 1);
	});
} 
	function deleteRecom(no,f){
	$.ajax({
		url: "${pageContext.request.contextPath}/boardMember/deleteRecom.json",
		type: "POST",
		data: {
			memberBoardNo: no
		}
	})
	.done(function (data) {
		$("#recomBtn" + no).attr("recomcheck", data).css("background", "");
		$("#recomCnt" + no).html(parseInt($("#recomCnt" + no).html()) - 1);
	});
} 
</script>
</body>
</html>



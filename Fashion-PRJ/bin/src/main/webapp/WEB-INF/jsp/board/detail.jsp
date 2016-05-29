<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src=https://code.jquery.com/jquery-2.2.4.min.js></script>
</head>
<body>
<div class="container">
	<div class="header">
		<%@ include file="/WEB-INF/jsp/include/topMenu.jsp" %>
	</div>	
	<div class="content">
		<!-- 메인 이미지 -->
		<div>
			<img width="400" height="500"
			src="${pageContext.request.contextPath}/file/down.do?filePath=${file.filePath}&realFileName=${file.realFileName}&draw=Y" />
		</div>
		<!-- 상세 설명 -->
		<div>
			<h2>Theme</h2>
			<h4>${board.contentTheme}</h4>			
			<h2>Note</h2>
			<h4>${board.contentNote}</h4>
			<h2>Tip</h2>
			<h4>${board.contentTip}</h4>			
		</div>		
		<!-- 평점 -->
		<div>
			<form action="">
				<input type="radio" name="score" value="good" checked="checked" /> GOOD
				<input type="radio" name="score" value="soso" /> SOSO
				<input type="radio" name="score" value="bad" /> BAD
				<button>확인</button>
			</form>
		</div>		
		<br />	
		<br />	
		<!-- 댓글 -->
		<!-- 댓글 등록 폼 -->
		<h3>후기</h3>
		<form id="crForm" name="crForm" action="registComment.json">
			<input type="hidden" name="boardNo" value="${board.boardNo}">
			<table>
				<tr>
					<th>${user.id}</th>
					<td><textarea name="content" rows="2" cols="60"></textarea></td>
					<td><button>등록</button></td>
				</tr>
			</table>	
		</form>		
		<!-- 댓글 삭제 폼 -->
		<form id="cmForm" name="cmForm" action="modifyComment.json">
			<input type="hidden" name="commentNo">
			<table>
				<tr>
					<th>${user.id}</th>
					<td><textarea name="content" rows="2" cols="60"></textarea></td>
					<td><button>등록</button></td>
				</tr>
			</table>	
		</form>
		
		
 		<!-- 댓글 목록 -->
 		<div id="commentList"></div>
		
		
	</div>
	<div class="footer">
		<%@ include file="/WEB-INF/jsp/include/bottom.jsp" %>
	</div>
</div>
<script>
	$(function() {
		$("#cmForm").hide();
		getCommentList();
		$("#crForm").submit(function (e) {
			commentReg();
			e.preventDefault();
		});
		$("#cmForm").submit(function (e) {
			commentMod();
			e.preventDefault();
		});
	});
	
	function getCommentList() {
		$.ajax({
			url: "listComment.json",
			data: {boardNo: "${board.boardNo}"}		
		})
		.done(commentList);
	}
	
	function commentList(list) {
		var table = $("<table>").append("<tr><th>작성자</th><th>내용</th><th>등록일</th><th></th></tr>");
		for (var i in list) {
			table.append(makeTr(list[i]));
		}
		if(list.length == 0) {
			table.append($("<tr>").append($("<td colspan='4'>").html("작성된 댓글이 없습니다.")));
		}
		$("#commentList").empty();
		$("#commentList").append(table);	
	}
	
	function makeTr(data) {
		var tr = $("<tr>").append($("<td>").html(data.id))
						  .append($("<td id='" + data.commentNo + "'>").html(data.content))
						  .append($("<td>").html(data.regDate));
		
		var html = "";
		if ("${user.id}" == data.id) {
			html = '<a href="#1" onclick="setModCommentForm(' + data.commentNo + ', \'' + data.content + '\')">수정</a>'
				 + '<a href="#1" onclick="commentDel(' + data.boardNo + ', ' + data.commentNo + ')">삭제</a>';
		}
		tr.append($("<td>").html(html));
		return tr;
	}
	
	function commentReg() {
		var f = document.crForm;
		$.ajax({
			url: f.action,
			type: "POST",
			data: {
				boardNo: f.boardNo.value,
				content: f.content.value
			}
		})
		.done(function (data) {
			f.content.value = "";
			$("#commentList > table > tbody > tr:eq(0)").after(makeTr(data));
		});		
	}	

	function setModCommentForm(commentNo, content) {
		var f = document.cmForm;
		f.commentNo.value = commentNo;
		f.content.value = content;
		
		$("#crForm").hide();
		$("#cmForm").show();
		
	}
	
	function commentMod() {
		var f = document.cmForm;
		$.ajax({
			url: f.action,
			type: "POST",
			data: {
				commentNo: f.commentNo.value,
				content: f.content.value
			}
		})
		.done(function (data) {
			$("#crForm").show();
			$("#cmForm").hide();
			
			$("#" + f.commentNo.value).html(f.content.value);
			
			f.commentNo.value = "";
			f.content.value = "";
		});
	}
	
	function commentDel(boardNo, commentNo) {
		$.ajax({
			url: "deleteComment.json",
			data: {
				boardNo: boardNo,
				commentNo: commentNo
			}
		})
		.done(commentList);
	}
	
	
</script>
</body>
</html>
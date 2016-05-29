<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 적용할 CSS 삽입 -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link href="${pageContext.request.contextPath }/css/makeCoordi.css" rel="stylesheet">
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
<title>Insert title here</title>
<script>
	$(function() {
		$(".tab_content").hide();
		$(".tab_content:first").show();
		$("ul.tabs li").click(function() {
			$("ul.tabs li").removeClass("active").css("color", "#333");
			$(this).addClass("active").css("color", "darkred");
			$(".tab_content").hide();
			var activeTab = $(this).attr("rel");
			$("." + activeTab).fadeIn();
		});

		$(".draggable").draggable({
			revert : "invalid",
			helper : "clone"
		});
		$("button").on("click", function() {
			$("#droppable img").css({
				"display" : "none"
			});
		});
		$("#droppable").droppable({
			drop : function(event, ui) {
				$(this).addClass("ui-state-highlight").find("p");
				$(ui.helper[0].innerHTML).css({
					"position" : "absolute",
					"left" : ui.offset.left - this.offsetLeft,
					"top" : ui.offset.top - this.offsetTop
				}).appendTo(this).draggable({
					revert : "invalid"
				});
			}
		});
	});
</script>
</head>
<body>
	<div class="header">
		<%@ include file="/WEB-INF/jsp/include/topMenu.jsp"%>
	</div>
	<div class="container" style="margin: auto;">
		<div id="droppable" class="ui-widget-header span2">
			<button>아이템 비우기</button>
		</div>

		<div id="coordi_content" class="span10">
			<ul class="tabs">
				<li class="active" rel="tab1">TOP</li>
				<li rel="tab2">BOTTOM</li>
				<li rel="tab3">OUTER</li>
				<li rel="tab4">ACC</li>
				<li rel="tab5">SHOES</li>
			</ul>
			<div class="tab_container">
				<div class="tab_content tab1">
					<c:forEach var="item" items="${item}">
						<c:if test="${item.codeValue == '01'}">
							<div class="draggable">
								<img width="100" height="100"
									src="${pageContext.request.contextPath}/file/down.do?filePath=${item.filePath}&realFileName=${item.realFileName}&draw=Y" />
							</div>
						</c:if>
					</c:forEach>
				</div>
				<div class="tab_content tab2">
					<c:forEach var="item" items="${item}">
						<c:if test="${item.codeValue == '02'}">
							<div class="draggable">
								<img width="100" height="100"
									src="${pageContext.request.contextPath}/file/down.do?filePath=${item.filePath}&realFileName=${item.realFileName}&draw=Y" />
							</div>
						</c:if>
					</c:forEach>
				</div>
				<div class="tab_content tab3">
					<c:forEach var="item" items="${item}">
						<c:if test="${item.codeValue == '03'}">
							<div class="draggable">
								<img width="100" height="100"
									src="${pageContext.request.contextPath}/file/down.do?filePath=${item.filePath}&realFileName=${item.realFileName}&draw=Y" />
							</div>
						</c:if>
					</c:forEach>
				</div>
				<div class="tab_content tab4">
					<c:forEach var="item" items="${item}">
						<c:if test="${item.codeValue == '04'}">
							<div class="draggable">
								<img width="100" height="100"
									src="${pageContext.request.contextPath}/file/down.do?filePath=${item.filePath}&realFileName=${item.realFileName}&draw=Y" />
							</div>
						</c:if>
					</c:forEach>
				</div>
				<div class="tab_content tab5">
					<c:forEach var="item" items="${item}">
						<c:if test="${item.codeValue == '05'}">
							<div class="draggable">
								<img width="100" height="100"
									src="${pageContext.request.contextPath}/file/down.do?filePath=${item.filePath}&realFileName=${item.realFileName}&draw=Y" />
							</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<div class="footer">
		<%@ include file="/WEB-INF/jsp/include/bottom.jsp"%>
	</div>
</body>
</html>
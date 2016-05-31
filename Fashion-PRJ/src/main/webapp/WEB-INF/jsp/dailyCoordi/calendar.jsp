<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>오늘의 코디</title>
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</head>
<body bgcolor='white'>
<table border='1' width='700' celpadding='0' cellspacing='0'>
	<tr>
		<td width='200' align="center" valign='middle'>
			<a href="calendar.do?month=${currMonth}&year=${currYear}&action=0" style="text-decoration: none;">
				<font size="1">Previous Month</font>
			</a>
		</td>
		<td width='300' align='center' valign='middle'>
			<b>${cCalDate}</b>
		</td>
		<td width='200' align="center" valign="middle">
			<a href="calendar.do?month=${currMonth}&year=${currYear}&action=1" style="text-decoration: none;">
				<font size="1">Next Month</font>
			</a>
		</td>
	</tr>
</table>
<table border="0" width="520" bordercolorlight="#C0C0C0" bordercolordark="#808080" 
	   style="border-collapse: collapse"
	   bordercolor="#111111" cellpadding="0" cellspacing="0">
	<td width="100%">
		<table border="2" width="519" bordercolorlight="#C0C0C0" bordercolordark="#000000" 
			   style="border-collapse: collapse" 
			   bordercolor="#000000" cellpadding="0" cellspacing="0" bgcolor="#DFDCD8">
			<tr>
				<td width="${boxSize}" align="center" nowrap bordercolor="#666666" bgcolor="#666666">
					<font color="#FFFFFF"><b>Sun</b></font>
				</td>
				<td width="${boxSize}" align="center" nowrap bordercolor="#666666" bgcolor="#666666">
					<font color="#FFFFFF"><b>Mon</b></font>
				</td>
				<td width="${boxSize}" align="center" nowrap bordercolor="#666666" bgcolor="#666666">
					<font color="#FFFFFF"><b>Tues</b></font>
				</td>
				<td width="${boxSize}" align="center" nowrap bordercolor="#666666" bgcolor="#666666">
					<font color="#FFFFFF"><b>Wed</b></font>
				</td>
				<td width="${boxSize}" align="center" nowrap bordercolor="#666666" bgcolor="#666666">
					<font color="#FFFFFF"><b>Thurs</b></font>
				</td>
				<td width="${boxSize}" align="center" nowrap bordercolor="#666666" bgcolor="#666666">
					<font color="#FFFFFF"><b>Fri</b></font>
				</td>
				<td width="${boxSize}" align="center" nowrap bordercolor="#666666" bgcolor="#666666">
					<font color="#FFFFFF"><b>Sat</b></font>
				</td>
			</tr>
			<c:set var="dispDay" value="1" />
			<c:set var="count" value="1" />
			<c:forEach var="w" begin="1" end="6">
			<tr>
				<c:forEach var="d" begin="1" end="7" varStatus="loop">
					<c:choose>
					<c:when test="${count lt week}">
						<td width="${boxSize}" height="${boxSize}" valign="top" align="left">&nbsp;</td>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${lastDate < dispDay}">
								<td width="${boxSize}" height="${boxSize}" valign="top" align="left">&nbsp;</td>
							</c:when>
							<c:otherwise>
								<td width="${boxSize}" align="left" height="${boxSize}" valign="top">${dispDay}<br></td>
								<c:set var="dispDay" value="${dispDay + 1}" />
							</c:otherwise>
						</c:choose>
					</c:otherwise>
					</c:choose>
					<c:set var="count" value="${count + 1}" />
				</c:forEach>
			</tr>
			</c:forEach>
		</table>
	</td>
</table>
</body>
</html>

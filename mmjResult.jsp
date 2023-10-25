<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="resultAndMapTable" width="100%" border="1" cellpadding="0" cellspacing="0">
		<tr><td colspan="2">
			<jsp:include page="Serch.jsp" flush="false"/>
			</td>
		</tr>
		<tr><td width="30%" valign="top">
			<jsp:include page="Result.jsp" flush="false"/>
			</td>
			<td width="70%" valign="top">
			<jsp:include page="map.jsp" flush="false"/>
			</td>
		</tr>
	</table>
	
</body>
</html>
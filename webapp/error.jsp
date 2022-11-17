<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String message = ( String )request.getAttribute( "message" );
	String location = ( String )request.getAttribute( "location" );
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link type="text/css"  rel="stylesheet" href="<%=request.getContextPath() %>/css/error.css"/>
	</head>
	<body>
		<div id='error-message-div' class="" >
			<h2>错误信息</h2>
			<div class="message-div">
				<%=message %>
				<a href="<%=location %>">返回</a>
			</div>
		</div>
	</body>
</html>
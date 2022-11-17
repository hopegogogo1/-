<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String userName = "";
	String password = "";
	String rememberMe = "";
	Cookie [] cookies = request.getCookies(); 
	if ( cookies != null ){
		for( int i=0; i<cookies.length; i++ ){
			if( "userName".equals( cookies[i].getName() ) ){
				userName = cookies[i].getValue();
				continue;
			} 
			if( "password".equals( cookies[i].getName() ) ){
				password = cookies[i].getValue();
				rememberMe = "checked";
			}
		}
	}
	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link type="text/css"  rel="stylesheet" href="css/login.css"/>
	</head>
	<body>
		<div id='form-div' class="" >
			<form action="servlet/login.do"  name="msgForm" method="post">
				<h2 class="form-title">用户登录</h2>
				<input type="text" name="userName" placeholder="用户名"
					value="<%=userName%>"/>
				<input type="password" name="password" placeholder="密码" 
					value="<%=password%>"/>
				<label class="lbl">
					<input type="checkbox" name="rememberMe" 
						value="rememberMe" <%=rememberMe %> /> 
					下次自动登录
				</label>
				<input type="submit" id="submit-button" value="登  录" />
			</form>
		</div>
	
	</body>
</html>
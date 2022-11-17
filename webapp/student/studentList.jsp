<%@page import="com.dao.StudentDao"%>
<%@page import="com.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>学生信息列表</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/studentList.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/studentForm.css" />
	</head>
	<body>
		<div class="main-div">
			<div class="head-div light-blue">
				<div id="search-div" <%--style="border: solid 1px red"--%>>
					<%--<form id="form" style="border: solid 1px green">--%>
						<input id="search-input" name="search" />
						<button type="submit" class="success" id="search-btn">搜索</button>
						<select name="search-select" id="search-select">
							<option>学号</option>
							<option>姓名</option>
							<option>性别</option>
							<option>院系</option>
							<option>专业</option>
						</select>
					<%--</form>--%>
				</div>
				<div id="action-div">
					<button type="button" class="success" id="add-btn">新增</button>
					<button type="button" class="danger" id="del-btn">删除</button>
					<button type="button" class="warning" id="modify-btn">修改</button>
				</div>
			</div>
			<div class="body-div">
				<ul id="msgList-ul">
				<%
					List<Object> stdList = ( List<Object> ) request.getAttribute( "stdList" );
					if( stdList != null ){
						for( Object obj : stdList ){
							Student std = ( Student ) obj;
				%>
						<li class="<%="男".equals( std.getSex() ) ? "male" : "female"%>">
							<input type="hidden" name="id" class="id-input" value="<%=std.getId()%>">
							<div class="img-div">
								<img class="img" src="<%=request.getContextPath() + std.getImageStr()%>">
							</div>
							<div class="msg-span-div">
								<span class="num-span"><%=std.getNumber()%></span>
								<span>
									<span class="name-span"><%=std.getName()%></span>
									<span class="sex-span"><%=std.getSex()%></span>
								</span>
								<span>
									<span class="depart-span" <%--style="flex: 2;"--%>><%=std.getDepartment()%></span>
									<span class="spec-span" <%--style="font-size: 0.8rem;flex: 1;"--%>><%=std.getSpecialty()%></span>
								</span>
								<span class="like-span">
									<%
									if( std.getLike() != null ){
										for( String like: std.getLike() ){
											out.println( "<span>" + like + "</span>" );
										}
									}
									%>
								</span>
							</div>
						</li>
				<%
						}
					}
				%>
				</ul>
			</div>
			<div class="modal-div" style="display: none;">
				<form action="../servlet/student.do" method="post" target="_blank" name="msgForm">
					<input type="hidden" name="action" id="act-input" value="">
					<input type="hidden" name="id" value="">
					<div id='form-div'>
						<button class="modal-close-btn danger" type="button" id="close-modal-btn">×</button>
						<h2 style="margin: 8px;justify-content: center;">学生信息</h2>
						<div>
							<label>学号：</label>
							<div>
								<input type="text" name="number" maxlength="9"/>
							</div>
						</div>
						<div>
							<label>姓名：</label>
							<div>
								<input type="text" name="name" />
							</div>
						</div>
						<div>
							<label>性别：</label>
							<div>
								<label>
									<input type="radio" name="sex" value="男" checked/>
									<span>男</span>
								</label>
								<label>
									<input type="radio" name="sex" value="女"/>
									<span>女</span>
								</label>
							</div>
						</div>
							<div>
								<label>兴趣爱好：</label>
								<div>
									<label>
										<input type="checkbox" name="like" value="音乐"/>
										<span>音乐</span>
									</label>
									<label>
										<input type="checkbox" name="like" value="运动"/>
										<span>运动</span>
									</label>
									<label>
										<input type="checkbox" name="like" value="读书"/>
									<span>读书</span>
								</label>
								<label>
									<input type="checkbox" name="like" value="学习"/>
									<span>学习</span>
								</label>
							</div>
						</div>
						<div>
							<label>所属院系：</label>
							<div>
								<select name="department">
									<option value="无">无</option>
									<option value="计算机工程系">计算机工程系</option>
									<option value="电子工程系">电子工程系</option>
									<option value="机械工程系">机械工程系</option>
								</select>
							</div>
						</div>
						<div>
							<label>所属专业：</label>
							<div>
								<input type="text" name="specialty">
							</div>
						</div>
						<div>
							<label>个人简介：</label>
							<div>
								<textarea name="detail" cols="30" rows="4"></textarea>
							</div>
						</div>
						<div>
							<label>个人主页：</label>
							<div>
								<a href="http://baidu.com" target="_blank">个人主页地址</a>
							</div>
						</div>
						<div><!--
							<input type="submit" value="确定"/>
							<input type="reset" value="重置"/>
							 -->
							<button type="button" id="submit-button">确定</button>
							<button type="reset" id="cancel-button">重置</button>
						</div>

					</div>

				</form>
			</div>
		</div>

	</body>
	<script type="text/javascript" src="../js/studentList.js"></script>
</html>

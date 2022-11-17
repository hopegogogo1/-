<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/index.css"/>
		<link rel="stylesheet" type="text/css" href="font/iconfont.css"/>
	</head>
	<body>
		<!--1左侧菜单 -->
		<div id="menu-div">
			<!--11 左侧菜单-上方用户信息-->
			<div id="logo-div">
				<img src="img/zs.png" />
				<span>张升</span>
			</div>
			<!--12 左侧菜单-下方菜单列表-->
				<div id="menu-list-div">
				<!--一级菜单列表-->
				<ul class="menu-ul level-1">
					<!--一级菜单列表项 活动菜单-->
					<li id="manage" class="menu-li active-menu">
						信息管理
						<span id="iconfont" class="iconfont"></span>
						<!--二级菜单列表-->
						<ul id="twobox" class="menu-ul level-2" >
							<!--二级菜单列表项 活动菜单-->
							<li id="studentList" class="menu-li" data-url="student/studentList.html">
								学生信息管理
							</li>
							<li class="menu-li" data-url="#">
								学生信息管理
							</li>
							<li class="menu-li" data-url="#">
								学生信息管理
							</li>
						</ul>
					</li>
					<!--一级菜单列表项-->
					<li class="menu-li active-menu">
						事务管理
						<span class="iconfont"></span>
						<!--二级菜单列表-->
						<ul class="menu-ul level-2">
							<!--二级菜单列表项-->
							<li class="menu-li" data-url="#">
								请销假申请</li>
							<li class="menu-li" data-url="#">
								助学金申请</li>
						</ul>
					</li>
					<li class="menu-li" data-url="#">
						个人设置
					</li>
					<li class="menu-li active-menu">
						数据分析
						<span class="iconfont"></span>
						<!--二级菜单列表-->
						<ul class="menu-ul level-2">
							<!--二级菜单列表项-->
							<li id="genderAnalysis" class="menu-li" data-url="#">
								性别分析</li>
							<li id="hobbyAnalysis" class="menu-li" data-url="#">
								爱好分析</li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
		<!--2 右侧主体部分 -->
		<div id="body-div">
			<!--21 右侧主体部分 顶部区域（系统名称、站内信、退出）-->
			<div id="top-div">
				<span id="title-span">学生信息管理系统</span>
				<div>
					<!--站内信 -->
					<button id="message-btn" type="button" class="top-btn">
						站内信
						<span>3</span>
						<div id="message-list-div">
							<ul>
								<li>
									<span class="from-user-span">张三</span>
									<span class="send-time-span">2022-04-20 20:25:46</span>
								</li>
								<li>
									<span class="from-user-span">李思文</span>
									<span class="send-time-span">2022-04-20 10:27:21</span>
								</li>
								<li>
									<span class="from-user-span">王武文</span>
									<span class="send-time-span">2022-04-19 22:39:52</span>
								</li>
							</ul>
						</div>
					</button>
					<!--退出 -->
					<button id="logout-btn" type="button" class="top-btn">退出</button>
				</div>
			</div>
			<!--22 右侧主体部分 主页面-->
			<div id="main-div">
				<iframe id="myFrame" src="servlet/student.do?action=list"></iframe>
			</div>
		</div>


	</body>


	<script type="text/javascript">
		window.onload = function(){
			let iconfont=document.getElementById("iconfont")
			let manage=document.getElementById("manage")
			let twobox=document.getElementById("twobox")
			manage.onclick=function (){
				twobox.style.display="none";
			}

			var logoutBtn = document.getElementById( "logout-btn" )
			logoutBtn.onclick = function(){
				window.open( "servlet/logout.do","_self" );
			}
		}
	</script>

	<script type="text/javascript" src="js/studentList.js"></script>
	<script type="text/javascript" src="js/linkJump.js"></script>
	<script type="text/javascript" src="js/index.js"></script>

</html>

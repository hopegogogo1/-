<%@ page import="java.util.List" %>
<%@ page import="com.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2022/11/9
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>爱好分析</title>
  <!-- 引入 echarts.js -->
  <script src="https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js"></script>
</head>
<body>
<%
  int music = (int) request.getAttribute( "music" );
  int sport = (int) request.getAttribute( "sport" );
  int book = (int) request.getAttribute( "book" );
  int study = (int) request.getAttribute( "study" );
%>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 804px;height:500px;"></div>

<script type="text/javascript">
  // 基于准备好的dom，初始化echarts实例
  var myChart = echarts.init(document.getElementById('main'));

  // 指定图表的配置项和数据
  var option = {
    title: {
      text: '爱好分析'
    },
    tooltip: {},
    legend: {
      data:['爱好分析']
    },
    xAxis: {
      data: ["音乐","运动","读书","学习"]
    },
    yAxis: {},
    series: [{
      type: 'bar',
      data: [<%=music%>, <%=sport%>, <%=book%>, <%=study%>]
    }]
  };

  // 使用刚指定的配置项和数据显示图表。
  myChart.setOption(option);
</script>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>成功跳转页面</title>
</head>
<body>
<h1>成功！</h1>
${teacher}
<br>
<table cellpadding="5" cellspacing="0" border="1">
<tr>
<th>id</th>
<th>teacher</th>
<th>course</th>
<th>address</th>
</tr>
<c:forEach items="${pageInfo.list}" var="info">
<tr>
<td>${info.id}</td>
<td>${info.teacher}</td>
<td>${info.course}</td>
<td>广州</td>
</tr>
</c:forEach>
<tr>
<td colspan="4">
<a href="getTeaByPage?i=1">首页</a>
<a href="getTeaByPage?i=${pageInfo.prePage }">上一页</a>
<c:forEach items="${pageInfo.navigatepageNums }" var="pageNum">
<c:if test="${pageNum==pageInfo.pageNum }">【${pageNum }】</c:if>
<c:if test="${pageNum!=pageInfo.pageNum }">
<a href="getTeaByPage?i=${pageNum }">${pageNum }</a>
</c:if>

</c:forEach>
<a href="getTeaByPage?i=${pageInfo.nextPage }">下一页</a>
<a href="getTeaByPage?i=${pageInfo.pages }">末页</a>
</td>
</tr>
</table>
</body>
</html>
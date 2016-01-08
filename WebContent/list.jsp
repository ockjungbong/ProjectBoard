<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
 	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
<title>본격 게시판 - 게시글 리스트</title>
<style type="text/css"> 
    table, td, th   { 
    border:1px solid gray; 
    } 
    th{ 
    background-color:gray; 
    color:white; 
    } 
</style>
</head>

<body>
<h1>게시글 리스트</h1>
	<table width="500" border="1" cellspacing="0" cellpadding="3" bordercolor="#999999">
		<tr>
			<th>번호</th>   <!-- 테이블 태그 내에서 강조하고 싶은 컬럼을 나타날 때 사용 -->
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${articleList}" var="article">
			<tr>
				<td>${article.idx}</td><!-- jstl의 표현식은 스크립트릿과 속성이 같아서 어디에쓰나 우선됨 -->
				<td><a href='content.do?idx=${article.idx}'>${article.title}</a></td>
				<td>${article.writer}</td>
				<td>${article.regdate}</td>
				<td>${article.count}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="write.jsp">글쓰기</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="java.util.regex.Pattern"%>
<%@ page import="java.sql.*"%>
<%
 	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>본격! 게시판 - 게시글 삭제</title>    
</head>

 
<script> 
    alert("게시글이 삭제되었습니다");  // 게시글이 삭제되었다는 경고창을 띄워주고 
    location.href="redirect.jsp";          // 리스트페이지로 이동합니다. 
</script> 
<body>   
</body>
</html>
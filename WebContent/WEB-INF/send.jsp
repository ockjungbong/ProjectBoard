<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	//한글 인코딩을 위한 UTF-8 설정
	request.setCharacterEncoding("utf-8");
	out.println("에디터 결과");  
	out.println(request.getParameter("smarteditor"));
%>
<body>

</body>
</html>
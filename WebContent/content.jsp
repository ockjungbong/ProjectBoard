<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.regex.Pattern"%>
<%@ page import="java.sql.*"%>
<%
 	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"> 
<title>본격! 게시판 - 게시글 조회</title>    
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
    <h1>게시글 조회</h1>
    <table border="1">                            <!-- border은 테두리를 표시하는 속성입니다. -->
        <tr>                               
             <th>번호</th> 
            <td>${idx }</td>
            <th>작성자</th>
            <td>${writer }</td>
            <th>날짜</th>
            <td>${regdate}</td>
            <th>조회수</th>
            <td>${count }</td>
        </tr> 
        <tr> 
            <th colspan="2">제목</th>                     <!-- colspan은 행병합 속성입니다. --> 
            <td colspan="6">${title }</td> 
        </tr> 
        <tr> 
            <th colspan="2">내용</th>
            <td colspan="6">${content }</td>
        </tr>
    </table>
    <a href="delete.do?idx=${idx }">게시글삭제</a>
    <a href="list.do">목록으로</a>

</body> 
</html>
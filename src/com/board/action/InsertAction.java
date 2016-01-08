package com.board.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;
import java.sql.*;
import java.util.ArrayList; 
import com.board.beans.Board;
import com.board.controller.CommandAction;

public class InsertAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub

		 
	    int idx = 1; 
	    String title = request.getParameter("title"); 
	    String writer = request.getParameter("writer"); 
	    String regdate = request.getParameter("regdate"); 
	    int count = 10000; 
	    String content = request.getParameter("content");

		if(title == "" ||title == null) System.out.println("title이 null입니다.");
	    if(writer == "" ||writer == null)
	    	System.out.println("writer가 null입니다.");   
		else if(!Pattern.matches("^[_0-9a-zA-Z-]+@[0-9a-zA-Z-]+(.[_0-9a-zA-Z-]+)*$", writer))
			System.out.println("이메일 형식이 아닙니다.");
	    if(regdate == "" ||regdate == null)
	    	System.out.println("regdate가 null입니다.");
		else if(!Pattern.matches("^[0-9]*$", regdate))
			System.out.println("숫자형식이 아닙니다.");
	 	if(content == "" ||content == null) System.out.println("content가 null입니다.");
	 	
	 	try{
	 		String driverName = "oracle.jdbc.driver.OracleDriver"; // 데이터베이스에 접속하기 위한 드라이버를 로드
	 		String url = "jdbc:oracle:thin:@localhost:1521:XE";  // 접속 URL 정보와 포트번호(오라클 포트), sid(오라클 버전)
	 		
	 		Class.forName(driverName);
	 		Connection con = DriverManager.getConnection(url, "dublin", "5016");
	 		System.out.println("오라클 DB에 성공적으로 접속했습니다.");
	 		
	 		Statement stmt = con.createStatement();            // SQL 쿼리를 날리기위한 Statement 객체 생성
	 		 
	 		 String sql = "INSERT INTO BOARD "+
	 		 
	 		                "(IDX, TITLE, WRITER, REGDATE, COUNT, CONTENT) "+
	 		 
	 		                "VALUES (AUTO_SEQ_Board.nextval, '"+title+"', '"+writer+"', '"+regdate+"', '1', '"+content+"')";
	 		 
	 		stmt.executeUpdate(sql);   
	 		
	 		con.close(); 		
	 	}catch(Exception e){
	 		System.out.println("오라클 DB 접속에 문제가 있습니다.<hr>");
	 		System.out.println(e.getMessage());
	 		e.printStackTrace(); 		
	 	}finally{
	 		//out.print()
	 	}

		return "redirect.jsp";
	}

}

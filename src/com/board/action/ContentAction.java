package com.board.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;
import java.sql.*;
import java.util.ArrayList; 
import com.board.beans.Board;
import com.board.controller.CommandAction;

public class ContentAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub

	    String idx = request.getParameter("idx");  // 전 페이지로부터 넘어온 idx 값 받기 
	    try { 
	        String driverName = "oracle.jdbc.driver.OracleDriver";  
	        String url = "jdbc:oracle:thin:@localhost:1521:XE"; 
	        ResultSet rs = null;     
	 
	        Class.forName(driverName); 
	        Connection con = DriverManager.getConnection(url,"dublin","5016"); 
	        System.out.println("Oracle Database Connection Success.");     
	 
	        Statement stmt = con.createStatement();       
	        String sql = "select * from board where idx = " + idx ;   // 쿼리를 날리고
	        rs = stmt.executeQuery(sql);                                    // 결과 받환 받기
	         while(rs.next()){                                                  // 게시글의 끝까지 돌면서  
	        	request.setAttribute("idx", rs.getString("idx"));          // 셋팅!
	        	request.setAttribute("writer", rs.getString("writer"));
	        	request.setAttribute("regdate", rs.getString("regdate"));
	        	request.setAttribute("count", rs.getString("count"));
	        	request.setAttribute("title", rs.getString("title"));
	        	request.setAttribute("content", rs.getString("content"));        	
	        }   
	       con.close(); 
		}catch (Exception e) { 
		    System.out.println("Oracle Database Connection Something Problem. <hr>"); 
		    System.out.println(e.getMessage()); 
		    e.printStackTrace(); 
		} 

		return "content.jsp";
	}

}

package com.board.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;
import java.sql.*;
import java.util.ArrayList; 
import com.board.beans.Board;
import com.board.controller.CommandAction;

public class DeleteAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
	    String idx = request.getParameter("idx");
	    try {
	        String driverName = "oracle.jdbc.driver.OracleDriver"; 
	        String url = "jdbc:oracle:thin:@localhost:1521:XE";      
	 
	        Class.forName(driverName); 
	        Connection con = DriverManager.getConnection(url,"dublin","5016"); 
            System.out.println("Oracle Database Connection Success.");     
	 
	        Statement stmt = con.createStatement(); 
	        String sql = "delete from board where idx = " + idx ;   // 삭제 쿼리입니다.
	        stmt.executeQuery(sql);
	        con.close(); 
	    }catch (Exception e) {
	    	System.out.println("Oracle Database Connection Something Problem. <hr>");
	    	System.out.println(e.getMessage());
	        e.printStackTrace();
	    } 
	
		return "delete.jsp";
	}

}

package com.board.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.board.beans.Board;

public class BoardDao extends CommonDao{
	public static BoardDao getInstance(){
		BoardDao Instance = new BoardDao();
		return Instance;
	}
	
	public ArrayList<Board> getArtileList() throws SQLException{
		ResultSet rs = null;
		String sql = "select * from board order by idx desc";
        rs = openConnection().executeQuery(sql);  // sql을 실행하기 위해 연결을 열어 쿼리를 실행하고 rs에 반환
        
        ArrayList<Board> articleList = new ArrayList<Board>(); // Board 형 배열 형식으로 선언
        
        while(rs.next()){
        	Board article = new Board();  // 데이터들을 담기위해 Board 객체에 메모리 할당
        	article.setIdx(rs.getInt("idx"));
        	article.setTitle(rs.getString("title"));
        	article.setWriter(rs.getString("writer"));
        	article.setRegdate(rs.getString("regdate"));
			article.setCount(rs.getInt("count"));
			articleList.add(article); // 셋팅된 빈을 리스트에 추가합니다.        	
        }
        
        closeConnection();
        
        return articleList;
	}
}

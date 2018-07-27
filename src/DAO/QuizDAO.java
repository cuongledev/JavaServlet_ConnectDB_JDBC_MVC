package DAO;

import java.sql.*;
import java.util.*;

import BEAN.Incomplete;
import DB.DBConnection;
public class QuizDAO {
	
	public static List<Incomplete> DisplayQuestion(Connection conn){
		List<Incomplete> list = new ArrayList<Incomplete>();
		
		String sql = "SELECT * FROM incomplete";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				int number = rs.getInt("number");
				String question = rs.getString("question");
				String option1 = rs.getString("option1");
				String option2 = rs.getString("option2");
				String option3 = rs.getString("option3");
				String option4 = rs.getString("option4");
				String correctanswer = rs.getString("correctanswer");
				
				Incomplete ibt = new Incomplete();
				ibt.setNumber(number);
				ibt.setQuestion(question);
				ibt.setOption1(option1);
				ibt.setOption2(option2);
				ibt.setOption3(option3);
				ibt.setOption4(option4);
				ibt.setCorrectanswer(correctanswer);
				list.add(ibt);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
	}
	
	public static List<Incomplete> getCorrectAnswe(Connection conn){
		List<Incomplete> list = new ArrayList<Incomplete>();
		
		String sql = "SELECT * FROM incomplete";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				int number = rs.getInt("number");
				String question = rs.getString("question");
				String option1 = rs.getString("option1");
				String option2 = rs.getString("option2");
				String option3 = rs.getString("option3");
				String option4 = rs.getString("option4");
				String correctanswer = rs.getString("correctanswer");
				
				Incomplete ibt = new Incomplete();
				ibt.setNumber(number);
				ibt.setQuestion(question);
				ibt.setOption1(option1);
				ibt.setOption2(option2);
				ibt.setOption3(option3);
				ibt.setOption4(option4);
				ibt.setCorrectanswer(correctanswer);
				list.add(ibt);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
	}
	
	// trả về số lượng câu hỏi trong bài
	
	public static int getCountBrow(Connection conn) {
		int count =0;
		String sql = "SELECT COUNT(*) FROM incomplete";
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}

}

package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.*;
import db.*;

public class QuestionDao {
	public ArrayList<Question> loadquestion(Subject subject) throws Exception {
		String sql = "select question,optiona,optionb,optionc,optiond from exam_question where subjectid=?";
		ArrayList<Question> res = new ArrayList<Question>();
		String sql2 = "select subjectid from exam_subject where subjectname = ? and subjectrate = ?";
		ResultSet rs1 = DbUtil.executeQuery(sql2,subject);
		int subjectid = 0;
		while (rs1.next()) {
			subjectid = rs1.getInt("subjectid");
		}
		ResultSet rs = DbUtil.executeQuery(sql,subjectid);
		Question q = null;
		try {
			while (rs.next()) {
				q = new Question();
				q.setQuestion(rs.getString("question"));
				q.setOptiona(rs.getString("optiona"));
				q.setOptionb(rs.getString("optionb"));
				q.setOptionc(rs.getString("optionc"));
				q.setOptiond(rs.getString("optiond"));
				res.add(q);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("ResultSet在执行前已关闭");
		} finally {
			DbUtil.closeAll();
		}

		return res;
	}
}

package db;
import java.util.*;
import java.io.*;
import java.sql.*;
import bean.*;

public class DbUtil {
	public static Connection con = null;
	public static PreparedStatement psmt = null;
	public static ResultSet rs = null;
	public static int res = 0;

	/*
	 * ���Ӷ���
	 */
	public static Connection getConnetion() {
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("config.properties"));
			Class.forName(properties.getProperty("driverName"));
			con = DriverManager.getConnection(properties.getProperty("url"),
					properties.getProperty("user"),
					properties.getProperty("password"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public static PreparedStatement getPreparedStatement(String sql) {
		con = getConnetion();
		try {
			psmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return psmt;
	}

	/**
	 * ִ��sql��䷵����Ӱ������
	 * 
	 * @param sql
	 *            ��� ֧��insert,update,delete
	 * @param paramrs
	 *            ���������б�
	 * @return int
	 */
	public static int executeUpdate(String sql, ArrayList<Object> params) {
		try {
			psmt = DbUtil.getPreparedStatement(sql);
			if (!sql.contains("delete")) {
				psmt.setString(1, (String) params.get(0));
				psmt.setString(2, (String) params.get(1));
			} else
				psmt.setString(1, (String) params.get(0));
			res = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return res;
	}

	/**
	 * ִ�� sql��䷵�ؽ����
	 * 
	 * @param sql
	 *            ��� ֧�� select
	 * @param paramrs
	 *            ���������б�
	 * @return ResultSet
	 */
	public static ResultSet executeQuery(String sql, ArrayList<Object> params) {
		try {
			psmt = DbUtil.getPreparedStatement(sql);
			if (params != null) {
				if (params.size()>1) {
					psmt.setString(1, (String) params.get(0));
					psmt.setString(2, (String) params.get(1));
				} else {
					psmt.setString(1, (String) params.get(0));
				}
			}
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DbUtil�㷢���쳣");
		}
		return rs;
	}
	/**
	 * ����subjectid
	 * @param sql
	 * @param subject
	 * @return
	 */
	public static ResultSet executeQuery(String sql,Subject subject) {
		try {
			psmt = DbUtil.getPreparedStatement(sql);
			psmt.setString(1, subject.getSubjectname());
			psmt.setString(2, subject.getSubejctRate());
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DbUtil�㷢���쳣");
		}
		return rs;
	}
	/**
	 * ������Ŀ
	 * @param sql
	 * @param id
	 * @return
	 */
	public static ResultSet executeQuery(String sql,int id) {
		try {
			psmt = DbUtil.getPreparedStatement(sql);
			psmt.setString(1, Integer.toString(id));
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DbUtil�㷢���쳣");
		}
		return rs;
	}

	public static void closeAll() {
		try {
			if (psmt != null) {
				psmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ResultSet executeQuery(String sql, User u) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		try {
			psmt = DbUtil.getPreparedStatement(sql);
			psmt.setString(1, (String) u.getName());
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DbUtil�㷢���쳣");
		}
		return rs;
	}
}

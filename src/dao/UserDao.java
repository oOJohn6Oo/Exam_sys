package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import db.DbUtil;
import bean.User;

public class UserDao {

	/**
	 * 查
	 * 
	 * @param u
	 * @return ArrayList<Userinfo>
	 * @throws Exception
	 */
	public User LoginSql(User u) throws Exception {
		String sql = "select username,userpassword,userid,userimg from exam_user where username=?";
		ResultSet rs = DbUtil.executeQuery(sql, u);
		User temp = null;
		try {
			while (rs.next()) {
				temp = new User();
				temp.setUserid(rs.getInt("userid"));
				temp.setName(rs.getString("username"));
				temp.setPassword(rs.getString("userpassword"));
				temp.setUserimg(rs.getString("userimg"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("ResultSet在执行前已关闭");
		} finally {
			DbUtil.closeAll();
		}

		return temp;

	}
}

package service;
import dao.UserDao;
import bean.User;

/**
 * 用户表的管理类
 * 
 * @author Administrator
 * 
 */
public class UserService {
	UserDao ud = new UserDao();
	User temp = new User();
	/*
	 * 验证登录
	 */
	public boolean Login(User user) throws Exception {
		boolean flag = false;
		temp = ud.LoginSql(user);
		if(temp==null){
			throw new Exception("没有该用户...");
		}
		else if(temp.getPassword().equals(user.getPassword()))
			flag = true;
		return flag;
	}
	/*
	 * 登录成功返回该用户所有信息
	 */
	public User SucceedLogin(User user) throws Exception {
		return temp;
	}
}
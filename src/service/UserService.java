package service;
import dao.UserDao;
import bean.User;

/**
 * �û���Ĺ�����
 * 
 * @author Administrator
 * 
 */
public class UserService {
	UserDao ud = new UserDao();
	User temp = new User();
	/*
	 * ��֤��¼
	 */
	public boolean Login(User user) throws Exception {
		boolean flag = false;
		temp = ud.LoginSql(user);
		if(temp==null){
			throw new Exception("û�и��û�...");
		}
		else if(temp.getPassword().equals(user.getPassword()))
			flag = true;
		return flag;
	}
	/*
	 * ��¼�ɹ����ظ��û�������Ϣ
	 */
	public User SucceedLogin(User user) throws Exception {
		return temp;
	}
}
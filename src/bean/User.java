package bean;

public class User {
	private int userid;
	private String name;
	private String password;
	private String userimg;
	
	public String getUserimg(){
		return userimg;
	}
	public void setUserimg(String img){
		this.userimg = img;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", password="
				+ password + "]";
	}
	public User(int userid, String name, String password,String userimg) {
		super();
		this.userid = userid;
		this.name = name;
		this.password = password;
		this.userimg = userimg;
	}
	public User() {
		super();
	}
	
	
}

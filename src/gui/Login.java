package gui;

import javax.swing.*;

import service.UserService;

import bean.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * 登录窗体
 * 
 * @author Administrator
 * 
 */

/*
 * 1在需要使用事件的窗体类中实现事件接口 ActionListener actionPerformed() 2 在需要使用事件的控件上添加注册该事件功能
 */
public class Login extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 窗体的成员
	// 定义成员
	private JLabel logo;
	private JLabel jLabel;
	private JLabel jLabel2;
	private JTextField jTextField;// 文本框
	private JPasswordField jPasswordField;// 密码框
	private JButton login;
	private JButton exit;
	
	private UserService service;

	public Login() {

		this.setDefaultCloseOperation(Login.EXIT_ON_CLOSE);  
		this.setTitle("长沙理工大学“严肃”考试系统");
		this.setSize(477, 369);
		this.setLocationRelativeTo(null);
		this.setLayout(null);// 空布局
		this.init();
		this.setVisible(true);// 最后
	}

	/**
	 * 初始化窗体其它成员的方法
	 */
	public void init() {
		// 初始化
		this.service = new UserService();
		
		this.logo = new JLabel("治学要严谨");
		logo.setFont(new Font("华文行楷", Font.BOLD, 70));
		this.jLabel = new JLabel(new ImageIcon("images//ac.png"));
		this.jLabel2 = new JLabel(new ImageIcon("images//pw.png"));
		this.jTextField = new JTextField();
		this.jPasswordField = new JPasswordField();
		this.login = new JButton("登录");
		login.setBackground(new Color(120, 158, 244));
		login.setForeground(Color.white);
		this.exit = new JButton("关闭");
		exit.setBackground(new Color(120, 158, 244));
		exit.setForeground(Color.white);
		// 将控件添加到当前窗体
		this.add(logo);
		this.add(jLabel);
		this.add(jLabel2);
		this.add(login);
		this.add(exit);
		this.add(jTextField);
		this.add(jPasswordField);
		// 设置坐标
		this.logo.setBounds(50, 0, 400, 177);
		this.jLabel.setBounds(104, 188, 30, 30);
		this.jLabel2.setBounds(104, 220, 30, 30);
		this.jTextField.setBounds(134, 188, 208, 30);
		this.jPasswordField.setBounds(134, 220, 208, 30);
		this.login.setBounds(134, 270, 60, 30);
		this.exit.setBounds(282, 270, 60, 30);

		// 添加事件功能
		this.jTextField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					login.doClick();
				}
			}
		});

		this.jPasswordField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					login.doClick();
				}
			}
		});
		this.login.addActionListener(this);
		this.exit.addActionListener(this);

	}

	/*
	 * 事件对应的功能 (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// 区别
		if (e.getActionCommand().equals("登录")) {
			User user = new User();
			// 思路 获取当前文本框和密码框上面的数据
			String name = this.jTextField.getText().trim();
			@SuppressWarnings("deprecation")
			String pwd = this.jPasswordField.getText().trim();
			/*
			 * 测试
			 */
			if (name.equals("") || pwd.equals("")) {
				JOptionPane.showMessageDialog(this, "请输入信息...");
			} else {
				JOptionPane.showMessageDialog(this, "您输入的用户名是：" + name + "，密码是"+ pwd);
				user.setName(name);
				user.setPassword(pwd);
				Boolean flag = false;
				try {
					flag = service.Login(user);
					user = service.SucceedLogin(user);
					if (flag) {
						JOptionPane.showMessageDialog(this,"登录成功");
						this.dispose();
						new Exam(user);
					} else
						JOptionPane.showMessageDialog(this,"登录失败，请重试...");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(this, e1.getMessage());
				}
				
			}
		}

		if (e.getActionCommand().equals("关闭")) {
			System.exit(0);
		}

	}
}


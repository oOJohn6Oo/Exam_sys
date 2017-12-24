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
 * ��¼����
 * 
 * @author Administrator
 * 
 */

/*
 * 1����Ҫʹ���¼��Ĵ�������ʵ���¼��ӿ� ActionListener actionPerformed() 2 ����Ҫʹ���¼��Ŀؼ������ע����¼�����
 */
public class Login extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ����ĳ�Ա
	// �����Ա
	private JLabel logo;
	private JLabel jLabel;
	private JLabel jLabel2;
	private JTextField jTextField;// �ı���
	private JPasswordField jPasswordField;// �����
	private JButton login;
	private JButton exit;
	
	private UserService service;

	public Login() {

		this.setDefaultCloseOperation(Login.EXIT_ON_CLOSE);  
		this.setTitle("��ɳ����ѧ�����ࡱ����ϵͳ");
		this.setSize(477, 369);
		this.setLocationRelativeTo(null);
		this.setLayout(null);// �ղ���
		this.init();
		this.setVisible(true);// ���
	}

	/**
	 * ��ʼ������������Ա�ķ���
	 */
	public void init() {
		// ��ʼ��
		this.service = new UserService();
		
		this.logo = new JLabel("��ѧҪ�Ͻ�");
		logo.setFont(new Font("�����п�", Font.BOLD, 70));
		this.jLabel = new JLabel(new ImageIcon("images//ac.png"));
		this.jLabel2 = new JLabel(new ImageIcon("images//pw.png"));
		this.jTextField = new JTextField();
		this.jPasswordField = new JPasswordField();
		this.login = new JButton("��¼");
		login.setBackground(new Color(120, 158, 244));
		login.setForeground(Color.white);
		this.exit = new JButton("�ر�");
		exit.setBackground(new Color(120, 158, 244));
		exit.setForeground(Color.white);
		// ���ؼ���ӵ���ǰ����
		this.add(logo);
		this.add(jLabel);
		this.add(jLabel2);
		this.add(login);
		this.add(exit);
		this.add(jTextField);
		this.add(jPasswordField);
		// ��������
		this.logo.setBounds(50, 0, 400, 177);
		this.jLabel.setBounds(104, 188, 30, 30);
		this.jLabel2.setBounds(104, 220, 30, 30);
		this.jTextField.setBounds(134, 188, 208, 30);
		this.jPasswordField.setBounds(134, 220, 208, 30);
		this.login.setBounds(134, 270, 60, 30);
		this.exit.setBounds(282, 270, 60, 30);

		// ����¼�����
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
	 * �¼���Ӧ�Ĺ��� (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// ����
		if (e.getActionCommand().equals("��¼")) {
			User user = new User();
			// ˼· ��ȡ��ǰ�ı������������������
			String name = this.jTextField.getText().trim();
			@SuppressWarnings("deprecation")
			String pwd = this.jPasswordField.getText().trim();
			/*
			 * ����
			 */
			if (name.equals("") || pwd.equals("")) {
				JOptionPane.showMessageDialog(this, "��������Ϣ...");
			} else {
				JOptionPane.showMessageDialog(this, "��������û����ǣ�" + name + "��������"+ pwd);
				user.setName(name);
				user.setPassword(pwd);
				Boolean flag = false;
				try {
					flag = service.Login(user);
					user = service.SucceedLogin(user);
					if (flag) {
						JOptionPane.showMessageDialog(this,"��¼�ɹ�");
						this.dispose();
						new Exam(user);
					} else
						JOptionPane.showMessageDialog(this,"��¼ʧ�ܣ�������...");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(this, e1.getMessage());
				}
				
			}
		}

		if (e.getActionCommand().equals("�ر�")) {
			System.exit(0);
		}

	}
}


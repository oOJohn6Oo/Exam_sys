package gui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import service.*;
import bean.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * 管理窗体
 * 
 * @author Administrator
 * 
 */

/*
 * 1在需要使用事件的窗体类中实现事件接口 ActionListener actionPerformed() 2 在需要使用事件的控件上添加注册该事件功能
 */
@SuppressWarnings("serial")
public class Exam extends JFrame implements ActionListener,ListSelectionListener{
	// 窗体的成员
	// 定义成员
	private JScrollPane jScrollPane;// 滚动面板
	
	private JLabel grade;
	private JLabel subject;
	private JLabel face;
	private JLabel username;
	private JLabel name;
	private ArrayList<Question> arrayList;
	
	private JComboBox<String> gd;
	private JComboBox<String> sb;
	private JList<String> list;
	private DefaultListModel<String> listmodel;
	
	private JButton exit;
	private JButton start;
	private JButton cancel;
	private JButton sure;
	
	private JCheckBox a;
	private JCheckBox b;
	private JCheckBox c;
	private JCheckBox d;
	
	private ButtonGroup group1;
	private QuestionService qs;

	public Exam(User user) {
		this.setDefaultCloseOperation(Exam.EXIT_ON_CLOSE);
		this.setTitle("长沙理工大学“严肃”考试系统");
		this.setSize(800, 450);
		this.setLocationRelativeTo(null);
		this.setLayout(null);// 空布局
		this.init(user);
		this.setVisible(true);// 最后
	}

	/**
	 * 初始化窗体其它成员的方法
	 */
	public void init(User user) {
		// 初始化
		arrayList = new ArrayList<Question>();
		qs = new QuestionService();
		grade = new JLabel("年级");
		subject = new JLabel("考试科目");
		
		list = new JList<String>();
		//设置列表与模型的关系
		listmodel = new DefaultListModel<String>();
	
		list.setModel(listmodel);
		
		//单选
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		jScrollPane = new JScrollPane();
		//设置滚动面板与列表之间的关系
		jScrollPane.getViewport().add(list);
		
		face = new JLabel(new ImageIcon("images//"+user.getUserimg()));
		username = new JLabel("—用户姓名—");
		name = new JLabel(user.getName());
		gd = new JComboBox<String>();
		gd.addItem("大一");
		gd.addItem("大二");
		gd.addItem("大三");
		
		sb = new JComboBox<String>();
		sb.addItem("java基础");
		sb.addItem("sql基础");
		sb.addItem("java进阶");
		sb.addItem("sql进阶");
		
		cancel = new JButton("取消");
		exit = new JButton("退出");
		sure = new JButton("确定");
		start = new JButton("开始答题");
		
		a = new JCheckBox("A：");
		b = new JCheckBox("B：");
		c = new JCheckBox("C：");
		d = new JCheckBox("D：");
		
		// 将控件添加到当前窗体
		this.group1=new ButtonGroup();
		group1.add(a);
		group1.add(b);
		group1.add(c);
		group1.add(d);
		
		this.add(jScrollPane);
//		this.add(list);  切记，，，加到模型里面的控件不用再add进来
		this.add(face);
		this.add(username);
		this.add(name);
		this.add(sb);
		this.add(gd);
		this.add(cancel);
		this.add(exit);
		this.add(sure);
		this.add(start);
		
		this.add(grade);
		this.add(subject);
		
		this.add(a);
		this.add(b);
		this.add(c);
		this.add(d);
		// 设置坐标
		
		//用户信息区域
		this.face.setBounds(650, 20, 100, 100);
		this.username.setBounds(660, 120, 100, 20);
		this.name.setBounds(690, 140, 100, 20);
		
		//顶部区域
		this.grade.setBounds(30, 20, 30, 30);
		this.gd.setBounds(90, 20, 60, 30);
		this.subject.setBounds(180, 20, 60, 30);
		this.sb.setBounds(250, 20, 100, 30);
		this.start.setBounds(400, 20, 100, 30);
		this.exit.setBounds(520, 20, 60, 30);
		
		//底部按钮
		this.sure.setBounds(420, 350, 60, 30);
		this.cancel.setBounds(520, 350, 60, 30);
		
		//选择框
		this.a.setBounds(400, 60, 200, 30);
		this.b.setBounds(400, 135, 200, 30);
		this.c.setBounds(400, 210, 200, 30);
		this.d.setBounds(400, 285, 200, 30);
		
		//列表框
		this.jScrollPane.setBounds(25, 60, 350, 300);

		this.cancel.addActionListener(this);
		this.exit.addActionListener(this);
		this.sure.addActionListener(this);
		this.start.addActionListener(this);
		this.a.addActionListener(this);
		this.list.addListSelectionListener(this);

	}
	public void ListbindData(){
		this.a.setText(arrayList.get(0).getOptiona());
		this.b.setText(arrayList.get(0).getOptionb());
		this.c.setText(arrayList.get(0).getOptionc());
		this.d.setText(arrayList.get(0).getOptiond());
	}

	/*
	 * 事件对应的功能 (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("开始答题")){
			this.listmodel.removeAllElements();
			Subject subject = new Subject();
			subject.setSubejctRate(gd.getItemAt(gd.getSelectedIndex()));
			subject.setSubjectname(sb.getItemAt(sb.getSelectedIndex()));
			try {
				arrayList = qs.loadquestion(subject);
				for (int i = 0; i < arrayList.size(); i++) {
					listmodel.addElement(arrayList.get(i).getQuestion());
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if(e.getValueIsAdjusting()){
			this.a.setText(arrayList.get(this.list.getSelectedIndex()).getOptiona());
			this.b.setText(arrayList.get(this.list.getSelectedIndex()).getOptionb());
			this.c.setText(arrayList.get(this.list.getSelectedIndex()).getOptionc());
			this.d.setText(arrayList.get(this.list.getSelectedIndex()).getOptiond());
		  }
	}
}

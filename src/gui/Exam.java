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
 * ������
 * 
 * @author Administrator
 * 
 */

/*
 * 1����Ҫʹ���¼��Ĵ�������ʵ���¼��ӿ� ActionListener actionPerformed() 2 ����Ҫʹ���¼��Ŀؼ������ע����¼�����
 */
@SuppressWarnings("serial")
public class Exam extends JFrame implements ActionListener,ListSelectionListener{
	// ����ĳ�Ա
	// �����Ա
	private JScrollPane jScrollPane;// �������
	
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
		this.setTitle("��ɳ����ѧ�����ࡱ����ϵͳ");
		this.setSize(800, 450);
		this.setLocationRelativeTo(null);
		this.setLayout(null);// �ղ���
		this.init(user);
		this.setVisible(true);// ���
	}

	/**
	 * ��ʼ������������Ա�ķ���
	 */
	public void init(User user) {
		// ��ʼ��
		arrayList = new ArrayList<Question>();
		qs = new QuestionService();
		grade = new JLabel("�꼶");
		subject = new JLabel("���Կ�Ŀ");
		
		list = new JList<String>();
		//�����б���ģ�͵Ĺ�ϵ
		listmodel = new DefaultListModel<String>();
	
		list.setModel(listmodel);
		
		//��ѡ
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		jScrollPane = new JScrollPane();
		//���ù���������б�֮��Ĺ�ϵ
		jScrollPane.getViewport().add(list);
		
		face = new JLabel(new ImageIcon("images//"+user.getUserimg()));
		username = new JLabel("���û�������");
		name = new JLabel(user.getName());
		gd = new JComboBox<String>();
		gd.addItem("��һ");
		gd.addItem("���");
		gd.addItem("����");
		
		sb = new JComboBox<String>();
		sb.addItem("java����");
		sb.addItem("sql����");
		sb.addItem("java����");
		sb.addItem("sql����");
		
		cancel = new JButton("ȡ��");
		exit = new JButton("�˳�");
		sure = new JButton("ȷ��");
		start = new JButton("��ʼ����");
		
		a = new JCheckBox("A��");
		b = new JCheckBox("B��");
		c = new JCheckBox("C��");
		d = new JCheckBox("D��");
		
		// ���ؼ���ӵ���ǰ����
		this.group1=new ButtonGroup();
		group1.add(a);
		group1.add(b);
		group1.add(c);
		group1.add(d);
		
		this.add(jScrollPane);
//		this.add(list);  �мǣ������ӵ�ģ������Ŀؼ�������add����
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
		// ��������
		
		//�û���Ϣ����
		this.face.setBounds(650, 20, 100, 100);
		this.username.setBounds(660, 120, 100, 20);
		this.name.setBounds(690, 140, 100, 20);
		
		//��������
		this.grade.setBounds(30, 20, 30, 30);
		this.gd.setBounds(90, 20, 60, 30);
		this.subject.setBounds(180, 20, 60, 30);
		this.sb.setBounds(250, 20, 100, 30);
		this.start.setBounds(400, 20, 100, 30);
		this.exit.setBounds(520, 20, 60, 30);
		
		//�ײ���ť
		this.sure.setBounds(420, 350, 60, 30);
		this.cancel.setBounds(520, 350, 60, 30);
		
		//ѡ���
		this.a.setBounds(400, 60, 200, 30);
		this.b.setBounds(400, 135, 200, 30);
		this.c.setBounds(400, 210, 200, 30);
		this.d.setBounds(400, 285, 200, 30);
		
		//�б��
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
	 * �¼���Ӧ�Ĺ��� (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("��ʼ����")){
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

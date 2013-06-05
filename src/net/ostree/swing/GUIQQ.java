package net.ostree.swing;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * ��QQ��¼����
 * 
 * @author jiang
 */
public class GUIQQ extends JFrame {
	// �û���
	private JTextField username;
	// ����
	private JPasswordField password;
	// С����
	private JLabel jl1;
	private JLabel jl2;
	private JLabel jl3;
	private JLabel jl4;

	// С��ť
	private JButton bu1;
	private JButton bu2;
	private JButton bu3;

	// ��ѡ��
	private JCheckBox jc1;
	private JCheckBox jc2;

	// �б��
	private JComboBox jcb;

	/*
	 * ���췽��
	 */
	public GUIQQ() {
		// ���ô��ڱ���
		this.setTitle("QQ2012��ʽ��");
		// ���������ʼ��
		init();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ���ò��ַ�ʽΪ���Զ�λ
		this.setLayout(null);
		
		this.setBounds(0, 0, 355, 265);
		// ���ô���ı���ͼ��
		Image image = new ImageIcon("e:/a.gif").getImage();
		this.setIconImage(image);
		
		// �����С���ܸı�
		this.setResizable(false);
		
		// ������ʾ
		this.setLocationRelativeTo(null);

		// ����ɼ�
		this.setVisible(true);
	}

	/*
	 * ��ʼ������
	 */
	public void init() {
		// ����һ������
		Container con = this.getContentPane();
		jl1 = new JLabel();
		// ���ñ���ͼƬ
		Image image1 = new ImageIcon("e:/background.jpg").getImage();
		jl1.setIcon(new ImageIcon(image1));
		jl1.setBounds(0, 0, 355, 265);
		
		// QQ��¼ͷ���趨
		jl2 = new JLabel();
		Image image2 = new ImageIcon("e:/a.gif").getImage();
		jl2.setIcon(new ImageIcon(image2));
		jl2.setBounds(40, 95, 50, 60);

		// �û������¼�����
		username = new JTextField();
		username.setBounds(100, 100, 150, 20);
		// �û������¼������Աߵ�����
		jl3 = new JLabel("ע���˺�");
		jl3.setBounds(260, 100, 70, 20);

		// ���������
		password = new JPasswordField();
		password.setBounds(100, 130, 150, 20);
		// ����������Աߵ�����
		jl4 = new JLabel("�һ�����");
		jl4.setBounds(260, 130, 70, 20);

		// ������·�����
		jc1 = new JCheckBox("��ס����");
		jc1.setBounds(105, 155, 80, 15);
		jc2 = new JCheckBox("�Զ���¼");
		jc2.setBounds(185, 155, 80, 15);

		// �û���¼״̬ѡ��
		jcb = new JComboBox();
		jcb.addItem("����");
		jcb.addItem("����");
		jcb.addItem("�뿪");
		jcb.setBounds(40, 150, 55, 20);

		// ��ť�趨
		bu1 = new JButton("��¼");
		bu1.setBounds(280, 200, 65, 20);
		// ����ť���1���¼�
		bu1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str=e.getActionCommand();
				if("��¼".equals(str)){
					String getName =username.getText();
//					String getPwd =password.getText();
					 JOptionPane.showConfirmDialog(null, "��������û�����"+getName);
				}
				
			}
		});
		
		
		bu2 = new JButton("���˺�");
		bu2.setBounds(5, 200, 75, 20);
		bu3 = new JButton("����");
		bu3.setBounds(100, 200, 65, 20);

		// �������������װ��
		jl1.add(jl2);
		jl1.add(jl3);
		jl1.add(jl4);
		jl1.add(jc1);
		jl1.add(jc2);
		jl1.add(jcb);
		jl1.add(bu1);
		jl1.add(bu2);
		jl1.add(bu3);
		con.add(jl1);
		con.add(username);
		con.add(password);

	}

	public static void main(String[] args) {
		// ʵ��������
		GUIQQ qq = new GUIQQ();
	}

}

package net.ostree.swing;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserLogin extends JFrame implements ActionListener {

 private JLabel lblUsername;
 private JLabel lblPassword;
 private JTextField tfUsername;
 private JPasswordField tfPassword;
 private JButton btnOK;
 private JButton btnExit;

 public UserLogin() {
  JPanel p1 = new JPanel();
  p1.setLayout(new BorderLayout());
  lblUsername = new JLabel("�û���:");
  tfUsername = new JTextField(12);
  p1.add(lblUsername, BorderLayout.WEST);
  p1.add(tfUsername, BorderLayout.EAST);

  JPanel p2 = new JPanel();
  p2.setLayout(new BorderLayout());
  lblPassword = new JLabel("����:");
  tfPassword = new JPasswordField(12);
  p2.add(lblPassword, BorderLayout.WEST);
  p2.add(tfPassword, BorderLayout.EAST);

  JPanel p3 = new JPanel();
  btnOK = new JButton("��¼");
  btnOK.addActionListener(this);
  btnExit = new JButton("ȡ��");
  btnExit.addActionListener(this);
  p3.add(btnOK);
  p3.add(btnExit);

  this.add(p1, BorderLayout.NORTH);
  this.add(p2, BorderLayout.CENTER);
  this.add(p3, BorderLayout.SOUTH);

  this.setLocation(400, 300);
  this.setSize(300, 110);
  this.setTitle("������֤");
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setVisible(true);
 }

 public void actionPerformed(ActionEvent e) {
  if (e.getActionCommand().equals("��¼")) {
   JOptionPane.showMessageDialog(this, "�����û���Ϊ" + tfUsername.getText()
     + "n" + "�������Ϊ" + String.valueOf(tfPassword.getText()));
  } else if(e.getActionCommand().equals("ȡ��")) {
   System.exit(0);
  }
 }

 public static void main(String[] args) {
  new UserLogin();
 }

}


package net.ostree.swing;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class Login2 {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    static void createAndShowGUI() {

        //////////////////////////////////////////////////////////////
        loginWindow = new JFrame("��¼��Ϣ");
        loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        loginWindow.setBounds(350,350,250,200);
        loginWindow.setResizable(false);

        JPanel usernamePanel = new JPanel();
        usernamePanel.add(new JLabel("�û�����",JLabel.CENTER));
        usernamePanel.add(usernameField);
 
        JPanel passwordPanel = new JPanel();
        passwordPanel.add(new JLabel("��  �룺",JLabel.CENTER));
        passwordPanel.add(passwordField);

        Box box = new Box(BoxLayout.Y_AXIS);
        box.add(usernamePanel);  box.add(passwordPanel);

        JPanel infoPanel = new JPanel();
        infoPanel.add(box);
        infoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(244,144,44)),"��д��¼��Ϣ"));

        JButton submitButton = new JButton("��¼");
        JButton cancelButton = new JButton("ȡ��");
        submitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();
             
                if(!username.equals("") && !password.equals("")) {
                    loginWindow.dispose();                
                    mainFrame.getContentPane().add(new JLabel("�û�����"+username+"    �����ǣ�"+password,JLabel.CENTER));
                    mainFrame.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null,"�û��������벻��Ϊ��","��ʾ",JOptionPane.WARNING_MESSAGE);
                    System.exit(1);
                }
            }
        });
        cancelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton); buttonPanel.add(cancelButton);
        loginWindow.getContentPane().add(infoPanel,BorderLayout.CENTER);
        loginWindow.getContentPane().add(buttonPanel,BorderLayout.SOUTH);
        loginWindow.getContentPane().add(new JPanel(),BorderLayout.EAST);
        loginWindow.getContentPane().add(new JPanel(),BorderLayout.WEST);
        loginWindow.setVisible(true);
        /////////////////////////////////////////////////////////////////

        mainFrame = new JFrame(); 
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(250,250,400,300);
        mainFrame.setVisible(false);
    }

    static JFrame loginWindow,mainFrame;
    static final JTextField usernameField = new JTextField(10);
    static final JPasswordField passwordField = new JPasswordField(10);
}

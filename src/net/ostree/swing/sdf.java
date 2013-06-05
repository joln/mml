package net.ostree.swing;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class sdf extends JFrame {


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		
		sdf d = new sdf();

	}
	
	public sdf()
	{
		JPanel jp = new JPanel();
		jp.setBackground(Color.red);
		this.add(jp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 600);
		this.setVisible(true);
	}

}

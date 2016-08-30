package com.huidao.ui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.border.LineBorder;

public class WelComeWindow extends JWindow{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	

	public WelComeWindow(){
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		setSize(300,220);
		JLabel l = new JLabel(new ImageIcon(getClass().getResource("welcome.jpg")));
		JPanel p = new JPanel();
		p.add(l);
		setContentPane(p);
		p.setBorder(new LineBorder(Color.blue));
		//æ”÷–
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		WelComeWindow w = new WelComeWindow();
		w.setVisible(true);
	}
}

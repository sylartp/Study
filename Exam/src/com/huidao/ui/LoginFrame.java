package com.huidao.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.naming.Context;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class LoginFrame extends JFrame{
		
	
	private ClientContext clientContext;
	
	private JTextField idField;
	
	private JPasswordField pwdField;

	private JLabel mes;
	
	public void setMes(String message){
		mes.setText(message);
	}
	
	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
	}

	public LoginFrame(){
		init();
		
		
	}

	private void init() {
		//���ñ���
		setTitle("��½ϵͳ");
		setSize(300,220);
		//Ĭ������Ļ����
		setLocationRelativeTo(null);
		setContentPane(createContentPane());
		//����Ĭ�ϲ��ɹر�
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		//
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				clientContext.exit(LoginFrame.this);
			}
		});
	}

	private Container createContentPane() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new BorderLayout());
		
		//�����ؼ��븸�����߿�ľ���
		p.setBorder(new EmptyBorder(8, 8, 8, 8));
		p.add(BorderLayout.NORTH,new JLabel("���Ե�½ϵͳ",JLabel.CENTER));
		
		p.add(BorderLayout.CENTER,createCenterPane());
		p.add(BorderLayout.SOUTH,createBtnPane());
		return p;
	}

	private Component createBtnPane() {
		JPanel p = new JPanel(new FlowLayout());
		JButton login = new JButton("login");
		JButton cancel = new JButton("cancle");
		p.add(login);
		p.add(cancel);
		// TODO Auto-generated method stub
		getRootPane().setDefaultButton(login);
		
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clientContext.login();
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clientContext.exit(LoginFrame.this);
			}
		});
		return p;
	}

	private Component createCenterPane() {
		JPanel p = new JPanel(new BorderLayout());
		p.setBorder(new EmptyBorder(10, 0, 0, 0));
		p.add(BorderLayout.NORTH,createIdPwdPane());
		 mes = new JLabel("",JLabel.CENTER);
		p.add(mes);
		return p;
	}

	private Component createIdPwdPane() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new BorderLayout());
		p.add(BorderLayout.NORTH,createIdPane());
		p.add(BorderLayout.SOUTH,createPwdPane());
		return p;
	}

	private Component createPwdPane() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new BorderLayout());
		p.setBorder(new EmptyBorder(0, 8, 0, 0));
		p.add(BorderLayout.WEST,new JLabel("����"));
		JPasswordField pwdField = new JPasswordField();
		this.pwdField = pwdField;
		p.add(BorderLayout.CENTER,pwdField);
		return p;
	}

	private Component createIdPane() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new BorderLayout());
		p.setBorder(new EmptyBorder(0, 8, 0, 0));
		p.add(BorderLayout.WEST,new JLabel("�˺�"));
		JTextField idField = new JTextField();
		this.idField = idField;
		p.add(BorderLayout.CENTER,idField);
		return p;
	}
	//��ȡ�����id�˺�
	public int getID(){
		String id = idField.getText();
		return Integer.valueOf(id);
	}
	
	public String getPwd(){
		char[] pwd =  pwdField.getPassword();
		return new String(pwd);
	}
}

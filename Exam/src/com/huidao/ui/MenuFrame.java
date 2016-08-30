package com.huidao.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.huidao.entity.User;

public class MenuFrame extends JFrame{
	private ClientContext clientContext;
	private JLabel text;
	
	
	
	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
	}

	public MenuFrame(){
		init();
	}

	private void init() {
		setSize(600,400);
		setTitle("汇道科技考试系统");
		setContentPane(createContentPane());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				clientContext.exit(MenuFrame.this);
			}
		});
	}

	private Container createContentPane() {
		JPanel p = new JPanel(new BorderLayout());
		ImageIcon icon = new ImageIcon(getClass().getResource("titile.jpg"));
		JLabel l = new JLabel(icon);
		p.add(BorderLayout.NORTH,l);
		p.add(BorderLayout.CENTER,createMenuPane());
		p.add(BorderLayout.SOUTH,new JLabel("本系统版权归汇道所有",JLabel.RIGHT));
		return p;
	}



	private Component createMenuPane() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new BorderLayout());
		text = new JLabel("xxx 同学您好，欢迎参加本次考试!",JLabel.CENTER);
		p.add(BorderLayout.NORTH,text);
		p.add(BorderLayout.CENTER,createBtnPane());
		return p;
	}

	private Component createBtnPane() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new FlowLayout());
	
		JButton start = createButton("开始","exam.png");
		JButton score = createButton("分数", "result.png");
		JButton message = createButton("考试规则", "message.png");
		JButton exit = createButton("退出", "exit.png");
		
		p.add(start);
		p.add(score);
		p.add(message);
		p.add(exit);
	
		getRootPane().setDefaultButton(start);
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.start();
			}
		});
		score.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.showScore();
			}
		});
		
		message.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.showMsg();
			}
		});
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.exit(MenuFrame.this);
			}
		});
		return p;
	}

	private JButton createButton(String name, String source) {
		ImageIcon icon = new ImageIcon(getClass().getResource(source));
		JButton b = new JButton(name,icon);
		b.setVerticalTextPosition(JButton.BOTTOM);
		b.setHorizontalTextPosition(JButton.CENTER);
		return b;
	}
	public void upDateView(User user){
		text.setText(user.getName()+"同学欢迎参加考试");
	}
}

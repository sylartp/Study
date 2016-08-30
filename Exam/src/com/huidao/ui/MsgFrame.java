package com.huidao.ui;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MsgFrame extends JFrame{	
	private ClientContext clientContext;
	private JTextArea text;
	
	
	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
	}

	public MsgFrame(){
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		setSize(600,400);
		setContentPane(createConentPane());
		setLocationRelativeTo(null);
	}

	private Container createConentPane() {
		// TODO Auto-generated method stub
		JScrollPane p = new JScrollPane();
		 text = new JTextArea();
		p.add(text);
		p.getViewport().add(text);
		
		
		return p;
	}
	public void showMsg(String rule){
		text.setText(rule);
		text.setVisible(true);
		text.setEditable(true);
	}
}

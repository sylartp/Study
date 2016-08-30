package com.huidao.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import com.huidao.entity.ExamInfo;
import com.huidao.entity.QuestionInfo;

public class ExamFrame extends JFrame {
	private ClientContext clientContext;
	private JLabel info;
	private JTextArea questionArea;
	private Option[] options = new Option[4];
	private JLabel questionCount;
	private JLabel timeText;
	private JButton pre;
	private JButton next;

	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
	}

	public ExamFrame() {
		init();
	}

	private void init() {
		setSize(600, 400);
		setTitle("祝你成功");
		setLocationRelativeTo(null);
		setContentPane(createContentPane());
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				clientContext.exit(ExamFrame.this);
			}
		});
	}

	private Container createContentPane() {
		JPanel p = new JPanel(new BorderLayout());
		ImageIcon icon = new ImageIcon(getClass().getResource("titile.jpg"));
		JLabel j = new JLabel(icon);
		p.add(BorderLayout.NORTH, j);
		p.add(BorderLayout.CENTER, createCenterPane());
		p.add(BorderLayout.SOUTH, createBottomPane());
		return p;
	}

	private Component createBottomPane() {
		JPanel p = new JPanel(new BorderLayout());
		questionCount = new JLabel("共20题第1题");
		p.add(BorderLayout.WEST, questionCount);
		timeText = new JLabel("1:11:11");
		p.add(BorderLayout.EAST, timeText);
		p.add(BorderLayout.CENTER, createBtnPane());
		return p;
	}

	public void updateView(ExamInfo info, QuestionInfo questionInfo) {
		setInfo(info);
		setQuestionArea(questionInfo);
		setQuestionCount(info.getQuestionCount(), questionInfo.getIndex() + 1);
		List<Integer> list = questionInfo.getUserAnswers();
		boolean[] b = questionInfo.getSelected();
		for (Integer integer : list) {
			b[integer] = true;
		}
		upDateOptions(b);
	}

	private Component createBtnPane() {
		JPanel p = new JPanel();
		pre = new JButton("上一题");
		next = new JButton("下一题");
		JButton submit = new JButton("交卷");
		p.add(pre);
		p.add(next);
		p.add(submit);
		pre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.pre();
			}
		});
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.next();
			}
		});
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.submit();
			}
		});
		return p;
	}
	private Component createCenterPane() {
		JPanel p = new JPanel(new BorderLayout());
		info = new JLabel("考生:小明  科目:JAVASE  时间:1小时", JLabel.CENTER);
		p.add(BorderLayout.NORTH, info);
		p.add(BorderLayout.CENTER, createQuestionPane());
		p.add(BorderLayout.SOUTH, createOptionsPane());
		return p;
	}
	private Component createOptionsPane() {
		JPanel p = new JPanel();
		Option a = new Option("A", 0);
		Option b = new Option("B", 1);
		Option c = new Option("C", 2);
		Option d = new Option("D", 3);
		options[0] = a;
		options[1] = b;
		options[2] = c;
		options[3] = d;
		p.add(a);
		p.add(b);
		p.add(c);
		p.add(d);
		return p;
	}

	private Component createQuestionPane() {
		JScrollPane jsp = new JScrollPane();
		// 设置标题边框
		jsp.setBorder(new TitledBorder("题目"));

		questionArea = new JTextArea(
				"1.你死不死撒1.你死不死撒1.你死不死撒1.你死不死撒1.你死不死撒1.你死不死撒1.你死不死撒1.你死不死撒1.你死不死撒1.你死不死撒1.你死不死撒1.你死不死撒1.你死不死撒1.你死不死撒1.你死不死撒1.你死不死撒1.你死不死撒\nA.是的\nB.不是\nC.萨比\nD.呵呵");
		questionArea.setEditable(false);
		questionArea.setLineWrap(true);
		// 设置字体
		questionArea.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		jsp.getViewport().add(questionArea);
		return jsp;
	}
	class Option extends JCheckBox {
		public int value;

		public Option(String name, int value) {
			super(name);
			this.value = value;
		}
	}
	public void setInfo(ExamInfo info) {
		this.info.setText(info.toString());
	}

	public List<Integer> getUserAnswers() {
		List<Integer> answers = new ArrayList<>();
		for (Option op : options) {
			if (op.isSelected()) {
				answers.add(op.value);
			}
		}
		return answers;
	}

	// 更新选项框
	public void upDateOptions(boolean[] b) {
		for (int i = 0; i < options.length; i++) {
			if (b[i] == true) {
				options[i].setSelected(true);
			} else {
				options[i].setSelected(false);
			}
		}
	}

	public void setQuestionArea(QuestionInfo info) {
		questionArea.setText(info.toString());
	}

	public void setQuestionCount(int total, int current) {
		questionCount.setText("共" + total + "题第" + current + "题");
	}

	public void setTimeText(int h, int m, int s) {
		timeText.setText(h + ":" + m + ":" + s);

	}

}

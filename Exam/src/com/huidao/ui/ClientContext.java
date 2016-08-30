package com.huidao.ui;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.omg.CORBA.Current;

import com.huidao.entity.ExamInfo;
import com.huidao.entity.QuestionInfo;
import com.huidao.entity.User;
import com.huidao.service.ExamServiceImp;
import com.huidao.service.IdOrPwdException;

/**
 * �û�������������ͻ��������Ļ���
 * 
 * @author Administrator
 *
 */
public class ClientContext {
	private int seconds;
	private MsgFrame msgFrame;
	private QuestionInfo currentQustion;
	private ExamInfo examInfo;
	private Timer timer = new Timer();
	private ExamFrame examFrame;
	private ExamServiceImp examServiceImp;
	private MenuFrame menuFrame;
	private WelComeWindow welComeWindow;
	private LoginFrame loginFrame;
	public ClientContext(ExamServiceImp examServiceImp) {
		msgFrame = new MsgFrame();
		msgFrame.setClientContext(this);
		loginFrame = new LoginFrame();
		loginFrame.setClientContext(this);
		welComeWindow = new WelComeWindow();
		menuFrame = new MenuFrame();
		menuFrame.setClientContext(this);
		examFrame = new ExamFrame();
		examFrame.setClientContext(this);
		this.examServiceImp = examServiceImp;
	}
	public void show() {
		welComeWindow.setVisible(true);
		// ��ʱ��
		Timer t = new Timer();
		t.schedule(new TimerTask() {

			@Override
			public void run() {
				welComeWindow.setVisible(false);
				loginFrame.setVisible(true);
				t.cancel();
			}
		}, 2000);

	}
	public void exit(JFrame frame) {
		int var = JOptionPane.showConfirmDialog(frame, "�Ƿ��˳�");
		if (var == JOptionPane.OK_OPTION) {
			System.exit(0);
		}
	}
	public void login() {
		// ��ȡ�û�������˺�
		try {
			int id = loginFrame.getID();
			// ��ȡ�û����������
			String pwd = loginFrame.getPwd();
			User user = examServiceImp.login(id, pwd);
			// ����UI
			menuFrame.upDateView(user);
			loginFrame.setVisible(false);
			menuFrame.setVisible(true);
		} catch (IdOrPwdException e) {
			e.printStackTrace();
			loginFrame.setMes("��½ʧ��:" + e.getMessage());
		} catch (NumberFormatException e) {
			e.printStackTrace();
			loginFrame.setMes("ID����������" + e.getMessage());
		}

	}
	public void start() {
		examInfo = examServiceImp.start();
		currentQustion = examServiceImp.getQuestion(0);
		examFrame.updateView(examInfo, currentQustion);
		menuFrame.setVisible(false);
		examFrame.setVisible(true);
		timerStart();
	}
	public void showScore() {
		if (examServiceImp.isFinished()) {
			JOptionPane.showMessageDialog(menuFrame, "��ķ�����:" + examInfo.getScore());
		}
	}
	public void showMsg() {
		String rule = examServiceImp.getMsg();
		msgFrame.showMsg(rule);
		msgFrame.setVisible(true);
	}
	public void next() {
		List<Integer> userAnswers = examFrame.getUserAnswers();
		examServiceImp.saveUserAnswer(currentQustion.getIndex(), userAnswers);
		int index = currentQustion.getIndex() + 1;
		currentQustion = examServiceImp.getQuestion(index);
		examFrame.updateView(examInfo, currentQustion);
	}
	public void pre() {
		List<Integer> userAnswers = examFrame.getUserAnswers();
		examServiceImp.saveUserAnswer(currentQustion.getIndex(), userAnswers);
		int index = currentQustion.getIndex() - 1;
		currentQustion = examServiceImp.getQuestion(index);
		examFrame.updateView(examInfo, currentQustion);
	}
	public void submit() {
		int score = examServiceImp.examOver();
		examInfo.setScore(score);
		int var = JOptionPane.showConfirmDialog(examFrame, "score:" + score);
		if (var == JOptionPane.OK_OPTION) {
			examFrame.setVisible(false);
			menuFrame.setVisible(true);
		}
	}
	public void timerStart() {
		int minutes = examInfo.getTimeLimit();
		seconds = minutes * 60;
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				seconds--;
				int h = seconds / 3600;
				int m = seconds / 60 - h * 60;
				int s = seconds - h * 3600 - m * 60;
				examFrame.setTimeText(h, m, s);
			}
		}, 0, 1000);
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				submit();
				timer.cancel();
			}
		}, seconds * 1000);
	}
}

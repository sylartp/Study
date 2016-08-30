package com.huidao.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.management.RuntimeErrorException;

import com.huidao.entity.EntityContext;
import com.huidao.entity.ExamInfo;
import com.huidao.entity.Question;
import com.huidao.entity.QuestionInfo;
import com.huidao.entity.User;

public class ExamServiceImp implements ExamService{
		private  EntityContext context;
		//�Ծ�
		private List<QuestionInfo> paper = new ArrayList<>();
		//��½���û�
		
		private User loginUer;
		//����
		private int score;
		//�жϿ����Ƿ�ʼ
		private boolean isStarted = false;
		
		//�жϿ����Ƿ����
		private boolean isFinished = false;
		public ExamServiceImp(EntityContext context) {
			// TODO Auto-generated constructor stub
			this.context = context;
		}
		

	public boolean isFinished() {
			return isFinished;
		}


	@Override
	public User login(int id, String passWd) throws IdOrPwdException {
		// TODO Auto-generated method stub
		User user = context.findUserById(id);
		
		//�ж�user�Ƿ�Ϊnull��һ���쳣
		if(user==null){
			throw new IdOrPwdException("�û�������");
		}
		//����û����ڱȽ�ȡ���û�����������봫��������Ƿ����
		if(user.getPasswd().equals(passWd)){
			loginUer = user;
			return user;
		}
		throw new IdOrPwdException("�������");
		/*
		 * user.getpassWd.equals(passWd)��һ���쳣
		 */
		
	}
	//��ʼ����ҵ��
	@Override
	public ExamInfo start() {
		// TODO Auto-generated method stub
		if(isStarted){
			throw new RuntimeException("�����Ѿ���ʼ��");
		}
		if(isFinished){
			throw new RuntimeException("�����Ѿ�������");
		}
		createPaper();
		ExamInfo info = new ExamInfo();
		info.setTile(context.getPerTitle());
		info.setTimeLimit(context.getTimeLimit());
		info.setUser(loginUer);
		info.setQuestionCount(paper.size());
		
		isStarted = true;
		return info;
		
		
	}
	/*
	 * �����Ծ�Ĺ���:
	 * ��ÿ���Ѷȵ���Ŀ�����ȡ����������Ծ�.
	 */
	private void createPaper() {
		// TODO Auto-generated method stub
		Random  r = new Random();
		List<Question> list = null;
		int index = 0;
		for (int level = Question.LEVEL1; level <= Question.LEVEL10; level++) {
			list = context.getQuestions(level);
			int index1 = r.nextInt(list.size());
			//���ȡ������
			Question q1 = list.get(index1);
			int index2 = 0;
			while(index1==(index2=r.nextInt(list.size()))){
			}
			Question q2 = list.get(index2);
			paper.add(new QuestionInfo(q1,index++));
			paper.add(new QuestionInfo(q2,index++));
		}
	}

	@Override
	public QuestionInfo getQuestion(int index) {
		// TODO Auto-generated method stub
		return paper.get(index);
	}

	@Override
	public void saveUserAnswer(int index, List<Integer> userAnswers) {
		// TODO Auto-generated method stub
		QuestionInfo info = paper.get(index);
		info.getUserAnswers().clear();
		info.getUserAnswers().addAll(userAnswers);
	}

	@Override
	public int examOver() {
		// TODO Auto-generated method stub
		if(isFinished){
			throw new RuntimeException("�����ѽ���");
		}
		for (QuestionInfo q : paper) {
			Question question = q.getQuestion();
			List<Integer> userAnswers = q.getUserAnswers();
			if(userAnswers.equals(question.getAnswers())){
				
				score += question.getScore();
			}
		}
		
		isFinished = true;
		return score;
		
	}

	@Override
	public String getMsg() {
		// TODO Auto-generated method stub
		return context.getMsg();
	}



}

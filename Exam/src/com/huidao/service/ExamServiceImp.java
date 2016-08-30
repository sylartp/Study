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
		//试卷
		private List<QuestionInfo> paper = new ArrayList<>();
		//登陆的用户
		
		private User loginUer;
		//分数
		private int score;
		//判断考试是否开始
		private boolean isStarted = false;
		
		//判断考试是否结束
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
		
		//判断user是否为null抛一个异常
		if(user==null){
			throw new IdOrPwdException("用户不存在");
		}
		//如果用户存在比较取出用户对象的密码与传入的密码是否相等
		if(user.getPasswd().equals(passWd)){
			loginUer = user;
			return user;
		}
		throw new IdOrPwdException("密码错误");
		/*
		 * user.getpassWd.equals(passWd)跑一个异常
		 */
		
	}
	//开始考试业务
	@Override
	public ExamInfo start() {
		// TODO Auto-generated method stub
		if(isStarted){
			throw new RuntimeException("考试已经开始了");
		}
		if(isFinished){
			throw new RuntimeException("考试已经结束了");
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
	 * 创建试卷的规则:
	 * 从每个难度的题目里随机取两道题加入试卷.
	 */
	private void createPaper() {
		// TODO Auto-generated method stub
		Random  r = new Random();
		List<Question> list = null;
		int index = 0;
		for (int level = Question.LEVEL1; level <= Question.LEVEL10; level++) {
			list = context.getQuestions(level);
			int index1 = r.nextInt(list.size());
			//随机取两道题
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
			throw new RuntimeException("考试已结束");
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

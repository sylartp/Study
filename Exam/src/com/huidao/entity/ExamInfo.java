package com.huidao.entity;

public class ExamInfo {
	//���Կ�Ŀ
	private String title;
	//����
	private User user;
	//����ʱ��(����)
	private int timeLimit;
	//��Ŀ������
	private int questionCount;
	//����
	private int score;
	public ExamInfo(String tile, User user, int timeLimit, int questionCount, int score) {
		super();
		this.title = tile;
		this.user = user;
		this.timeLimit = timeLimit;
		this.questionCount = questionCount;
		this.score = score;
	}
	public ExamInfo() {
		super();
	}
	public String getTile() {
		return title;
	}
	public void setTile(String tile) {
		this.title = tile;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}
	public int getQuestionCount() {
		return questionCount;
	}
	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		if(user==null){
			return "����Ϣ";
		}
		return "����:"+user.getName()+"���:"+user.getId()+"����ʱ��:"+timeLimit+"����"+"���Կ�Ŀ:"+title+"��Ŀ����:"+questionCount;
	}
	
	
}

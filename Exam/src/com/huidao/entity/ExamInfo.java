package com.huidao.entity;

public class ExamInfo {
	//考试科目
	private String title;
	//考生
	private User user;
	//考试时间(分钟)
	private int timeLimit;
	//题目的数量
	private int questionCount;
	//分数
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
			return "无信息";
		}
		return "姓名:"+user.getName()+"编号:"+user.getId()+"考试时间:"+timeLimit+"分钟"+"考试科目:"+title+"题目数量:"+questionCount;
	}
	
	
}

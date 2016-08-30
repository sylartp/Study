package com.huidao.entity;

import java.util.ArrayList;
import java.util.List;

public class QuestionInfo {
	private Question question ;
	private int index;
	private boolean[] Selected ={false,false,false,false};
	//用户的答案
	List<Integer> userAnswers = new ArrayList<>();
	public QuestionInfo(Question question, int index, List<Integer> userAnswers) {
		super();
		this.question = question;
		this.index = index;
		this.userAnswers = userAnswers;
	}
	
	
	public boolean[] getSelected() {
		return Selected;
	}


	public void setSelected(boolean[] selected) {
		Selected = selected;
	}


	public QuestionInfo(Question question, int index) {
		super();
		this.question = question;
		this.index = index;
	}


	public QuestionInfo() {
		super();
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public List<Integer> getUserAnswers() {
		return userAnswers;
	}
	public void setUserAnswers(List<Integer> userAnswers) {
		this.userAnswers = userAnswers;
	}
	@Override
	public String toString() {
		return (index+1)+"."+question.toString();
	}
	
}

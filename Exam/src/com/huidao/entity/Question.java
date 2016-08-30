package com.huidao.entity;

import java.util.ArrayList;
import java.util.List;

public class Question {
	//单选多选
	public static final int SINGLE_SELECTION = 0;
	public static final int MULTI_SELECTION = 1;
	//题目等级
	public static final int LEVEL1 = 1;
	public static final int LEVEL2 = 2;
	public static final int LEVEL3 = 3;
	public static final int LEVEL4 = 4;
	public static final int LEVEL5 = 5;
	public static final int LEVEL6 = 6;
	public static final int LEVEL7 = 7;
	public static final int LEVEL8 = 8;
	public static final int LEVEL9 = 9;
	public static final int LEVEL10 = 10;
	private int id;
	//题干
	private String title;
	//选项
	private List<String> options = new ArrayList<>();
	//正确答案
	private List<Integer> answers = new ArrayList<>();
	private int score;
	//题目难度
	private int level;
	//0大表单选1代表多选
	private int type;
	public Question(int id, String title, List<String> options, List<Integer> answers, int score, int level, int type) {
		this.id = id;
		this.title = title;
		this.options = options;
		this.answers = answers;
		this.score = score;
		this.level = level;
		this.type = type;
	}
	public Question() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	public List<Integer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Integer> answers) {
		this.answers = answers;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(title+"\n");
		for (int i = 0; i < options.size(); i++) {
			sb.append((char)('A'+i)+"."+options.get(i)+"\n");
		}
		return sb.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answers == null) ? 0 : answers.hashCode());
		result = prime * result + id;
		result = prime * result + level;
		result = prime * result + ((options == null) ? 0 : options.hashCode());
		result = prime * result + score;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + type;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (answers == null) {
			if (other.answers != null)
				return false;
		} else if (!answers.equals(other.answers))
			return false;
		if (id != other.id)
			return false;
		if (level != other.level)
			return false;
		if (options == null) {
			if (other.options != null)
				return false;
		} else if (!options.equals(other.options))
			return false;
		if (score != other.score)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	
}

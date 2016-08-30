package com.huidao.service;

import java.util.List;

import com.huidao.entity.ExamInfo;
import com.huidao.entity.QuestionInfo;
import com.huidao.entity.User;

/**软件的核心功能，登陆，开始考试，结束考试。。。。。
 * @author Administrator
 *
 */
public interface ExamService {
	//登陆
	User login(int id,String passWd) throws IdOrPwdException;
	//考试开始
	ExamInfo start();
	
	void saveUserAnswer(int index,List<Integer> userAnswers);
	
	int examOver();
	
	String getMsg();
	
	QuestionInfo getQuestion(int index);
	
}

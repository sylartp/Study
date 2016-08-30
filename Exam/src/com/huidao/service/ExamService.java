package com.huidao.service;

import java.util.List;

import com.huidao.entity.ExamInfo;
import com.huidao.entity.QuestionInfo;
import com.huidao.entity.User;

/**����ĺ��Ĺ��ܣ���½����ʼ���ԣ��������ԡ���������
 * @author Administrator
 *
 */
public interface ExamService {
	//��½
	User login(int id,String passWd) throws IdOrPwdException;
	//���Կ�ʼ
	ExamInfo start();
	
	void saveUserAnswer(int index,List<Integer> userAnswers);
	
	int examOver();
	
	String getMsg();
	
	QuestionInfo getQuestion(int index);
	
}

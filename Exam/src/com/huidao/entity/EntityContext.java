package com.huidao.entity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import com.huidao.util.Config;

public class EntityContext {
	private Config config;

	public EntityContext(Config config) {
		// 加载配置文件
		this.config = config;
		// 加载用户信息
		loadUsers(config.getString("UserFile"));
		// 加载题库
		loadQuestions(config.getString("QuestionFile"));

	}
	private void loadQuestions(String fileName) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("#") || line.equals("")) {
					continue;
				}
				Question q = parseQuestion(line, br);
				addQuestion(q);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	private void addQuestion(Question q) {
		// TODO Auto-generated method stub
		/*
		 * List<Question> list = null; if(questions.get(q.getLevel())==null){
		 * list = new ArrayList<>();
		 * 
		 * questions.put(q.getLevel(), list); }
		 * questions.get(q.getLevel()).add(q);
		 */
		List<Question> list = questions.get(q.getLevel());
		if (list == null) {
			list = new ArrayList<>();
			// list.add(q);
			questions.put(q.getLevel(), list);
		} else {
			list.add(q);
		}
	}

	public List<Question> getQuestions(int level) {
		return questions.get(level);
	}
	public int getTimeLimit() {
		return config.getInt("Timelimit");
	}
	public String getPerTitle() {
		return config.getString("PaperTile");
	}
	public int getQuestionCount() {
		return config.getInt("QuestionNumber");
	}

	// @answer=2/3,score=5,level=5
	// {,3,5,5}
	private Question parseQuestion(String line, BufferedReader br) throws IOException {
		String data[] = line.split("[@,][a-z]+=");
		Question q = new Question();

		q.setAnswers(parseAnswers(data[1]));

		q.setScore(Integer.parseInt(data[2]));
		q.setLevel(Integer.valueOf(data[3]));
		q.setTitle(br.readLine());
		List<String> options = new ArrayList<>();
		options.add(br.readLine());
		options.add(br.readLine());
		options.add(br.readLine());
		options.add(br.readLine());
		q.setOptions(options);
		q.setType(q.getAnswers().size() == 1 ? Question.SINGLE_SELECTION : Question.MULTI_SELECTION);
		return q;
	}
	private List<Integer> parseAnswers(String string) {
		List<Integer> answers = new ArrayList<>();
		String[] str = string.split("/");
		for (String s : str) {
			answers.add(Integer.valueOf(s));
		}
		return answers;
	}
	// 所有用户信息e
	private Map<Integer, User> users = new HashMap<>();
	// 所有题目信息
	private Map<Integer, List<Question>> questions = new HashMap<>();

	private void loadUsers(String fileName) {
		try {
			// BufferedReader如果没有数据可读了会返回null
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			String line;
			while ((line = br.readLine()) != null) {
				// 去除两端空格
				line = line.trim();
				if (line.startsWith("#") || line.equals("")) {
					continue;
				}
				User user = parseUser(line);
				// 将用户信息对象加入集合
				users.put(user.getId(), user);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	private User parseUser(String line) {
		String[] data = line.split(":");
		User user = new User();
		user.setId(Integer.valueOf(data[0]));
		user.setName(data[1]);
		user.setPasswd(data[2]);
		user.setPhone(data[3]);
		user.setEmail(data[4]);
		return user;
	}
	public User findUserById(int id) {
		return users.get(id);
	}
	public String getMsg() {
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream(config.getString("ExramRule"))));
			String line;
			StringBuffer sb = new StringBuffer();
			while ((line = br.readLine()) != null) {
				line = line.trim();
				sb.append(line + "\n");
			}
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}

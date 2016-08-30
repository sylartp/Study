package com.huidao.test;

import java.util.Timer;
import java.util.TimerTask;

import com.huidao.entity.EntityContext;
import com.huidao.service.ExamServiceImp;
import com.huidao.ui.ClientContext;
import com.huidao.util.Config;

public class Main {
	public static void main(String[] args) {
		Config config = new Config("client.properties");
		EntityContext entityContext = new EntityContext(config);
		ExamServiceImp examServiceImp = new ExamServiceImp(entityContext);
		ClientContext clientContext = new ClientContext(examServiceImp);
		clientContext.show();
		
	}
}

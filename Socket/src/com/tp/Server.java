package com.tp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			ServerSocket serverSocket=new ServerSocket(8888);
			Socket socket=null;
			System.out.println("***�����������������ȴ��ͻ��˵�����***");
			while(true){
				socket=serverSocket.accept();
			//	System.out.println("���ӳɹ�");
				ServerThread serverThread=new ServerThread(socket);
				serverThread.start();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

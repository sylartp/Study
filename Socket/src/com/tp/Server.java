package com.tp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static boolean flag = true;

	public static void main(String[] args) {
		Socket socket = null;
		try {
			ServerSocket serverSocket = new ServerSocket(8888);
			System.out.println("***服务器即将启动，等待客户端的连接***");
			while (flag) {
				socket = serverSocket.accept();
				ServerThread serverThread = new ServerThread(socket);
				serverThread.start();
			}
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}


package com.tp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread {
	private Socket socket = null;
	Server server = null;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	@SuppressWarnings("static-access")
	public void run() {
		int info;
		char[] buffer = new char[8 * 1024];
		String b, c = null;
		InputStream is = null;
		InputStreamReader isr = null;
		OutputStream os = null;
		PrintStream ps = null;
		server = new Server();
		Scanner sc = new Scanner(System.in);
		try {
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			os = socket.getOutputStream();
			ps = new PrintStream(os);
			while ((info = isr.read(buffer, 0, buffer.length)) != -1) {
				String a = new String(buffer, 0, info);
				System.out.println("客户端说:" + a);
				c = a;
				break;
			}
			if (c.equals("bye")) {
				System.out.println("聊天结束！");
				server.flag = false;
				socket.close();
			} else {
				System.out.print("你说:");
				b = sc.nextLine();
				ps.println(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (isr != null) {
					isr.close();
				}
				if (os != null) {
					os.close();
				}
				if (is != null) {
					is.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}

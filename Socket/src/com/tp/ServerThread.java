package com.tp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread {
	private Socket socket = null;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	@SuppressWarnings("resource" )
	public void run(){
		int info;
		String b =null;
		char[] buffer = new char[8*1024];
		InputStream is=null;
		InputStreamReader isr=null;
		OutputStream os=null;
		PrintStream ps=null;
		Scanner sc = new Scanner(System.in);
		try {
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			os = socket.getOutputStream();
			ps = new PrintStream(os);
				while(( info = isr.read(buffer,0,buffer.length))!=-1){
					String a = new String(buffer,0,info);
					System.out.println("客户端说:"+a);
					break;
				}
			System.out.println("你说:");
			b = sc.nextLine();
			ps.println(b);
			ps.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}/*finally{
			if(b=="bye"){
				try {
				isr.close();
				is.close();
				ps.close();
				os.close();
				socket.close();
				server.flag =false;
				System.out.println("聊天结束");
			} catch (IOException e) {
				e.printStackTrace();
			}
				
			}
		}*/

	}
}
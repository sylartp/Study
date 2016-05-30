package com.tp;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int info;
		String a,b,c=null;
		boolean aa =true;
		Socket socket = null;
		OutputStream os =null;
		InputStream is =null;
		PrintStream ps =null;
		InputStreamReader isr = null;
		char[] buffer = new char[8*1024];
		Scanner sc = new Scanner(System.in);
		try {
			while(aa){
			socket=new Socket("localhost", 8888);
			os=socket.getOutputStream();
			ps = new PrintStream(os);
			is=socket.getInputStream();
			isr = new InputStreamReader(is);
			System.out.println("你说:");
			a =sc.nextLine();
			c=a;
			ps.print(a);
			ps.flush();
			while((info =isr .read(buffer,0,buffer.length))!=-1){
				b= new String(buffer, 0, info);
				System.out.println("服务器说:"+b);
				break;
			}
			/*if(c =="bye"){
				aa=false;
				break;
			}*/
		}
			socket.close();
			if(socket.isClosed()){
			System.out.println("聊天结束");
			}
		}catch (UnknownHostException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
	}
}
}
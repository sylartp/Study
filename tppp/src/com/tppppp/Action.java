package com.tppppp;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Action {
	List<String> l1 = new ArrayList<String>();
	int e,f,ff,t,g,p,m,i,j,k=0;
	float h;

	// BufferedInputStream a;
	public Action() throws IOException {    
		BufferedReader a = new BufferedReader(
				new InputStreamReader(
				new FileInputStream("Text/文档1.txt")));
		BufferedReader b = new BufferedReader(
				new InputStreamReader(
				new FileInputStream("Text/文档2.txt")));
		String aa = a.readLine();
		String bb = b.readLine();
		char[] c =aa.toCharArray();
		t=(bb.length())/10;
		 for (; i < bb.length(); i++) {		
			l1.add(i, bb.substring(p, p+10));
			char[] cc = l1.get(i).toCharArray();
			for(;j<10;j++)
			  for (; k < aa.length();k++) {
		         if (cc[j]== c[k]) {
		        	 m++;
					if(m==10){
						g++;
						break;
					}
				}
				else if(l1.get(i).charAt(m)!= c[k]){
					break;
				}
			}
			  p++;
			if ((bb.length() - p+1) == 10) {
				break ;
			} 
		}
		 for (String ssss : l1) {
				System.out.println(ssss);
			}
		 l1.clear();
		 System.out.println(g);
		 System.out.println(t);
		 float aaa=(float)g/t*100;
		  System.out.println("重复率为:"+aaa+"%");
		b.close();
		a.close();
	}

	public static void main(String[] args) throws IOException {
		Action action = new Action();
	}
}
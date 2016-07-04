package test;

import java.util.Scanner;
//  一个for循环创建正三角形
public class Show {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("输入三角形行数：");
		int n = scan.nextInt();
		int a =0,b=0;
		for(int i=0;i<n;i++){
			if(a!=n-i-1){
				System.out.print(" ");
				a++;
				i-=1;
			}else if(b!=2*i+1){
				System.out.print("*");
				b++;
				i-=1;
			}else{
				a=0;
				b=0;
				System.out.println();
			}
			
		}
	}

}

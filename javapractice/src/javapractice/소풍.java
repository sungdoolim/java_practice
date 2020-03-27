package javapractice;

import java.util.Scanner;

public class 소풍 {

//https://algospot.com/judge/problem/read/PICNIC
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int testcase=sc.nextInt();
	int student=0;
	int couple=0;
	int len=0;
	int [][]ar;
	int r;
	
	for(int i=0;i<testcase;i++) {
		r=0;
		
		ar=null;
		student=sc.nextInt();
		couple=sc.nextInt();
		len=2*couple;
		ar=new int[couple][];
		for(int j=0;j<couple;j++) {
			ar[j]=new int[2];
		for(int k=0;k<2;k++) {
		ar[j][k]=sc.nextInt();	
			}
		}
		
		for(int l=0;l<couple;l++) {
			for(int o=0;o<2;o++) {
				ar[l][o]=0;
			}
		}
		
		
		
		}
	
	
	}
}

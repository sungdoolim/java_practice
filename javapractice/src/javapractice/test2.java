package javapractice;

import java.util.Arrays;
import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		int t;
		int[]ar = new int[1000];
		int[]br = new int[101];
		int max=0;
		int index=0;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		t=sc.nextInt();
		
		for(int i=0;i<1000;i++) {
			ar[i]=sc.nextInt();
			
		}for(int k=0;k<=100;k++) {
			br[k]=0;
		}
		for(int i=0;i<1000;i++) {
			br[ar[i]]++;
		}max=0;
		for(int i=0;i<=100;i++) {
			if(max<br[i]) {
				max=br[i];
				index=i;
				}else if(max==br[i]) {
					if(index<i)
						index=i;
				}
		}
		
		
	
			
			System.out.println("#"+t+" "+index);
			

		}
	}

}

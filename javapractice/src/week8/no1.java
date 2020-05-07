package week8;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

//2015112120 임성두

public class no1 {

	public static void main(String[] args) {
	
		
		Scanner sc=new Scanner(System.in);
		String text="ekdmcljekdmco2015112120sungdoolim2015112120sungdoolim2sk2ekdm015sjwldcj12048ysungd20lf3iekdmc1lim92015112120sungdoolim2skekdefdmcdoo201dh11212cjndowkjdigjekdmckhsklikunklim";
		String pattern="2015112120sungdoolim2";
	
		//String pattern=sc.next();
		//String text=sc.next();
		int tl=text.length();
		int pl=pattern.length();
		
		
		
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		int index=bruteforce(text,pattern,tl,pl);
		System.out.println(index);//44나오면 됨
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long msecDiffTime = (afterTime - beforeTime); //두 시간에 차 계산

		System.out.println("\n\n brute force 걸린 시간 : "+msecDiffTime+"milliseconds\n");
		
		
		
		
		beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		int index2=rabinkarp(text,pattern,tl,pl);
		System.out.println(index2);
		 afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		 msecDiffTime = (afterTime - beforeTime); //두 시간에 차 계산

		 System.out.println("\n\n rabinkarf 걸린 시간 : "+msecDiffTime+"milliseconds\n");
		
		String s="abacaaba";
		int []t=maketable(s,	s.length());
		for(int i=0;i<t.length;i++) {
			System.out.print(t[i]+" ");
		}
		System.out.println("mt test ");
		
		
		beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		kmp(text,pattern,tl,pl);
		 afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		 msecDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
		
		 System.out.println("\n\n kmp 걸린 시간 : "+msecDiffTime+"milliseconds\n");
		
		
		
		
		System.out.println("\n");
		
	
		
	

	}
	
	static int bruteforce(String text,String pattern,int tl,int pl) {
		int count=0;
		int t;
		
		test: for(int i=0;i<tl;i++) {
			t=i;
			for(int j=0;j<pl;j++) {
				if(pattern.charAt(j)!=text.charAt(t)) {

					count=0;
					break;
				}count++;t++;
				if(count==pl) {
					System.out.println("bruteforce :"+i+"번째 인덱스에서 발견");
					count=0;
					continue test;
					//return i;
				}
			}
		}return 0;
	}
	
	
	
	static int rabinkarp(String text,String pattern,int tl,int pl) {

		int hashp=0;
		int [] hasht=new int[tl-pl+2];
		//System.out.println(tl-pl+2);
		int n;
		
		
		for(int i=0;i<pl;i++) {
			hashp+=(int) Math.pow((int)pattern.charAt(i),pl-i);
		}
		n=0;
		for(int j=0;j<pl;j++) {
			hasht[0]+=(int) Math.pow((int)text.charAt(j),pl-n);
			n++;
		}
		
		
	//	System.out.println(hashp);
		for(int i=1;i<tl-pl;i++) {
			n=0;
			for(int j=i;j<i+pl;j++) {
				hasht[i]+=(int) Math.pow((int)text.charAt(j),pl-n);
				n++;
			}
		//	System.out.println("\nhasht "+i+": "+hasht[i]);
		}
		System.out.println(hashp+","+hasht[98]);
		
		test: for(int i=0;i<tl-pl;i++) {
			
			if(hasht[i]==hashp) {
				//return i;

				//System.out.println("rabinkarf :"+i+"번째 인덱스에서 발견");
				for(int j=i;j<pl;j++) {
					
					if(pattern.charAt(j-i)!=text.charAt(j)) {
						continue test;
					}
				}

				System.out.println("rabinkarf :"+i+"번째 인덱스에서 발견");
				
			}
			
		}
		return 0;
		
	}
	static void kmp(String text,String pattern ,int tl,int pl) {
	/*	text="acacabacacabacadcac";
		pattern="acad";
		tl=text.length();
		pl=pattern.length();
		
		*/
		
		System.out.println("t1:"+tl+"pl:"+pl);
		int []pattern_table=maketable(pattern,pl);
		for(int i=0;i<pl;i++) {
			System.out.print(pattern_table[i]+" ");
		}System.out.println("mk 나옴");
		
		int i=0,j=0;
		while(j<=tl) {
		//	System.out.println(i+","+j);
	//	System.out.println(pattern.charAt(i)+","+text.charAt(j));
		
				while(j<=tl&pattern.charAt(i)!=text.charAt(j)) {
					if(i==0) {
						j++;
					//	System.out.println("j:"+j);
						if(j>=tl)
							return;
					}
					if(i-1>=0) {
					i=pattern_table[i-1];
				//	System.out.println("i"+i);
					}
					}
			//	System.out.println(i+","+j);
				//System.out.println(pattern.charAt(i)+","+text.charAt(j));
				i++;j++;
				if(i==pl) {

					System.out.println("index:"+(j-21));
				i=0;
				//System.out.println("b"+j);
				j=j-pl+2;
			//	System.out.println("A"+j);
				}
			}
		//	System.out.println("index:"+j);
		
		
		
		
		
		
		
	}
	static int[] maketable(String pattern,int pl) {
	//	int tl=text.length();
		int [] table=new int[pl];
		int i=0,j=1;
		while(true) {
			if(i<0) 
			{i=0;}
			if(j==pl||i==pl)
				break;
				if(pattern.charAt(i)==pattern.charAt(j)) {
					table[j]=i+1;
					i++;j++;
				}else {i=i-1;
				//System.out.println(i);
				if(i<0) {
					i=0;j++;
					continue;
				}
					do {
					//System.out.println("??");
						if(pattern.charAt(table[i])==pattern.charAt(j)) {
							table[j]=table[i]+1;				
							break;
						}else{
							i=table[i]-1;				
						}
					//	System.out.println(i);
					}while(i>0);			
				}
				//System.out.println(i+","+j+","+table[j]);
			}
		//System.out.println("return");
		return table;
	}

}

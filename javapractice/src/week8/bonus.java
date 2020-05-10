package week8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
//2015112120 임성두

public class bonus {

// 파일 생성하는 코드를 밑에 주석 처리했고, 만든 파일을 주석처리하여 작성하고 싶었지만 너무 큰 문자열이고, 
	//이클립스 문제인지 붙여넣기가 안되어 파일을 첨부했습니다. 양해 부탁드립니다.
	//1000만 의 문자이상은 제가 파일을 여는때에도 문제가 생기기에 100만까지만 만들었습니다.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String d;
int a;
String text="";
		String l;
		 PrintWriter pw;
	/*	try {
			pw = new PrintWriter("C:/Users/bohee/Desktop/a.txt");
			  for(int i=1; i<100000000; i++) {
		         
		            a= (int) (Math.random()*10);
		         
		            pw.print(a);
		        }
		        pw.close();
		        //
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/ 

	      
		  BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("C:/Users/bohee/Desktop/a.txt"));
			 while(true) {
				 l=br.readLine();
		            
		             text +=l;
		            		 
		             if (l==null) break;
		           
		        }
		        br.close();
			
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
		
		
		
		
		//System.out.println("\n"+text+"\n");

		//String pattern="6855022210";
		//String pattern="685502221043568";
		//String pattern="68550222104356834890";
		//String pattern="6855022210435683489024598";
		String pattern="685502221043568348902459822168";
		int tl=text.length();
		int pl=pattern.length();
		
		//System.out.println(tl);
		System.out.println(pl);
		

		int hashp=makehash2(text, pattern, tl,pl);
		double []hashtable=makehash(text, pattern, tl, pl,hashp);
		 int [] pattern_table=maketable(pattern, pl);
		// 위 3개의 메서드는 시간이 걸립니다.
		 
		 
		 
		 
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		bruteforce(text,pattern,tl,pl);
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long msecDiffTime = (afterTime - beforeTime); //두 시간에 차 계산

		System.out.println("brute force 걸린 시간 : "+msecDiffTime+"milliseconds\n");

		beforeTime = System.currentTimeMillis(); 
		rabinkarp(text,pattern,tl,pl,hashtable,hashp);
		 afterTime = System.currentTimeMillis();
		 msecDiffTime = (afterTime - beforeTime);
		 System.out.println("rabinkarf 걸린 시간 : "+msecDiffTime+"milliseconds\n");
		

		beforeTime = System.currentTimeMillis(); 
		kmp(text,pattern,tl,pl,pattern_table);
		 afterTime = System.currentTimeMillis();
		 msecDiffTime = (afterTime - beforeTime);
		
		 System.out.println("kmp 걸린 시간 : "+msecDiffTime+"milliseconds\n");
		
		
		
		
		System.out.println("\n");	
	}
	
	
	

	static int bruteforce(String text,String pattern,int tl,int pl) {
		int count=0;
		int t;
		
		test: for(int i=0;i<=tl-pl;i++) {
			t=i;
			for(int j=0;j<pl;j++) {
		//		System.out.println(i+","+j);
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
	static int makehash2(String text,String pattern,int tl,int pl) {
		int hashp=0;	
		int mod=97;
		double k=Math.pow(2,pl-1);
			for(int j=0;j<pl;j++) {
					hashp+=(pattern.charAt(j)* k);
					k/=2;
					}
				hashp%=mod;	
			return hashp;
			
	}
	static double[] makehash(String text,String pattern,int tl,int pl,int hashp) {
	//	int hashp=0;
		int t_p=tl-pl;
		double [] hasht=new double[t_p+2];
		double b=0;
		int mod=97;
		for(int i=0;i<=t_p;i++) {
			if(i==0) {
				double k=Math.pow(2,pl-1);
					for(int j=0;j<pl;j++) {
					hasht[0]+=(text.charAt(j)* k);
					k/=2;
					}
				hasht[0]%=mod;
				continue;
			}
					b=(text.charAt(i-1)* Math.pow(2,pl-1))%mod;
					hasht[i]=((hasht[i-1]-b)*2)%mod+text.charAt(i+pl-1)%mod;
					if(hasht[i]>=mod)
						{hasht[i]%=mod;}
					else if(hasht[i]<0)
						{hasht[i]+=mod;}
		}
		return hasht;
	}
	
	static int rabinkarp(String text,String pattern,int tl,int pl,double[] hasht,int hashp) {
		int t_p=tl-pl;	
	for(int i=0;i<=t_p;i++) {
				if(hasht[i]==hashp) {
					for(int j=i;j<i+pl;j++) {
						if(pattern.charAt(j-i)!=text.charAt(j)) {
							break;
						}else if(j==i+pl-1){
								System.out.println("rabinkarf :"+i+"번째 인덱스에서 발견");
								break;}	
				}
			}
		} 
		return 0;
	}
	
	
	
	static void kmp(String text,String pattern ,int tl,int pl,int[] pattern_table) {				
		int i=0,j=0;
		while(j<tl) {		
				while(j<tl&&pattern.charAt(i)!=text.charAt(j)) {
					if(i>0) {
						i=pattern_table[i-1];
						}else {
						j++;
					}
					 
				}
				
				i++;j++;
				if(i==pl) {
					System.out.println("kmp :"+(j-pl)+"번째 인덱스에서 발견");
				i=0;
				j=j-pl+2;
				}
			}		
	}
	static int[] maketable(String pattern,int pl) {

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

				if(i<0) {
					i=0;j++;
					continue;
				}
					do {
						if(pattern.charAt(table[i])==pattern.charAt(j)) {
							table[j]=table[i]+1;				
							break;
						}else{
							i=table[i]-1;				
						}
					}while(i>0);			
				}
			}
		return table;
	}

}

package week9;
//2015112120 임성두
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class trivial2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		String ref ="agctaagtccgtagctttgccgacgtcagcaaacgttcagggctcttgacaaccttgtctagcgatagcctagc";
		String ref2 ="agctaagtccgtagctttgccgacgtcagcaaacgttcagggctcttgacaaccttgtctagcgatagcctagc";
		ref=ref.toUpperCase();
		ref2=ref2.toUpperCase();
		char[]dna= {'A','G','C','T'};		
		StringBuilder strref=new StringBuilder(ref);
				System.out.println(strref.length());
				long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기				
				Scanner sc=new Scanner(System.in);
				int k=sc.nextInt();
				int n=sc.nextInt();
				double y=sc.nextDouble();
			System.out.println(strref);
			String []shortread=makeShortread(strref, k, n,10,dna);
			System.out.println(strref);
			System.out.println(ref);
			double count=0;
			for(int i=0;i<ref.length();i++) {
				if(ref.charAt(i)!=strref.charAt(i)){
					count++;
				}
			}System.out.println(count+"개의 불일치");
				
				

			try {	
				  PrintWriter pw;
						pw = new PrintWriter("C:/Users/bohee/Desktop/pracshort.txt");
						for(int i=0;i<shortread.length;i++) {
						pw.println(shortread[i]);}
					        pw.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}

		      
			  BufferedReader br;
				try {
					String str;
					br = new BufferedReader(new FileReader("C:/Users/bohee/Desktop/pracshort.txt"));
					int i=0;
					while(true) {
						 str=br.readLine();	
						 if(str==null)
							 break;
						 
						// System.out.println(str);
				shortread[i]=str;i++;
					}br.close();
					System.out.println("반복문 끝");
					for(int j=0;j<shortread.length;j++) {
						System.out.println(shortread[j]);
					} 
				} catch ( IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("short생성 끝");
			
				
				strref=new StringBuilder(ref2);
			
			StringBuilder mydna=makeMyDna(strref,k,n,y,dna,shortread);
		//	System.out.println(ref);
		//	System.out.println(mydna);
			 count=0;
			for(int i=0;i<ref.length();i++) {
				if(ref.charAt(i)!=mydna.charAt(i)){
					count++;
				}
			}System.out.println(count+"개의 불일치");
				
				

				//System.out.println(ref);
				//System.out.println(mydna);
				try {	
					  PrintWriter pw;
							pw = new PrintWriter("C:/Users/bohee/Desktop/pracoutput.txt");
				            pw.print(mydna);
						    pw.close();
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}

				long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
				double ra=(count/74)*100;
				System.out.println("오차율 : "+ra+"입니다");
				long msecDiffTime = (afterTime - beforeTime); //두 시간에 차 계산

		
				sc.close();
	}
	static StringBuilder makeMyDna(StringBuilder ref,int k,int n,double y,char[] dna,String[]shortread) {
		int indexcount=0;
		int count=0;
		boolean countb=false;
		//int stindex=0;
		int tmp;
		int [][]store=new int[(int)y][2];
		for(int stindex=0;stindex<n;stindex++) {
		for(int v=0;v<=ref.length()-k+1;v++) {
			
			tmp=v;
			countb=true;
			count=0;
			for(int stl=0;stl<k;stl++,tmp++) {
				if(shortread[stindex].charAt(stl)!=ref.charAt(tmp)) {

					count++;
					if(count>y) {
						
						countb=false;
						break;
					}
					store[count-1][0]=stl;
					store[count-1][1]=tmp;
					
				}
			}
			if(countb) {
				for(int i=0;i<count;i++)
				{//System.out.println(store[i][1]+","+store[i][0]);
					ref.setCharAt(store[i][1], shortread[stindex].charAt(store[i][0]));}
				break;
				
			}
		}
		
		
		}
	
		return ref;
		
	}
	static String[] makeShortread(StringBuilder ref,int k,int n,double y,char[] dna) {
	
		int rl=ref.length();
		
		int ratio=(int)(rl*(y/100));System.out.println(ratio);
		int tmp2;
		
		
		ArrayList<Integer>a=new ArrayList<>();
		for(int i=0;i<ratio;i++) {
			tmp2=(int)(Math.random()*rl);
			while(a.contains(tmp2)) {
				tmp2=(int)(Math.random()*rl);
			}a.add(tmp2);
			
		}
	
		char t;
		char diff;
		for(int i=0;i<ratio;i++) {
			t=ref.charAt(a.get(i));
			diff=dna[(int)(Math.random()*4)];
			while(t==diff) {
				diff=dna[(int)(Math.random()*4)];
			}
			//System.out.println(a.get(i)+": "+t+","+diff);
		ref.setCharAt(a.get(i),diff);// 이 ref는 x%다른 mydna입니다.
		}//System.out.println(ref);
		
		int l=rl-k;
		String [] shortread=new String[n];
		int randomtmp;		
		for(int i=0;i<n;i++){
			randomtmp=(int)(Math.random()*l);
			//System.out.println(randomtmp);
			shortread[i]=ref.substring(randomtmp, randomtmp+k);
			
		}

		try {	
			  PrintWriter pw;
					pw = new PrintWriter("C:/Users/bohee/Desktop/mydna2.txt");
					
					pw.print(ref);
				        pw.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
return shortread;		
		
	}

}

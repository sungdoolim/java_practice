package week9;
//2015112120 임성두
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class trivial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		String ref ="";
	
		char[]dna= {'A','G','C','T'};
				/*try {	
			  PrintWriter pw;
					pw = new PrintWriter("C:/Users/bohee/Desktop/input.txt");
					
					int a=5;
					int c=0;
					int count=0;
					  for(int i=0; i<500000; i++) {
				         
				    //두번의 중복은 허용 합니다
				    //즉 같은 값이 3번 나올수 있습니다.
				    //aagggt 처럼 g가 3번까지 반복이 가능하며
				    // 4개이상 반복되어 나올수 없는 것 입니다.
				          
				            c= (int) (Math.random()*4);
				            if(a==c) {// 바로 직전의 값과 같다면 중복되므로 count를 올려줄지 중복을 제거 할지 결정합니다.
				            	if(count>=2) {
				            		//중복count가 이미 2라면 , 즉 중복으로 3번 나온 후 4번째 같은 값이 나오게 되면 값을 바꿉니다.
				            		while(a==c) {
				            			c= (int) (Math.random()*4);
				            		}count=0;// 값을 바꾸고 나면 count를 초기화 합니다.
				            	}
				            	else {
				            	count++;// 전 값에 동일하게 중복되고, 아직 중복된 값이 3개 이하 일때는 중복을 허용하고 count를 올립니다.
				            	}
				            }
				            a=c;          
				            pw.print(dna[a]);
				        }
				        pw.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
*/
			      
				  BufferedReader br;
				try {
					br = new BufferedReader(new FileReader("C:/Users/bohee/Desktop/input.txt"));
						 ref=br.readLine();				            			         		 	        
				         br.close();
					
				} catch ( IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
		StringBuilder strref=new StringBuilder(ref);

		StringBuilder strref2=new StringBuilder(ref);
			//	System.out.println(strref.length());
				Scanner sc=new Scanner(System.in);
				int k=sc.nextInt();
				int n=sc.nextInt();
				double y=sc.nextDouble();
			//	double x=sc.nextDouble();
				
		/*	String []shortread=makeShortread(strref, k, n,10,dna);
		//	System.out.println(strref);
			try {	
				  PrintWriter pw;
						pw = new PrintWriter("C:/Users/bohee/Desktop/shortread.txt");
						for(int i=0;i<shortread.length;i++) {
						pw.println(shortread[i]);}
					        pw.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
			*/
			String []shortread = new String[n];
			 
				try {
					String str;
					br = new BufferedReader(new FileReader("C:/Users/bohee/Desktop/shortread.txt"));
					int i=0;
					while(true) {
						 str=br.readLine();	
						 if(str==null)
							 break;
						 
						// System.out.println(str);
				shortread[i]=str;i++;
					}br.close();
					System.out.println("반복문 끝");
					//for(int j=0;j<shortread.length;j++) {
					//	System.out.println(shortread[j]);
				//	}
				} catch ( IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String str = null;
				try {
					br = new BufferedReader(new FileReader("C:/Users/bohee/Desktop/mydna.txt"));
			
						 str=br.readLine();	
			br.close();
	
				} catch ( IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				double count=0;
				for(int i=0;i<ref.length();i++) {
					if(str.charAt(i)!=ref.charAt(i)){
						count++;
					}
				}

				double ra=(count/500000)*100;
				System.out.println("ref / my "+count+"개의 불일치");
				 ra=(count/500000)*100;
				System.out.println("ref/ my  오차율 : "+ra+"입니다");
		
				
				
				
				

				long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기			
			
			StringBuilder mydna=makeMyDna(strref2,k,n,y,dna,shortread);
		//	System.out.println(ref);
		//	System.out.println(mydna);
			long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
			long msecDiffTime = (afterTime - beforeTime); //두 시간에 차 계산

			System.out.println(msecDiffTime/1000+"초의 시간이 걸렸습니다.");
	
			
			
			
			
			count=0;
			beforeTime=System.currentTimeMillis();
			for(int i=0;i<ref.length();i++) {
				if(ref.charAt(i)!=mydna.charAt(i)){
					count++;
				}
			}System.out.println(" dna는 ref와 "+count+"개의 불일치");
				
				

				//System.out.println(ref);
				//System.out.println(mydna);
				try {	
					  PrintWriter pw;
							pw = new PrintWriter("C:/Users/bohee/Desktop/output.txt");
				            pw.print(mydna);
						    pw.close();
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}

				 afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
				ra=(count/500000)*100;
				System.out.println("ref와의 오차율 : "+ra+"입니다");
				 msecDiffTime = (afterTime - beforeTime); //두 시간에 차 계산

				System.out.println(msecDiffTime/1000+"초의 시간이 걸렸습니다.");

			
				
				 count=0;
				beforeTime=System.currentTimeMillis();
				for(int i=0;i<ref.length();i++) {
					if(str.charAt(i)!=mydna.charAt(i)){
						count++;
					}
				}System.out.println("복구한 dna는 mydna와 "+count+"개의 불일치");
				 ra=(count/500000)*100;
				System.out.println("mydna와의 오차율 : "+ra+"입니다");
		
				sc.close();
				
				
			
				
				
	}
	static StringBuilder makeMyDna(StringBuilder ref,int k,int n,double y,char[] dna,String[]shortread) {
		//int indexcount=0;
		int count=0;
	//	boolean countb=false;
		//int stindex=0;
		int tmp;
		//int rl=ref.length();
		int rlt=ref.length()-k+1;
		int [][]store=new int[(int)y][2];
		for(int stindex=0;stindex<n;stindex++) {
			if(stindex%2000==0) {System.out.println(stindex);}
		test:for(int v=0;v<=rlt;v++) {
			
			tmp=v;
			//countb=true;
			count=0;
			for(int stl=0;stl<k;stl++,tmp++) {
				if(shortread[stindex].charAt(stl)!=ref.charAt(tmp)) {
					count++;
					if(count>y) {
						continue test;
					}
					store[count-1][0]=stl;
					store[count-1][1]=tmp;
				}
			}

				for(int i=0;i<count;i++)
				{//System.out.println(store[i][1]+","+store[i][0]);
					ref.setCharAt(store[i][1], shortread[stindex].charAt(store[i][0]));}
				break;
			}
		}
	
		return ref;
		
	}
	static String[] makeShortread(StringBuilder ref,int k,int n,double x,char[] dna) {
	
		int rl=ref.length();
		
		int ratio=(int)(rl*(x/100));
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
					pw = new PrintWriter("C:/Users/bohee/Desktop/mydna.txt");
					
					pw.print(ref);
				        pw.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
return shortread;		
		
	}

}

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
	
		String ref ="agctaagtccgtagctttgccgacgtcagcaaacgttcagggctcttgacaaccttgtctagcgatagcctagc";
		ref=ref.toUpperCase();
		char[]dna= {'A','G','C','T'};
			/*	try {	
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
				ref=ref.toUpperCase();
				
				
		StringBuilder strref=new StringBuilder(ref);
				System.out.println(strref.length());
				long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기				
				Scanner sc=new Scanner(System.in);
				int k=sc.nextInt();
				int n=sc.nextInt();
				int y=sc.nextInt();
			///String []shortread=makeShortread(strref, k, n,y,dna);
			System.out.println(strref);
			/*try {	
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
					for(int j=0;j<shortread.length;j++) {
						System.out.println(shortread[j]);
					}
				} catch ( IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			
			
			StringBuilder mydna=makeMyDna(strref,k,n,y,dna,shortread);
		//	System.out.println(ref);
		//	System.out.println(mydna);
			double count=0;
			for(int i=0;i<ref.length();i++) {
				if(ref.charAt(i)!=mydna.charAt(i)){
					count++;
				}
			}System.out.println(count+"개의 불일치");
				
				

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

				long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
				double ra=(count/500000)*100;
				System.out.println("오차율 : "+ra+"입니다");
				long msecDiffTime = (afterTime - beforeTime); //두 시간에 차 계산

		
				sc.close();
	}
	/*static StringBuilder makeMyDna(StringBuilder ref,int k,int n,int y,char[] dna,String[]shortread) {
		int indexcount=0;
		int count=0;
		boolean countb=false;
		//int stindex=0;
		int tmp;
		int [][]store=new int[y][2];
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
	static String[] makeShortread(StringBuilder ref,int k,int n,int y,char[] dna) {
	//int l=500000-k;
		int l=ref.length()-k;
		String [] shortread=new String[n];
		StringBuilder strtmp;	
		int randomtmp;
		int yindex;
		int tmp = 0;
		for(int i=0;i<n;i++){
			randomtmp=(int)(Math.random()*l);
			//System.out.println(randomtmp);
			shortread[i]="";
			for(int j=0;j<k;j++) {
				shortread[i]+=ref.charAt(randomtmp+j);
			}
			
			//System.out.println(shortread[i]);
			strtmp=new StringBuilder(shortread[i]);
			//1System.out.println("builder : "+strtmp);
			for(int m=0;m<y;m++) {
				yindex=(int)(Math.random()*k);
				//System.out.println("여기 바꾸자  : "+yindex);
				while(dna[tmp]==shortread[i].charAt(yindex)) {
				tmp=(int)(Math.random()*4);
				}
				strtmp.setCharAt(yindex, dna[tmp]);
				shortread[i]=strtmp.toString();
				for(int q=0;q<k;q++) {
				ref.setCharAt(randomtmp+q, shortread[i].charAt(q));
				}
			//	System.out.println("바뀐 값 :"+shortread[i]);
			}
			
		}
		// 지금은 최소 0자리, 최대 3자리가 다를 수 있습니다.(랜덤으로 하기에 확률 적으로 최소보다는 최대가 나올 확률이 높습니다.)
		
		//System.out.println();
		for(int i=0;i<n;i++) {
		//	System.out.println(shortread[i]);
		}
		return shortread;
		
	}*/
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
		
		int ratio=(int)(rl*(y/100));
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
		StringBuilder strtmp;	
		int randomtmp;
		int yindex;
		int tmp = 0;
		
		for(int i=0;i<n;i++){
			randomtmp=(int)(Math.random()*l);
			//System.out.println(randomtmp);
			shortread[i]=ref.substring(randomtmp, randomtmp+k);
			
		}
		
		//System.out.println(ref);
		
return shortread;		
		
	}

}

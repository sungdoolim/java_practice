import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class prj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ref=null;
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
			System.out.println(strref.length());
			Scanner sc=new Scanner(System.in);
			double k=sc.nextInt();
			int n=sc.nextInt();
			double y=sc.nextInt();
			char []dna= {'A','G','C','T'};
			long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		
			String []shortread=makeShortread(strref, k, n,y,dna);
			sc.close();
			
			StringBuilder mydna=makeMyDna(strref,k,n,y,dna,shortread);
			
			
			long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
			long msecDiffTime = (afterTime - beforeTime); //두 시간에 차 계산

			System.out.println(msecDiffTime+"초");
	}
	
	 static StringBuilder makeMyDna(StringBuilder ref,double k,int n,double y,char[] dna,String[]shortread) {

		 double gap=k/(y+1);
		 double ggap= Math.ceil(gap);
		 StringBuilder[][] strb=new StringBuilder[n][(int)Math.ceil(k/ggap)];
		

		 
		 
		 
		 
		 return ref;

		 
	}
	 
	 
	 static String[] makeShortread(StringBuilder ref,double k,int n,double y,char[] dna) {
			//int l=500000-k;
				double l=ref.length()-k;
				String [] shortread=new String[n];
				StringBuilder strtmp;	
				int randomtmp;
				int yindex;
				int tmp = 0;
				for(int i=0;i<n;i++){
					randomtmp=(int)(Math.random()*l);
					System.out.println(randomtmp);
					shortread[i]="";
					for(int j=0;j<k;j++) {
						shortread[i]+=ref.charAt(randomtmp+j);
					}
					
					System.out.println(shortread[i]);
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
				
				System.out.println();
				for(int i=0;i<n;i++) {
					System.out.println(shortread[i]);
				}
				return shortread;
				
			}
	
	
	
	
	

}

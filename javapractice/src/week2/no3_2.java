//2015112120 임성두
package week2;

public class no3_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        
		/*
		int []N=new int[10];
		for(int i=0;i<10;i++) {
			
			N[i]=(int)(Math.random()*10000)+1;// 랜덤으로 수 배정
			System.out.print(N[i]+" ");
		}
		bubble(N,N.length);
		System.out.println("\n--------------------");
		for(int i=0;i<10;i++) {
			System.out.print(N[i]+" ");
		}
		*/
		int []K=new int[1000];
		for(int i=0;i<1000;i++) {
			K[i]=(int)(Math.random()*10000)+1;// 랜덤으로 수 배정
			System.out.print(K[i]+" ");
		}
		bubble(K,K.length);
		
		System.out.println("\n--------------------------------------");
		for(int i=0;i<1000;i++) {
			System.out.print(K[i]+" ");
		}// 1000을 동적할당한 K 배열에 관한 코드 입니다.
		

	
	}
	static void bubble(int[] N,int len) {
		boolean b=true;
		int tmp=0;
		for(int i=0;i<len-1;i++) {
			if(N[i]<N[i+1]) {
				b=false;
				tmp=N[i];
				N[i]=N[i+1];
				N[i+1]=tmp;
			}
		}if(!b) {// 바로 옆 값과 비교해서 한번이라도 교환 되면 b=false이므로 다시 재귀적으로 정렬 시도합니다
			
			bubble(N,len);
		}

	}

}

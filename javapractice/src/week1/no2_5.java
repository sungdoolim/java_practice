

//2015112120 임성두
package week1;
import java.util.Scanner;
public class no2_5 {

	static int []remethodM=new int[100];// 0으로 초기화가 됩니다.
	static Scanner sc=new Scanner(System.in);// 코인 배열 크기를 먼저 입력받습니다.

	static int d=sc.nextInt();
	public static void main(String[] args) {


		int []c=new int[d];
		
		for(int i=0;i<c.length;i++) {
				c[i]=sc.nextInt();// 코인의 종류를 입력 받습니다.
			}
		int different=0;
		for(int M=0;M<100;M++) {
		int GreedyResult=GreedyBetterChange(M,c,d);
		int BruteFoceResult=bruteforce(M,c, d);
		remethodM[M]=BruteFoceResult;
		
		if(GreedyResult!=BruteFoceResult) {
			different++;
			
		//System.out.print(M+": "+GreedyResult+", ");
		//System.out.println(BruteFoceResult);
		// 틀린 M의 목록입니다.
		}
	  }System.out.println("틀린 갯수 : "+different);
		
	}
	
	public static int GreedyBetterChange(int M,int []c,int d) {
		if(M==0)
			return 0;

		for(int i=0;i<d;i++) {
			if(M>=c[i]) {
				return GreedyBetterChange(M-c[i], c, d)+1;
			}
		}
		return 1;

	}
		
	
	public static int bruteforce(int M,int[]c,int d) {
		if(M==0) {
			return 0;
		}
		else if(remethodM[M]!=0) {
			return remethodM[M];
		}
		// M이 1~100까지에 대하여 반복적으로 수행하는 때가 굉장히 많습니다.
		// 따라서 main함수에서 remethodM에 M에 접근할때 값을 저장하고
		// 중복된 M에 해단 메서드 요청시 배열에 있는 값을 리턴합니다.
		// 이로 인한 실행 시간 단축이 가능 합니다.
		
		int result=1000;// 임의로 상대적으로 큰수르 지정했습니다.
		for(int i=0;i<d;i++) {
			if(M>=c[i]) {
				int brut=bruteforce(M-c[i],c,d)+1; 
				// 현재 인덱스 i 에 해당하는 c[i]의 값보다 M이 크면 M-c[i]를 하고 재귀함수를 호출합니다
				// +1은 사용한 코인의 수를 증가 시키는 것 입니다.
				if(result>brut)
					result=brut;
			}
		}// for 문이 끝나면 위 if 문에서 result의 최솟값을 찾게 됩니다.
return result;
	}
}

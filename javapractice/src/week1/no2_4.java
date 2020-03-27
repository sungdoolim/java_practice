
//2015112120 임성두
package week1;
import java.util.Scanner;

public class no2_4{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int M=40;
		int d=sc.nextInt();// 코인의 종류의 수를 입력받습니다
		int []c= new int[d];
		for(int i=0;i<d;i++) {// 코인의 종류를 입력받습니다
			c[i]=sc.nextInt();
		}
	
		System.out.println(bruteforce(M, c, d));
	}
	public static int bruteforce(int M,int[]c,int d) {
		if(M==0) {
			return 0;
		}
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

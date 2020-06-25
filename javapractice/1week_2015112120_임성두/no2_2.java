
//2015112120 임성두
package week1;

import java.util.Scanner;

public class no2_2{
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int d=sc.nextInt();// 배열의 크기를 입력받습니다
		int M=40;
		
		int []c=new int[d];
		for(int i=0;i<d;i++) {
			c[i]=sc.nextInt(); // 코인의 종류를 입력 받습니다. 이때 정렬됨을 전제로 합니다
		}
		System.out.println(greedy(40,c,d));
	}
	
public static int greedy(int M,int []c, int d) {
		if(M==0)
			return 0;
		for(int i=0;i<d;i++) {
			if(M>=c[i]) {
				return greedy(M-c[i], c, d)+1;
				// 정렬된 배열중에 최댓값부터 빼가면서 계산하기에, 바로 return을 할수 있습니다.
				//M에서 코인의 최대값부터 뺄수 있는지 확인후 빼고 다시 greedy메서드를 재귀적으로 호출합니다.
				// 코인을 사용한 수를 측정하기 위해 +1을 한것 입니다.
			}
		}
		return 1;
	}
}

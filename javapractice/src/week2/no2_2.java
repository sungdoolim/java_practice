//2015112120 임성두

package week2;

import java.util.Scanner;

public class no2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int a,b;
		a=sc.nextInt();b=sc.nextInt();
		System.out.println(gcd(a,b));// 두 수를 입력받아 메서드를 실행합니다

	}
	static int gcd(int a, int b) {
		 // 한 쪽이 0 이되면 0이 아닌 쪽이 최대 공약수 입니다
		if(a!=0&&b==0) {
			return a;
		}else if(a==0&&b!=0) {
			return b;
		}
		else if(a>b) {
			return gcd(b,a%b);
		}else {
			return gcd(a,b%a);
		}
		// 두 수중 큰쪽은 작은 수로 나누어 재귀함수를 호출합니다.
		
	}// 유클리드 호제법을 참고 했습니다. 
}

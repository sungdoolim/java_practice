//2015112120 임성두
package week2;

import java.util.Scanner;

public class no2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		int a,b;
		a=sc.nextInt();b=sc.nextInt();
		System.out.println(gcd(a,b));
		// 두수를 입력받아 메서드를 실행합니다
	}
	static int gcd(int a, int b) {
	
		int t=0;
		while(a!=0&&b!=0) {// 하나의 수가 0이 될 때까지 실행합니다.
			if(a>b) {
				t=a%b;
				a=t;
			}else {
				t=b%a;
				b=t;
			}
		}
		if(a!=0)return a;
		else return b;
		//두수중에 큰값을 작은 값으로 나눈 수를 t 에 저장하고 a,b중 큰값에 t를 대입합니다.
		// 그후 한쪽이 0 이 됬을 때 0이 아닌 수가 바로 최대 공약수입니다.
		// 이는 유클리드 호제법을 참고했습니다.

		
	}

}

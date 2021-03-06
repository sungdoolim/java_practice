//2015112120 임성두
package week2;

import java.util.Scanner;

public class no2_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int []ar=new int[n];// 입력받을 수의 갯수를 먼저 입력 받아 배열을 동적 할당 합니다
		for(int i=0;i<n;i++) {
			ar[i]=sc.nextInt();// 수를 입력받습니다
			}
		int len=ar.length;
		System.out.println(gcdar(ar,0,len));
		
	}
	static int gcdar(int []ar,int index,int len) {
		
		if(index==len-1) {// 인덱스가 len-1과 같다면 배열의 맨 마지막 값이므로 리턴합니다
			return ar[index];
		}
		
		return gcd(ar[index],gcdar(ar,index+1,len));
		// 예를 들면 gcd(0,gcdar(1,5)) -> gcd(0,gcd(1,gcdar(2,5))).....
		// 마침내는 gcd(0,gcd(1,gcd(2,gcd(3,gcd(4,gcd(5)))))))
	    // 즉 마침내는 모든 인덱스와 gcd 연산을 하게 됩니다.
	}
static int gcd(int a, int b) {
		
		if(a!=0&&b==0) {
			return a;
		}else if(a==0&&b!=0) {
			return b;
		}// 한 쪽이 0 이되면 0이 아닌 쪽이 최대 공약수 입니다
		else if(a>b) {
			return gcd(b,a%b);
		}else {
			return gcd(a,b%a);
		}
		// 두 수중 큰쪽은 작은 수로 나누어 재귀함수를 호출합니다.
		// 유클리드 호제법을 참고 했습니다. 
	}
}

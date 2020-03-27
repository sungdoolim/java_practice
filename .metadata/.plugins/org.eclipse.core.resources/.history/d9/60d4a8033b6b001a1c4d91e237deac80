

/*
유사코드
ar(A,n)
for (i=0;i<n;i++){
ar[i]<-user_input
}
sum=0
for (i=0;i<n;i++){
sum+=ar[i]
print(sum/(i+1))
}



 */
//2015112120 임성두
package week1;
import java.util.Scanner;
public class no1 {

	public static void main(String[] args) {
		System.out.println("배열을 입력해 주세요 : ");
		Scanner sc=new Scanner(System.in);
		int i=0;
		int []ar=new int[10];// 배열 크기를 10 으로 제한했습니다. 
		for(;i<10;i++) {
			ar[i]=sc.nextInt();
			if(ar[i]==0) {// 0을 입력시 배열입력을 더이상 받지 않습니다.
				break;}
		}
		
		System.out.println("Avr 출력");
		float sum=0;// 배열의 값들을 더하여 저장할 변수 입니다
		for(int j=0;j<i;j++) {
			sum+=ar[j];
			System.out.println("Avr["+j+"]: "+sum/(j+1));
			// 지금까지 더한 배열값들의 합을  지금까지의 진행한 배열의 index로 나누면 평균을 구할수 있습니다. 
		}
	}
}

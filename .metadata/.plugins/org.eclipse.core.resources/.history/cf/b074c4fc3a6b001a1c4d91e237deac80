

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
public class no2_5 {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int d=sc.nextInt();// 코인 배열 크기를 먼저 입력받습니다.
		int []c=new int[d];
		for(int i=0;i<c.length;i++) {
				c[i]=sc.nextInt();// 코인의 종류를 입력 받습니다.
			}
		int different=0;
		for(int M=0;M<100;M++) {
		int GreedyResult=GreedyBetterChange(M,c,d);
		int BruteFoceResult=BruteForceChange(M,c, d);
		if(GreedyResult!=BruteFoceResult) {
			different++;
		System.out.print(M+": "+GreedyResult+", ");
		System.out.println(BruteFoceResult);
		
		}
	  }System.out.println("틀린 갯수 : "+different);
		
	}
	
	public static int GreedyBetterChange(int M,int []c,int d) {
		
		
		
		int result=0;// c배열을 요소 얼마나 많이 사용해야 M을 만들수 있는지에 대한 결과 값입니다.
		
		int []k= new int[d];
		for(int i=0;i<d;i++) {
			k[i]=M/c[i];// 몫을 구해 저장한 후,
			M-=k[i]*c[i];// M에서 M에서 c[i]로 뺄수있는 최대로 빼는 것 입니다.
			result+=k[i];// result는 k배열의 합입니다.
		}
		return result;
		

	}
	public static int BruteForceChange(int M,int []c,int d) {
		
	
	
		
		int []k= new int[d];
		for(int i=0;i<d;i++) {
			k[i]=M/c[i];
		}
		int valueOfCoin=0;
		int result=k[d-1];	// 최대의 많은 빈도를 가지게 되는 값을 일단 result에 초기 값으로 줍니다.
		int sum=0;
		
		for(int q=0;q<=k[0];q++) {
			for(int w=0;w<=k[1];w++) {
				for(int e=0;e<=k[2];e++) {
					for(int r=0;r<=k[3];r++) {
						for(int t=0;t<=k[4];t++) {
							
							for(int y=0;y<k[5];y++) {
							valueOfCoin=c[0]*q+c[1]*w+c[2]*e+c[3]*r+c[4]*t+c[5]*y;// M을 구성하게 되는 모든 경우의 수를 전부 구해봅니다. 
							if(valueOfCoin==M) {// 구한 값이 M 과 같다면,
								sum=q+w+e+r+t+y;// sum이라는 변수에 q,w,e,r,t의 합을 저장합니다
												//q,w,e,r,t는 각각 c배열 인덱스에 해당하는 값을 사용한 빈도수라고 할 수 있습니다.
								if(result>sum) {// result의 값은 가장 작은 값을 선택하는 것이므로,
									result=sum;// result보다 작은 경우에만 result에 저장합니다
								}
							}
							
							}
							
							
						}
					}
				}
			}
		}
		return result;
	}
	
}

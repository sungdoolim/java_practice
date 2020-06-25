//2015112120 임성두
package week4;

public class no1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []ar=new int[1000];
		int n=ar.length;
		//Math.random 은 0~1범위
		for(int i=0;i<n;i++) {
			ar[i]=(int)(Math.random()*100000)+1;
			//1~100000 랜덤으로 1000개 입력받기!
		}
		for(int i=0;i<n;i++) {
			System.out.print(ar[i]+" ");
		}// 원래 배열 출력해보기

		System.out.println("min : "+minimun(ar, n));
		System.out.println("max : "+maximum(ar, n));
		int []minmax=findminmax(ar, n);
		System.out.println("\nfindminmax 메서드 \nmin : "+minmax[0]);
		System.out.println("max : "+minmax[1]);
		
		
		
		
	}
public static int minimun(int[]ar,int n) {
	int min=ar[0];
	int index=0;
	for(int i=1;i<n;i++) {
		if(min>ar[i]) {
			min=ar[i];
		    index=i;	
		}
	}
	System.out.println("\n"+index+"번 인덱스");
	return min;
	
}
public static int maximum(int[]ar,int n) {
	int max=ar[0];
	int index=0;
	for(int i=1;i<n;i++) {
		if(max<ar[i]) {
			max=ar[i];
		    index=i;	
		}
	}
	System.out.println("\n"+index+"번 인덱스");
	return max;
	
}
public static int[] findminmax(int[]ar,int n) {
	/*
	 * 배열에 접근할 때 for문에서 i+=2를 하기에 접근을 최소화 합니다.
i 인덱스와 i+1 인덱스의 값을 비교, 
그중 큰 값은 max와 , 
작은 값은 min과 비교 하여 max와 min을 수정 합니다
배열로 리턴을 했기에 mM[0]는 최솟값 이고, mM[1]이 최대값입니다
	 */
	int min=ar[0];
	int max=ar[0];
	int m,M;
	for(int i=0;i<n;i+=2) {
		if(ar[i]<ar[i+1]) {
			m=ar[i];M=ar[i+1];}
		else {
			m=ar[i+1];M=ar[i];}
		
		if(min>m) {
			min=m;}
			
		if(max<M) {
			max=M;}
			
	}
	int []mM= {min,max};
	
	return mM;
	
	

}
}

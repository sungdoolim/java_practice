//2015112120 임성두
package week3;

import java.util.Stack;

public class no1_2 {
	static int index=0;

	static int []A= {30, 20, 40, 35, 5, 50, 45, 10, 25, 15};
	static int []B=new int[10];// 0으로 초기화가 됨
	static int len=A.length;
	public static void main(String[] args) {
		int len=A.length;
	
		System.out.println("처음 배열 : ");
		for(int i=0;i<len;i++) {System.out.print(A[i]+" ");}
		
		System.out.println("\n");
		mergeSort(A);

		System.out.println("최종 sort 된 배열 :  ");
		for(int i=0;i<len;i++) {System.out.print(A[i]+" ");}

	}
	static void mergeSort(int[]A) {	
	int rest=0;
		test :for(int i=0;i<len;i++) {
// 배열은 2^n개씩 묶어서 정렬할 것입니다.
//배열을 두 개씩 , 4개씩, 8개씩 , 2^4개씩 ......2^n 개씩 묶어서 정렬하는 것이 핵심입니다.(2^n<len)
			int p=(int) Math.pow(2, i+1);
			int m;
			for(int j=0;j<len;j+=p) {
				if(j==0) {
					index=0;//배열 처음부터 정렬하려면 B의 index를 초기화 해야합니다
					if(j+p-1>=len) {
//2^n개씩 나눠가며 정렬할때 정렬할 index를 넘어가면 최종 정렬을 합니다.
// 예를 들어 100의 크기의 배열을 정렬할때 2개씩, 4개씩, 8개씩 .....64개, 128개씩 정렬할때
//128은 100을 넘어가기에 0~ 100까지만 정렬한다는 것 입니다.
						sort(A,0,len-1,rest);
						break test;
					}
				}
				if(j+p-1>=len) {
					sort(A,j,len-1,(j+len-1)/2);
					break;
					
					/*
					* 예를 들어 100의 크기의 배열을 정렬할때 2개씩, 4개씩, 8개씩 .....64개씩 정렬할때
					* 0~64번째 인덱스의 값을 정렬하고나면 65~128번째 인덱스 값을 정렬해야 합니다.
					* 이때 128은 100을 넘어가기에 65~100까지만 정렬합니다.
					*/
				}
				m=(2*j+p-1)/2;
				sort(A,j,j+p-1,m);
				rest=j+p-1;
			}
			for(int a=0;a<len;a++) {System.out.print(A[a]+" ");}
			System.out.println();
		}
	}
	static void sort(int[]A,int left,int right,int middle) {
		int l=left,r=right,m=middle+1;
		if(left>=right||l>right||r>right) 			
			return;
		while(true) {
		if(l>middle||m>right ) {
			// left부터의 값이나 middle부터의 값이 비교 대상이 없을때는 while문 break합니다
			break;}
		if(A[l]>A[m]) {
			B[index]=A[m];
			index++;m++;			
		}else if(A[l]<=A[m]) {
			B[index]=A[l];
			index++;l++;
		}
	}//left부터의 값과 middle부터의 값을 비교하여 B에 넣습니다.
		if(l<=middle) {
			for(;l<=middle;l++) {
				B[index]=A[l];
				index++;
			}
		}else if(m<=right) {
			for(;m<=right;m++) {
				B[index]=A[m];
				index++;	
			}
		}// 비교 되지 않아 남아있는 left부터의 값이나 middle부터의 값을 그대로 B배열에 넣습니다.
		
		for(int i=left;i<=right;i++) {
			A[i]=B[i];// 정렬된 배열을 복사 합니다.
			}//메서드가 끝나기전 배열 복사입니다.
	}
}

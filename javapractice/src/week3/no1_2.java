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

	int k=1;
	int tmp;int t1, t2,t;

/*	for(int i=0;i<len;i+=2) {
		if (i==len)break;
		if(A[i]>A[i+1]) {
			tmp=A[i];
			A[i]=A[i+1];
			A[i+1]=tmp;
		}
	}*/// 배열의 원소 두개씩만 묶어서 정렬한 것 입니다.
	

	//for(int i=0;i<len;i++) {System.out.print(A[i]+" ");}
	//System.out.println();
		//int middle=(left+right)/2;
	
	int rest=0;
		test :for(int i=0;i<len;i++) {
		
			int p=(int) Math.pow(2, i+1);
			int m;
			for(int j=0;j<len;j+=p) {
				if(j==0) {
					index=0;
					if(j+p-1>=len) {
					//	System.out.println(rest);
						sort(A,0,len-1,rest);	
					//	for(int a=0;a<len;a++) {System.out.print(A[a]+" ");}
					//	System.out.println("Ainsort");
						break test;
					}
				}
				if(j+p-1>=len) {
					sort(A,j,len-1,(j+len-1)/2);
					break;
				}
				m=(2*j+p-1)/2;
				sort(A,j,j+p-1,m);
				rest=j+p-1;
			}//sort(A,rest,len-1,(rest+len-1)/2);
			for(int a=0;a<len;a++) {System.out.print(A[a]+" ");}
			System.out.println();
		}
		/*sort(A,0,3,1);
		for(int i=0;i<len;i++) {System.out.print(B[i]+" ");}
		System.out.println("B1");
		for(int i=0;i<len;i++)System.out.print(A[i]+" ");System.out.println();
		
		sort(A,4,7,5);
		for(int i=0;i<len;i++) {System.out.print(B[i]+" ");}
		System.out.println("B2");
		
		
		for(int i=0;i<len;i++)System.out.print(A[i]+" ");System.out.println();
		
		index=0;
	
		sort(A,0,7,3);
		for(int i=0;i<len;i++) {System.out.print(B[i]+" ");}
		System.out.println("B3");
		index=0;
		for(int i=0;i<len;i++)System.out.print(A[i]+" ");System.out.println();
		
		
		sort(A,0,len-1,7);
		for(int i=0;i<len;i++)System.out.print(A[i]+" ");System.out.println();		
		for(int i=0;i<len;i++) {System.out.print(B[i]+" ");}
		System.out.println("B4");
		break;
		*/	
	}
	
	
	
	static void sort(int[]A,int left,int right,int middle) {
		
		int l=left,r=right,m=middle+1;
		if(left>=right||l>right||r>right) 			
			return;
		
		while(true) {
	//		System.out.println(m);
		if(l>middle||m>right )
			break;
		if(A[l]>A[m]) {
			B[index]=A[m];
			index++;m++;
			//for(int i=0;i<len;i++) {System.out.print(B[i]+" ");}
			//System.out.println("Bin");
			//System.out.println(l+","+r+","+m);
	
			
			
		}else if(A[l]<=A[m]) {
			B[index]=A[l];
			index++;l++;
			//for(int i=0;i<len;i++) {System.out.print(B[i]+" ");}
		//	System.out.println("Bin2");
			//System.out.println(l+","+r+","+m);
		}
	
		}
		
		
		
		if(l<=middle) {
			for(;l<=middle;l++) {
				//System.out.println(index+","+l+","+m);
				B[index]=A[l];
				index++;
			//	for(int i=0;i<len;i++) {System.out.print(B[i]+" ");}
			//	System.out.println("Bin3");
			//	System.out.println(l+","+r+","+m);
			}
		}else if(m<=right) {
			for(;m<=right;m++) {
			//	System.out.println(index+","+l+","+m);
				B[index]=A[m];
				index++;	
			//	for(int i=0;i<len;i++) {System.out.print(B[i]+" ");}
			//	System.out.println("Bin4");
			//	System.out.println(l+","+r+","+m);
			}
		}
		
		for(int i=left;i<=right;i++) {
			A[i]=B[i];// 정렬된 배열을 복사 합니다.
			}
		
		
	}
}

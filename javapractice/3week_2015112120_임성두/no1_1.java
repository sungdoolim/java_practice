//2015112120 임성두
package week3;

public class no1_1 {

	public static void main(String[] args) {

		int  []A= {30, 20, 40, 35, 5, 50, 45, 10, 25, 15};
		int len=A.length;
		System.out.println("처음 배열 : ");
		for(int i=0;i<len;i++) {System.out.print(A[i]+" ");}
		
		System.out.println("\n");
		mergeSort(A,0,len-1);
		System.out.println("최종 sort 결과 : ");
		for(int i=0;i<len;i++) {System.out.print(A[i]+" ");}
		
	}

	
	static void mergeSort(int []A,int left,int right) {
		if(left>=right) {
			return;
		}
		int middle=(left+right)/2;
		mergeSort(A,left,middle);
		mergeSort(A,middle+1,right);
		
		merge(A,left,right,middle);
		for(int i=0;i<A.length;i++) {System.out.print(A[i]+" ");}
		System.out.println();
	}
	
	
	
	static void merge(int[]A,int left,int right,int middle) {
		int []B=new int[right-left+1];
		int index=0;
		int l=left;
		int m=middle+1;
		while(true) {
		    if(l>=middle+1) {// l 이 중간 값을 넘어서면 비교가 끝난 것 입니다.
		    	for(;m<=right;m++) {
// left < middle 쪽에서 비교할 값이 없기에 middle~ right쪽의 배열 값은 그대로 B배열에 넣으면 됩니다.
		    		B[index]=A[m];
		    		index++;
		    	}
		    	break;
		    }else if(m>=right+1) {
		    	// m이 right를 넘어가면 middle ~ right의 배열들의 비교가 끝난 것 입니다
		    	for(;l<middle+1;l++) {
// middle < right 쪽에서 비교할 값이 없기에 left~ middle쪽의 배열 값은 그대로 B배열에 넣으면 됩니다.
	    		B[index]=A[l];
	    		index++;
	    	}
		    	break;
		    }
			else if(A[l]>A[m]) {
// left쪽과 middle쪽에서 하나씩 비교후 작은 값을 B에 넣습니다.
				B[index]=A[m];m++;
				index++;		
			}else if(A[l]<=A[m]) {
				B[index]=A[l];l++;
				index++;
			}
		}
		for(int i=0;i<right-left+1;i++) {
			A[left+i]=B[i];// B의 배열을 A로 복사합니다.
		}
	}
}

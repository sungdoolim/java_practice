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
	//	System.out.println("merge : "+l+" "+r+" "+m);
		while(true) {
		    if(l>=middle+1) {
		    	for(;m<=right;m++) {
		    		B[index]=A[m];
		    		//System.out.println(index+" "+B[index]);
		    		index++;
		    	}
		    	break;
		    }else if(m>=right+1) {
		    	for(;l<middle+1;l++) {
		    	//	System.out.println(l+","+m+","+index);
	    		B[index]=A[l];
	    		//System.out.println(index+" "+B[index]);
	    		index++;
	    	}
		    	break;
		    }
			else if(A[l]>A[m]) {
				B[index]=A[m];m++;
			//	System.out.println(index+" "+B[index]);
				index++;
				
			}else if(A[l]<=A[m]) {
				B[index]=A[l];l++;
			//	System.out.println(index+" "+B[index]);
				index++;
			}
		}
		for(int i=0;i<right-left+1;i++) {
			A[left+i]=B[i];// B의 배열을 A로 복사합니다.
		}
	}
}

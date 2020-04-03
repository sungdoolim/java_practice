package week3;

public class no2makeheap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []A= {4,1,3,2,16,9,10,14,8,7};
		int len=A.length;
		makeheap(A,0,len-1);	
		System.out.println("최종 힙 생성 결과 : ");
		for(int i=0;i<len;i++) {
			System.out.print(A[i]+" ");
		}	
	}
	
	
	public static void makeheap(int[]A,int root,int last) {
		
		int index=(last-1)/2;
		for(int i=index;i>=root;i--) {
		
			makeheap2(A,i,last);	
			for(int j=0;j<=last;j++) {
				System.out.print(A[j]+" ");
			}	System.out.println();
		}	
	}
	public static void makeheap2(int[]A,int index,int end) {
		int t1=2*index+1;
		int t2=2*index+2;
		int len=end+1;
	
		int tmp;
		if(t1>=len) {
			return;
		}else if(t2>=len) {
			if(A[t1]>A[index]) {
			tmp=A[index];
			A[index]=A[t1];
			A[t1]=tmp;
			}
			return;
		}else {
			
			if(A[t1]>A[t2]&&A[index]<A[t1]){
				tmp=A[t1];
				A[t1]=A[index];
				A[index]=tmp;
				makeheap2(A,t1,end);
			}
			else if(A[t1]<=A[t2]&&A[index]<A[t2]){
				tmp=A[t2];
				A[t2]=A[index];
				A[index]=tmp;
				makeheap2(A,t2,end);
			}
		}
	}

}

//2015112120 임성두
package week3;

public class no2makeheap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []A= {4,1,3,2,16,9,10,14,8,7};
		int len=A.length;
		
		System.out.println("원래 배열 : ");
		
		for(int i=0;i<len;i++) {
			System.out.print(A[i]+" ");
		}System.out.println("\n");
		makeheap(A,0,len-1);	
		System.out.println("최종 힙 생성 결과 : ");
		for(int i=0;i<len;i++) {
			System.out.print(A[i]+" ");
		}	
	}
	
	
	public static void makeheap(int[]A,int root,int last) {	
		int index=(last-1)/2;// 자식노드를 가지는 가장 끝의 인덱스를 찾는 것 입니다.
		for(int i=index;i>=root;i--) {
			// 인덱스를 1씩 줄여가며 힙을 만듭니다.
			makeheap2(A,i,last);	
			for(int j=0;j<=last;j++) {
				System.out.print(A[j]+" ");
			}	System.out.println();
		}	
	}
	public static void makeheap2(int[]A,int index,int end) {
		int t1=2*index+1;// index의 자식노드 입니다
		int t2=2*index+2;// index의 자식노드 입니다
		int len=end+1;// 힙 정렬을 할 배열의 끝 인덱스를 제한합니다.
		int tmp;
		if(t1>=len) {// 자식 노드가 없는 경우 메서드를 끝냅니다
			return;
		}else if(t2>=len) {
			// 자식노드가 하나인 경우 그 값과 index의 배열 값을 비교하여 노드의 값이 크면 index의 값과 교환합니다
			if(A[t1]>A[index]) {
			tmp=A[index];
			A[index]=A[t1];
			A[t1]=tmp;
			}
			return;
		}else {
			// 일반적인 경우입니다. 
			// 두 자식 노드의 값중 큰 값을 골라 큰 값이 index의 값보다 크면 교환을 합니다.
			// 만약 교환이 일어나게 되면 교환한 자식노드를 기준으로 힙을 재 구성 해야합니다.
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

//2015112120 임성두
package week2;

import java.util.Stack;

public class no3_3 {

	public static void main(String[] args) {


		// TODO Auto-generated method stub
		/*int []N=new int[10];
		for(int i=0;i<10;i++) {
			N[i]=(int)(Math.random()*10000)+1;//랜덤으로 수를 배정 받습니다.
			System.out.print(N[i]+" ");
		}
		quick(N,10);
		System.out.println("\n----------------------");
		for(int i=0;i<10;i++) {
			System.out.print(N[i]+" ");
		}*/
		
		int []K=new int[1000];
		for(int i=0;i<1000;i++) {
			K[i]=(int)(Math.random()*10000)+1;//랜덤으로 수를 배정 받습니다.
			System.out.print(K[i]+" ");
		}
		quick(K,1000);
		System.out.println("\n----------------------");
		for(int i=0;i<1000;i++) {
			System.out.print(K[i]+" ");
		}

	}

	static void quick(int[]N,int len) {
		Stack<Integer> stack = new Stack<>();
		int start=0;
		int end=len-1;
		stack.push(end);
		stack.push(start);
		int left=0;
		int right=0;
		int tmp=0;
		//스택을 하나 만들고 항상 end 값과 start 값 순서로 받아야 합니다.
		
		while(!stack.isEmpty()) {
		
			start=stack.pop();
			end=stack.pop();
			if(start<0||end<0||start>=end)continue;
			while(true) {
				left=start+1;
				right=end;
			while(N[start]<=N[left]&&left<=end) {
				left++;
				if(left>end) {
					left=start;
					break;}
			}// start인덱스의 값보다 작은 left를 찾아 냅니다. 예외로 찾지 못했을때는 start값이 left가 됩니다
			while(N[start]>=N[right]&&right>start) {
				right--;
				// start인덱스의 값보다 큰 right를 찾아 냅니다. 				
			}
			// 오름 차순이라면 등호만 반대로 하면 됩니다.
			
			if(left<right) {
				// 순서가 위와 같다면 단순히 둘을 교환 합니다.
				tmp=N[left];
				N[left]=N[right];
				N[right]=tmp;
			}else if(left==right) {
				// 두 수가 같다면 같은 수는 더이상 정렬할 필요가 없기에 break입니다
			break;	
			}
			else {
			// 순서가 엇 갈렸을때 start와 엇갈린 right인덱스의 값과 비교후에
			// right인덱스를 기준으로 둘로 나누어 정렬을 하게 됩니다.
			//right+1 ~ end 와 start ~ right-1 까지의 정렬을 하게 됩니다.
				tmp=N[start];
				N[start]=N[right];
				N[right]=tmp;
				stack.push(end);
				stack.push(right+1);
				stack.push(right-1);
				stack.push(start);
				break;
			}
			}
			
		}
	}

}

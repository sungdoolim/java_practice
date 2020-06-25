//2015112120 임성두
package week5;

public class no1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		no1_map [][]map= {
				{new no1_map(3,1),new no1_map(2,0),new no1_map(4,2),new no1_map(0,4),new no1_map(-1,3)},
				{new no1_map(3,4),new no1_map(2,6),new no1_map(4,5),new no1_map(1,2),new no1_map(-1,1)},
				{new no1_map(0,4),new no1_map(7,4),new no1_map(3,5),new no1_map(4,2),new no1_map(-1,1)},
				{new no1_map(3,5),new no1_map(3,6),new no1_map(0,8),new no1_map(2,5),new no1_map(-1,3)},
				{new no1_map(1,-1),new no1_map(3,-1),new no1_map(2,-1),new no1_map(2,-1),new no1_map(-1,-1)}
				};
		
		dynamic(map);
		
		
	}
	static void dynamic(no1_map[][] map) {
		int t1,t2;
		/*
		 * 따로 배열을 만드는 것이 아니고, map구현시 멤버 변수 max를 선언 해 두었습니다.
		 * */
		for(int i=1;i<5;i++) {
			map[0][i].max=map[0][i-1].right+map[0][i-1].max;
			map[i][0].max=map[i-1][0].down+map[i-1][0].max;
		}// 초기에 테두리 부분은 비교 할 필요가 없기 때문에 바로 진행 방향에 맞게 초기화 해줄수 있습니다.
		for(int i=1;i<5;i++) {
			for(int j=1;j<5;j++) {
				t1=map[i][j-1].max+map[i][j-1].right;
				t2=map[i-1][j].max+map[i-1][j].down;
				if(t1>t2) {
					map[i][j].max=t1;
				}else {
					map[i][j].max=t2;
				}
			}
		}/*(0,0~4)까지와 (0~4,0)까지의 max값은  별도로 초기화 했습니다. 

일반적인 경우 왼쪽과 위쪽의 경로에서의 비용을 비교 해야 합니다. 
예를 들면 (3,2)의 경우 (3,1)인 왼쪽과 (2,2)인 위쪽의 경로에서 (3,2)로 이동하게 될 것이기에 왼쪽에서 오는 경우와 위쪽에서 오는 경우를 비교해야 합니다. 
(i,j)에서 (i,j-1)은 왼쪽이고, (i-1,j)는 위쪽입니다. 
왼쪽에서 오는 경우 왼쪽에 저장된 max와 right 의 값을 더한 값을 t1, 
위쪽에서 오는 경우 위쪽에 저장된 max 와 down의 값을 더한 값을 t2에 저장하고, 
t1,t2를 비교하여 큰 값을 max로 선택합니다 ( 최대치를 주는 경로를 선택했다고 생각할 수 있습니다.)*/
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.printf("%3d ",map[i][j].max);
			}System.out.println();
		}
		
		}

}

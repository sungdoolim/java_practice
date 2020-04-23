//2015112120 임성두
package week4;

public class no2_bonus {

	public static void main(String[] args) {
	
		no2_map [][]map= {
				{new no2_map(3,1),new no2_map(2,0),new no2_map(4,2),new no2_map(0,4),new no2_map(-1,3)},
				{new no2_map(3,4),new no2_map(2,6),new no2_map(4,5),new no2_map(1,2),new no2_map(-1,1)},
				{new no2_map(0,4),new no2_map(7,4),new no2_map(3,5),new no2_map(4,2),new no2_map(-1,1)},
				{new no2_map(3,5),new no2_map(3,6),new no2_map(0,8),new no2_map(2,5),new no2_map(-1,3)},
				{new no2_map(1,-1),new no2_map(3,-1),new no2_map(2,-1),new no2_map(2,-1),new no2_map(-1,-1)}
				};
		//맵 구현입니다 no2_map에는 int right,down이 있고 생성자에 의해 초기화가 가능합니다.
		//right나 down이 벽인 경우 -1로 처리했습니다.
		System.out.println("최다 관광수 : "+bruteforce(map,0,0));
		
		
		}
	static int bruteforce(no2_map[][] map,int i,int j) {
		int r, d;
		int s1,s2;
			r=map[i][j].right;
			d=map[i][j].down;
			if(j<4) 
			{s1=r+bruteforce(map,i,j+1);}
			else s1=0;
			if(i<4)
			{s2=d+bruteforce(map,i+1,j);}
			else s2=0;
			if(s1>s2)return s1;
			else return s2;

	}
}

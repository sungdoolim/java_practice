//2015112120 임성두
package week4;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class no2 {

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
		System.out.println("start : ");
		System.out.println("Map[0][0]");
		greedy(map);
		
		
		}
	static void greedy(no2_map[][] map) {
		int r, d;
		int i=0,j=0;
		int sum=0;
		
		while(i!=4||j!=4) {
			r=map[i][j].right;
			d=map[i][j].down;
			if(r>d) {
				sum+=r;
				j++;
				System.out.println("Map["+i+"]["+j+"]");
			}
			else {
				sum+=d;
				i++;

				System.out.println("Map["+i+"]["+j+"]");
			}

		}
		System.out.println("sum : "+sum);

	}
}

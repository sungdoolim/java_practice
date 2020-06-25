//2015112120 임성두
package week7;

public class node {

	node left;
	node right;
	node p;
	int value,color;
	node(){
		left=null;
		right=null;
		p=null;
		value=-1;
		color=1;//-1은 black, 1은 red입니다
	}
}

//2015112120 임성두
package week7;

import java.util.Scanner;

public class no3 {

	static node head=new node();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
	
		String s;
		while(true) {
			// 입력 받은 문자가 p 나 q일때, 각 트리 출력과 종료입니다.
		s=sc.next();
		 
		  if(s.charAt(0)=='p')
		{	show();}
		
		else if(s.charAt(0)=='q')
				break;
		redblack(s);
		}
		show();
	}
	
	static void prints(node t) {
		if(t==null)
			return;
		
		System.out.println(t.value+" ");
		prints(t.left);
		prints(t.right);
	}
	static void redblack(String s) {

		int v;
		switch(s.charAt(0)) {
		//들어온 string의 첫 문자로 삽입,삭제,탐색을 판단합니다
		case '+':
			s=s.substring(1, s.length());
			v=Integer.parseInt(s);
			insert(v);
			break;
			default:
				break;
		}
	}
	
	
	static void insert(int v) {
		// head를 제외한 insert는 무조건 red입니다(color=1)
		node parent;
		node grandp;
	
		parent=head;//이때부터는 parent조작시 head도 같이 조작됩니다.
		
		if(parent.value==-1) {
			// 임의의 값인 -1이 head에 있다면 비어있는 것으로 간주하고 head에 값을 넣습니다.
			// -1은 의미 없는 값으로 간주 한 것 입니다.
			parent.value=v;
			parent.color=-1;//-1은 black을 뜻합니다
			return;
		}
		while(true) {
			grandp=parent.p;
			//if(grandp!=null)
			//{System.out.println(grandp.value);}
			if(parent.value>v) {// 삽입하려는 값과 현 노드의 값과 비교합니다.
				if(parent.left!=null) {// 작으면 left로 이동하여 다시 비교를 합니다.
					parent=parent.left;
				}else {// 값을 넣을 곳을 찾고 넣으면 메서드를 종료합니다.
					parent.left=new node();
					parent.left.value=v;
				//	parent.left.color=1;//red입니다
					parent.left.p=parent;
					head=solve(grandp,parent,parent.left);
					break;
				}
			}
			else {//크면 right입니다
				if(parent.right!=null) {
					parent=parent.right;
				}else {// 값을 넣을 곳을 찾고 넣으면 메서드를 종료합니다.
					parent.right=new node();
					parent.right.value=v;
				//	parent.right.color=1;//red입니다.
					parent.right.p=parent;
					head=solve(grandp,parent,parent.right);
					break;
				
					}
				}
			}//System.out.println("head: "+head.value);		
	}

	static boolean isleft(node grandp, node parent) {
		boolean GLorR;
		if(grandp==null)System.out.println("null?");
		if(grandp.left==null) {GLorR=false;}
		else if(grandp.right==null) {GLorR=true;}
		else if(grandp.left.value==parent.value) {GLorR=true;}
		else {GLorR=false;}
		//true라면 지금 parent는 grandp의 left입니다
	return GLorR;
	}
	static node solve(node grandp,node parent,node child) {
		
		if(parent.color==1&&child.color==1) {
			System.out.println("interrupt");
			boolean GLorR=isleft(grandp,parent);
			boolean LorR=isleft(parent,child);

		//	node tmp=parent;
			if(GLorR) {// 지금 parent 가 grandp의 left라면
				 if(grandp.right!=null&&grandp.right.color==1) {
					 //삼촌노드가 적색이라면 grandp의 노드는 흑색 parent와 삼촌을 적색으로 합니다
					grandp.color=1;
					//parent.color=-1;
					grandp.left.color=-1;
					grandp.right.color=-1;	
				}
				 else if(grandp.right==null||grandp.right.color!=1) {//노드가 없거나 흑색이라면
					if(!LorR) {// case 2라면 case3을 만들기위해 rotate
						System.out.println("case2");
						RtoL_Rotate(grandp,parent,child);
						child.color=-1;
						grandp.color=1;
						LtoR_Rotate(grandp.p, grandp, child);
						
					}
					else {
						System.out.println("case3");
					//case3의 경우의 처리
					parent.color=-1;
					grandp.color=1;
					LtoR_Rotate(grandp.p, grandp, parent);
					}
				}
			}
			
			
			else {// 위와 left/right의 차이만 있고 동일한 알고리즘입니다.
				if(grandp.left!=null&&grandp.left.color==1) {//삼촌노드가 적색이라면 grandp의 노드는 흑색 parent와 삼촌을 적색으로 합니다
					grandp.color=1;
					parent.color=-1;
					grandp.left.color=-1;	
				}
				else if(grandp.left==null||grandp.left.color!=1) {
					if(LorR) {
						LtoR_Rotate(grandp, parent, child);
						child.color=-1;
						grandp.color=1;
						RtoL_Rotate(grandp.p, grandp, child);
					}
					else {
						parent.color=-1;
						grandp.color=1;
						RtoL_Rotate(grandp.p, grandp, parent);
					}
				}
		
			}

		}
		
		
		

		if(child.p!=null)
		 child=child.p;
		
		 parent=child.p;
		// grandp=parent.p;
		 if(parent!=null) {
		 grandp=parent.p;}
		 if(parent!=null) {
			 if(parent==head) {
				 parent.color=-1;
			 }
		  return solve(grandp,parent,child);
		 }else
		return child;//head를 리턴합니다.
		
		
	}
	static void RtoL_Rotate(node grandp,node parent,node child){

		if(child.left!=null)
		{parent.right=child.left;}else {
			parent.right=null;
		}
		child.left=parent;
		child.p=parent.p;
		parent.p=child;
		
		if(grandp!=null) {
			boolean GLorR;
			if(grandp.left==null) {GLorR=false;}
			else if(grandp.right==null) {GLorR=true;}
			else if(grandp.left.value==parent.value) {GLorR=true;}
			else {GLorR=false;}
		if(GLorR) {
			grandp.left=child;
		}else {
			grandp.right=child;
		}
		}
	}
	static void LtoR_Rotate(node grandp,node parent,node child){

		if(child.right!=null)
		{parent.left=child.right;}else {
			parent.left=null;
		}
		child.right=parent;
		child.p=parent.p;
		parent.p=child;
		
		if(grandp!=null) {
			boolean GLorR;
			if(grandp.left==null) {GLorR=false;}
			else if(grandp.right==null) {GLorR=true;}
			else if(grandp.left.value==parent.value) {GLorR=true;}
			else {GLorR=false;}
		if(GLorR) {
			grandp.left=child;
		}else {
			grandp.right=child;
		}
		}else {
			head=child;
		}
	}
	

	
	static void show() {

		if (head == null)
		{System.out.println("empty");}// 트리가 비었을 경우 입니다
		else
		{
			System.out.println();
			showSub(head,1);// 순환적으로 구현했습니다.
			System.out.println();
			
		}
	}
	static void showSub(node p,int level) {
		// 트리의 구조를 그려줍니다.
		/*
		 * 아이디어로는 맨 첫줄은 가장 right쪽에 있는 값,
		 * 그후에는 맨 right의 부모의 left에서 또다시 가장 right에 있는 값을 출력해야 합니다.
		 * 따라서 순환적으로 
		 * f(right) -> 조건에 맞는 그림과 값 출력 -> f(left)식으로 진행하게 됩니다
		 * 
		 */
		int i;
		if (p != null){
			String Color;
			if(p.color==1)
				Color="R";
			else
				Color="B";
			showSub(p.right, level + 1);// 맨 right쪽으로 이동하여서 출력해야 합니다
			for (i = 0; i < level; i++)// 순환적으로 함수를 들어갈 때 마다 level을 올려야 합니다
			{
				System.out.print("\t");//트리그릴때 여유를 두기위해 공백을 주었습니다
			}
			
			System.out.print(" "+p.value+"("+Color+")");
			
			if ((p.left != null) && (p.right != null))
			{// 자식노드 둘이 전부 null이 아니라면 양쪽으로 가지를 뻗어야 합니다
				System.out.print("<");
			}
			else if (p.right != null)// 한쪽일때 한쪽만 가지를 뻗습니다
			{
				System.out.print("/");			}
			else if (p.left != null)
			{
				System.out.print("\\");
			}
			System.out.println();
			showSub(p.left, level + 1);
			// 모든 right가 끝나면 left로 가고, 그 후 또다시 그중에 가장 right를 찾게 됩니다
		}
	}
}


/*
+20
+15
+14
+12
+13
+1

+15
+3
+17
+2
+8
+18
+5
+10


+15
+7
+17
+16
+2
+1
+4
+5
+3
 */
//2015112120 임성두
package week6;

import java.util.Scanner;

public class no1 {
	static node head=new node();
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
	
		String s;
		while(true) {
			// 입력 받은 문자가 p 나 q일때, 각 트리 출력과 종료입니다.
		s=sc.next();
		if(s.charAt(0)=='p')
			show();
		else if(s.charAt(0)=='q')
				break;
		btree(s);
		}
		show();
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
			showSub(p.right, level + 1);// 맨 right쪽으로 이동하여서 출력해야 합니다
			for (i = 0; i < level; i++)// 순환적으로 함수를 들어갈 때 마다 level을 올려야 합니다
			{
				System.out.print("    ");//트리그릴때 여유를 두기위해 공백을 주었습니다
			}
			System.out.print(" "+p.value);
			
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
	
	
	
	static void btree(String s) {

		int v;
		switch(s.charAt(0)) {
		//들어온 string의 첫 문자로 삽입,삭제,탐색을 판단합니다
		case '+':
			s=s.substring(1, s.length());
			v=Integer.parseInt(s);
			insert(v);
			break;
		case '-':
			s=s.substring(1, s.length());
			v=Integer.parseInt(s);
			del(v);			
			break;

		case '?':
			s=s.substring(1, s.length());
			v=Integer.parseInt(s);
			find(v,0);	
			break;
			default:
				break;
		}
	}
	static void insert(int v){
		node tmp;
		tmp=head;//이때부터는 tmp조작시 head도 같이 조작됩니다.
		if(tmp.value==-1) {
			// 임의의 값인 -1이 head에 있다면 비어있는 것으로 간주하고 head에 값을 넣습니다.
			// -1은 의미 없는 값으로 간주 한 것 입니다.
			tmp.value=v;
			return;
		}
		while(true) {	
			if(tmp.value>v) {// 삽입하려는 값과 현 노드의 값과 비교합니다.
				if(tmp.left!=null) {// 작으면 left로 이동하여 다시 비교를 합니다.
					tmp=tmp.left;
				}else {// 값을 넣을 곳을 찾고 넣으면 메서드를 종료합니다.
					tmp.left=new node();
					tmp.left.value=v;
					break;
				}
			}
			else {//크면 right입니다
				if(tmp.right!=null) {
					tmp=tmp.right;
				}else {// 값을 넣을 곳을 찾고 넣으면 메서드를 종료합니다.
					tmp.right=new node();
					tmp.right.value=v;
					break;
				
					}
				}
			}	
	}
	
	static node find(int v,int p) {
		node tmp=head;
		node pointer=head;
		while(true) {
			
			if(tmp.value==v) {// 찾게 되면 정보를 출력합니다.
				if(p==-1)// 단순히 출력을 할지 말지 결정해줄 뿐 입니다.
				{	break;}
				
				System.out.println("Retrived key = "+v);
				System.out.print("left child is ");
			if(tmp.left!=null)
				{System.out.println(tmp.left.value);}
			else
				{System.out.println("none");}
			System.out.print("right child is ");
			if(tmp.right!=null)
			{System.out.println(tmp.right.value);}
			else
			{	System.out.println("none");}
			break;
			}// 여기까지는 찾았을때의 출력입니다.
			
			else {// 현 노드가 찾는 노드가 값의 비교 후에 아니라면 계속 탐색합니다.
				if(tmp.value>v) {// 삽입하려는 값과 현 노드의 값과 비교합니다.
					if(tmp.left!=null) {// 작으면 left,
						pointer=tmp;//pointer는 부모노드 역할을 하게 됩니다. 삭제 구현시 사용됩니다
						tmp=tmp.left;
					}else {// 값을 넣을 곳을 찾고 넣으면 메서드를 종료합니다.
						System.out.println("찾는 노드 없음!");
						break;
					}
					}
					else {//크면 right입니다
						if(tmp.right!=null) {
							pointer=tmp;//pointer는 부모노드 역할을 하게 됩니다. 삭제 구현시 사용됩니다
							tmp=tmp.right;
						}else {
							System.out.println("찾는 노드 없음!");
							break;
						}
					}
			}
			
		}

	return pointer;
	}

	
	
	
	
	static void del(int v) {
		
		node tmp=find(v,-1);// 삭제할 노드의 부모 노드를 가져옵니다, 즉 밑에 t의 부모 노드 입니다.
		node t;
		boolean b;// 부모 노드의 right를 삭제 하는 것이면 true , left라면 false입니다.
		if(tmp.right!=null&&tmp.right.value==v)
			{t=tmp.right;
			tmp.right=null;
			b=true;}
		else
			{t=tmp.left;
			tmp.left=null;
			b=false;}
		/* 정말로 찾는 노드는 t 입니다. t 가 삭제할 노드 입니다.
		right 노드 가 없으면 left노드가 삭제하는 노드 대신 연결됩니다.
		부모노드도 알고 삭제할 자식 노드도 아는 상태이므로 일단 연결을 끊어 놓습니다.null
		*/
		if(t.right==null) {
			//삭제 하고자 하는 노드의 right가 존재하지 않으면 그냥 left에 부모노드를 이으면 됩니다.
			 if(b) {//b가 true이면 부모노드에서 right가 삭제할 노드라는 것 입니다.
				 //때문에 부모의 right를 이어주어야 합니다
				if(t.left!=null)
				{tmp.right=t.left;}
			}else {
				if(t.left!=null)
				{tmp.left=t.left;}
			}
		}
		
		
		// right는 있는데 right의 left가 없는 경우, right가 삭제하는 노드 대신 연결되며 
		//삭제된 노드의 right를 대신한 노드의 right에 연결합니다.
		else if(t.right!=null&&t.right.left==null) {
			if(b) {

				tmp.right=t.right;
				if(t.left!=null)
				{tmp.right.left=t.left;}
			}else {
				tmp.left=t.right;
				if(t.left!=null)
				{tmp.left.left=t.left;}
			}
		}
		
		// 그외 경우
		//left중에 가장 큰 값이나, right중에 가장 큰 값을 대신으로 합니다.
		else {
			node point=t.right;
			while(point.left!=null) {
				point=point.left;
			}//삭제할 노드의 right중에서 가장 left를 찾습니다 , 즉 right에서 가장 작은 값을 찾는 것 입니다.
			
			if(b) {//b가 true라는 것은 삭제할 노드는 그 노드의 부모 노드의 right노드라는 것 입니다.
				/*
				 *위에서 찾은 노드 point를 일단 삭제 합니다.
				 *그러기 위해 nullexception 발생을 막기위해 tmp.right를 다시 이었습니다. 
				 */
				tmp.right=t;//nullexception을 방지할뿐 논리적으로는 무관합니다.
				del(point.value);//일단 point를 지웁니다
				tmp.right=point;// 그후 부모노드를 point에 있고, point의 left,right를 알맞게 지정합니다.
				point.left=t.left;
				point.right=t.right;
			}else {//left부분이고, 논리는 위와 같습니다. 
				tmp.left=t;
				del(point.value);
				tmp.left=point;
				point.left=t.left;
				point.right=t.right;
			}
		}
		
	}
	
	
}









/*
 
+20
+6
+2
+4
+16
+10
+8
+12
+14
+9

 */











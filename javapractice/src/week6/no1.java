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
		s=sc.next();
		if(s.charAt(0)=='q')
			break;
		
		btree(s);
		}
		print(head);
	}
	
	
	
	
	
	
	static void btree(String s) {
		s.charAt(0);
		int v;
		switch(s.charAt(0)) {
		case '+':
			s=s.substring(1, s.length());
			//System.out.println(s);
			v=Integer.parseInt(s);
			node p=insert(v);
			
			
			break;
			
			
			
		case '-':
			break;
			
			
			
		case '?':
			break;
			
		}
	}

	static void print(node p) {
		System.out.println(p.value);
		if(p.left!=null) {
			print(p.left);
		}
		if(p.right!=null) {
			print(p.right);
		}
	
	}
	static node insert(int v){
		node tmp;
		node pointer;
		pointer=head;
		tmp=head;
		int a=0;
		/*	if(pointer==null) {
				pointer.value=v;
				if(a<0) {
					tmp.left=pointer;
				}else if(a>0) {
					tmp.right=pointer;
				}
				
			}*/
		
		while(true) {
			//System.out.println(tmp.value);
			if(pointer==null) {
				pointer=new node();
				pointer.value=v;
				if(a<0) {
					tmp.left=pointer;
				}else if(a>0) {
					tmp.right=pointer;
				}
				
				return tmp;
			}
		if(tmp.value>v) {
			pointer=tmp.left;
			a=-1;
			if(pointer!=null) {
				tmp=tmp.left;
			}
		}
		else {
			pointer=tmp.right;
			a=1;
			if(pointer!=null) {
				tmp=tmp.right;
			}
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











package week6;

import java.util.Scanner;

public class bonus {
	static bonus_node head=new bonus_node();
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		String s;
		while(true) {
		s=sc.next();
		if(s.charAt(0)=='Q')
				break;

		//System.out.println(s.charAt(0));
		btree(s);
		}

		//print(head);

	}
	static void btree(String s) {
		s.charAt(0);
		int v;
		switch(s.charAt(0)) {
		case '+':
			s=s.substring(1, s.length());
			v=Integer.parseInt(s);
			insert(v);
			
			
			break;
			
			
			
		case '-':
			s=s.substring(1, s.length());
			v=Integer.parseInt(s);
			//del(v);
			
			break;
			
			
			
		case '?':
			s=s.substring(1, s.length());
			v=Integer.parseInt(s);
		//	find(v);
			
			break;
			
		}
	}
	
	static void insert(int v) {
		bonus_node tmp=head;
		
		
		
	}

}

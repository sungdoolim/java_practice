package week6;

public class prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		node a=new node();
		node t=a;
		System.out.println(a.value);
		System.out.println(t.value);
		t.value=10;
		t.left=new node();
		System.out.println(a.value);
		System.out.println(t.value);
		System.out.println(a.left.value);
	}

}

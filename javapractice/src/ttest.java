import java.util.ArrayList;

public class ttest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[]tmp=new String[5];int tl;int k;
		ArrayList<String>s=new ArrayList();
		s.add("hi");
		s.add("hello");
		ArrayList<String> s1=(ArrayList<String>) s.clone();
		s1.remove(1);
		System.out.println(s.get(1));
	}

}

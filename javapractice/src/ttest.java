import java.util.ArrayList;

public class ttest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	String a="abcd3423423efgh";
	String b="fghcd3fghjd";
	String c=b.substring(0,3);
	int al=a.length();
	int index=a.indexOf(c);
	System.out.println(al);
	System.out.println(index);
	System.out.println(al-index);
	}

}

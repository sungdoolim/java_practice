import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ref ="agctaagtccgtagctttgccgacgtcagcaaacgttcagggctcttgacaaccttgtctagcgatagcctagc";
		ref=ref.toUpperCase();
		StringBuilder strref=new StringBuilder(ref);
		String str=null;
		try {
		      
			  BufferedReader br;
			
			br = new BufferedReader(new FileReader("C:/Users/bohee/Desktop/mydna2.txt"));
			str=br.readLine();
		br.close();

		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double count=0;
		for(int i=0;i<ref.length();i++) {
			if(ref.charAt(i)!=str.charAt(i)){
				count++;
			}
		}System.out.println(count+"개의 불일치");
			
			

	
	
	
	
	}
	 static void s(StringBuilder a) {
		a.setCharAt(2, 'x');
	}
}

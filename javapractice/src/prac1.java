
public class prac1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ex="100-200*300-500+20";
		solution(ex);
		
	}//   \\+ \\* -
    public static long solution(String expression) {
        long answer = 0;
       /* String[]a=expression.split("\\*|\\+|-");
        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a[2]);
        System.out.println(a[3]);
        System.out.println(a[4]);
        */
        String [][]b=new String[3][3];
        String []a=expression.split("\\*");
        int alen=a.length;
        //for(int i=0;i<alen;i++) {
        	// b[1][]=a[i].split("\\+");
        //}
        
        
        
        return answer;
    }

}

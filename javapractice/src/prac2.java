import java.util.ArrayList;

public class prac2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//String a[]= {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
	String a[]= {"AA", "AB", "AC", "AB", "AC"};
		solution(a);
	
		
	}//   \\+ \\* -

    public static int[] solution(String[] gems) {
        
        int gl=gems.length;
        //String[]gem = new String[gl];
        ArrayList<String>gemt=new ArrayList<>();
       gemt.add(gems[0]);
       
     //   String []
        int count=1;
        for(int i=0;i<gl;i++) {
        for(int j=0;j<gemt.size();j++) {
        	if(gemt.contains(gems[i])) {
        		break;
        	}else {
        		count++;
        		gemt.add(gems[i]);
        		continue;
        	}
        }

        }
        int c1=1;
        int []a=new int[gl];
        int []at=new int[gl];
      //  ArrayList<String>gemt=new ArrayList<>();
        System.out.println(count);
        
        
        
        for(int i=0;i<gl;i++) {
        	c1=1;
        	gemt.clear();
        	gemt.add(gems[i]);
        	for(int j=i+1;j<gl;j++) {
        		if(!(gemt.contains(gems[j]))) {
        			c1++;
        			gemt.add(gems[j]);
        		}
        		if(c1==count) {
        			a[i]=j;
        			break;
        		}
        		
        	}
        	
        	
        	
        }
        
    //    System.out.println(a[0]);
count=0;

    	for(int j=0;j<gl;j++) {
    	//System.out.print(j+" "+a[j]);
    		 at[j]=a[j]-j;
    		// System.out.println(at[j]);
    	}
    	 count=at[0];
    	 c1=0;
    	for(int j=1;j<gl;j++) {
    		if(at[j]<=0)
    			at[j]=100000;
    		
    		if(count>at[j]) {
    			count=at[j];
    			c1=j;}
    					
    	}
    //	System.out.println(c);
    	int[] answer = {c1+1,c1+count+1};
    	//System.out.println(answer[0]+" "+answer[1]);
        return answer;
    }
}

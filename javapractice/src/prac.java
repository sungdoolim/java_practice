
public class prac {

	static Integer a=3;
	public static void main(String[] args) {
	
		int[]numbers= {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		String hand="left";
		
	System.out.println(solution(numbers,hand));
	
	
	
	
	
	}
	
	
	
	
	
	
	   public static String solution(int[] numbers, String hand) {
	        String answer = "";
	        int numlen=numbers.length;
	        int cursorl=10;
	        int cursorr=12;
	        int tl=0;
	        int tr=0;
	        for(int i=0;i<numlen;i++) {
	        	if(numbers[i]==0) {
        		numbers[i]=11;
        		}
	        	
	        	if(numbers[i]%3==1) {
	        		answer+="L";
	        		cursorl=numbers[i];
	        	}else if(numbers[i]%3==0) {
	        		answer+="R";
	        		cursorr=numbers[i];	
	        	}else {
	        		
	        		
	        		
	        		if((cursorl)%3==2) {
	        		tl=Math.abs(cursorl-numbers[i]);
	        				}
	        		else {
	        			tl=numbers[i]-1;

		        		tl=Math.abs(cursorl-tl)+3;
	        		}
	        		
	        		
	        		
	        		if((cursorr)%3==2) {
	        		tr=Math.abs(cursorr-numbers[i]);}
	        		else {
	        			tr=numbers[i]+1;

		        		tr=Math.abs(cursorr-tr)+3;
	        		}
	   
	        		
	        		if(tl<tr) {
	        			answer+="L";
	        			cursorl=numbers[i];
	        		}else if(tr<tl){
	        			answer+="R";
	        			cursorr=numbers[i];
	        		}else {
	        			if(hand.equals("left")) {

		        			answer+="L";
		        			cursorl=numbers[i];
	        			}else {

		        			answer+="R";
		        			cursorr=numbers[i];
	        			}
	        		}
	        	}
	        	
	        	
	        	
	        	
	        	
	        }
	        
	        
	        
	        
	        
	        return answer;
	    }

}


package week11;
//2015112120 임성두

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.Any;

public class bwt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String T="missisippi";
		//String T="acaacg";
		String T="SungDooLim";
		//String T="1234";
		//String T="abccbaabc";
		String[] bwt=BWT(T);   /// bwt(t)를 받아 옵니다.
		int bwtl=bwt.length;
		
		System.out.println("\nBWT(T)의 결과 : ");
		for(int i=0;i<bwtl;i++) {
			System.out.print(bwt[i]);
		}System.out.println();
		
		
		String myText=FindMyText(bwt,bwtl);	
		
		
		
	}
	
	
	
	
	static String FindMyText(String[] bwt,int bwtl) {

		String[] bwt_origin=bwt.clone();
		//현 bwt를 복사합니다.
		String[] bwt_original_tmp=bwt.clone();
		// 현 bwt를 하나더 복사합니다/.
		Arrays.sort(bwt);// 알파벳 순서 정렬 
		String[] bwt_tmp=bwt.clone();
		// 알파벳 순서로 정렬된 bwt를 복사 합니다. 
		
		// sort된 bwt는 처음 열 을 가지게 됩니다. 
	//	Map<String,Integer> har=new HashMap<>();
		String []keys=new String[bwtl];
		int c=0;
		for(int i=0;i<bwtl-1;i++) {
			if(bwt[i].equals(bwt[i+1])) {
				continue;
			}else {
				keys[c]=bwt[i];c++;
			}
		}keys[c]=bwt[bwtl-1];
		int count=0;
//		int kl=0;
//			for(int i=0;i<bwtl-1;i++) {
//			if(bwt[i]==bwt[i+1]) {
//			count++;
//			continue;
//			}else {
//				keys[kl]=bwt[i];
//				har.put(bwt[i], count);
//				count=0;
//				kl++;
//			}
//		}har.put(bwt[bwtl-1], count);
		
		int countmp=0;
		for(int j=0;j<c+1;j++) {
			count=0;
			countmp=0;
			for(int i=0;i<bwtl;i++) {
				if(keys[j].equals(bwt_origin[i])) {
					bwt_original_tmp[i]+=count;count++;
				}
				if(keys[j].equals(bwt[i])) {
					bwt_tmp[i]+=countmp;countmp++;
				}
			}
			
			
		}
//		for(int i=0;i<bwtl;i++) {
//			System.out.println(bwt_origin[i]);
//		}
//		for(int i=0;i<bwtl;i++) {
//			System.out.println(bwt[i]);
//		}
//	
		
	//	String a="SDfdsf";
//		ArrayList<Object> originbwt=new ArrayList<>();
//		originbwt.add("2");
//		originbwt.add('c');
//		originbwt.add(3);
//		System.out.println(originbwt.get(2));
		//ArrayList sortedbwt=new ArrayList<>();

		
		//har.put(bwt[i], count);
		
		for(int i=0;i<bwtl;i++) {
		//	System.out.println(bwt_tmp[i]+","+bwt_original_tmp[i]);	
		}		
		String result="";
		//System.out.println("R="+result);
		
		int i=0;
		String ortmp;
		String btmp;
		test:while(true) {
			
			for(int j=0;j<bwtl;j++) {
				
				ortmp=bwt_original_tmp[i];
				btmp=bwt_tmp[j];
				if(ortmp.equals(btmp)) {
					if(btmp.equals("$0"))
					{	break test;}
					
					result=bwt[j]+result;	
					System.out.println(result);
					i=j;
					
				}else {
					continue;
				}
			}
		}		
		
		System.out.println("R="+result);
		
		
		
		
		
		for(int j=0;j<bwtl;j++) {
			System.out.print(bwt_tmp[j]+" ");
		}System.out.println();
		for(int j=0;j<bwtl;j++) {
			System.out.print(bwt_original_tmp[j]+" ");
		}
		System.out.println();
		return "";
	}
	
	static String[] BWT(String T) {
		
		T="$"+T;
		System.out.println(T+"\n");
		int tl=T.length();
		String []FTRest=new String[tl];
		String tmp1,tmp2;
		for(int i=tl;i>0;i--) {
			// Fill the Rest를 만들어 냅니다.
			tmp1=T.substring(0, i);
			tmp2=T.substring(i);
			FTRest[tl-i]=tmp2+tmp1;
		}

		System.out.println("Fill the Rest : ");
		for(int i=0;i<FTRest.length;i++) {
			//Fill the Rest출력 결과 입니다.
			System.out.println(FTRest[i]);
		}
		
		Arrays.sort(FTRest);
		System.out.println();

		System.out.println("Sorted Fill the Rest : ");
		for(int i=0;i<FTRest.length;i++) {
			//Fill the Rest를 알파벳 순서로 sort한 결과 출력입니다.
			System.out.println(FTRest[i]);
		}
		
		//String bwt="";
		String []bwt2=new String[tl];
		for(int i=0;i<tl;i++) {
			//bwt+=FTRest[i].charAt(tl-1);
			bwt2[i]=FTRest[i].substring(tl-1);
		}
	
		//return bwt;
		return bwt2;
	}
		

}

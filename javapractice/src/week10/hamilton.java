package week10;
//2015112120 임성두

import java.util.ArrayList;
//2015112120 임성두
public class hamilton {

	static ArrayList<String>result=new ArrayList();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> s1=new ArrayList<String>();
		ArrayList<String> s2=new ArrayList<String>();
		ArrayList<String> s3=new ArrayList<String>();
		ArrayList<String> s4=new ArrayList<String>();
		ArrayList<String> s5=new ArrayList<String>();
		s1.add("AGT");s1.add("AAA");s1.add("ACT");s1.add("AAC");
		s1.add("CTT");s1.add("GTA");s1.add("TTT");s1.add("TAA");
		//AGTAAACTTT 이 복원되어 나오면 됩니다.
		s2.add("ATG");s2.add("AGG");s2.add("TGC");s2.add("TCC");
		s2.add("GTC");s2.add("GGT");s2.add("GCA");s2.add("CAG");
		//ATGCAGGTCC 이 복원되어 나오면 됩니다.
		s3.add("ATG");s3.add("TGG");s3.add("TGC");s3.add("GTG");
		s3.add("GGC");s3.add("GCA");s3.add("GCG");s3.add("CGT");
		//ATGCGTGGCA   ATGGCGTGCA 이 복원되어 나오면 됩니다.
		//s4.add("kATG");
		s4.add("ATGC");s4.add("TGCG");s4.add("GCGG");s4.add("CGGC");s4.add("GGCT");
		s4.add("GCTG");s4.add("CTGT");s4.add("GTAT");s4.add("TATG");s4.add("ATGG");
		s4.add("TGGT");s4.add("GGTG");s4.add("TGTA");
		//ATGCGGCTGTATGGTG
		
		s5.add("BBB");s5.add("BBC");s5.add("AAA");
		s5.add("AAB");s5.add("CAA");s5.add("BCA");
		s5.add("AAC");s5.add("ACA");s5.add("ABB");
		// 임의로 만든 것으로 제가 정확한 결과를 예측할 수는 없었지만 어느정도 순환되는 것을 확인하기 위해 만들었습니다. 
		// 위  13 가지 에서 어떤 값을 먼저 시작해도 문자가 완성될 수 있게 구성 했습니다. 
		// 즉 최소 13 개가 나올 수 있고, 제 생각과 달리 연결되는 부분이 더 많아 더 많은 경우를 확인 할 수 있었습니다.

		Spectrum(s1,3);	for(int i=0;i<result.size();i++) {System.out.println(i+1+"번째 경우 : "+result.get(i));}
		System.out.println();
		result.clear();
		Spectrum(s2,3);	for(int i=0;i<result.size();i++) {System.out.println(i+1+"번째 경우 : "+result.get(i));}
		System.out.println();
		result.clear();
		Spectrum(s3,3);	for(int i=0;i<result.size();i++) {System.out.println(i+1+"번째 경우 : "+result.get(i));}
		System.out.println();
		result.clear();
		Spectrum(s4,4);	for(int i=0;i<result.size();i++) {System.out.println(i+1+"번째 경우 : "+result.get(i));}
		System.out.println();
		result.clear();
		Spectrum(s5,3);	for(int i=0;i<result.size();i++) {System.out.println(i+1+"번째 경우 : "+result.get(i));}
		
	//	System.out.println(s1.get(0));
	//	Spectrum(s2,l2);
	//	Spectrum(s4,l3);
	//	Spectrum(s4,l4);
		
	
	}
	
	static void Spectrum(ArrayList<String> s,int l) {
		int len=s.size();
		int f=firstString(s,l,len);
		// 첫번째 문자를 찾아내는 것인데 효율적일지도 모르겠다 생각해 구현 했을뿐 큰 의미는 없습니다.
		//System.out.println(f);
		String t=null;
		if(f>-1) {
		t=s.get(f).toString();
		s.remove(f);
		len=s.size();
		next(s,l,len,t,new ArrayList<String>());
		}// 여기까지의 if문은 사실상 필요 없습니다 - 조금은 효율적으로 활용할수 있다 판단했기에 만들었습니다. 
		//첫 스타트를 해주는 스트링을 찾아내는 것 입니다.
		//첫 스타트를 해주는 스트링을 찾으면 밑의 for문을 하지 않아도 되기에 효율적이라 생각했습니다. (반복을 줄임)
		
		
		
		else {ArrayList<String> scl;
			for(int i=0;i<s.size();i++) {
				// 모든 경우에 대해서 매칭되는 스트링을 찾습니다. 
				// 모든 리스트의 값들이 첫번째 스트링으로 해보면서 반복하는 것 입니다. 
				//- 이 때문에 위에서 firstString을 찾아보려 했습니다
				scl=(ArrayList<String>) s.clone();
				f=i;
				t=scl.get(f).toString();// 리스트의 값을 하나 꺼냅니다
				scl.remove(f);// 꺼낸 것은 바로 리스트에서 지웁니다.
				len=scl.size();
				next(scl,l,len,t,new ArrayList<String>());
				// 꺼낸 스트링에 매칭될수 있는 스트링을 찾는 메서드 입니다. 
				//System.out.println("result : "+rs);
			}
		}
	}
	static  void next(ArrayList<String> s,int l,int len,String t,ArrayList<String> sltmp) {
		//System.out.println(t);
		if(s.isEmpty()) {// 리스트에 스트링이 없다면 전부 매칭이 된것으로 result에 저장합니다
			//System.out.println("return 값: "+t);
			if(!result.contains(t))// 이미 있다면 저장하지 않아도 됩니다.
			{result.add(t);}
			return;// 찾았으면 메서드를 종료합니다.
		}
		String[]tmp=new String[len];
		// 매칭이 될수 있는 경우 하나하나를 담는 배열입니다. 크기는 최대 크기로 리스트의 크기로 줍니다.
		int tl=t.length();//tl-l+1;
		int k=0;
		sltmp=(ArrayList<String>) s.clone();
		//원본은 유지 하기 위해 clone메서드를 사용했습니다. 그리고 클론 된 리스트를 사용합니다.
		int ll=len;
		//System.out.println("지금 들어온 t :"+t);
		String stmp;
		String st;
			for(int j=0;j<len;j++) {
				stmp=s.get(j).toString();
				st=stmp.substring(0, l-1);
			//	System.out.println(st);
			//매칭되는 문자를 리스트에서 찾습니다. 예를 들어 act가 들어오면 매칭되는 cta나 ctg등 'ct'로 시작하는 문자를 찾습니다.
				if(t.substring(tl-l+1).equals(st)) {
					sltmp.remove(j);//찾으면 리스트에서 삭제 합니다
					ll=sltmp.size();
					tmp[k]=t+stmp.substring(l-1);// 문자를 이어서 저장합니다
					//System.out.println(tmp[k]);
					next(sltmp,l,ll,tmp[k],new ArrayList<String>());
					// 와성된 문자에 매칭이되는 스트링을 재귀적으로 다시 찾습니다
					k++;
					sltmp=(ArrayList<String>) s.clone();
					//for문 반복을 위해 다시 리스트를 초기화 합니다.
				}
			}
		return;
	}
	static int firstString(ArrayList<String> s,int l,int len) {
		String t="";
		String t1="";
		int k;
		test:for(int i=0;i<len;i++) {
			k=i;
			t=s.get(i).toString().substring(0,l-1);
			//앞부분을 저장하고...
			for(int j=0;j<len;j++) {
			//	System.out.println(i+","+j);
				if(i==j) {continue;}			
				t1=s.get(j).toString().substring(1);
			//	System.out.println(t+","+t1);
				if(t.equals(t1)) {
					//다른 리스트의 값들의 뒷부분과 같은지를 확인합니다. 
					continue test;
				}
			}
			return k;// 찾으면 그 값의 인덱스를 리턴하고
		}
		return -1;	// 그렇지 않으면 -1입니다.
	}
}

package week10;
//2015112120 임성두

import java.util.ArrayList;

public class hamilton {

	static ArrayList<String>result=new ArrayList();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> s1=new ArrayList();
		ArrayList<String> s2=new ArrayList();
		ArrayList<String> s3=new ArrayList();
		ArrayList<String> s4=new ArrayList();
		ArrayList<String> s5=new ArrayList();
		s1.add("AGT");s1.add("AAA");s1.add("ACT");s1.add("AAC");s1.add("CTT");s1.add("GTA");s1.add("TTT");s1.add("TAA");
		
		s2.add("ATG");s2.add("AGG");s2.add("TGC");s2.add("TCC");s2.add("GTC");s2.add("GGT");s2.add("GCA");s2.add("CAG");
		
		s3.add("ATG");s3.add("TGG");s3.add("TGC");s3.add("GTG");s3.add("GGC");s3.add("GCA");s3.add("GCG");s3.add("CGT");
	
		//s4.add("kATG");
		s4.add("ATGC");s4.add("TGCG");s4.add("GCGG");s4.add("CGGC");s4.add("GGCT");
		s4.add("GCTG");s4.add("CTGT");s4.add("GTAT");s4.add("TATG");s4.add("ATGG");
		s4.add("TGGT");s4.add("GGTG");s4.add("TGTA");
		
		s5.add("AAAA");s5.add("BBBB");s5.add("BBBC");s5.add("BBCA");
		s5.add("AAAB");s5.add("ABBB");s5.add("BCAA");
		s5.add("AABB");
		s5.add("CAAA");s5.add("AAAC");s5.add("AACA");s5.add("ACAA");s5.add("CAAA");
		//AGTAAACTTT
		//String []s2={"ATG", "AGG", "TGC", "TCC", "GTC", "GGT", "GCA", "CAG"};
		//ATGCAGGTCC
		//String []s3={"ATG", "TGG", "TGC", "GTG", "GGC", "GCA", "GCG", "CGT"};
		//ATGCGTGGCA   ATGGCGTGCA
		//String []s4={"ATGC", "TGCG", "GCGG", "CGGC","GGCT", "GCTG",
		//"CTGT", "TGTA", "GTAT", "TATG", "ATGG", "TGGT", "GGTG"};
		//ATGCGGCTGTATGGTG
		
	
		//System.out.println(s1.get(0));
		Spectrum(s1,3);	for(int i=0;i<result.size();i++) {System.out.println(i+","+result.get(i));}
		System.out.println();
		result.clear();
		Spectrum(s2,3);	for(int i=0;i<result.size();i++) {System.out.println(i+","+result.get(i));}
		System.out.println();
		result.clear();
		Spectrum(s3,3);	for(int i=0;i<result.size();i++) {System.out.println(i+","+result.get(i));}
		System.out.println();
		result.clear();
		Spectrum(s4,4);	for(int i=0;i<result.size();i++) {System.out.println(i+","+result.get(i));}
		System.out.println();
		result.clear();
		Spectrum(s5,4);	for(int i=0;i<result.size();i++) {System.out.println(i+","+result.get(i));}
		
	//	System.out.println(s1.get(0));
	//	Spectrum(s2,l2);
	//	Spectrum(s4,l3);
	//	Spectrum(s4,l4);
		
	
	}
	static void Spectrum(ArrayList s,int l) {
		int len=s.size();
		int f=firstString(s,l,len);
		//System.out.println(f);
		String t=null;
		if(f>-1) {
		t=s.get(f).toString();
		s.remove(f);
		len=s.size();
		String rs=next(s,l,len,t,new ArrayList<String>());


		}else {ArrayList<String> scl;
			for(int i=0;i<s.size();i++) {
				scl=(ArrayList<String>) s.clone();
				f=i;
				t=scl.get(f).toString();
				scl.remove(f);
				len=scl.size();
				String rs=next(scl,l,len,t,new ArrayList<String>());
				//System.out.println("result : "+rs);
			}
		}
	}
	static String next(ArrayList s,int l,int len,String t,ArrayList sltmp) {
		if(s.isEmpty()) {
			//System.out.println("return 값: "+t);
			if(!result.contains(t))
			{result.add(t);}
			return t;
		}
		
		String[]tmp=new String[5];int tl;int k;
		sltmp=(ArrayList<String>) s.clone();
		int ll=len;
		//System.out.println("지금 들어온 t :"+t);
		
		 tl=t.length();//tl-l+1;
		k=0;
	
		
		String stmp;
		String st;String r;
		
			for(int j=0;j<len;j++) {
				stmp=s.get(j).toString();
				st=stmp.substring(0, l-1);
			//	System.out.println(st);
				if(t.substring(tl-l+1).equals(st)) {
					sltmp.remove(j);
					ll=sltmp.size();
					tmp[k]=t+stmp.substring(l-1);
					//System.out.println(tmp[k]);
					r=next(sltmp,l,ll,tmp[k],new ArrayList<String>());
					k++;
					sltmp=(ArrayList<String>) s.clone();
				}
				
			}
			for(int i=0;i<tmp.length;i++) {
			//	System.out.println(tmp[i]);
			}
			
		return "X";
		
	}
	static int firstString(ArrayList s,int l,int len) {
		String t="";
		String t1="";
		int k;
		test:for(int i=0;i<len;i++) {
			k=i;
			t=s.get(i).toString().substring(0,l-1);
			for(int j=0;j<len;j++) {
			//	System.out.println(i+","+j);
				
				if(i==j) {continue;}
				
				t1=s.get(j).toString().substring(1);
			//	System.out.println(t+","+t1);
				if(t.equals(t1)) {
					continue test;
				}
			}
			return k;
		}
		return -1;
		
	}

}

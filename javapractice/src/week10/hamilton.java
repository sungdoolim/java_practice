package week10;

import java.util.ArrayList;

public class hamilton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> s1=new ArrayList();
		s1.add("AGT");s1.add("AAA");s1.add("ACT");s1.add("AAC");
		s1.add("CTT");s1.add("GTA");s1.add("TTT");s1.add("TAA");
		
		//AGTAAACTTT
		String []s2={"ATG", "AGG", "TGC", "TCC", "GTC", "GGT", "GCA", "CAG"};
		//ATGCAGGTCC
		String []s3={"ATG", "TGG", "TGC", "GTG", "GGC", "GCA", "GCG", "CGT"};
		//ATGCGTGGCA   ATGGCGTGCA
		String []s4={"ATGC", "TGCG", "GCGG", "CGGC","GGCT", "GCTG", "CTGT", "TGTA", "GTAT", "TATG", "ATGG", "TGGT", "GGTG"};
		//ATGCGGCTGTATGGTG
		
	
		//System.out.println(s1.get(0));
		Spectrum(s1,3);
	//	System.out.println(s1.get(0));
	//	Spectrum(s2,l2);
	//	Spectrum(s4,l3);
	//	Spectrum(s4,l4);
		
		
	}
	static String Spectrum(ArrayList s,int l) {
		int len=s.size();
		int f=firstString(s,l,len);System.out.println(f);
		String t=s.get(f).toString();
		s.remove(f);
		len=s.size();
		

		String rs=next(s,l,len,t,new ArrayList<String>());
		System.out.println(rs);
		
		

		
		return "";
	}
	static String next(ArrayList s,int l,int len,String t,ArrayList sltmp) {
		if(s.isEmpty()) {
			return t;
		}
		
		String[]tmp=new String[5];int tl;int k;
		sltmp=(ArrayList<String>) s.clone();
		int ll=len;
		System.out.println(t);
		
		 tl=t.length();//tl-l+1;
		k=0;
	
		
		String stmp;
		String st;
		
			for(int j=0;j<len;j++) {
				stmp=s.get(j).toString();
				st=stmp.substring(0, l-1);
				System.out.println(st);
				if(t.substring(tl-l+1).equals(st)) {
					sltmp.remove(j);
					ll=sltmp.size();
					tmp[k]=t+stmp.substring(l-1);
					System.out.println(tmp[k]);
					next(sltmp,l,ll,tmp[k],new ArrayList<String>());
					k++;
					sltmp=(ArrayList<String>) s.clone();
				}
				
			}
			for(int i=0;i<tmp.length;i++) {
				System.out.println(tmp[i]);
			}
			
		return "x";
		
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
				
				if(i==j)continue;
				
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

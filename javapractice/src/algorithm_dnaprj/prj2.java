package algorithm_dnaprj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class prj2 {
    static ArrayList<ArrayList<String>> resultList;
    static ArrayList<String> resultString;
    static int COUNT=0;
    static int DENOVCOUNT=0;

    @SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {

        Scanner sc=new Scanner(System.in);
      
        System.out.print("mydna의 길이 입력 : ");
		int l=sc.nextInt();//50만
        System.out.print("shortread 문자열 하나의 길이 입력 : ");
        int k=sc.nextInt();//50만 기준 2000
        System.out.print("shortread 개수 입력: ");
        int n=sc.nextInt();//50만 기준 3000
       
        makemydna.make(k,n,l);
		  ArrayList<String> shortread=fileshort();
	      
		System.out.println("일치 최소 개수 입력 : ");
        int r=sc.nextInt(); // 몇개까지 일치하면 합칠까?
     brute(shortread,r,l,k);
        System.out.println(COUNT);
        sc.close();
        compare_denov.compare(l);
    }
    @SuppressWarnings("unchecked")
    static void brute(ArrayList<String>shortread,int r,int l,int k) throws IOException {
       
        ArrayList<String> shorttmp;
        
        System.out.println("length = "+shortread.size());
            shorttmp=(ArrayList<String>) shortread.clone();
            denov(shorttmp,shorttmp.remove(0),1,r,l,k);

    }
    @SuppressWarnings("unchecked")
	static int denov(ArrayList<String> shorttmp,String res,int i,int r,int l,int k) throws IOException {


        int len_short=k;//short의 길이---------------------------------------


        // 50만
        //1000/5000-10     27% 잘 안되네
        //1000/5000/ 7
        
        //1000/7000/ 10     0.034% / 0.09 /0.09
        //1500 5000 500000 10 0.4% / 7 / 잘 안도미
        //250 20000 500000 10  0.3// 잘 안됨
        //2000 3000 500000 10 0.49 0.41  0.3
        
        

        //10만
       
        //10만 100/2000/ 10   실패
        // 10만/ 200/3000/ 10  실패
        // 10만 / 500/1000/10   실패
        
        //10만 500 2000 100000 10   0.3 /0.4/0.4/0.4
        
        //250 4000 100000 10 0.46 /6% 간혹 실패 
        
        //5만
        //300 2500 50000 10   0.75% /0.67 /0.91/0.91
        
        //250 2000 50000 10   0.28% 0.4% /0.44% 간혹 실패....

        DENOVCOUNT++;
        String result=res;
            System.out.println("count: "+DENOVCOUNT+", "+result.length());
        if(DENOVCOUNT>=1000){
            if(result.length()>l*0.95)
            { writefile(result);
            return 1;}else if(result.length()<l*0.75) {
            	return 0;
            }
           
        }

        String compare;
        String subtmp;
        String subtmp2;String subtmp3;
        int d,j;
        ArrayList<String>tmp;
        int len=shorttmp.size();
        int rindex;
        int rl;int ret;

        int subrl;
        for(j=0;j<len;j++) {

            if(result.length()>=l*0.995) {
                writefile(result);
                return 1;
            }
            compare=shorttmp.get(j);

            subtmp=compare.substring(0,r);
            subtmp2=compare.substring(r);

            if(result.contains(subtmp)) {
                rindex=result.lastIndexOf(subtmp);
                rl=result.length();
                subrl=rl-rindex;
                if(subrl==r) {
                    result+=subtmp2;
                    tmp=(ArrayList<String>) shorttmp.clone();
                    tmp.remove(j);len--;
                    //Collections.shuffle(tmp);
                   ret= denov(tmp,result,j,r,l,k);
                   if(ret==1) {return 1;}
                }else if(subrl<len_short&&subrl>r) {
                    d=subrl-r;
                    subtmp3=subtmp2.substring(0,d);
                    if(result.substring(rl-d).equals(subtmp3)) {
                        result+=subtmp2.substring(d);
                        tmp=(ArrayList<String>) shorttmp.clone();
                        tmp.remove(j);len--;
                     //   Collections.shuffle(tmp);
                      ret=  denov(tmp,result,j,r,l,k);
                      if (ret==1) {  return 1;}
                    }
                }

            }}
        if(result.length()>=l*0.995) {
            writefile(result);
             return 1;
        }
        return 0;
    }
static void writefile(String result){
                try {
                	 PrintWriter pw;
 					pw = new PrintWriter("C:/Users/bohee/Desktop/denov.txt");
                pw.print(result);
                pw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } 
}

    static ArrayList<String> fileshort() {
        ArrayList<String> strlist=new ArrayList<String>();
        BufferedReader br;
        try {
            String str;
            br = new BufferedReader(new FileReader("C:/Users/bohee/Desktop/shortread.txt"));
            while(true) {
                str=br.readLine();
                if(str==null)
                { break;}
                strlist.add(str);
            }br.close();
        } catch ( IOException e) {
            e.printStackTrace();
        }
        return strlist;
    }
}

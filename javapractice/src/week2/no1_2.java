//2015112120 임성두
package week2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class no1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 순환  회문 알고리즘
		
		try{
            //파일 객체 생성
            File file = new File("C:\\Users\\bohee\\Desktop\\sample.txt");
          //입력 스트림 생성, 파일을  한줄 씩 읽어 옵니다
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while((line = bufReader.readLine()) != null){
            	// 파일에 모든 문자를 읽어 올때 까지 ispal 메서드를 실행합니다
               System.out.println(ispal(line));

                
            }
            //.readLine()은 끝에 개행문자를 읽지 않습니다.            
            bufReader.close();
        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }

	}
	static boolean ispal(String s) {
	return recurpal(s,0,s.length());

		
	}
	static boolean recurpal(String s,int index, int len) {
		
		if(index==len/2) {
			return true;
			// 끝까지 다 대칭인지를 확인 했는지를 확인합니다. 끝부분이라면 true 입니다
			
		}
		else if(s.charAt(index)!=s.charAt(len-index-1)) {
			return false;	// 한번이라도 대칭이지 않은 지점이 나오면 false 입니다
			
		}
		else if(index!=len/2) {
			return recurpal(s,index+1,len);
			// 현 인덱스에 대해서 대칭이라면 다음 인덱스도 대칭인지를 재귀함수로  확인합니다
			
		}
		
		return true;
	}
	

}

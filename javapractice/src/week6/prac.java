package week6;

import java.security.Provider;
import java.security.Security;

public class prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Provider provider = Security.getProvider("BC");
		  if (provider != null){
		   System.out.println("Bouncy Castle provider is available");
		   System.out.println(provider.getInfo());
		  } else {
		   System.out.println("Bouncy Castle provider is NOT available");
		  }
	}

}

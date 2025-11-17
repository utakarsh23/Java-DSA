package CodeForces;

import java.util.*;
import java.lang.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for(int i = 0; i < T; i++) {
		    int N = input.nextInt();
		    if(N == 1 || N == 3) {
		        System.out.println(1);
		        continue;
		    }
		    int sec = 1;
		    while(N > 0 && N != 1 && N!= 3) {
		        sec++;
		        N = N-2;
		    }
		    System.out.println(sec);
		    
		}

	}
}

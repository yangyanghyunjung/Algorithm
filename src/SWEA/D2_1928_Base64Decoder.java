package SWEA;

import java.util.Base64;
import java.util.Scanner;

public class D2_1928_Base64Decoder {
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String encodedStr = sc.next();
	        byte[] decodedBytes = Base64.getDecoder().decode(encodedStr);
	        System.out.printf("#%d %s\n", test_case, new String(decodedBytes));

		}
	}
}

package InflearnLecture;

import java.util.Scanner;

public class Madi {
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			char[] strArr = sc.next().toCharArray();
            for(int i = 1; i <= 10; ++i) {
                boolean bMadi = true;
            	for(int j = 0; j < i; ++j) {
                	if(strArr[j] != strArr[i + j]) {
                    	bMadi = false;
                        break;
                    }
                }
            	if (bMadi) {
            		System.out.println(String.format("#%d %d", test_case, i));
            		break;
            	}
            }

		}
	}

}

package SWEA;

import java.util.Scanner;

public class D2_1989_Palindrom {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int result = 1;
			char[] arr = sc.next().toCharArray();
			for (int i = 0; i < arr.length / 2; ++i) {
				if(arr[i] != arr[arr.length - 1 - i]) {
					result = 0;
					break;
				}
			}
			
			System.out.printf("#%d %d\n", test_case, result);
		}
	}
}

package SWEA;

import java.util.Scanner;

public class D2_1986_ZgZeg {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int result = 0;
			for (int i = 1; i<= N; ++i) {
				result += (i % 2 == 0) ? -i : i; 
			}
			
			System.out.printf("#%d %d\n", test_case, result); 

		}
	}
}

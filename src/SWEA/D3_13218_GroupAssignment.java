package SWEA;

import java.util.Scanner;

public class D3_13218_GroupAssignment {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			System.out.printf("#%d %d\n", test_case, N/3);
		}

	}

}

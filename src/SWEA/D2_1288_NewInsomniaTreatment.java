package SWEA;

import java.util.HashSet;
import java.util.Scanner;

public class D2_1288_NewInsomniaTreatment {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int k = 0;
			HashSet hs = new HashSet<Integer>();
			while(true) {
				int num = N * ++k;
				while(num > 0) {
					int digit = num % 10;
					hs.add(digit);
					num /= 10;
				}
				
				if (hs.size() == 10) {
					break;
				}
			}

			System.out.printf("#%d %d\n", test_case, k * N);
		}
	}
}

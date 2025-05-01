package SWEA;

import java.util.Scanner;

public class D2_1284_WaterFeeBattle {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int P = sc.nextInt();
			int Q = sc.nextInt();
			int R = sc.nextInt();
			int S = sc.nextInt();
			int W = sc.nextInt();
			
			int result = 0;
			int aFee = 0;
			int bFee = 0;
			if (W <= R) {
				aFee = P * W;
				bFee = Q;
			} else {
				aFee = P * W;
				bFee = (W - R) * S  + Q;
			}
			result = aFee < bFee ?  aFee : bFee;
			
			System.out.printf("#%d %d\n",test_case, result);
		}
	}
}

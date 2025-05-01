package SWEA;

import java.util.Scanner;

// 간단한 소인수 분해
public class D2_1945_PrimeFactorization {
	public static int[] solution(int N) {
		int[] result = new int[5];
		int[] bases = {2, 3, 5, 7, 11};
		
		for (int i = 0; i < bases.length; ++i) {
			int base = bases[i];
			int facter = 0;
			
			while(N % base == 0) {
				facter++;
				N /= base;
			}
			result[i] = facter;
		}
		
		return result;
	}
	

	public static void main(String[] args) {
//		D2_1945_PrimeFactorization main = new D2_1945_PrimeFactorization();
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			System.out.printf("#%d ", test_case);
			for(int i : solution(N)) {
				System.out.print(String.format("%d ", i));
			}
			System.out.println();
		}

	}

}

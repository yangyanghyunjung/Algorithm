package SWEA;

import java.util.Scanner;

public class D3_1206_SW문제해결기본_1일차 {
	public static int solution(int N, int[] arr) {
		int result = 0;
		for(int i = 2; i < N - 2; ++i) {
			int curr = arr[i];
			int leftMax = Math.max(arr[i - 1], arr[i - 2]);
			int rightMax = Math.max(arr[i + 1], arr[i + 2]);
			int totalMax = Math.max(leftMax, rightMax);
			
			if(totalMax < curr) {
				result += curr - totalMax;
			}
		}
		
		return result;
	}
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i = 0; i < N; ++i) {
				arr[i] = sc.nextInt();
			}
			System.out.printf("#%d %d\n", test_case, solution(N, arr));
		}
	}

}

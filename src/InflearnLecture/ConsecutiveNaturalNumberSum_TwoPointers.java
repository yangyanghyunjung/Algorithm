package InflearnLecture;

import java.util.Scanner;

public class ConsecutiveNaturalNumberSum_TwoPointers {
	public int solution(int N) {
		int cnt = 0;
		int left = 1, sum = 0;
		
		for (int right = 1; right <= N / 2 + 1; ++right) {
			sum += right;
			
			while (sum > N) {
				sum -= left++;
			}
			
			if(sum == N) {
				cnt++;
			}
		}
		
		return cnt;
	}

	public static void main(String[] args) {
		ConsecutiveNaturalNumberSum_TwoPointers T = new ConsecutiveNaturalNumberSum_TwoPointers();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.print(T.solution(N));
	}

}

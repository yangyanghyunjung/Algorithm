package InflearnLecture;

import java.util.Scanner;

public class ConsecutiveSubSequence {
	public int solution(int n, int m, int[] arr) {
		if (n == 1 && arr[0] == m) {
			return 1;
		}
		
		int result = 0;
		 int startIdx = 0, endIdx = 0, sum = arr[startIdx];
		
		 //종료 조건
		 // 1. endIdx가 n-1(arr.length)을 넘었을 경우
		 // 2. endIdx가 마지막인데 sum이 작은 경우
		 
		 while (true) {
			 if (sum < m) {
				if (++endIdx > n - 1) {
					 break;
				 }
				sum += arr[endIdx];
			 } else if (sum > m) {
				 sum -= arr[startIdx++];
			 } else {
				 result++;
				 if (++endIdx > n - 1) {
					 break;
				 }
				 sum = sum - arr[startIdx++] + arr[endIdx];
			 }
		 }
		
		 // 더하고 밑에서 같은지 확인
		return result;
	}
	
	
	public static void main(String[] args) {
		ConsecutiveSubSequence T = new ConsecutiveSubSequence();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = sc.nextInt();
		}
		System.out.print(T.solution(n, m, arr));
	}

}

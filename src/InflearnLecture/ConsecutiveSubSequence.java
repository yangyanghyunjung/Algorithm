package InflearnLecture;

import java.util.Scanner;

public class ConsecutiveSubSequence {
	public int solution(int n, int m, int[] arr) {
		if (n == 1 && arr[0] == m) {
			return 1;
		}
		
		int result = 0;
		 int startIdx = 0, endIdx = 0, sum = arr[startIdx];
		
		 //���� ����
		 // 1. endIdx�� n-1(arr.length)�� �Ѿ��� ���
		 // 2. endIdx�� �������ε� sum�� ���� ���
		 
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
		
		 // ���ϰ� �ؿ��� ������ Ȯ��
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

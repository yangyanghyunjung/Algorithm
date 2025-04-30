package InflearnLecture;

import java.util.Scanner;

public class MaxSales {
	public int solution(int n, int k, int[] arr) {
		int sum = 0;
		for (int i = 0; i < k; ++i) {
			sum += arr[i];
		}
		int result = sum;
		
		for (int i = k; i < n; ++i) {
			sum = sum - arr[i - k] + arr[i];
			if (result < sum) {
				result = sum;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		MaxSales T = new MaxSales();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0 ; i < n; ++i) {
			arr[i] = sc.nextInt();
		}
		
		System.out.print(T.solution(n, k, arr));
	}
}

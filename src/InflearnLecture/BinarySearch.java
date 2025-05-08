package InflearnLecture;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
	public static int solution(int N, int M, int[] arr) {
		int result = -1;
		int l = 0;
		int r = N - 1;
		
		while(l <= r) {
			int m = l + (r - l) / 2;
			if(arr[m] == M) {
				return m + 1;
			}
			
			if(arr[m] < M) {
				l = m + 1;
			} else {
				r = m - 1;
			} 
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; ++i) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		System.out.print(solution(N, M, arr));
	}

}

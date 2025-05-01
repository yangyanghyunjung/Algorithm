package InflearnLecture;

import java.util.Scanner;

public class MaxConsecutiveSubSequence {
	public static int solution(int n, int k, int[] arr) {
		int max = 0, LT = 0, cnt0 = 0, length = 0;
		
		for(int RT = 0; RT < n; ++ RT) {
			if(arr[RT] == 0) {
				cnt0++;
			}
			while(cnt0 > k) {
				if(arr[LT] == 0) {
					cnt0--;
				} 
				LT++;
			}
			length = RT - LT + 1;
			max = Math.max(max, length);
		}
		
		
		return max;
	}
	
	public static void main(String[] args) {
		MaxConsecutiveSubSequence T = new MaxConsecutiveSubSequence();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = sc.nextInt();
		}
		System.out.println(T.solution(n, k, arr));
	}

}

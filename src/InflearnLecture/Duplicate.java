package InflearnLecture;

import java.util.Scanner;

public class Duplicate {
	public static String solution(int n, int[] arr) {
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < i; ++j) {
				if(arr[i] == arr[j]) {
					return "D";
				}
			}
		}
		return "U";
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; ++i) {
			arr[i] = sc.nextInt();
		}
		System.out.println(solution(n, arr));
	}
}

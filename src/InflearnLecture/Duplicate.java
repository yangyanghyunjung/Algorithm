package InflearnLecture;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Duplicate {
	public static String solution(int n, int[] arr) {
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < n; ++i) {
			if(set.contains(arr[i])) {
				return "D";
			}
			set.add(arr[i]);
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

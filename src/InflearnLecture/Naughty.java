package InflearnLecture;

import java.util.Scanner;

public class Naughty {
	public static void solution(int n, int[] arr) {
		int[] sortedArr = arr.clone();
		for(int i = 0; i < n - 1; ++i) {
			int minIdx = i;
			
			for(int j = i + 1; j < n; ++j) {
				if(sortedArr[minIdx] > sortedArr[j]) {
					minIdx = j;
				}
			}
			if(i != minIdx) {
				int tmp = sortedArr[i];
				sortedArr[i] = sortedArr[minIdx];
				sortedArr[minIdx] = tmp;
			}
		}
		
		for(int k = 0; k < n; ++k) {
			if(arr[k] != sortedArr[k]) {
				System.out.printf("%d ", k + 1);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; ++i) {
			arr[i] = sc.nextInt();
		}
		solution(n, arr);
	}

}

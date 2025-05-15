package InflearnLecture;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CoinTranslation {
	static int N;
	static int M;
	static int min = Integer.MAX_VALUE;
	static int[] arr;
	
	public void DFS(int L, int sum) {
		if(L >= min) {
			return;
		}
		if(sum > M) {
			return;
		} else if(sum == M) {
			min = Math.min(min, L);
			return;
		}
		
		for(int i = 0; i < N; ++i) {
			DFS(L + 1, sum + arr[i]);
		}
	}
	public static void main(String[] args) {
		CoinTranslation T = new CoinTranslation();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for(int i = 0; i < N; ++i) {
			arr[i] = sc.nextInt();
		}
		//Arrays.sort(arr, Collections.reverseOrder());
		
		for(int i = 0; i < N - 1; ++i) {
			int maxIdx = i;
			for(int j = i + 1; j < N; ++j) {
				if(arr[maxIdx] < arr[j]) {
					maxIdx = j;
				}
			}
			if(maxIdx != i) {
				int tmp = arr[maxIdx];
				arr[maxIdx] = arr[i];
				arr[i] = tmp;
				
			}
		}
		M = sc.nextInt();
		T.DFS(0, 0);
		System.out.print(min);
	}

}

package InflearnLecture;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class KLargeValue {
	public int solution(int N, int k, int[] arr) {
		int result = -1;
		TreeSet<Integer> tSet = new TreeSet<>(Collections.reverseOrder());
		
		for(int i = 0; i < N - 2; ++i) {
			for(int j = i + 1; j < N - 1; ++j) {
				for(int l = j + 1; l < N; ++l) {
					tSet.add(arr[i] + arr[j] + arr[l]);
				}
			}
		}
		int cnt = 0;
		for (int i : tSet) {
			cnt++; 
			if(cnt == k) {
				return i;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		KLargeValue T = new KLargeValue();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; ++i) {
			arr[i] = sc.nextInt();
		}
		System.out.print(T.solution(N, k, arr));
	}

}

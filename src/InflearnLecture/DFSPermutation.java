package InflearnLecture;

import java.util.Scanner;

public class DFSPermutation {
	static int N;
	static int M;
	static int[] arr;
	static int[] check;
	static int[] result;
	
	public void DFS(int L) {
		if(L == M) {
			String s = "";
			for(int i = 0; i < M; ++i) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; ++i) {
			if(check[i] == 0) {
				result[L] = arr[i];
				check[i] = 1;
				DFS(L + 1);
				check[i] = 0;
			}
		}
	}
	public static void main(String[] args) {
		DFSPermutation T = new DFSPermutation();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		check = new int[N];
		result = new int[M];
		
		for(int i = 0; i < N; ++i) {
			arr[i] = sc.nextInt();
		}
		T.DFS(0);
	}

}

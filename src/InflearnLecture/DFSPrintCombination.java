package InflearnLecture;

import java.util.Scanner;

public class DFSPrintCombination {
	static int N;
	static int M;
	static int[] cb;
	
	public static void DFS(int L, int nv) {
		if(L == M) {
			for(int i = 0; i < M; ++i) {
				System.out.print(cb[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = nv; i <= N; ++i) {
			cb[L] = i;
			DFS(L + 1, i + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		cb = new int[N];
		DFS(0, 1);
	}

}

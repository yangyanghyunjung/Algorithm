package InflearnLecture;

import java.util.Scanner;

public class DFSDuplicatePermutation {
	static int N;
	static int M;
	static int[] ch;
	public void DFS(int L) {
		if(L == M) {
			for(int i = 0; i< M; ++i) {
				System.out.print(ch[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N; ++i) {
			ch[L] = i;
			DFS(L + 1);
			//ch[L] = 0;// 뺴도 됨! ==> i는 for문 끝나면 자동 갱신
		}
		
	}
	public static void main(String[] args) {
		DFSDuplicatePermutation T = new DFSDuplicatePermutation();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		ch = new int[M];
		T.DFS(0);
		
	}

}

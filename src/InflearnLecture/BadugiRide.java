package InflearnLecture;

import java.util.Scanner;

public class BadugiRide {
	static int C;
	static int N;
	static int[] baduk;
	static int max;
	
	public void DFS(int L, int sum) {
		if(L == N) {
			if(sum <= C && sum > max) {
				max = sum;
			}
			return;
		}
		if(sum > C) {
			return;
		}
		DFS(L + 1, sum + baduk[L]);
		DFS(L + 1, sum);
	}
	public static void main(String[] args) {
		BadugiRide T = new BadugiRide();
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		N = sc.nextInt();
		
		baduk = new int[N];
		for(int i = 0; i < N; ++i) {
			baduk[i] = sc.nextInt();
		}
		T.DFS(0, 0);
		System.out.println(max);
	}

}

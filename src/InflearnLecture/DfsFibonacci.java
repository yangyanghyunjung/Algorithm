package InflearnLecture;

import java.util.Scanner;

public class DfsFibonacci {
	static int[] fibo;
	public static int Dfs(int N) {
		if(fibo[N] > 0) {
			return fibo[N];
		}
		if(N == 1) {
			return fibo[N] = 1;
		} 
		else if(N == 2) {
			return fibo[N] = 1;
		} 
		
		return fibo[N] = Dfs(N - 2) + Dfs(N - 1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		fibo = new int[N + 1];
		Dfs(N);
		for(int i = 1; i <= N; ++i) {
			System.out.print(fibo[i] + " ");
		}
	}
}

package InflearnLecture;

import java.util.Scanner;

public class Combination_Memoization {
	static int[][] ch;
	
	public static int Dfs(int n, int r) {
		if(ch[n][r] > 0) {
			return ch[n][r];
		}
		
		if(n == r || r == 0) {
			return 1;
		} else {
			return ch[n][r] = Dfs(n-1, r-1) + Dfs(n-1, r);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		
		ch = new int[n + 1][r + 1];
		System.out.println(Dfs(n, r));
	}

}

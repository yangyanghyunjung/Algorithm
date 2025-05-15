package InflearnLecture;

import java.util.Scanner;

public class Combination_Memoization {
	static int[][] ch;
	
	public static int Dfs(int n, int r) {
		if(n == r || r == 0) {
			return 1;
		} else {
			
			int a = ch[n -1][r-1];
			if(a == 0) {
				a = Dfs(n-1, r-1);
				ch[n -1][r-1] = a;
			}
			
			int b = ch[n -1][r];
			if(b == 0) {
				b = Dfs(n-1, r);
				ch[n -1][r] = b;
			}
			
			return a + b;
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

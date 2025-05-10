package InflearnLecture;

import java.util.Scanner;

public class DfsFibonacci {
	public static int Dfs(int N) {
		if(N == 0) {
			return 0;
		} 
		else if(N == 1) {
			return 1;
		} 
		
		return Dfs(N - 2) + Dfs(N - 1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 1; i <= N; ++i) {
			System.out.print(Dfs(i) + " ");
			
		}
	}
}

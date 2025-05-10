package InflearnLecture;

import java.util.Scanner;

public class DfsFactorial {
	public static int Dfs(int N) {
		if(N == 1) {
			return 1;
		} else {
			return N * Dfs(N - 1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(Dfs(N));
	}

}

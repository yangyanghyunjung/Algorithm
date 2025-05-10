package InflearnLecture;

import java.util.Scanner;

public class DfsBinary {
	public static void Dfs(int N) {
		if(N == 1) {
			System.out.print(1);
		} else {
			Dfs(N / 2);
			System.out.print(N % 2);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Dfs(N);
	}
}

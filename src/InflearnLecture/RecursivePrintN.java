package InflearnLecture;
import java.util.Scanner;

public class RecursivePrintN {
	public static void Dfs(int N) {
		if(N == 0) {
			return;
		} else {
			Dfs(N - 1);
			System.out.print(N);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Dfs(N);
	}

}

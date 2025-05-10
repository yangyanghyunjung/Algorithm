package InflearnLecture;

import java.util.Scanner;

public class ForFibonacci {
	public static void solution(int N) {
		int pre = 0;
		int curr = 1;
		System.out.print(curr + " ");
		for(int i = 1; i < N; i++) {
			int tmp = pre;
			pre = curr;
			curr += tmp;
			System.out.print(curr + " ");
			
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		solution(N);
	}
}

package InflearnLecture;

import java.util.Scanner;

public class ConsecutiveNaturalNumberSum_Math {
	public int solution(int N) {
		int result = 0;
		int digitCnt = 1;
		N--;
		
		while(N > 0) {
			digitCnt++;
			N -= digitCnt;
			if (N % digitCnt == 0) result++; 
		}
		
		return result;
	}

	public static void main(String[] args) {
		ConsecutiveNaturalNumberSum_Math T = new ConsecutiveNaturalNumberSum_Math();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.print(T.solution(N));
	}
}

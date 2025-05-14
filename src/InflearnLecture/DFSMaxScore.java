package InflearnLecture;

import java.util.Scanner;

public class DFSMaxScore {
	static final int SCORE = 0;
	static final int TIME = 1;
	
	static int N; // 문제 수
	static int M; // 제한 시간
	static int[][] arr;
	static int maxScore = 0;
	
	public void DFS(int L, int scoreSum, int timeSum) {
		if(timeSum > M) { // 걔를 포함했는데 M 보다 크면 그 밑으로 가지 치면 안되고 옆으로 가지 쳐야함
			return;
		}
		
		if(L == N) {
			maxScore = Math.max(maxScore, scoreSum);
			return;
		}
		
		DFS(L + 1, scoreSum + arr[L][SCORE], timeSum + arr[L][TIME]);
		DFS(L + 1, scoreSum, timeSum);
		
	}
	public static void main(String[] args) {
		DFSMaxScore T = new DFSMaxScore();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][2];
		
		for(int i = 0; i < N; ++i) {
			arr[i][SCORE] = sc.nextInt();
			arr[i][TIME] = sc.nextInt();
		}
		T.DFS(0, 0, 0);
		System.out.println(maxScore);
	}

}

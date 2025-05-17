package InflearnLecture;

import java.util.Scanner;

public class DFSIsland {
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}; // 위 부터 시계
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1}; // 위 부터 시계
	static final int dir_cnt = 8;
	
	static int N;
	static int[][] board;
	
	public static void DFS(int r, int c) {
		for(int i = 0; i < dir_cnt; ++i) {
			int nr = r + dr[i], nc = c + dc[i];
			
			if(nr >= 0 && nr < N && nc >= 0 && nc < N && board[nr][nc] == 1) {
				board[nr][nc] = 0;
				DFS(nr, nc);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		board = new int[N][N];
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				board[i][j] = sc.nextInt();
			}
		}
		
		
		int cnt = 0;
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				if(board[i][j] == 1) {
					board[i][j] = 0;
					DFS(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}

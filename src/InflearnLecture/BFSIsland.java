package InflearnLecture;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSIsland {
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	static int N;
	static final int dir_cnt = 8;
	static final int row = 0;
	static final int col = 1;
	
	public static void BFS(int r, int c, int[][] board) {
		Queue<int[]> Q = new LinkedList<int[]>();
		Q.offer(new int[] {r, c});
		
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			int cr = cur[row], cc = cur[col];
			
			for(int i = 0; i < dir_cnt; ++i) {
				int nr = cr + dr[i], nc = cc + dc[i];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && board[nr][nc] == 1) {
					board[nr][nc] = 0;
					Q.offer(new int[] {nr, nc});
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[][] board = new int[N][N];
		
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
					BFS(i, j, board);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}

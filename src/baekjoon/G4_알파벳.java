package baekjoon;

import java.util.Scanner;

public class G4_¾ËÆÄºª {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] board;
	static int R;
	static int C;
	static boolean[] alpah = new boolean[91];
	static int maxCnt = Integer.MIN_VALUE;
	
	
	public static void DFS(int L, int r, int c) {
		if(L == R * C) {
			return;
		}
		
		for(int i = 0; i < 4; ++i) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr >= 0 && nr < R && nc >= 0 && nc < C && !alpah[board[nr][nc]]) {
				alpah[board[nr][nc]] = true;
				DFS(L + 1, nr, nc);
				alpah[board[nr][nc]] = false;
			}
		}
		maxCnt = Math.max(maxCnt, L);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		
		board = new int[R][C];
		for(int i = 0; i < R; ++i) {
			char[] tmp = sc.next().toCharArray();
			for(int j = 0; j < C; ++j) {
				board[i][j] = tmp[j];
			}
		}

		alpah[board[0][0]] = true;
		DFS(0, 0, 0);
		System.out.println(maxCnt + 1);
	}

}

package baekjoon;

import java.util.Scanner;

public class G4_¾ËÆÄºª {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static char[][] board;
	static int R, C;
	static boolean[] alpah = new boolean[26];
	static int maxCnt = Integer.MIN_VALUE;
	
	
	public static void DFS(int L, int r, int c) {
		alpah[board[r][c] - 'A'] = true;
		maxCnt = Math.max(maxCnt, L);
		
		for(int i = 0; i < 4; ++i) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr >= 0 && nr < R && nc >= 0 && nc < C && !alpah[board[nr][nc] - 'A']) {
				DFS(L + 1, nr, nc);
			}
		}
		alpah[board[r][c] - 'A'] = false;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();
		
		board = new char[R][C];
		 for (int i = 0; i < R; i++) {
            board[i] = sc.nextLine().toCharArray();
        }

		DFS(0, 0, 0);
		System.out.println(maxCnt + 1);
	}

}

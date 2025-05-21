package baekjoon;

import java.util.Scanner;

public class S1_안전영역 {
	static int rain = 0;
	static int N;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	
	public static void DFS(int r, int c, boolean[][] ch) {
		for(int i = 0; i < 4; ++i) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] > rain && !ch[nr][nc]) {
				ch[nr][nc] = true;
				DFS(nr, nc, ch);
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		int maxHeight = 0;
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				int h = sc.nextInt();
				map[i][j] = h;
				maxHeight = Math.max(maxHeight, h);
			}
		}
		
		int maxCnt = 0;
		for(int i = maxHeight - 1; i >=0; --i) {
			rain = i;
			int safeCnt = 0;
			boolean[][] ch = new boolean[N][N];
			
			for(int j = 0; j < N; ++j) {
				for(int k = 0; k < N; ++k) {
					if(map[j][k] > i && !ch[j][k]) {
						safeCnt++;
						ch[j][k] = true;
						DFS(j, k, ch);
					}
				}
			}
			maxCnt = Math.max(maxCnt, safeCnt);
		}
		
		
		System.out.println(maxCnt);
	}
}

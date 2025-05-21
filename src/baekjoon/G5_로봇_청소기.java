package baekjoon;

import java.util.Scanner;

public class G5_로봇_청소기 {
	static int[][] room;
	static int[] dr = new int[]{-1, 0,1, 0}; // 위, 오, 아, 왼
	static int[] dc = new int[]{0, 1, 0, -1};
	static int result = 0;
	static boolean[][] visited;
	
	public static void DFS(int cr, int cc, int cd) {
		if(!visited[cr][cc]) {
			visited[cr][cc] = true;
			result++;
		} 
		
		for(int i = 0; i < 4; ++i) {
			cd = (cd + 3) % 4; // 90도
			int nr = cr + dr[cd];
			int nc = cc + dc[cd];
			
			if(!visited[nr][nc] && room[nr][nc] == 0) {
				cr = nr;
				cc = nc;
				DFS(cr, cc, cd);
				return;
			}
			
		}
		
		int nr = cr - dr[cd]; // 180도 반대
		int nc = cc - dc[cd];
		
		if(room[nr][nc] == 0) DFS(nr, nc, cd);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int cr = sc.nextInt();
		int cc = sc.nextInt();
		int cd = sc.nextInt();
		room = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				room[i][j] = sc.nextInt();
			}
		}
		
		DFS(cr, cc, cd);
		System.out.println(result);
	}
}

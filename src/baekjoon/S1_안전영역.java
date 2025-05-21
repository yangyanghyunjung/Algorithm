package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class S1_��������_Dot{
	int r, c;
	
	S1_��������_Dot(int r, int c){
		this.r = r;
		this.c = c;
	}
}

public class S1_�������� {
	static int N;
	static int[][] map;
	static boolean[][] ch;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	
	public static void BFS(int r, int c, int rain) {
		Queue<S1_��������_Dot> Q = new LinkedList<S1_��������_Dot>();
		Q.offer(new S1_��������_Dot(r, c));
		
		while(!Q.isEmpty()) {
			S1_��������_Dot cur = Q.poll();
			
			for(int i = 0; i < 4; ++i) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !ch[nr][nc] && map[nr][nc] > rain){
					ch[nr][nc] = true;
					Q.offer(new S1_��������_Dot(nr, nc));
				}
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
		for(int h = 0; h < maxHeight; h++) {
			ch = new boolean[N][N];
			int cnt = 0;
			
			for(int i = 0; i < N; ++i) {
				for(int j = 0; j < N; ++j) {
					if(map[i][j] > h && !ch[i][j]) {
						ch[i][j] = true;
						cnt++;
						BFS(i, j, h);
					}
				}
			}
			maxCnt = Math.max(maxCnt, cnt);
		}
		System.out.println(maxCnt);
	}
}

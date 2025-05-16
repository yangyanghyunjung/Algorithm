package InflearnLecture;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSTomato {
	static int N;
	static int M;
	static int result;
	static int[][] tomatos;
	static int[][] dist;
	
	static int[] dr = {-1, 0, 1, 0}; 
	static int[] dc = {0, 1, 0, -1};
	static Queue<int[]> Q = new LinkedList<>();
	
	public static void BFS() {
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			for(int i  = 0; i < 4; ++i) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && tomatos[nr][nc] == 0) {
					int tmp = dist[cr][cc] + 1;
					dist[nr][nc] = tmp;
					result = Math.max(result, tmp);
					tomatos[nr][nc] = 1;
					Q.offer(new int[] {nr, nc});
				}
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt(); 
		N = sc.nextInt(); 
		tomatos =  new int[N][M];
		dist =  new int[N][M];
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				int t = sc.nextInt();
				if(t == 1) {
					Q.offer(new int[]{i , j});
				} 
				
				tomatos[i][j] = t;
			}
		}
		
		if(Q.isEmpty()) {
			System.out.println(0);
		} else {
			BFS();
			
			boolean bRiped = true;
			for(int i = 0; i < N; ++i) {
				for(int j = 0; j < M; ++j) {
					int t = tomatos[i][j];
					if(t == 0) {
						bRiped = false;
					} 
				}
			}
			if(bRiped) {
				System.out.println(result);
			} else {
				System.out.println(-1);
			}
		}
	}

}

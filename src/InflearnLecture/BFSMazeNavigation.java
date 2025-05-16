package InflearnLecture;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSMazeNavigation {
	static int cnt = 0;
	static int min = Integer.MAX_VALUE;
	static int[][] board = new int[8][8];
	static int[][] dis = new int[8][8];
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	
	public void BFS(int x, int y) {
		Queue<int[]> Q = new LinkedList<>();
		Q.add(new int[]{x, y});
		board[x][y] = 1;
		
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			board[cur[0]][cur[1]] = 1;
			
			for(int j = 0; j < 4; ++j) {
				int nx = cur[0] + dx[j]; 
				int ny = cur[1] + dy[j]; 
				
				if(nx >=1 && nx <= 7 && ny >=1 && ny <= 7 && board[nx][ny] == 0) {
					board[nx][ny] = 1;
					Q.offer(new int[] {nx, ny});
					dis[nx][ny] = dis[cur[0]][cur[1]] + 1;
					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		BFSMazeNavigation T = new BFSMazeNavigation();
		Scanner sc = new Scanner(System.in);
		for(int i = 1; i <= 7; ++i) {
			for(int j = 1; j <=7; ++j) {
				board[i][j] = sc.nextInt();
			}
		}
		T.BFS(1, 1);
		if(dis[7][7] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(dis[7][7]);
		}
	}

}

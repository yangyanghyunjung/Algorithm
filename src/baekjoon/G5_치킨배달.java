package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class chi_Dot{
	int r, c;
	
	public chi_Dot(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class G5_Ä¡Å²¹è´Þ {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int N;
	static int closeStroeCnt;
	
	static int[][] map;
	static ArrayList<chi_Dot> storeList;
	static int minDist = Integer.MAX_VALUE;
	static int minLevel = Integer.MAX_VALUE;
	
	
	public static int BfsGetMinDist(boolean[][] ch_dist, chi_Dot d) {
		int result = 0;
		int L = 0;
		Queue<chi_Dot> Q = new LinkedList<>();
		Q.offer(d);
		
		while(!Q.isEmpty()) {
			chi_Dot cur = Q.poll();
			int cr = cur.r;
			int cc = cur.c;
			
			if(map[cr][cc] == 2) {
				return Math.abs(d.r - cr) + Math.abs(d.c - cc);
			}
			
			for(int i = 0; i < 4; ++i) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				
				if(nr >=0 && nr < N && nc >=0 && nc < N && !ch_dist[nr][nc]) {
					ch_dist[nr][nc] = true;
					Q.offer(new chi_Dot(nr, nc));
				}
			}
		}
		
		
		return result;
	}
	public static void DfsFindStore(int L, int s) {
		if(L == closeStroeCnt) {
			// Bfs È£Ãâ
			int sum = 0;
			for(int i = 0; i < N; ++i) {
				for(int j = 0; j < N; ++j) {
					if(map[i][j] == 1) {
						boolean[][] ch_dist = new boolean[N][N];
						ch_dist[i][j] = true;
						sum += BfsGetMinDist(ch_dist, new chi_Dot(i, j));
						
						if(sum > minDist) break;
					}
				}
				
			}
			minDist = Math.min(minDist, sum);
			return;
		}
		
		for(int i = s; i < storeList.size(); ++i) {
			chi_Dot d = storeList.get(i);
			int r = d.r;
			int c = d.c;
			
			map[r][c] = 0; //  Æó¾÷
			DfsFindStore(L + 1, i + 1);
			map[r][c] = 2; //  º¹±Í
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		
		map = new int[N][N];
		
		
		
		storeList = new ArrayList<>();
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				int val = sc.nextInt();
				map[i][j] = val;
				if(val == 2) storeList.add(new chi_Dot(i, j));
			}
		}
		closeStroeCnt = storeList.size() - M;
		
		DfsFindStore(0, 0);
		
		System.out.println(minDist);
		
	}

}

package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Dir{
	int d, s;
	
	Dir(int d, int s) {
		this.d = d;
		this.s = s;
	}
}
class Dot{
	int r, c;
	
	Dot(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class G5_마법사_상어와_비바라기 {
	static int N, M;
	static int[][] board;
	static boolean[][] wasCloud;
	static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1}; // 서, 북서, 북, 북동, 동, 남동, 남, 남서
	static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
	static ArrayList<Dot> clouds;
	
	
	public static void magic(int d, int s) {
		wasCloud = new boolean[N][N];
		ArrayList<Dot> newClouds = new ArrayList<>();
		
		// clouds에 들어있는 구름 이동
		for(Dot x : clouds) {
			int cr = x.r;
			int cc = x.c;
			
			// 1이면 구름 이동 (d방향으로 s만큼)
			cr = (cr + dr[d] * s + N * 100) % N;
			cc = (cc + dc[d] * s + N * 100) % N;
			
			// 물 +1씩
			board[cr][cc] += 1;
			wasCloud[cr][cc] = true;
			newClouds.add(new Dot(cr, cc));
			
		}
		
		// 대각선 탐색 -> 0이상이면 현재에 + 1; (물복사)
		for(Dot x : newClouds) {
			int cr = x.r;
			int cc = x.c;
			
			for(int k = 1; k <= 7; k += 2) {
				int tr = cr + dr[k];
				int tc = cc + dc[k];
				int cnt = 0;
				if(tr >= 0 && tr < N && tc >= 0 && tc < N  && board[tr][tc] > 0) {
					cnt++;
				}
				board[cr][cc] += cnt;
			}
			
		}
		clouds.clear();
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				if(!wasCloud[i][j] && board[i][j] >= 2) {
					// 이동한 곳에 물-2
					board[i][j] -=  2;
					clouds.add(new Dot(i, j));
				} 
			}
		}
	}
	

	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		board = new int[N][N];
		clouds = new ArrayList<>();
		
		// 격자 초기화
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				board[i][j] = sc.nextInt();
			}
		}
		// 초기 구름 설정
		clouds.add(new Dot(N-2, 0));
		clouds.add(new Dot(N-2, 1));
		clouds.add(new Dot(N-1, 0));
		clouds.add(new Dot(N-1, 1));
		
		// 이동 정보 초기화
		for(int i = 0; i < M; ++i) {
			magic(sc.nextInt() - 1, sc.nextInt()); //d, s
		}
		
		// board 총 물량 탐색
		int sum = 0;
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				sum += board[i][j];
			}
			
		}
		
		System.out.println(sum);
	}

}

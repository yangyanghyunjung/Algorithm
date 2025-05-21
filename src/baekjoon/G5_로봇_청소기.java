package baekjoon;

import java.util.Scanner;

public class G5_로봇_청소기 {
	static int[][] room;
	static int[] dr = new int[]{-1, 0,1, 0}; // 위, 오, 아, 왼
	static int[] dc = new int[]{0, 1, 0, -1};
	static int cd;
	
	public static int solution(int cr, int cc) {
		int result = 0;
		
		while(true) {
			if(room[cr][cc] == 0) {
				room[cr][cc] = 2;
				result++;
			} 
			
			boolean bClean = false;
			for(int i = 0; i < 4; ++i) {
				cd = (cd + 3) % 4; // 90도
				int nr = cr + dr[cd];
				int nc = cc + dc[cd];
				
				if(room[nr][nc] == 0) {
					bClean = true;
					cr = nr;
					cc = nc;
					break;
				}
				
			}
			
			if(bClean) continue;
				
			int nr = cr - dr[cd]; // 180도 반대
			int nc = cc - dc[cd];
			
			if(room[nr][nc] == 1) break;
			
			cr = nr;
			cc = nc;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int cr = sc.nextInt();
		int cc = sc.nextInt();
		cd = sc.nextInt();
		room = new int[N][M];
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				room[i][j] = sc.nextInt();
			}
		}
		System.out.println(solution(cr, cc));
	}
}

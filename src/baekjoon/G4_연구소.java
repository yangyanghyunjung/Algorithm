package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class G4_楷备家_Dot{
	int r, c;
	
	G4_楷备家_Dot(int r, int c){
		this.r = r;
		this.c = c;
	}
}

public class G4_楷备家 {
	static int[] dr = new int[]{-1, 0, 1, 0};
	static int[] dc = new int[]{0, 1, 0, -1};
	static int[][] board;
	static boolean[][] polluted;
	static int N;
	static int M;
	
	static int maxEcnt;
	
	static ArrayList<G4_楷备家_Dot> empty = new ArrayList<>();
	static ArrayList<G4_楷备家_Dot> virus = new ArrayList<>();
	
	
	public static void DfsSpreadVirus(int r, int c, int[][] newBoard) {
		for(int i = 0; i < 4; ++i) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr >= 0 && nr < N && nc >= 0 && nc < M && newBoard[nr][nc] == 0 && !polluted[nr][nc]) {
				newBoard[nr][nc] = 2;
				polluted[nr][nc] = true;
				DfsSpreadVirus(nr, nc, newBoard);
			}
		}
	}
	
	public static void DfsMakeWall(int L, int s) {
		if(L == 3) {
			int[][] newBoard = new int[N][M];
			for(int i = 0; i< N; ++i) {
				newBoard[i] = board[i].clone();
			}
			
			polluted = new boolean[N][M];
			int cnt = 0;
			
			for(G4_楷备家_Dot d : virus) {
				int vr = d.r;
				int vc = d.c;
				
				DfsSpreadVirus(vr, vc, newBoard);
			}
			
			for(int i = 0; i < N; ++i) {
				for(int j = 0; j < M; ++j) {
					if(newBoard[i][j] == 0) {
						cnt++;
					}
				}
			}
			
			maxEcnt = Math.max(cnt, maxEcnt);
			return;
		}
		
		for(int i = s; i < empty.size(); ++i) {
			G4_楷备家_Dot tmp = empty.get(i);
			int r = tmp.r;
			int c = tmp.c;
			
			if(board[r][c] == 0) {
				board[r][c] = 1;
				DfsMakeWall(L + 1, i + 1);
				board[r][c] = 0;
			}
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		board = new int[N][M];
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				int val = sc.nextInt();
				board[i][j] = val;
				
				if(val == 0) {
					empty.add(new G4_楷备家_Dot(i,j));
				}
				else if(val == 2) {
					virus.add(new G4_楷备家_Dot(i,j));
				}
			}
			
		}
		
		DfsMakeWall(0, 0);
		
		System.out.println(maxEcnt);
	}

}

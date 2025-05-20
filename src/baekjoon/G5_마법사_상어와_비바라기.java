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

public class G5_������_����_��ٶ�� {
	static int N, M;
	static int[][] board;
	static boolean[][] wasCloud;
	static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1}; // ��, �ϼ�, ��, �ϵ�, ��, ����, ��, ����
	static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
	static ArrayList<Dot> clouds;
	
	
	public static void magic(int d, int s) {
		wasCloud = new boolean[N][N];
		ArrayList<Dot> newClouds = new ArrayList<>();
		
		// clouds�� ����ִ� ���� �̵�
		for(Dot x : clouds) {
			int cr = x.r;
			int cc = x.c;
			
			// 1�̸� ���� �̵� (d�������� s��ŭ)
			cr = (cr + dr[d] * s + N * 100) % N;
			cc = (cc + dc[d] * s + N * 100) % N;
			
			// �� +1��
			board[cr][cc] += 1;
			wasCloud[cr][cc] = true;
			newClouds.add(new Dot(cr, cc));
			
		}
		
		// �밢�� Ž�� -> 0�̻��̸� ���翡 + 1; (������)
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
					// �̵��� ���� ��-2
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
		
		// ���� �ʱ�ȭ
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				board[i][j] = sc.nextInt();
			}
		}
		// �ʱ� ���� ����
		clouds.add(new Dot(N-2, 0));
		clouds.add(new Dot(N-2, 1));
		clouds.add(new Dot(N-1, 0));
		clouds.add(new Dot(N-1, 1));
		
		// �̵� ���� �ʱ�ȭ
		for(int i = 0; i < M; ++i) {
			magic(sc.nextInt() - 1, sc.nextInt()); //d, s
		}
		
		// board �� ���� Ž��
		int sum = 0;
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				sum += board[i][j];
			}
			
		}
		
		System.out.println(sum);
	}

}

package SWEA;

import java.util.Scanner;

public class D2_1954_달팽이숫자 {
	public static int[][] solution(int N){
		int[][] result = new int[N][N];
		int[] xD = {0, 1, 0, -1};
		int[] yD = {1, 0, -1, 0};
		
		int x = 0, y = 0, dir = 0;
		
		for(int k = 1; k <= N * N; ++k) {
			result[x][y] = k;
			
			int nx = x + xD[dir];
			int ny = y + yD[dir];
			
			if (nx < 0 || x + xD[dir] >= N || ny < 0 || ny >= N || result[nx][ny] != 0) {
				dir = (dir + 1) % 4;
				nx = x + xD[dir];
				ny = y + yD[dir];
			}
			
			x = nx;
			y = ny;
		}
		
		return result;
	}
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int[][] result = solution(N);
			System.out.printf("#%d\n", test_case);
			
			for(int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					System.out.printf("%d ", result[i][j]);
				}
				System.out.println();
			}

		}
	}
}

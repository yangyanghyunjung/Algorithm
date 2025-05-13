package InflearnLecture;

import java.util.Scanner;

public class DfsFindPath_AdjacencyMatrix {
	static int[][] matrix;
	static int[] ch;
	static int N;
	static int cnt = 0;
	
	public void DFS(int root, int[] ch) {
		if(root == N) {
			cnt++;
			return;
		}
		for(int j = 1; j <= N; ++j) {
			if (matrix[root][j] == 1 && ch[j] == 0) {
				ch[j] = 1; // key point!!
				DFS(j,ch);
				ch[j] = 0; // key point!!
			}
		}
	}
	
	public static void main(String[] args) {
		DfsFindPath_AdjacencyMatrix T = new DfsFindPath_AdjacencyMatrix();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		matrix = new int[N + 1][N + 1];
		ch = new int[N + 1];
		
		for(int i = 0; i < M; ++i) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			matrix[row][col] = 1;
		}
		ch[1] = 1;
		T.DFS(1, ch);
		System.out.println(cnt);
	}

}

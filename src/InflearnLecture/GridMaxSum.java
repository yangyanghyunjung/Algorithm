package InflearnLecture;

import java.util.Scanner;

public class GridMaxSum {
	public void solution(int n, int[][] arr) {
		int max = 0;
    	int row, col;
		// 가로
		for (int i = 0; i < n; ++i) {
			int sum = 0;
          	row =col=0;
			for (int j = 0; j < n; ++j) {
				row+= arr[i][j];
              	col+= arr[j][i];
			}
			max = Math.max(max, row);
          	max = Math.max(max, col);
		}

		//대각1
		int LtToRtsum = 0;
		int RtToLtsum = 0;
		for (int i = 0; i < n; ++i) {
			LtToRtsum+= arr[i][i];
			RtToLtsum+= arr[i][n-1-i];
		}
		max = Math.max(max, LtToRtsum);
		max = Math.max(max, RtToLtsum);
		
		System.out.println(max);
	}
	
	
	
	public static void main(String[] args) {
		GridMaxSum T = new GridMaxSum();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][n];
		for (int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				arr[i][j] = sc.nextInt();
			}
		}
		T.solution(n, arr);	
	}
}

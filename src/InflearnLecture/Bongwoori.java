package InflearnLecture;

import java.util.Scanner;

public class Bongwoori {
	final int[] DX = {-1, 0, 1, 0};
	final int[] DY = {0, 1, 0, -1};
	
	public int solution(int n, int[][] arr) {
		int result = 0;
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <=n; ++j) {
				boolean bBong = true;
				for (int k = 0; k < DX.length; ++k) {
					if (arr[DX[k]+i][DY[k]+j] >= arr[i][j]) {
						bBong = false;
						break;
					}
				}
				if (bBong) result++;
				
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Bongwoori T = new Bongwoori();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n+2][n+2];
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <=n; ++j) {
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.print(T.solution(n, arr));
	}

}

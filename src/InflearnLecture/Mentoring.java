package InflearnLecture;

import java.util.Scanner;

public class Mentoring {
	public int solution(int m ,int n, int[][] arr) {
		int result = 0;
		
		// 짝 만들기 (모든 경우의수)
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (i != j) {
					int count = 0;
					// 검증
					for (int k = 0; k < m; ++k) {
						int mento = 0, menti = 0;
						for (int s = 0; s < n; ++s) {
							if (arr[k][s] == i) {
								mento = s;
							}
							if (arr[k][s] == j) {
								menti = s;
							}
						}
						if(mento > menti) {
							break;
						}
						count++;
					}
					if (count == m) {
						result++;
					}
				}
				
				
			}
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		Mentoring T = new Mentoring();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[m][n];
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(T.solution(m, n, arr));

	}

}

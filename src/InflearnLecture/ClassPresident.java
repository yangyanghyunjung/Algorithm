package InflearnLecture;

import java.util.HashMap;
import java.util.Scanner;

public class ClassPresident {
	public int solution(int n, int[][] arr) {
		int max = 0;
		int answer = 0;
		for (int i = 0; i < n; ++i) {
			int cnt = 0;
			for (int j = 0; j < n; ++j) {
				for (int k = 0; k < 5; ++k) {
					if (arr[i][k] == arr[j][k]) {
						cnt++;
						break;
					}
				}
			}
			if (max < cnt) {
				max = cnt;
				answer = i  + 1;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		ClassPresident T = new ClassPresident();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] arr = new int[n][5];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < 5; ++j) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(T.solution(n, arr));

	}

}

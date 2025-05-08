package InflearnLecture;

import java.util.Scanner;

public class CoordinateSort {
	public static int[][] solution(int N, int[][] arr){
		for(int i = 0; i < N; i++) {
			int minIdx = i;
			for(int j = i + 1; j < N; j++) {
				if(arr[minIdx][0] > arr[j][0]) {
					minIdx = j;
				} else if(arr[minIdx][0] == arr[j][0]) {
					if(arr[minIdx][1] > arr[j][1]) {
						minIdx = j;
					}
				}
			}
			if(minIdx != i) {
				int[] tmp = arr[i]; 
				arr[i] = arr[minIdx];
				arr[minIdx] = tmp;
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < 2; ++j) {
				arr[i][j] = sc.nextInt();
			}
		}
		int[][] result = solution(N, arr);
		for (int i = 0; i < N; ++i) {
			System.out.printf("%d %d",result[i][0], result[i][1]); 
			System.out.println();
		}
		
	}

}

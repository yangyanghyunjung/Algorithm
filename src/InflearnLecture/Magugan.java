package InflearnLecture;

import java.util.Arrays;
import java.util.Scanner;

public class Magugan {
	public static int getAcceptableHorsesCnt(int minDistance, int[] arr) {
		int cnt = 1;
		int ep = arr[0];
		for(int i = 1; i < arr.length; ++i) {
			int dt = arr[i] - ep;
			if(dt >= minDistance) {
				cnt++;
				ep = arr[i];
			}
		}
		return cnt;
	}
	
	public static int solution(int N, int C, int[]arr) {
		int result = 0;
		Arrays.sort(arr);
		
		int lt = 1;
		int rt = arr[N - 1] - arr[0];
		
		while(lt <= rt) {
			int mid = (lt + rt) / 2;
			if(getAcceptableHorsesCnt(mid, arr) >= C) {
				lt = mid + 1;
				result = mid;
			} else {
				rt = mid - 1;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int C = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0 ; i< N; ++i) {
			arr[i] = sc.nextInt();
		}
		System.out.print(solution(N, C, arr));
	}

}

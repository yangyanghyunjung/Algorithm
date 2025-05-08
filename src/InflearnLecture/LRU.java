package InflearnLecture;          

import java.util.Scanner;

public class LRU {

	public static int[] solution(int size, int[] arr) {
		int[] result = new int[size];
		for(int i = 0; i < arr.length ; ++i) {
			int idx = size - 2;
			for(int j = 0; j < size; ++j) {
				if(result[j] == 0) {
					break;
				}
				if(result[j] == arr[i]) {
					idx = j - 1;
					break;
				}
			}
			while(idx >= 0) {
				result[idx + 1] = result[idx];
				idx--;
			}
			result[0] = arr[i];
		}
		
		return result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; ++i) {
			arr[i] = sc.nextInt();
		}
		for(int i : solution(size, arr)) {
			System.out.printf("%d ", i);
		}
	}

}

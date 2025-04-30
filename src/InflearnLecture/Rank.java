package InflearnLecture;

import java.util.Scanner;

public class Rank {
	public int[] solution(int n, int[] arr) {
		int[] result = new int[n];
		
		for(int i = 0; i < n; ++i) {
			int curr = arr[i];
			
			for(int j = 0; j < n; ++j) {
				if (j == i) {
					continue;
				}
				if (curr < arr[j]) {
					result[i]++;
				} 
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Rank T = new Rank();
		Scanner in=new Scanner(System.in);
	    int n = in.nextInt();
	    int[] arr = new int[n];
	    for (int i = 0; i < n; ++i) {
	    	arr[i] = in.nextInt();
	    }
		for(int i : T.solution(n, arr)) {
			System.out.print(String.format("%d ", i + 1));
		}
	}
}

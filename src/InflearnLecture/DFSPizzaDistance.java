package InflearnLecture;

import java.util.ArrayList;
import java.util.Scanner;

public class DFSPizzaDistance {
	static int N;
	static int M;
	static int result = Integer.MAX_VALUE;
	static ArrayList<int[]> house, pizza;
	static int[] cob;
	
	public static void DFS(int L, int s) {
		if(L == M) {
			int sum = 0;
			for(int i = 0; i < house.size(); ++i) {
				int min = Integer.MAX_VALUE;
				for(int j = 0; j < M; ++j) {
					int[] ch = house.get(i);
					int[] cp = pizza.get(cob[j]);
					int dist = Math.abs(ch[0] - cp[0]) + Math.abs(ch[1] - cp[1]);
					min = Math.min(min, dist);
				}
				sum += min;
			}
			result = Math.min(result, sum);
			return;
		}
		
		for(int i = s; i < pizza.size(); ++i) {
			cob[L] = i;
			DFS(L + 1, i + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		cob = new int[M];
		pizza = new ArrayList<>();
		house = new ArrayList<>();
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				int tmp = sc.nextInt();
				if(tmp == 1) {
					house.add(new int[]{i, j});
				} else if(tmp == 2) {
					pizza.add(new int[]{i, j});
				}
			}
			
		}
		
		DFS(0, 0);
		System.out.println(result);
	}

}

package InflearnLecture;

import java.util.Scanner;


public class DfsSubSet {
	static int n;
	static int[] check;
	
	
	public void Dfs(int L) {
		if(L == n + 1) {
			StringBuilder sb = new StringBuilder();
			for(int i = 1; i <= n; ++i) {
				if(check[i] == 1) {
					sb.append(i + " ");
				}
			}
			if(sb.length() > 0) {
				System.out.println(sb.toString());
			}
		} else {
			check[L] = 1;
			Dfs(L + 1);
			check[L] = 0;
			Dfs(L + 1);
		}
	}
	
	public static void main(String[] args) {
		DfsSubSet tree = new DfsSubSet();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		check = new int[n + 1];
		
		tree.Dfs(1);
		
		
	}
}

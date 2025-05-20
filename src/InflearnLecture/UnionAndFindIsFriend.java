package InflearnLecture;

import java.util.Scanner;

public class UnionAndFindIsFriend {
	static int[] unf;
	
	public static int Find(int x) {
		if(x == unf[x]) {
			return unf[x];
		} 
		return unf[x] = Find(unf[x]);
	}
	
	public static void Union(int a, int b) {
		int fa = Find(a);
		int fb = Find(b);
		if(fa != fb) {
			unf[fa] = fb;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		unf = new int[N + 1];
		for(int i = 1; i <= N; ++i) {
			unf[i] = i;
		}
		
		for(int i = 0; i < M; ++i) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			Union(a, b);
		}
		int f1 = sc.nextInt();
		int f2 = sc.nextInt();
		if(Find(f1) == Find(f2)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

}

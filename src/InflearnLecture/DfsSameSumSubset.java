package InflearnLecture;

import java.util.Scanner;

public class DfsSameSumSubset {
	static int N; 
	static int[] ch; 
	static int[] set; 
	boolean flag = false; 
	String result = "NO";
	static int total;
	
	
	public void DFS(int L) {
		if(flag) return;
		
		if(L == N) {
			int sum = 0;
			
			for(int i = 0; i < N; ++i) {
				if(ch[i] == 1){
					sum += set[i];
				}
			}
			if(total - sum == sum) {
				result = "YES";
				flag = true;
			}
			
		} else {
			ch[L] = 1;
			DFS(L + 1);
			ch[L] = 0;
			DFS(L + 1);
		}
	}
	
	
	public static void main(String[] args) {
		DfsSameSumSubset T = new DfsSameSumSubset();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		set = new int[N];
		ch = new int[N];
		
		for(int i = 0; i < N; ++i) {
			set[i] = sc.nextInt();
			total += set[i];
		}
		
		T.DFS(0);
		System.out.println(T.result);
	}

}

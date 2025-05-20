package InflearnLecture;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSIsFriend {
	static int f1;
	static int f2;
	static int[] ch;
	
	public static void BFS(ArrayList<ArrayList<Integer>> graph, int V) {
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(V);
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			
			for(int x : graph.get(cur))
			if(ch[x] == 0) {
				ch[x] = 1;
				Q.offer(x);
				
				if(x == f2) {
					System.out.println("YES");
					return;
				}
			}
		}
		System.out.println("NO");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<ArrayList<Integer>> graph  = new  ArrayList<>(); 
		
		for(int i = 0; i < N + 1; ++i) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < M; ++i) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		f1 = sc.nextInt();
		f2 = sc.nextInt();
		
		ch = new int[N + 1];
		ch[f1] = 1;
		BFS(graph, f1);
	}

}

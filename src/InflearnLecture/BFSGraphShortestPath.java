package InflearnLecture;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSGraphShortestPath {
	static ArrayList<ArrayList<Integer>> graph;
	static int N;
	
	
	public int[] BFS(int root) {
		int[] level = new int[N + 1];
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(root);
		int L = 0;
		
		while(!Q.isEmpty()) {
			L++;
			int size = Q.size();
			for(int i = 0; i < size; ++i) {
				int cur = Q.poll();
				
				for(int next : graph.get(cur)) {
					if(level[next] == 0) {
						Q.offer(next);
						level[next] = L;
					}
				}
			}
		}
		
		
		return level;
	}
	public static void main(String[] args) {
		BFSGraphShortestPath T = new BFSGraphShortestPath();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i <= N; ++i) {
			graph.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < M; ++i) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			graph.get(a).add(b);
		}
		
		int[] result = T.BFS(1);
		for(int i = 2; i < result.length; ++i) {
			System.out.printf("%d : %d\n", i, result[i]);
		}
	}

}

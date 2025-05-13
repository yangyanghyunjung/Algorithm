package InflearnLecture;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSGraphShortestPath {
	static ArrayList<ArrayList<Integer>> graph;
	static int N;
	static boolean[] visited;
	static int[] dist;
	
	
	public void BFS(int root) {
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(root);
		
		while(!Q.isEmpty()) {
			int size = Q.size();
			for(int i = 0; i < size; ++i) {
				int cur = Q.poll();
				
				for(int next : graph.get(cur)) {
					if(visited[next] == false) {
						visited[next] = true;
						dist[next] = dist[cur] + 1;	// level
						Q.offer(next);
					}
				}
			}
		}
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
		visited = new boolean[N + 1];
		dist = new int[N + 1];
		
		T.BFS(1);
		for(int i = 2; i < dist.length; ++i) {
			System.out.printf("%d : %d\n", i, dist[i]);
		}
	}

}

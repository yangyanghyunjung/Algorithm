package InflearnLecture;

import java.util.ArrayList;
import java.util.Scanner;

public class DFSFindPath_AdjacencyList {
	static ArrayList<ArrayList<Integer>> graph;
	static int cnt = 0;
	static int N;
	static int[] ch;
	
	public void DFS(int V) {
		if(V == N) {
			cnt++;
			return;
		}
		
		for(int nv : graph.get(V)) {	// foreach
			if(ch[nv] == 0) {
				ch[nv] = 1;
				DFS(nv);
				ch[nv] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		graph = new ArrayList<ArrayList<Integer>>();
		DFSFindPath_AdjacencyList T = new DFSFindPath_AdjacencyList();
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		ch = new int[N + 1];
		
		for(int i = 0; i <= N; ++i) {
			graph.add(new ArrayList<>());	// ��ü ���� �ʼ�!!
		}
		
		for(int i = 0; i < M; ++i) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b);			// get().add()
		}
		ch[1] = 1;
		T.DFS(1);
		System.out.println(cnt);
		
	}

}

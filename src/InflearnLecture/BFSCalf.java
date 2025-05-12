package InflearnLecture;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSCalf {
	static int[] ch = new int[10001];
	
	public int BFS(int root, int target) {
		int level = 0;
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(root);
		ch[root] = 1;
		
		while(true) {
			int size = Q.size();
			for(int i = 0; i < size; ++i) {
				int curr = Q.poll();
				if(curr == target) {
					return level;
				}
				
				if(curr > target) {
					Q.offer(curr - 1);
				} else {
					if(ch[curr + 1] == 0) {
						Q.offer(curr + 1);
						ch[curr + 1] = 1;
					}
					if(ch[curr + 5] == 0) {
						Q.offer(curr + 5);
						ch[curr + 5] = 1;
					}
				}
			}
			level++;
		}
	}
	
	public static void main(String[] args) {
		BFSCalf t = new BFSCalf();
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt(); // 현수(이동)
		int E = sc.nextInt(); // 송아지(고정)
		System.out.println(t.BFS(S, E));
	}

}

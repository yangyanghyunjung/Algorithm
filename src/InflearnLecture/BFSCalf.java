package InflearnLecture;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSCalf {
	int[] dir = {1, -1, 5}; // �迭�� ����� for�� �������ְ�
	int[] ch = new int[10001];
	Queue<Integer> Q = new LinkedList<>();
	
	public int BFS(int root, int target) {
		int level = 0;
		Q.offer(root);
		ch[root] = 1;
		
		while(true) {
			int size = Q.size();
			for(int i = 0; i < size; ++i) {
				int curr = Q.poll();
				for(int j = 0; j < 3; ++j) {
					int next = curr + dir[j];
					if(next == target) { // Queue�� �ֱ� ���� ��ȯ
						return level + 1;
					}
					if(ch[next] == 0 && next >=1 && next <= 10000) {
						ch[next] = 1;
						Q.offer(next);
					}
				}
			}
			level++;
		}
	}
	
	public static void main(String[] args) {
		BFSCalf t = new BFSCalf();
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt(); // ����(�̵�)
		int E = sc.nextInt(); // �۾���(����)
		System.out.println(t.BFS(S, E));
	}

}

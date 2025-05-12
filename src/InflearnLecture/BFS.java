package InflearnLecture;

import java.util.LinkedList;
import java.util.Queue;

class Node_BFS{
	int data;
	Node_BFS lt, rt;
	
	Node_BFS(int data){
		this.data = data;
		this.lt = this.rt = null;
	}
}

public class BFS {
	static Node_BFS root;
	public void Bfs(Node_BFS root) {
		Queue<Node_BFS> Q = new LinkedList<>();
		Q.offer(root);
		int Level = 0;
		
		while(!Q.isEmpty()) {
			System.out.println("Level : " + Level);
			int len = Q.size();
			for(int i = 0; i < len; ++i) {
				Node_BFS curr = Q.poll();
				System.out.print(curr.data + " ");
				if(curr.lt != null) {
					Q.offer(curr.lt);
				}
				if(curr.rt != null) {
					Q.offer(curr.rt);
				}
			}
			System.out.println();
			Level++;
		}
		                
	}
	
	public static void main(String[] args) {
		BFS tree = new BFS();
		tree.root = new Node_BFS(1);
		tree.root.lt = new Node_BFS(2);
		tree.root.rt = new Node_BFS(3);
		tree.root.lt.lt = new Node_BFS(4);
		tree.root.lt.rt = new Node_BFS(5);
		tree.root.rt.lt = new Node_BFS(6);
		tree.root.rt.rt = new Node_BFS(7);
		
		tree.Bfs(root);
	}

}

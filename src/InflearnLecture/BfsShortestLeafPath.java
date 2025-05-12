package InflearnLecture;

import java.util.LinkedList;
import java.util.Queue;

class Node_BfsShortestLeafPath{
	int data;
	Node_BfsShortestLeafPath lt, rt;
	
	Node_BfsShortestLeafPath(int data){
		this.data = data;
		this.lt = this.rt = null;
	}
}

public class BfsShortestLeafPath {
	Node_BfsShortestLeafPath root;
	
	public int BFS(Node_BfsShortestLeafPath root) {
		Queue<Node_BfsShortestLeafPath> Q = new LinkedList<>();
		Q.offer(root);
		int L = 0;
		
		while(!Q.isEmpty()) {
			int size = Q.size();
			for(int i = 0; i < size; ++i) {
				Node_BfsShortestLeafPath curr = Q.poll();
				
				if(curr.lt == null && curr.rt == null) {
					return L;
				}
				if(curr.lt != null) {
					Q.offer(curr.lt);
				}
				if(curr.rt != null) {
					Q.offer(curr.rt);
				}
			}
			L++;
		}
		return L;
	}
	
	public static void main(String[] args) {
		BfsShortestLeafPath tree = new BfsShortestLeafPath();
		tree.root = new Node_BfsShortestLeafPath(1);
		tree.root.lt = new Node_BfsShortestLeafPath(2);
		tree.root.rt = new Node_BfsShortestLeafPath(3);
		tree.root.lt.lt = new Node_BfsShortestLeafPath(4);
		tree.root.lt.rt = new Node_BfsShortestLeafPath(5);
		
		System.out.println(tree.BFS(tree.root));
	}

}

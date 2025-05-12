package InflearnLecture;

import java.util.Scanner;


class Node {
	int data;
	Node lt, rt;
	
	public Node(int data) {
		this.data = data;
		this.lt = this.rt = null;
	}
}

public class BinaryTreeDfs {
	Node root;
	
	public void Dfs(Node root) {
		if(root == null) {
			return;
		}
		Dfs(root.lt);
		Dfs(root.rt);
		System.out.print(root.data + " ");
	}
	public static void main(String[] args) {
		BinaryTreeDfs tree = new BinaryTreeDfs();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		tree.root.rt.lt = new Node(6);
		tree.root.rt.rt = new Node(7);
		
		
		
		tree.Dfs(tree.root);
	}
}

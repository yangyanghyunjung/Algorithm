package InflearnLecture;

class Node_DfsShortestLeafPath {
	int data;
	Node_DfsShortestLeafPath lt, rt;
	
	Node_DfsShortestLeafPath(int data){
		this.data = data;
		this.lt = this.rt = null;
	}
}

public class DfsShortestLeafPath {
	Node_DfsShortestLeafPath root;
	 
	public int DFS(int L, Node_DfsShortestLeafPath root) {
		if(root.lt == null && root.rt == null) {
			return L;
		}
		return Math.min(DFS(L + 1, root.lt), DFS(L + 1, root.rt));
	}
	
	public static void main(String[] args) {
		DfsShortestLeafPath tree = new DfsShortestLeafPath();
		tree.root = new Node_DfsShortestLeafPath(1);
		tree.root.lt = new Node_DfsShortestLeafPath(2);
		tree.root.rt = new Node_DfsShortestLeafPath(3);
		tree.root.lt.lt = new Node_DfsShortestLeafPath(4);
		tree.root.lt.rt = new Node_DfsShortestLeafPath(5);
		
		System.out.println(tree.DFS(0, tree.root));
	}

}

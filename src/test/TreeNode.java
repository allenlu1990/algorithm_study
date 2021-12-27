package test;

import java.util.TreeSet;

public class TreeNode<T>{
	T value;
	TreeNode left;
	TreeNode right;
	
	TreeNode(T data,TreeNode left,TreeNode right) {
		this.value = data;
		this.left = left;
		this.right = right;
	}

	public int getDeep(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int left = getDeep(root.left);
			int right = getDeep(root.right);
			return Math.max(left, right) + 1;
		}
	}


	public static void main(String[] args) {
		TreeNode<String> i = new TreeNode<>("I", null, null);
		TreeNode<String> d = new TreeNode<>("D", i, null);
		TreeNode<String> e = new TreeNode<>("E", null, null);
		TreeNode<String> f = new TreeNode<>("F", null, null);
		TreeNode<String> g = new TreeNode<>("G", null, null);
		TreeNode<String> b = new TreeNode<>("B", d, e);
		TreeNode<String> c = new TreeNode<>("C", f, g);
		TreeNode<String> a = new TreeNode<>("G", b, c);

		int deep = a.getDeep(a);
		System.out.println(deep);
	}
}

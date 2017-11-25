package bst;

import bst.Bstnode.Node;

public class Traversals {

	Node root;
	void inorder(Node root)
	{
		if(root==null)
			return;
		inorder(root.left);
		System.out.println(root.value+ " ");
		inorder(root.right);
		
	}
}

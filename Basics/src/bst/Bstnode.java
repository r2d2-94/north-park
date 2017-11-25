package bst;

public class Bstnode {
	class Node
	{
	int value;
	 Node left;
	 Node right;
	 
	 Node(int value)
	 {
		 this.value = value;
		 left=right=null;
	 }
	}
	 
void insert(Node root, int k)
{
	if(root==null)
	{
		Node node = new Node(k);
		return;
	}
	if(k<root.value)
	{
		insert(root.left,k);
	}
	else if(k>root.value)
	{
		insert(root.right,k);
	}
	return;
}

Node find(Node root,int k)
{
	if(root==null)
		return null;
	else if(k== root.value)
		return root;
	else if(k<root.value)
	{
		find(root.left,k);
	}
	else if(k>root.value)
	{
		find(root.right,k);
	}
	return null;
}

Node delete(Node root, int k)
{
	if(root==null)
		return root;
	if(k<root.value)
		root.left=delete(root.left,k);
	else if(k>root.value)
		root.right = delete(root.right,k);
	else
	{
		if(root.left==null)
			return root.right;
		else if(root.right == null)
			return root.left;
		
		Node temp= root.right;
		int min=root.value;
		while(temp!= null)
		{
			temp= temp.left;
			min=temp.left.value;
		}
		
		root.right=delete(root.right, min);		
	}
	return root;
	
}
}

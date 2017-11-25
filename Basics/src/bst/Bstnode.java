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

boolean delete(Node root, int k)
{
	return false;
}
}

package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphByListUnweighted {
	
	int vertices;
	
	List<LinkedList<Integer>> adjList;
	
	GraphByListUnweighted(int vertices)
	{
		adjList = new ArrayList<LinkedList<Integer>>();
		
		int count;
		for(count = 0; count < vertices ; count++)
		{
			LinkedList<Integer> vertexList = new LinkedList<Integer>();
			adjList.add(vertexList);
		}
		
	}
	public void addedge(GraphByListUnweighted graph, int src, int dest,int value)
	{
		graph.adjList.get(src).addFirst(dest);
	}

}

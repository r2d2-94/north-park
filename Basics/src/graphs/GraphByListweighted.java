package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Pair
{
	public Pair(int dest, int weight2) {
		weight = dest;
		weight = weight2;
	}
	int vertex;
	int weight;
	
}
public class GraphByListweighted {
	
	int vertices;
	
	
	List<LinkedList<Pair>> adjList;
	
	GraphByListweighted(int vertices)
	{
		adjList = new ArrayList<>();
		
		int count;
		for(count = 0; count < vertices ; count++)
		{
			LinkedList<Pair> vertexList = new LinkedList<>();
			adjList.add(vertexList);
		}
		
	}
	public void addedge(GraphByListweighted graph, int src, int dest,int weight)
	{
		Pair vertexValuePair = new Pair(dest,weight);
		graph.adjList.get(src).addFirst(vertexValuePair);
	}

}

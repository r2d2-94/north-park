package graphs;

import java.awt.event.AdjustmentListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class ShortestPathbetweenPrime {

	public static void main(String[] args){
		
		int n1,n2;
		Scanner sc= new Scanner(System.in);
		n1=sc.nextInt();
		n2=sc.nextInt();
		
		List primeList = new ArrayList<Integer>();
		Sieve(primeList);
		Graph adjGraph = createGraph(primeList);
		int path = bfs(adjGraph,primeList.indexOf(n1), primeList.indexOf(n2));
				System.out.println("Distance is :" + path);
		}
	class Graph
	{
		int vertex;
		List<LinkedList<Integer>> adjList;
		Graph(int v)
		{	
			vertex=v;
			adjList = new ArrayList<LinkedList<Integer>>();
			int i=0;
			for(i=0;i<v;i++)
			{
				LinkedList vertexList = new LinkedList<Integer>();
				vertexList.addFirst(i);
				adjList.add(vertexList);
			}
		}
		void addEdge(int src, int dest)
		{
			adjList.get(src).add(dest);
			adjList.get(dest).add(src);
		}
		
	}
	
 static void Sieve(List primeList)
{
	int n=9999;
	int i=2;
	boolean[] notPrime = new boolean[10000];
	for (i=2;i*i<n;i++)
	{
		if(notPrime[i]==false)
		{
			int x;
			for(x=i*i;x<=n;x+=i)
			{
				notPrime[x]=true;
			}
		}
	}
	for(i=1000;i<=n;i++)
	{
		if(notPrime[i]==false)
		{
			primeList.add(i);
		}
	}
}

static boolean hasEdge(int n1, int n2)
{
	int nonmatches=0;
	if(n1/1000 != n2/1000)
	{
		nonmatches++;
	}
	n1=n1%1000;
	n2=n2%1000;
	
	if(n1/100 != n2/100)
	{
		nonmatches++;
	}
	n1=n1%100;
	n2=n2%100;
	
	if(n1/10 != n2/10)
	{
		nonmatches++;
	}
	n1=n1%10;
	n2=n2%10;
	
	if(n1 != n2)
	{
		nonmatches++;
	}
	
	return (nonmatches==1);
		
}

static Graph createGraph(List<Integer> primeList)
{
	int vertices=primeList.size();
	int i=0;
	int j=0;
	ShortestPathbetweenPrime ne =  new ShortestPathbetweenPrime();
	Graph adjGraph = ne.new Graph(vertices);
	for(i=0;i<vertices;i++)
	{
		for(j= i + 1;j<vertices;j++)
		{
			
		if(hasEdge(primeList.get(i),primeList.get(j)))
		{
			adjGraph.addEdge(i,j);
		}
			
		}
	}
	return adjGraph;
}



static int bfs(Graph G, int src , int dest)
{
	int count=0;
	int[] isvisited = new int[G.vertex];
	 Deque<Integer> queue = new LinkedList();
	 queue.addFirst(src);
	 while(queue.size()!=0)
	 {
		
		int current =  queue.removeFirst();
		 
		int i;
		int element=0;
		for(i=0;i<G.adjList.get(current).size();i++)
		{
			element = G.adjList.get(current).get(i);
			if(isvisited[element] == 0){	
			queue.addFirst(element);
			isvisited[element] = isvisited[current] + 1;
			}
			if(element == dest)
			{
				return isvisited[element] - 1;
			}
		}
		
		
	 }
	return 0;
	
}
}

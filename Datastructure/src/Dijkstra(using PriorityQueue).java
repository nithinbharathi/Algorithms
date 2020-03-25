/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Dijkstra
{
	public static void main (String[] args) throws java.lang.Exception
	{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l[] = br.readLine().split(" ");
        int v = Integer.parseInt(l[0]);
        int e = Integer.parseInt(l[1]);
		ArrayList<node>graph[] = new ArrayList[v];
		for(int i =0;i<v;i++)graph[i] = new ArrayList<node>();
		for(int i =0;i<e;i++){
            String line[] = br.readLine().split(" ");
		    int a = Integer.parseInt(line[0]);
		    int b = Integer.parseInt(line[1]);
		    int w = Integer.parseInt(line[2]);
		    a--;
		    b--;
		    node n = new node(b,w);
		    graph[a].add(n);
		    n = new node(a,w);
		    graph[b].add(n);
		}
		boolean vis[] = new boolean[v];
		int dis[] = new int[v];
		Arrays.fill(dis,Integer.MAX_VALUE);
		PriorityQueue<Integer>q = new PriorityQueue<>();
		HashMap<Integer,Integer>map = new HashMap<>();
		dis[0] = 0;
		q.add(0);
		map.put(0,0);
		while(!q.isEmpty()){
		    int smallest_weight =q.remove();
		    int vertex = map.get(smallest_weight);
		    if(vis[vertex])continue;
		    vis[vertex] = true;
		    for(int i =0;i<graph[vertex].size();i++){
		        node n = graph[vertex].get(i);
		        int second_vertex = n.v;
		        int weight = n.w;
		        if(dis[vertex]+weight<dis[second_vertex]){
		            dis[second_vertex] = dis[vertex]+weight;
		            q.add(dis[vertex]+weight);
		            map.put(dis[vertex]+weight,second_vertex);
		        }
		    }
		}
		for(int i =1;i<v;i++){
		    System.out.print(dis[i]+" ");
		}
	}
}
class node{
int v,w;
    public node(int v,int w){
        this.v = v;
        this.w = w;
    }
}

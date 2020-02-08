
import java.util.*;
import java.lang.*;
import java.io.*;

class Prims
{
    static ArrayList<Node>g[];
    static PriorityQueue<Node> queue;
    static int minimumCost;
    static boolean vis[];
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner input = new Scanner(System.in);
	    int v = input.nextInt();
	    int e = input.nextInt();
	    queue= new PriorityQueue<>(new compare());
	    g = new ArrayList[v+1];
	    vis = new boolean[v+1];
	    Node n;
	    for(int i=1;i<=v;i++)g[i] = new ArrayList<>();
	   for(int i=1;i<=e;i++){
	       int a = input.nextInt();
	       int b = input.nextInt();
	       int w = input.nextInt();
	       g[a].add(new Node(b,w));
	       g[b].add(new Node(a,w));
	      
	   }
	   System.out.println(prims(1));
	   
	}
	public static int prims(int v){
	    queue.add(new Node(v,0));
	    while(!queue.isEmpty()){
	        Node e = queue.poll();
	        if(vis[e.v])continue;
	        vis[e.v] = true;
	        minimumCost+=e.w;
	        for(int i=0;i<g[e.v].size();i++){
	            Node child = g[e.v].get(i);
	            if(vis[child.v])continue;
	            queue.add(new Node(child.v,child.w));
	        }
	        
	    }
	    return minimumCost;
	}
}
class Node{
    int v;
    int w;
    public Node(int v,int w){
        this.v = v;
        this.w = w;
    }
}
class compare implements Comparator<Node>{
    public int compare(Node a,Node b){
        return Integer.compare(a.w,b.w);
    }
}

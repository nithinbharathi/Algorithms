
import java.util.*;
import java.lang.*;
import java.io.*;

class MinimumSpanningTree
{
    static HashMap<Integer,Node>map = new HashMap<>();
    static int set[];
    static int minimumCost = 0;
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner input = new Scanner(System.in);
	    int v = input.nextInt();
	    int e = input.nextInt();
	    set = new int[v+1];
	    for(int i=1;i<=v;i++)set[i] = i;
	    Node n;
	    int weights[] = new int[e];
	    for(int i=0;i<e;i++){
	        int a = input.nextInt();
	        int b = input.nextInt();
	        int w = input.nextInt();
	        weights[i] = w;
	        n = new Node(a,b);
	        map.put(w,n);
	    }
	   Arrays.sort(weights);
	   System.out.println(kruskal(weights));
	}
  
	public static int kruskal(int weights[]){
	    for(int i=0;i<weights.length;i++){
	        Node set_node = map.get(weights[i]);
	        if(!union(set_node.v1,set_node.v2)){
	            minimumCost+=weights[i];
	        }
	    }
	   return minimumCost;
	}
  
	public static int find(int a){
	    while(a != set[a]){
	        a = set[a];
	    }
	    return a;
	}
  
	public static boolean union(int a,int b){
	    int parent_a = find(a);
	    int parent_b = find(b);
	    if(parent_a == parent_b){
	        return true;
	    }
	   set[parent_b] = parent_a;
	   return false;
	}
}

class Node{
    int v1,v2;
    public Node(int v1,int v2){
        this.v1 = v1;
        this.v2 = v2;
    }
}

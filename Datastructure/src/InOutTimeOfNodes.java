//Used in flattening of tree,finding articulation points and bridges

import java.util.*;
import java.lang.*;
import java.io.*;

class InOut
{
  static int mod = (int)1e9+7;
  static ArrayList<Integer>graph[];
  static boolean vis[];
  static int in_time[];
  static int out_time[];
  static int time = 1;
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner input = new Scanner(System.in);
	    int v = input.nextInt();
	    int e = input.nextInt();
	    vis = new boolean[v];
	    graph = new ArrayList[v];
	    for(int i=0;i<v;i++)graph[i] = new ArrayList<>();
	     in_time = new int[v];
	     out_time = new int[v];
	    for(int i=0;i<e;i++){
	        int a = input.nextInt();
	        int b = input.nextInt();
	        a--;
	        b--;
	        graph[a].add(b);
	        graph[b].add(a);
	    }
	    dfs(0);
	    for(int ins:in_time){
	        System.out.print(ins+" ");
	    }
	    System.out.println();
	    for(int outs:out_time){
	        System.out.print(outs+" ");
	    }
	}
	public static void dfs(int root){
	    vis[root] = true;
	   in_time[root] = time++;
	    for(int i=0;i<graph[root].size();i++){
	        int child = graph[root].get(i);
	        if(!vis[child]){
	            dfs(child);
	        }
	    }
	    out_time[root] = time++;
	}
}

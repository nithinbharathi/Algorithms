// Does not work for connected components
//Time Complexity : O(V+E)
//Space complexity :O(V+E)

import java.util.*;
import java.lang.*;
import java.io.*;

class BipartiteChefUsingDFS
{
    static int vis[];
    static int color[];
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int e =input.nextInt();
		ArrayList<Integer>g[] = new ArrayList[n];
		for(int i=0;i<n;i++)g[i] = new ArrayList<>();
		color = new int[n];
		vis = new int[n];
		for(int i =0;i<e;i++){
		    int a = input.nextInt();
		    int b = input.nextInt();
		    a--;
		    b--;
		    g[a].add(b);
		    g[b].add(a);
		}
		if(dfs(g,0,1)){
		    System.out.println("Bipartite");
		}else{
		    System.out.println("Not Bipartite");
		}
	}
	
	public static boolean dfs(ArrayList<Integer>g[],int u,int c){
	    vis[u] = 1;
	    color[u] = c;
	    for(int i=0;i<g[u].size();i++){
	        int child = g[u].get(i);
	        if(vis[child] == 0){
	            if(!dfs(g,child,c^1))return false;
	        }else if(color[child] ==  color[u]){
	            return false;
	        }
	    }
	    return true;
	}
}

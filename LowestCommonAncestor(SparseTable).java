//Time Complexity : logn per query
//Spcae Complexity: nlogn

import java.util.*;
import java.lang.*;
import java.io.*;

class LCA
{
    static int level[];
    static int dp[][];
    static int log[];
    static int max = (int)1e5+1;
    static int maxLog = 0;
    static ArrayList<Integer>graph[];
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner input = new Scanner(System.in);
	    int n = input.nextInt();
	    graph = new ArrayList[n];
	    level = new int[n];
	    log = new int [max];
	    for(int i=0;i<n;i++){
	        graph[i]  = new ArrayList<>();
	    }
	   for(int i=0;i<n-1;i++){
	       int a = input.nextInt();
	       int b = input.nextInt();
	       a--;
	       b--;
	       graph[a].add(b);
	       graph[b].add(a);
	   }
	   log();
	   dp = new int[n][log[n]+1];
	   for(int i=0;i<n;i++){
	       Arrays.fill(dp[i],-1);
	   }
	   dfs(0,-1);
	   for(int i=0;i<n;i++){
	       for(int j =1;j<=log[n];j++){
	           if(dp[i][j-1] != -1){
	               int t = dp[i][j-1];
	               dp[i][j] = dp[t][j-1];
	           }	       }
	   }
	   for(int i=0;i<n;i++){
	       for(int j = 0;j<=log[n];j++){
	           System.out.print(dp[i][j]+" ");
	       }
	       System.out.println();
	   }
	   maxLog = log[n];
	   System.out.println(lca(2,3));
	}
	public static int lca(int a,int b){
	    if(level[a]<level[b]){
	        int t = b;
	        b = a;
	        a = t;
	    }
	    int diff = level[a]-level[b];
	    while(diff>0){
	        int l = log[diff];
	        a = dp[a][l];
	        diff = l -(1<<l);
	    }
	    if(a == b){
	        return a;
	    }
	    System.out.println(a+" "+b);
	    for(int i = maxLog;i>=0;i--){
	        if(dp[a][i] != -1 &&  dp[a][i] != dp[b][i]){
	            System.out.println(i+" "+dp[a][i]+" "+dp[b][i]);
	            a = dp[a][i];
	            b = dp[b][i];
	        }
	    }
	    return dp[a][0];
	    
	}
	public static void log(){
	    for(int i=2;i<max;i++){
	        log[i] = log[i/2]+1;
	    }
	}
	public static void dfs(int v,int p){
	    dp[v][0] = p;
	    level[v] = p!=-1?level[p]+1:0;
	    for(int i=0;i<graph[v].size();i++){
	        int child = graph[v].get(i);
	        if(p != child){
	            dfs(child,v);
	        }
	    }
	}
}

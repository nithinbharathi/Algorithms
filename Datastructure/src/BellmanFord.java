/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Bellmanford
{
	public static void main (String[] args) throws java.lang.Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l[] = br.readLine().split(" ");
//	Scanner input = new  Scanner(System.in);
        int v = Integer.parseInt(l[0]);
        int e = Integer.parseInt(l[1]);
		ArrayList<Integer>graph[] = new ArrayList[v];
		for(int i =0;i<v;i++)graph[i] = new ArrayList<Integer>();
		for(int i =0;i<e;i++){
		    l = br.readLine().split(" ");
		    int a = Integer.parseInt(l[0]);
		    int b = Integer.parseInt(l[1]);
		    int w = Integer.parseInt(l[2]);
		    a--;
		    b--;
		    graph[i].add(a);
		    graph[i].add(b);
		    graph[i].add(w);
		}
		int dis[] = new int[v];
		Arrays.fill(dis,Integer.MAX_VALUE);
		dis[0] = 0;
		for(int i =0;i<v-1;i++){
		    int j =0;
		    while(j< e){
		        if(dis[graph[j].get(0)]+graph[j].get(2)<dis[graph[j].get(1)])
		           dis[graph[j].get(1)] = dis[graph[j].get(0)]+graph[j].get(2);
		         j++;
		    }
		}
		for(int i =1;i<v;i++){
		    System.out.print(dis[i]+" ");
		}
	}
}

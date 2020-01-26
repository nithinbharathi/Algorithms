
import java.util.*;
import java.lang.*;
import java.io.*;

class TopologicalSort
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int e = input.nextInt();
		ArrayList<Integer>g[] = new ArrayList[n];
		for(int i=0;i<n;i++){
		    g[i] = new ArrayList<>();
		}
		for(int i=0;i<e;i++){
		    int a = input.nextInt();
		    int b = input.nextInt();
		    a--;
		    b--;
		    g[a].add(b);
		}
		HashMap<Integer,Integer>map = new HashMap<Integer,Integer>();
		for(int i=0;i<n;i++){
		    for(int j=0;j<g[i].size();j++){
		         int t = g[i].get(j);
		         if(map.containsKey(t)){
		             map.put(t,map.get(t)+1);
		         }else{
		             map.put(t,1);
		         }
		    }
		}
		ArrayList<Integer>list = new ArrayList<>();
		for(int i=0;i<n;i++){
		    if(!map.containsKey(i)){
		        list.add(i);
		    }
		}
		while(!list.isEmpty()){
		    int x =list.get(0);
		    System.out.print((x+1)+" ");
		    list.remove(0);
		    for(int i=0;i<g[x].size();i++){
		        int t = g[x].get(i);
		        int deg = map.get(t);
		        if(deg == 1){
		            list.add(list.size(),t);
		        }
		        map.put(t,deg-1);
		    }
		}
        
	}
	
}

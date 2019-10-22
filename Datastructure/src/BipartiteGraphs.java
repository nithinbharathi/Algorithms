 Scanner input = new Scanner(System.in);
	        int v = input.nextInt();
	        int e = input.nextInt();
	        int graph[][] = new int[2001][2001];
	        for(int i =0;i<e;i++){
	            int a1 = input.nextInt();
	            int a2 = input.nextInt();
	            graph[a1-1][a2-1] = 1;
	            graph[a2-1][a1-1] = 1;
	        }
	        if(bipartite(graph,v)){
	            System.out.println("Bipartite");
	        }else{
	            System.out.println("Not Bipartite");
	        }
	    }
	    
	}
	public static boolean bipartite(int graph[][],int v){
	    int arr[] = new int[v];
	    Arrays.fill(arr,-1);
	    for(int i =0;i<v;i++){   //checking for disconnectivity 
	        if(arr[i] == -1){
	            if(bfs(graph,i,arr,v) == false)return false;    
	        }
	    }
	    return true;
	}
	public static boolean bfs(int graph[][],int v,int color[],int size){
	    Queue<Integer>q = new LinkedList<>();
	    q.add(v);
	    color[v] = 1;
	    while(!q.isEmpty()){
	        int curr = q.remove();
	        if(graph[curr][curr] == 1)return false;     //Self loop
	        for(int i =0;i<size;i++){
	            if(graph[curr][i] == 1 && color[i] == -1){
	                color[i] = 1-color[curr];
	                q.add(i);
	            }else if(graph[curr][i] == 1 & color[curr] == color[i]){   // if it is already colored with the same color as current vertex
	                return false;
	            }
	        }
	    }
	    return true;
	}
}

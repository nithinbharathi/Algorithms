import java.util.*;
public class Bridges{
    static int in[];
    static int low[];
    static int time =0;
    static ArrayList<Integer>graph[];
    static boolean vis[];
    static int bridge = 0;
     public static void main(String []args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        vis = new boolean[n];
        in = new int[n];
        low = new int[n];
        graph = new ArrayList[n];
        for(int i =0;i<n;i++)graph[i] = new ArrayList<>();
        int v = input.nextInt();
        for(int i =0;i<v;i++){
            int a = input.nextInt();
            int b = input.nextInt();
            a--;
            b--;
            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(0,-1);
        System.out.println(bridge);
     }
     public static void dfs(int ch,int par){
         vis[ch] = true;
         in[ch] = low[ch] = time++;
         for(int i =0;i<graph[ch].size();i++){
             int child = graph[ch].get(i);
             if(child == par)continue;
             if(vis[child]){
                 low[ch] = Math.min(low[ch],in[child]);
             }
             else{
                 dfs(child,ch);
                 if(low[child]>in[ch]){
                     bridge++;
                 }
                 low[ch] = Math.min(low[ch],low[child]);
             }
         }
     }
}

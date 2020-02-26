//Space Complexity: O(N*log(N))
//Time Complexity To Build: O(N*log(N))
//Time to answer Queries: O(1)

import java.util.*;
import java.lang.*;
import java.io.*;

class SparseTableForMinRangeQueries
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner input = new Scanner(System.in);
	    int arr[] = {5,2,4,7,6,3,1,2};
	    SparseTable obj = new SparseTable(arr);
	    obj.construct_table();
	    System.out.println(obj.Min_Query(0,6));
	    
	}
}
class SparseTable{
    int table[];
    int log[];
    int sparse_table[][];
    public SparseTable(int arr[]){
        table = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            table[i] = arr[i];
        }
        log = new int[arr.length+1];
        for(int i=2;i<log.length;i++){
            log[i] = log[i/2]+1;
        }
    }
    public void construct_table(){
        sparse_table = new int[log[table.length]+1][table.length];
        sparse_table[0] = table;
        for(int i=1;i<sparse_table.length;i++){
            for(int j =0;j+(1<<i)<=table.length;j++){
                sparse_table[i][j] = Math.min(sparse_table[i-1][j],sparse_table[i-1][j+(1<<i-1)]);
            }
        }
    }
    public  int Min_Query(int l,int r){
        
        int log_val = log[r-l+1];
        return Math.min(sparse_table[log_val][l],sparse_table[log_val][r-(1<<log_val)+1]);
    }
}

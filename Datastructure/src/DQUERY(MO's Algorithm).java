
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;
class MO
{
    public static int blk_size =0;
    static int res =1;
    static int arr[];
    static int freq[];
    static int ans[];
	public static void main (String[] args) throws java.lang.Exception
	{
	
        InputReader input 		= new InputReader(System.in);
        OutputWriter out	=	new OutputWriter(System.out);
		int n = input.readInt();
		 arr = new int[n];
		 freq = new int[(int)1e6+1];
		for(int i=0;i<n;i++)arr[i] = input.readInt();
		blk_size =(int)Math.sqrt(n);
		int q = input.readInt();
		Query query[] = new Query[q];
		for(int i=0;i<q;i++){int l = input.readInt();int r = input.readInt();query[i] = new Query(l-1,r-1,i); }
		ans = new int[q];
		solve(query);
		 for(int i=0;i<q;i++)out.printLine(ans[i]);
		 out.flush();
		 out.close();
	}
	public static void solve(Query query[]){
	    Arrays.parallelSort(query);
		int ml=query[0].l,mr= ml;
		freq[arr[query[0].l]]++;
		for(int i=0;i<query.length;i++){
		    int ql = query[i].l;
		    int qr = query[i].r;
		    while(ml<ql){
		        remove(ml);
		        ml++;
		    }
		    while(ml>ql){
		        ml--;
		        add(ml);
		    }
		    while(mr<qr){
 		        mr++;
		        add(mr);
		    }
		    while(mr>qr){
		        remove(mr);
		        mr--;
		    }
		    ans[query[i].index] = res;
		    
		    }
		   
	}
	public static void add(int index){
	    freq[arr[index]]++;
	    if(freq[arr[index]] == 1)res++;
	}
	public static void remove(int index){
	    freq[arr[index]]--;
	    if(freq[arr[index]] == 0)res--;
	}
}
class Query implements Comparable<Query>{
    int l,r,index;
    public Query(int l,int r,int index){
        this.l = l;
        this.r = r;
        this.index = index;
    }
    public int compareTo(Query q){
        int l1  = this.l/MO.blk_size;
        int  l2 = q.l/MO.blk_size;
        if(l1-l2 != 0){
            return l1-l2;
        }else{
            return this.r - q.r;
        }
        
    }
     public String toString() {
        return "Query{" +
                "index=" + index +
                ", left=" + l +
                ", right=" + r +
                '}';
    }
}


class InputReader {
 
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
 
		public InputReader(InputStream stream) {
			this.stream = stream;
		}
 
		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}
 
		public int readInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
 
		public String readString() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}
 
		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
 
		public String next() {
			return readString();
		}
 
		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
 
class OutputWriter {
		private final PrintWriter writer;
 
		public OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}
 
		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}
 
		public void print(Object...objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0)
					writer.print(' ');
				writer.print(objects[i]);
			}
		}
 
		public void printLine(Object...objects) {
			print(objects);
			writer.println();
		}
 
		public void close() {
			writer.close();
		}
 
		public void flush() {
			writer.flush();
		}
 
		}
 
class IOUtils {
 
		public static int[] readIntArray(InputReader in, int size) {
			int[] array = new int[size];
			for (int i = 0; i < size; i++)
				array[i] = in.readInt();
			return array;
		}
 
		}

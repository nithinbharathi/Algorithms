
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.concurrent.LinkedBlockingQueue;
class CentroidDecomposition
{   static int MAX = (int)2e5+1;
    static int k =0,n=0,m=0;
    static String arr[];
    static ArrayList<Integer>graph[];
    static int size[];
    static boolean deleted[];
    static boolean vis[];
	public static void main (String[] args) throws java.lang.Exception
	{
	    //InputReader input = new InputReader(System.in);
	     OutputWriter out = new OutputWriter(System.out);
	     Scanner input = new Scanner(System.in);
	    int n= input.nextInt();
	    int e = input.nextInt();
	    graph = new ArrayList[n];
	    size = new int[n];
	    deleted = new boolean[n];
	    vis = new boolean[n];
	    for(int i =0;i<n;i++)graph[i] = new ArrayList<>();
	    for(int i =0;i<e;i++){
	        int a = input.nextInt();
	        int b = input.nextInt();
	        a--;
	        b--;
	        graph[a].add(b);
	        graph[b].add(a);
	    }
	    centroid_decomposition();
	    
	}
	public static void centroid_decomposition(){
	    decompose(0);
	}
	public static void decompose(int v){
	    calculateSubtreeSize(v);
	    int centroid = findCentroid(v,size[v]);
	    System.out.print((centroid+1)+" ");
	    calculateSubtreeSize(centroid);
	    deleted[centroid] = true;
	    for(int child:graph[v]){
	        if(deleted[child])continue;
	        decompose(child);
	    }
	}
	public static int findCentroid(int v,int total){
	    for(int child:graph[v]){
	        if(vis[child] || deleted[child])continue;
	        if(size[child]>total/2){
	            findCentroid(child,size[child]);
	        }
	    }
	    return v;
	}
	public static void calculateSubtreeSize(int v){
	    size[v] = 1;
	    vis[v] = true;
	    for(int child:graph[v]){
	        if(vis[child] || deleted[v])continue;
	        calculateSubtreeSize(child);
	        size[v]+=size[child];
	    }
	}
}
class Query{
    String s = null;
    public Query(String s){
        this.s = s;
    }
}
class Node{
    int id,r,l;
    public Node(int r,int l,int id){
        this.r = r;
        this.l = l;
        this.id = id;
    }
}
 class InputReader{
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
		
		public InputReader(InputStream stream) {
			this.stream = stream;
		}
		
		public int read() {
			if (numChars == -1) {
				throw new InputMismatchException();
			}
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}
		
		public int readInt() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
		
		public String readString() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}
		
		public double readDouble() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') {
				if (c == 'e' || c == 'E') {
					return res * Math.pow(10, readInt());
				}
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') {
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) {
					if (c == 'e' || c == 'E') {
						return res * Math.pow(10, readInt());
					}
					if (c < '0' || c > '9') {
						throw new InputMismatchException();
					}
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}
		
		public long readLong() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
		
		public boolean isSpaceChar(int c) {
			if (filter != null) {
				return filter.isSpaceChar(c);
			}
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
		
		public void print(Object... objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0) {
					writer.print(' ');
				}
				writer.print(objects[i]);
			}
			writer.flush();
		}
		
		public void printLine(Object... objects) {
			print(objects);
			writer.println();
			writer.flush();
		}
		
		public void close() {
			writer.close();
		}
		
		public void flush() {
			writer.flush();
		}
	}
	   


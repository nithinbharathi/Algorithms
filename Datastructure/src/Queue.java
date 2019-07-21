

public class Queue{
	static int count = 0;
	public static void main(String[] args) {
		CircularQueue obj = new CircularQueue();
		obj.remove();
		obj.add(3);
		obj.add(1);
		obj.add(6);
		obj.add(5);
		obj.print();
	}
	
}
class CircularQueue{
	private int front = -1;
	private int rear =-1;
	private int size = 10;
	int arr[];
	public CircularQueue(){
		arr = new int[size];
	}
	
	
	//checks if the queue is empty
	public boolean isEmpty(){
		if(front == -1)return true;
		return false;
	}
	
	
	//checks if the queue is full
	public boolean isFull(){
		if(front == 0 && rear == size-1 || rear+1 == front)return true;
		return false;
	}
	
	
	// inserts elemengt in the queue
	public void add(int data){
		if(isFull()){
			System.out.println("queue is full !");
			return;
		}
		if(isEmpty()){
			front = 0;
			rear =0;
		}else if(rear == size-1){
			rear = 0;
		}else{
			rear++;
		}
		arr[rear] = data;
	}
	
	
	//removes the element at the front of the queue
	public void remove(){
		if(isEmpty()){
			System.out.println("Queue is empty !");
			return;
		}
		if(front == rear){
			arr[front] = 0;
			front = -1;
			rear = -1;
		}else{
			arr[front] = 0;
			front++;
		}
	}
	
	
	//returns element at the front of queue
	public int peek(){
		if(isEmpty()){
			return -1;
		}
		return arr[front];
	}
	
	
	//prints the queue
	public void print(){
	   for(int items:arr){
		   if(items != 0){
			   System.out.print(items+" ");
		   }
		  
	   }
	}	
}

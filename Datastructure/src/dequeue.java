
public class deque {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularQueue obj = new CircularQueue();
		obj.addFront(4);
		obj.addFront(8);
		obj.addRear(10);
		obj.addRear(19);
		obj.addRear(101);
		obj.addRear(191);
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
	
	
	// inserts element in the queue
	public void addFront(int data){
		if(isFull()){
			System.out.println("queue is full !");
			return;
		}
		if(isEmpty()){
			front = 0;
			rear =0;
		}else if(front == 0){
			front = size-1;
		}else{
			front--;
		}
		arr[front] = data;
	}
	
	
	
	//inserts element at the rear of the queue
	public void addRear(int data){
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
	public void removeRear(){
		if(isEmpty()){
			System.out.println("Queue is empty !");
			return;
		}
		if(front == rear){
			arr[front] = 0;
			front = -1;
			rear = -1;
		}else{
			arr[rear] = 0;
			rear--;
		}
	}
	
	
	//removes the element at the front of the queue
		public void removeFront(){
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
	public int getFront(){
		if(isEmpty()){
			return -1;
		}
		return arr[front];
	}
	
	
	//returns element at the rear of the queue
	public int getRear(){
		if(isEmpty()){
			return -1;
		}
		return arr[rear];

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

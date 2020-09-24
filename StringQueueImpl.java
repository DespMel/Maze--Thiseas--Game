import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringQueueImpl implements StringQueue {
	
	
	private ListNode head;
	private ListNode tail;
	private String name;
	int sizeOfQueue;
	
	
	
	public boolean isEmpty(){
		return head==null;
	}

	
	public void put(String item) {
		ListNode node = new ListNode (item);
		if (isEmpty()){
			head=tail=node;
		}
		else{
			tail.nextNode=node;
			tail=node;
		}
		sizeOfQueue++;
	}
	
	
	public String get() throws NoSuchElementException{
		
		if (isEmpty()) {
			throw new NoSuchElementException(name);
		} 
		else{
		String removedItem = head.data;
		ListNode temp = head.nextNode;
		head =temp;
		sizeOfQueue--;
		return removedItem;
		}
	}
	
	public String peek() throws NoSuchElementException {
		
		String firstElement= head.data;
		
		if (isEmpty()) {
			throw new NoSuchElementException(name);
		}
		
		else {
			
			return firstElement;
		}
	}
	
	
	public void printQueue(PrintStream stream) {
		if(isEmpty()){
			System.out.print(" The queue is empty!");
		}
		else{
			ListNode current = head;
			while ( current != null )
			{
				stream.println(current.data );
				stream.flush();
				current = current.nextNode;
			} 
		}
		
		
	}
	
	public int size(){
		if (isEmpty()){
			return 0;
		}
		else{
			 return sizeOfQueue;
			}
	}
}

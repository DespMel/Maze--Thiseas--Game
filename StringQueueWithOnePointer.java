import java.io.PrintStream;
import java.util.NoSuchElementException;


public class StringQueueWithOnePointer implements StringQueue {
	
	
		private ListNode head;
		private String name;
		int sizeOfQueue;
		
		
		
		public boolean isEmpty(){
			return head==null;
		}

		
		public void put(String item) {
			ListNode node = new ListNode (item);
			if (isEmpty()){
				head=node;
				head.nextNode=head;
			}
			else{
			
				node.nextNode=head.nextNode;
				head.nextNode=node;
			
			}
			sizeOfQueue++;
		}
		
		
		public String get() throws NoSuchElementException{
			
			if (isEmpty()) {
				throw new NoSuchElementException(name);
			} 
			else{
			String removedItem = head.nextNode.data;
			ListNode temp = head.nextNode.nextNode;
			head.nextNode =temp;
			sizeOfQueue--;
			return removedItem;
			}
		}
		
		public String peek() throws NoSuchElementException {
			
			String oldestElement= head.nextNode.data;
			
			if (isEmpty()) {
				throw new NoSuchElementException(name);
			}
			
			else {
				
				return oldestElement;
			}
		}
		
		
		public void printQueue(PrintStream stream) {
			if(isEmpty()){
				System.out.print(" The queue is empty!");
			}
			else{
				ListNode current = head.nextNode;
				while ( current != null )
				{
					stream.println(current.data );
					stream.flush();
					current = current.nextNode.nextNode;
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




import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringStackImpl implements StringStack {

	private ListNode firstNode;
	private ListNode lastNode;
	private String name;
	private int sizeOfStack;

	public boolean isEmpty() {
		return firstNode == null;
	}

	public void push(String item) {

		ListNode node = new ListNode(item);
		if (isEmpty()) {
			firstNode = lastNode = node;
		} 
		else {
			node.nextNode = firstNode;
			firstNode = node;
		}
		sizeOfStack++;
	}

	public String pop() throws NoSuchElementException {
		
		
		if (isEmpty()) {
			throw new NoSuchElementException(name);
		}
		String removedItem = firstNode.data;
		 
		if (firstNode == lastNode) {
				firstNode = null;
				lastNode = null;
		} 
		else {
				firstNode = firstNode.nextNode;
				
		}
		sizeOfStack--;
	
		return removedItem;
	}
	
	
	public String peek() throws NoSuchElementException{
		
		String firstElement= firstNode.data;
		
		if (isEmpty()) {
			throw new NoSuchElementException(name);
		}
		
		else {
			
			return firstElement;
		}
	}
	
	public void printStack(PrintStream stream) {
		if(isEmpty()){
			System.out.print(" The stack is empty!");
		}
		else{
			ListNode current = firstNode;
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
			 return sizeOfStack;
		}
	}
}


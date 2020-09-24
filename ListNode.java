class ListNode
{
	String data;
	ListNode nextNode;

	/**
	 * Constructor. It initializes data and sets next node to null 
	 * @param object a reference to node's data
	 */
	ListNode( String object )
	{
		this( object, null );
	} 
	
	/**
	 * constructor creates ListNode with passed data and next node
	 * @param object the reference to node's data
	 * @param node the next node in the list
	 */
	ListNode( String object, ListNode node )
	{
		data = object;
		nextNode = node;
	}

	/**
	 * Returns this node's data
	 * @return the reference to node's data
	 */
	String getObject()
	
	{
		return data; 
	}

	/**
	 * Get reference to next node
	 * @return the next node
	 */
	ListNode getNext()
	{
		return nextNode; 
	} 
} 
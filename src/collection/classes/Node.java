package collection.classes;



/*
 * Node class for the linked stack
 */

public class Node<T> {
	/*
	 * Instance Variables
	 */
	private T data;
	private Node<T> link;

	/*
	 * Constructor
	 */
	public Node(T data, Node<T> link) {
		this.data = data;
		this.link = link;
	}

	/*
	 * Description: Getter for the data at each element
	 * Params: No params
	 * Preconditon: Can always be called
	 * Postcondition: Returns the data of an elemnent
	 * Throws list:  Doesn't throw anything
	 */
	public T getData() {
		return data;
	}
	
	
	/*
	 * Description: Sets the data for an element
	 * Params: Takes a generic data type that the node will store
	 * Preconditon: Can always set the data since generic
	 * Postcondition: An element will have its data set to something
	 * Throws list:  Doesn't throw anything
	 */
	public void setData(T data) {
		this.data = data;
	}
	
	
	/*
	 * Description: Getter for the link at each element
	 * Params: No params
	 * Preconditon: Can always be called
	 * Postcondition: Returns the link of an elemnent
	 * Throws list:  Doesn't throw anything
	 */
	public Node<T> getLink() {
		return link;
	}
	
	
	/*
	 * Description: Assings the link of the node. The node that the current node is pointing to
	 * Params: Takes the link of a node
	 * Preconditon: Can always be called since the node is generic
	 * Postcondition: The node will have its link set to something
	 * Throws list: Doesn't throw anything
	 */
	public void setLink(Node<T> link) {
		this.link = link;
	}
	

	/*
	 * Description: prints the content of a node
	 * Params: No params
	 * Preconditon: Can always be called
	 * Postcondition: The data and link of a node will be printed to the screen
	 * Throws list: Doesn't throw anything
	 */
	@Override
	public String toString() {
		return "GENNode [data=" + data + ", link=" + link + "]";
	}

}

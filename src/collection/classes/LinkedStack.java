package collection.classes;
import java.util.EmptyStackException;

/*
 * Class is the data strucure used to store the symbols to find if an expression is balanced or unbalanced
 */

public class LinkedStack<T> {

	/*
	 * Instance Variables
	 */
	private Node<T> top;

	/*
	 * Constructor
	 */
	public LinkedStack() {
		top = null;
	}

	/*
	 * Description: Places an element onto the top of the stack
	 * Params: Takes an element
	 * Preconditon: Can always push an item since generic
	 * Postcondition: A new element will be added to the stack
	 * Throws list:  Throws an OutOfMemoryException if the computer runs out of space
	 */
	public void push(T item) {
		top = new Node<T>(item, top);
	}
	
	/*
	 * Description: Takes the top item off of the stack.
	 * Params: No params
	 * Preconditon: Stack must contain at least one item
	 * Postcondition: Top element taken off and retured
	 * Throws list:  Throws an EmptyStackException if the method is called on an empty stack
	 */
	public T pop() {
		T answer;

		if (top == null)
			throw new EmptyStackException();

		answer = top.getData();
		top = top.getLink();
		return answer;
	}
	
	/*
	 * Description: Returns the top item without removing it
	 * Params: No params
	 * Preconditon: Stack can't be empty
	 * Postcondition: The top elements data will be returned
	 * Throws list:  Throws an EmptyStackException if the method is called on an empty stack
	 */
	public T peek() {
		if (top == null)
			throw new EmptyStackException();
		return top.getData();
	}
	
	/*
	 * Description: Checks if the stack is emtpy
	 * Params: No params
	 * Preconditon: Can always be called
	 * Postcondition: Returns true if empty otherwise false
	 * Throws list:  Doesn't throw anything
	 */
	public boolean isEmpty() {
		return (top == null);
	}

	/*
	 * Description: Prints the content of a stack
	 * Params: No params
	 * Preconditon: Can always be called
	 * Postcondition: Returns a string representation of what is in the stack
	 * Throws list: Doesn't throw anything
	 */
	@Override
	public String toString() {
		String info = "";
		Node<T> cursor = top;
		while (cursor != null) {
			info += "| " + cursor.getData() + " |";
			info += (cursor == top) ? " <- TOP\n" : "\n";
			cursor = cursor.getLink();
		}

		info += "  --- ";
		return info;
	}

}

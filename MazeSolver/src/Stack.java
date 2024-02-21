/**
 * Project Description:
 * 
 * Name: Farzad Hasan
 * Period: 1
 * Project: Maze Solver
 * Date: 2/20/2024
 * 
 * A last-in-first-out (LIFO) stack of generic items.
 *
 * @param <T> the type of item to store in the stack
 */
public class Stack<T>
{
	
	//Creates the starting node.
	private Node head;
	//Creates variable to track length of list.
    private int size;
    
    private static class Node<T> 
    {
    	//Creates field for data.
        private T data;
        //Creates the next node to point to the next item in list.
        private Node next;
    }
    
    public Stack()
    {
    	//Creates a new stack
    	head = null;
        size = 0;
    }

    /**
     * Adds an item to the stack.
     *
     * @param newItem the item to add
     */
    public void push(T newItem)
    {
    	//Checks if new item had anything of not.
    	if (newItem == null) {
    		throw new IllegalArgumentException();
    	}
    	
    	//pushes to the stack.
        Node old = head;
        head = new Node();
        head.data = newItem;
        head.next = old;
        size++;
    }

    /**
     * Removes and returns the item on the stack that was most recently added.
     *
     * @return the item on the stack that was most recently added
     */
    public T pop()
    {
    	//Checks current state of the list.
    	if (isEmpty()) {
    		throw new IllegalStateException();
    	}
        T popItem = (T)head.data;
        head = head.next;
        size--;
        return popItem;
    }

    /**
     * Returns the item most recently added to the stack.
     *
     * @return the item most recently added to the stack
     */
    public T peek()
    {
    	if (isEmpty()) {
    		throw new IllegalStateException();
    	}
        return (T)head.data;
    }

    /**
     * Returns whether the stack is empty.
     *
     * @return whether the stack is empty
     */
    public boolean isEmpty()
    {
    	//checks if array is empty or not.
    	return (size == 0);
    }

    /**
     * Returns the number of items in the stack.
     *
     * @return the number of items in the stack
     */
    public int size()
    {
    	return size;
    }
}

/**
 * Project Description:
 * 
 * Name: Farzad Hasan
 * Period: 1
 * Project: Maze Solver
 * Date: 2/13/2024
 * 
 * A first-in-first-out (FIFO) queue of generic items.
 *
 * @param <T> the type of item to store in the queue
 */
public class Queue<T>
{
	//Constructing a node.
	private static class Node<T> {
        private T value;
        private Node<T> next;
    }
	
	//Relevant nodes and variables made to traverse linked list.
	private int size;
    private Node<T> head;
    private Node<T> tail;
    
    /**
     * Initializes an empty queue.
     */
    public Queue()
    {
    	//Setting all values to null to create empty que.
    	head = null;
        tail = null;
        size = 0;
    }
    
    

    /**
     * Adds an item to the queue.
     *
     * @param newItem the item to add
     */
    public void enqueue(T newItem)
    {
    	if (newItem == null) {
    			throw new IllegalArgumentException();
    		}
        Node<T> current = tail;
        tail = new Node<T>();
        tail.next = null;
        tail.value = newItem;
        if (isEmpty()) head = tail;
        else current.next = tail;
        size++;
    }

    /**
     * Removes and returns the item on the queue that was least recently added.
     *
     * @return the item on the queue that was least recently added
     */
    public T dequeue()
    {
    	if (isEmpty()) {
    		throw new IllegalStateException();
    	}
        T val = (T)head.value;
        head = head.next;
        size--;
        if (isEmpty()) {
        	tail = null;
        }
        return val;
    }

    /**
     * Returns the item least recently added to the queue.
     *
     * @return the item least recently added to the queue
     */
    public T peek()
    {
    	if (isEmpty()) {
    		throw new IllegalStateException();
    	}
        return (T)head.value;
    }

    /**
     * Returns whether the queue is empty.
     *
     * @return whether the queue is empty
     */
    public boolean isEmpty()
    {
    	return (head == null);
    }

    /**
     * Returns the number of items in the queue.
     *
     * @return the number of items in the queue
     */
    public int size()
    {
        return size;
    }
}

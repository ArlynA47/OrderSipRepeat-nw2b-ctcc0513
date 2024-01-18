package ordersiprepeat.nw2b.ctcc0513;

/**
 *
 * @author arlyn musada
 */
import java.util.LinkedList;
import java.util.NoSuchElementException;

// Custom queue implementation using a LinkedList
public class MyQueue<T> {

    // Internal list to store queue elements
    private LinkedList<T> data;

    // Default constructor that creates an empty queue
    public MyQueue() {
        this.data = new LinkedList<>(); // Initialize the internal list
    }

    // Constructor that creates a copy of another queue
    public MyQueue(MyQueue<T> otherQueue) {
        // Create a new list and copy elements from the other queue's list
        this.data = new LinkedList<>(otherQueue.data);
    }

    // Adds an item to the back of the queue (FIFO order)
    public void enqueue(T item) {
        // Use LinkedList's addLast method to add to the tail
        data.addLast(item);
    }

    // Removes and returns the item at the front of the queue
    public T dequeue() {
        // Check if the queue is empty
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot dequeue from an empty queue");
        }

        // Use LinkedList's removeFirst method to remove and return the head
        return data.removeFirst();
    }

    // Checks if the queue is empty (no elements)
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // Returns the number of elements currently in the queue
    public int size() {
        return data.size();
    }
}

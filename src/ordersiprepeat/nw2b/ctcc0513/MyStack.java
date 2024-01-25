package ordersiprepeat.nw2b.ctcc0513;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A LIFO (Last-In-First-Out) data structure implemented using linked nodes.
 *
 * @param <T> The type of data stored in the stack.
 */
public class MyStack<T> implements Iterable<T> {

    private Node<T> top; // Top element of the stack (null if empty)

    private static class Node<T> {

        T data; // The data stored in this node
        Node<T> next; // Reference to the next node below (null if last)

        Node(T data) {
            this.data = data;
        }
    }

    /**
     * Constructs an empty stack.
     */
    public MyStack() {
        this.top = null;
    }

    /**
     * Constructs a new stack that is a copy of another stack.
     *
     * @param otherStack The stack to copy.
     */
    public MyStack(MyStack<T> otherStack) {
        this.top = null;
        for (T item : otherStack) {
            this.push(item);
        }
    }

    /**
     * Pushes a new element onto the top of the stack.
     *
     * @param item The element to push.
     */
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
    }

    /**
     * Retrieves the top element of the stack without removing it.
     *
     * @throws IllegalStateException If the stack is empty.
     */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    /**
     * Removes and returns the top element of the stack.
     *
     * @throws IllegalStateException If the stack is empty.
     */
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return True if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Empties the stack by setting the top element to null.
     */
    public void clear() {
        top = null;
    }

    /**
     * Implements the Iterable interface to enable iterating over the stack
     * elements.
     *
     * @return An iterator for the stack elements.
     */
    @Override
    public Iterator<T> iterator() {
        return new MyStackIterator<>(top);
    }

    private static class MyStackIterator<T> implements Iterator<T> {

        private Node<T> current;

        MyStackIterator(Node<T> top) {
            current = top;
        }

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.data;
            current = current.next;
            return data;
        }
    }
}

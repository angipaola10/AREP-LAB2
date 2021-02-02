package edu.escuelaing.arep.datastructures;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Doubly linked list implementation
 * A doubly linked list is a representation of a collection of data.
 * The doubly linked list can store data of any type
 * @author Angi Paola Jimenez Pira
 * @param <E> data type of the elements of doubly linked list.
 */
public class LinkedList<E> implements Iterable<E>, Serializable {

    private Node<E> firstNode = null;
    private Node<E> lastNode = null;
    private int size = 0;

    /**
     * Instantiates a new Linked list.
     */
    public LinkedList(){}

    /**
     * Adds an element to the end of the doubly linked list.
     *
     * @param e a data to add at the doubly linked list
     */
    public void add(E e){
        Node<E> node = new Node<>(e);
        if (firstNode == null) {
            setFirstNode(node);
        } else {
            lastNode.setNextNode(node);
            node.setPrevNode(lastNode);
        }
        setLastNode(node);
        size++;
    }

    /**
     * Gets node data with a specific index
     *
     * @param index number or position of a specific node
     * @return node data
     * @throws IndexOutOfBoundsException throws if the node with index couldn't be found
     */
    public E get(int index) throws IndexOutOfBoundsException{
        if (index == 0) return firstNode.getData();
        if (index == size - 1) return lastNode.getData();
        if (index < size && index > 0) {
            Node<E> currentNode = firstNode;
            for (int i = 1; i <= index; i++){
                currentNode = currentNode.getNextNode();
            }
            return currentNode.getData();
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * Remove node with a specific index of the doubly linked list.
     *
     * @param index number or position of a specific node
     * @throws IndexOutOfBoundsException throws if the node with index couldn't be found
     */
    public void remove(int index) throws IndexOutOfBoundsException{
        if (index > -1 && index < size) {
            if (index == 0) {
                firstNode = firstNode.getNextNode();
            } else if (index == size - 1) {
                lastNode = lastNode.getPrevNode();
                lastNode.setNextNode(null);
            } else {
                Node<E> currentNode = firstNode;
                for (int i = 1; i <= index; i++) {
                    currentNode = currentNode.getNextNode();
                }
                currentNode.getPrevNode().setNextNode(currentNode.getNextNode());
            }
            size--; return;
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * Gets first node of the doubly linked list.
     *
     * @return the first node of the doubly linked list
     */
    public Node<E> getFirstNode() {
        return firstNode;
    }

    /**
     * Set first node of the doubly linked list.
     *
     * @param firstNode the first node of the doubly linked list
     */
    public void setFirstNode(Node<E> firstNode){
        this.firstNode = firstNode;
    }

    /**
     * Gets last node of the doubly linked list.
     *
     * @return the last node of the doubly linked list
     */
    public Node<E> getLastNode() {
        return lastNode;
    }

    /**
     * Set last node of the doubly linked list.
     *
     * @param lastNode the last node of the doubly linked list
     */
    public void setLastNode(Node<E> lastNode){
        this.lastNode = lastNode;
    }

    /**
     * Find size of the doubly linked list.
     *
     * @return the size of the doubly linked list.
     */
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> currentNode = firstNode;

            /**
             * Change the actual node for the next and return the next data node.
             * @return next data node
             */
            public E next() {
                E currentData = currentNode.getData();
                currentNode = currentNode.getNextNode();
                return currentData;
            }

            /**
             * Check if exists a next node.
             * @return boolean
             */
            public boolean hasNext() {
                return currentNode != null;
            }

        };
    }

}

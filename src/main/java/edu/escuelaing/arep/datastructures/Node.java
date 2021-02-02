package edu.escuelaing.arep.datastructures;

import java.io.Serializable;

/**
 * Node implementation
 * A node is a representation of data, the node has a previous and next node.
 * The node can be of any type
 * @author Angi Paola Jimenez Pira
 * @param <E> data type of the node.
 */
public class Node<E> implements Serializable {

    private Node<E> prevNode = null;
    private E data;
    private Node<E> nextNode = null;

    /**
     * Instantiates a new Node.
     *
     * @param data the node data
     */
    public Node(E data){
        this.data = data;
    }

    /**
     * Gets previous node.
     *
     * @return the previous node
     */
    public Node<E> getPrevNode() { return this.prevNode; }

    /**
     * Sets previous node.
     *
     * @param prevNode the previous node
     */
    public void setPrevNode (Node<E> prevNode) { this.prevNode = prevNode; }

    /**
     * Gets node data.
     *
     * @return the node data
     */
    public E getData(){
        return data;
    }

    /**
     * Sets node data.
     *
     * @param data the node data
     */
    public void setData(E data) {
        this.data = data;
    }

    /**
     * Get the next node.
     *
     * @return the next node
     */
    public Node<E> getNextNode(){ return nextNode; }

    /**
     * Set the next node.
     *
     * @param nextNode the next node
     */
    public void setNextNode (Node<E> nextNode){
        this.nextNode = nextNode;
    }

}

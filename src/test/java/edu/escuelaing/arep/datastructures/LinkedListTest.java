package edu.escuelaing.arep.datastructures;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The type Linked list test.
 */
public class LinkedListTest {

    /**
     * Should create linked list.
     */
    @Test
    public void shouldCreateLinkedList(){
        LinkedList<Double> newLinkedList = new LinkedList<>();
        assertEquals(newLinkedList.getClass().toString(),"class edu.escuelaing.arep.datastructures.LinkedList");
        assertNotNull(newLinkedList);
    }

    /**
     * Should add to linked list.
     */
    @Test
    public void shouldAddToLinkedList(){
        LinkedList<String> newLinkedList = new LinkedList<>();
        String[] dataSet = {"Value1", "Value2", "Value3", "Value4", "Value5"};
        for (int i = 0; i < dataSet.length; i++){
            newLinkedList.add(dataSet[i]);
            assertEquals(i+1, newLinkedList.size());
            assertEquals(dataSet[i], newLinkedList.get(i));
        }
    }

    /**
     * Should get size of linked list.
     */
    @Test
    public void shouldGetSize(){
        LinkedList<Double> newLinkedList = new LinkedList<>();
        Double[] dataSet = {1.0, 2.1, 3.2, 4.3, 5.4, 6.5, 7.6, 8.7, 9.8, 10.8};
        for (int i = 0; i < dataSet.length; i++){
            newLinkedList.add(dataSet[i]);
            assertEquals(i+1, newLinkedList.size());
        }
    }

    /**
     * Should get data of specific index.
     */
    @Test
    public void shouldGetDataOfSpecificIndex(){
        LinkedList<Integer> newLinkedList = new LinkedList<>();
        Integer[] dataSet = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < dataSet.length; i++){
            newLinkedList.add(dataSet[i]);
        }
        for(int i = dataSet.length - 1; i >= 0; i--){
            assertEquals(dataSet[i], newLinkedList.get(i));
        }
    }

    /**
     * Should remove data of specific index.
     */
    @Test
    public void shouldRemoveDataOfSpecificIndex(){
        LinkedList<Integer> newLinkedList = new LinkedList<>();
        Integer[] dataSet = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < dataSet.length; i++){
            newLinkedList.add(dataSet[i]);
        }
        newLinkedList.remove(0);
        assertEquals(dataSet.length - 1, newLinkedList.size());
        assertNotEquals(dataSet[0], newLinkedList.get(0));

        newLinkedList.remove(newLinkedList.size() - 1);
        assertEquals(dataSet.length - 2, newLinkedList.size());
        assertNotEquals(dataSet[dataSet.length - 1], newLinkedList.get(newLinkedList.size() - 1));

        newLinkedList.remove(2);
        assertEquals(dataSet.length - 3, newLinkedList.size());
        assertNotEquals(dataSet[2], newLinkedList.get(2));

    }

}
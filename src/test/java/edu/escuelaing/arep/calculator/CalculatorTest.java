package edu.escuelaing.arep.calculator;

import edu.escuelaing.arep.datastructures.LinkedList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * The type Calculator test.
 */
public class CalculatorTest {

    private LinkedList<Double> values1;
    private LinkedList<Double> values2;
    private LinkedList<Double> values3;
    private LinkedList<Double> values4;


    /**
     * Set up.
     * Initialize the data set structures that will be used in the tests.
     */
    @Before
    public void setUp(){
        this.values1 = createLinkedList(new Double[]{186.0,699.0,132.0,272.0,291.0,331.0,199.0,1890.0,788.0,1601.0});
        this.values2 = createLinkedList(new Double[]{16.0,69.0,12.0,22.0,21.0,31.0,19.0,180.0,78.0,161.0});
        this.values3 = createLinkedList(new Double[]{86.0,99.0,32.0,22.0,91.0,91.0,99.0,890.0,88.0});
        this.values4 = createLinkedList(new Double[]{56.0,679.0,182.0,292.0,91.0,531.0,799.0,890.0});
    }

    /**
     * Should calculate mean.
     */
    @Test
    public void shouldCalculateMeanWithLinkedList() {
        assertEquals(638.9, Calculator.mean(values1), 0.0);
        assertEquals(60.9, Calculator.mean(values2), 0.0);
        assertEquals(166.44444, Calculator.mean(values3), 0.00001);
        assertEquals(440.0, Calculator.mean(values4), 0.0);
    }

    /**
     * Should calculate mean.
     */
    @Test
    public void shouldCalculateMeanWithStringLine() {
        assertEquals(638.9, Calculator.mean("186.0,699.0,132.0,272.0,291.0,331.0,199.0,1890.0,788.0,1601.0"), 0.0);
        assertEquals(60.9, Calculator.mean("16.0,69.0,12.0,22.0,21.0,31.0,19.0,180.0,78.0,161.0"), 0.0);
        assertEquals(166.44444, Calculator.mean("86.0,99.0,32.0,22.0,91.0,91.0,99.0,890.0,88.0"), 0.00001);
        assertEquals(440.0, Calculator.mean("56.0,679.0,182.0,292.0,91.0,531.0,799.0,890.0"), 0.0);
    }

    /**
     * Should calculate standard deviation.
     */
    @Test
    public void shouldCalculateMeanStandardDeviationWithLinkedList() {
        assertEquals(625.63398, Calculator.standardDeviation(values1), 0.00001);
        assertEquals(62.11539, Calculator.standardDeviation(values2), 0.00001);
        assertEquals(272.85028, Calculator.standardDeviation(values3), 0.00001);
        assertEquals(328.30908, Calculator.standardDeviation(values4), 0.00001);
    }

    /**
     * Should calculate standard deviation.
     */
    @Test
    public void shouldCalculateMeanStandardDeviationWithStringLine() {
        assertEquals(625.63398, Calculator.standardDeviation("186.0,699.0,132.0,272.0,291.0,331.0,199.0,1890.0,788.0,1601.0"), 0.00001);
        assertEquals(62.11539, Calculator.standardDeviation("16.0,69.0,12.0,22.0,21.0,31.0,19.0,180.0,78.0,161.0"), 0.00001);
        assertEquals(272.85028, Calculator.standardDeviation("86.0,99.0,32.0,22.0,91.0,91.0,99.0,890.0,88.0"), 0.00001);
        assertEquals(328.30908, Calculator.standardDeviation("56.0,679.0,182.0,292.0,91.0,531.0,799.0,890.0"), 0.00001);
    }

    private LinkedList<Double> createLinkedList(Double[] values){
        LinkedList<Double> dataLinkedList = new LinkedList<>();
        for(Double value: values){
            dataLinkedList.add(value);
        }
        return dataLinkedList;
    }
}
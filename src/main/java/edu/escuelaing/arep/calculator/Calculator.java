package edu.escuelaing.arep.calculator;

import edu.escuelaing.arep.datastructures.LinkedList;

/**
 * Statistics calculator that helps to calculate the arithmetic mean and standard deviation.
 * @author Angi Paola Jimenez Pira
 * @version 1.0
 */
public class Calculator {

    /**
     * Calculates the arithmetic mean of a set of double values.
     *
     * @param values Linked List with the values to calculate the mean
     * @return Arithmetic mean of the values
     */
    public static double mean(LinkedList<Double> values){
        Double sum = 0.0;
        for (Double value: values) sum += value;
        return sum / values.size();
    }

    /**
     * Calculates the arithmetic mean of a set of double values.
     *
     * @param line String line with the values to calculate the mean separated by ","
     * @return Arithmetic mean of the values
     */
    public static double mean(String line){
        LinkedList<Double> values = generateLinkedList(line);
        Double sum = 0.0;
        for (Double value: values) sum += value;
        return sum / values.size();
    }

    /**
     * Calculates the standard deviation of a set of double values.
     *
     * @param line String line with the values to calculate the mean separated by ","
     * @return Standard deviation of the values
     */
    public static double standardDeviation(String line){
        LinkedList<Double> values = generateLinkedList(line);
        double standardDeviation = 0.0;
        double mean = mean(values);
        for(double value: values){
            standardDeviation += Math.pow( (value - mean), 2);
        }
        standardDeviation = Math.sqrt( standardDeviation / (values.size() - 1) );
        return standardDeviation;
    }


    private static LinkedList<Double> generateLinkedList(String line){
        String[] list = line.split(",");
        LinkedList<Double> linkedList = new LinkedList<>();
        for(String s: list){
            linkedList.add(new Double(s));
        }
        return linkedList;
    }

}

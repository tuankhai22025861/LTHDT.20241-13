package aimproject.test;

import aimproject.aim.*;
public class TestMergeSort {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

        int[] array = {64, 34, 25, 12, 22, 11, 90};
        mergeSort.setArray(array);

        System.out.println("Initial Array:");
        mergeSort.displaySteps();

        System.out.println("Sorting...");
        mergeSort.sort();

        System.out.println("Sorted Array:");
        mergeSort.displaySteps();
        // Test method getArray 
        System.out.println("Sorted Array (dung getArray):");
        int[] sortedArray = mergeSort.getArray();
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Test getSteps
        System.out.println("Steps of sorting:");
        for (int[] step : mergeSort.getSteps()) {
            for (int num : step) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    
}

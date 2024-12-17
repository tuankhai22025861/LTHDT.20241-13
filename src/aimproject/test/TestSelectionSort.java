package aimproject.test;

import aimproject.aim.*;
public class TestSelectionSort {
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();

        int[] array = {64, 34, 25, 12, 22, 11, 90};
        selectionSort.setArray(array);

        System.out.println("Initial Array:");
        selectionSort.displaySteps();

        System.out.println("Sorting...");
        selectionSort.sort();

        System.out.println("Sorted Array:");
        selectionSort.displaySteps();
        
        System.out.println("Sorted Array (dung getArray):");
        int[] sortedArray = selectionSort.getArray();
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Test getSteps
        System.out.println("Steps of sorting:");
        for (int[] step : selectionSort.getSteps()) {
            for (int num : step) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

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
    }
}

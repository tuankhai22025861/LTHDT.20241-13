package aimproject.test;

import aimproject.aim.*;
public class TestShellSort {
    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();

        int[] array = {64, 34, 25, 12, 22, 11, 90};
        shellSort.setArray(array);

        System.out.println("Initial Array:");
        shellSort.displaySteps();

        System.out.println("Sorting...");
        shellSort.sort();

        System.out.println("Sorted Array:");
        shellSort.displaySteps();

        System.out.println("Sorted Array (dung getArray):");
        int[] sortedArray = shellSort.getArray();
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

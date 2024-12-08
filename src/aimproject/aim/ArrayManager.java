package aimproject.aim;

import java.util.Random;
import java.util.Scanner;

public class ArrayManager {
    // Attribute to store the array
    private int[] array;

    // Constructor
    public ArrayManager() {
        this.array = null;
    }

    // Method to create a random array
    public int[] createRandomArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        Random random = new Random();
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100); // Generates numbers between 0 and 99
        }
        return array;
    }

    // Method to input an array manually
    public int[] inputArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        array = new int[size];
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        return array;
    }

    // Method to get the array
    public int[] getArray() {
        return array;
    }

    // Method to display the array
    public void displayArray() {
        if (array == null) {
            System.out.println("Array is not initialized.");
            return;
        }
        System.out.print("Array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
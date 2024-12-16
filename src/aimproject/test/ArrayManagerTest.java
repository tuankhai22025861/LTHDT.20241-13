package aimproject.test;

import aimproject.aim.*;
import java.util.Scanner;

public class ArrayManagerTest {
    public static void main(String[] args) {
        ArrayManager arrayManager = new ArrayManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nArray Manager Test Menu");
            System.out.println("1. Create Random Array");
            System.out.println("2. Input Array Manually");
            System.out.println("3. Display Array");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter size of the array: ");
                    int size = scanner.nextInt();
                    try {
                        arrayManager.createRandomArray(size);
                        System.out.println("Random array created successfully.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        arrayManager.inputArray();
                        System.out.println("Array input successfully.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    arrayManager.displayArray();
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
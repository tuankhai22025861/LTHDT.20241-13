package aimproject.aim;

import java.util.Random;
import java.util.Scanner;

public class ArrayManager {
    private int[] array;

    // Constructor
    public ArrayManager() {
        this.array = null;
    }

    // Method to create a random array
    public int[] createRandomArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("so luong phan tu phai lon hon 0");
        }
        Random random = new Random();
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000); // random 0-1000
        }
        return array;
    }

    // nhap phan tu
    public int[] inputArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("chon so luong phan tu: ");
        int size = scanner.nextInt();
        if (size <= 0) {
            throw new IllegalArgumentException("so luong phan tu phai lon hon 0");
        }
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    // Method to get the array
    public int[] getArray() {
        return array;
    }

    
}
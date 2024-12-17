package aimproject.aim;

import java.util.ArrayList;
import java.util.List;

abstract class SortAlgorithm {
    protected int[] array;

    // Abstract method sort
    public abstract void sort();
    protected List<int[]> steps; // danh sach luu cac buoc sap xep
    // Hien thi cac buoc cua thuat toan sap xep
    public void displaySteps() {
        System.out.print("Array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    //Setter cho array
    public void setArray(int[] array) {
        this.array = array;
        steps = new ArrayList<>();
        saveStep();
    }

    // Getter cho array
    public int[] getArray() {
        return array;
    }

    // method tra ve mang o tung buoc sap xep
    public List<int[]> getSteps() {
        return steps;
    }

    // luu lai 1 buoc sap xep
    protected void saveStep() {
        steps.add(array.clone());  
    }
}
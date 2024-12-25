package application;

import java.util.ArrayList;
import java.util.List;

abstract class SortAlgorithm {
    protected int[] array;

    public abstract void sort();
    protected List<int[]> steps; 

    public void displaySteps() {
        System.out.print("Array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    

    public void setArray(int[] array) {
        this.array = array;
        steps = new ArrayList<>();
        saveStep();
    }


    public int[] getArray() {
        return array;
    }


    public List<int[]> getSteps() {
        return steps;
    }


    protected void saveStep() {
        steps.add(array.clone());  
    }
}
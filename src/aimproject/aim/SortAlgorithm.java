package aimproject.aim;

abstract class SortAlgorithm {
    protected int[] array;

    // Abstract method sort
    public abstract void sort();

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
    }

    // Getter cho array
    public int[] getArray() {
        return array;
    }
}
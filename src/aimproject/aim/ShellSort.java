package aimproject.aim;

public class ShellSort extends SortAlgorithm{
    @Override
    public void sort() {
        System.out.println("Performing Shell Sort...");
        int n = array.length;
        for(int gap = n/2; gap > 0; gap = gap/2){
            for(int i = gap; i<n; i++){
                int temp = array[i];
                int j;
                for(j = i; j>=gap && array[j-gap] > temp; j = j-gap){
                    array[j] = array[j-gap];
                }
                array[j] = temp;
                displaySteps();
            }
        }
    }
}

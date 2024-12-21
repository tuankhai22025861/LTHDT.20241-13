package application;

public class SelectionSort extends SortAlgorithm {
    @Override
    public void sort(){
        System.out.println("Performing Selection Sort...");
        int n = array.length;
        for(int i = 0; i < n - 1; i++){
            int minIdx = i;
            for(int j = i+1; j<n; j++){
                if(array[j] < array[minIdx]){
                    minIdx = j;
                }
            }
            int tmp = array[minIdx];
            array[minIdx] = array[i];
            array[i] = tmp;
            displaySteps();
            saveStep();
        }
    }
}
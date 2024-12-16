package aimproject.aim;

public class MergeSort extends SortAlgorithm {
    @Override
    public void sort(){
        System.out.println("Performing Merge Sort...");
        mergeSort(0, array.length - 1);
    }

    private void mergeSort(int left, int right){
        if(left < right){
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid+1, right);
            merge(left, mid, right);
            displaySteps();
            saveStep();
        }
    }

    private void merge(int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - (mid + 1) + 1;
        
        int[] L = new int[n1];
        int[] R = new int[n2]; // Cap phat bo nho cho 2 mang L va R
        
        for(int i = 0; i < n1; i++) L[i] = array[left + i]; // Mang L chua cac phan tu ben phai
        for(int j = 0; j < n2; j++) R[j] = array[mid + 1 + j]; // Mang R chua cac phan tu ben trai cua mang

        int i = 0, j = 0, k = left;
        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                array[k] = L[i];
                k++;
                i++;
            }else{
                array[k] = R[j];
                k++;
                j++;
            }
        }
        while(i < n1){
            array[k] = L[i];
            k++;
            i++;
        }
        while(j < n2){
            array[k] = R[j];
            k++;
            j++;
        }

    }
}

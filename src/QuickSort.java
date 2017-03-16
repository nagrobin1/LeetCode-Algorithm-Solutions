// packages to be used in her

import AuxFunctions.PrintArray;
import AuxFunctions.SwapValuesInArray;
import java.util.Random;

/**
 * Created by test on 1/25/17.
 */

public class QuickSort {

    public static void main(String [] args){

        int [] A = {1,3,1,4,1,1,1,1,0,9,7,7};
        System.out.println("Sorted :");
        quickSort(A, 0, A.length-1);
        PrintArray.print_array(A);

    }

    public static void quickSort(int [] A, int low_index, int high_index) {

        if(low_index < high_index){

            // Partition
            int pivot_location = partition(A, low_index, high_index);

            // Recurse of items to left of the pivot_location
            quickSort(A, low_index, pivot_location-1);

            // Recurse of items to left of the pivot_location
            quickSort(A, pivot_location + 1, high_index);

        }
        // base case
        else{
            return;
        }
    }


    public static  int partition(int A[], int low_index, int high_index)
    {
        // randomly choose a pivot location
        Random rPivot = new Random();
        int tempPivotIndex = rPivot.nextInt(high_index - low_index + 1) + low_index;
        // get the value at the random pivot location
        int pivot_value = A[tempPivotIndex];

        // place the pivot value at the end of the array for easy for-loop
        SwapValuesInArray.swap(A, tempPivotIndex, high_index);

        // this is the location we will return at the end
        int pivot_location = low_index;

        // For loop with an inner if-statement
        // i < high_index because we do not want to touch the pivot
        for(int i = low_index; i < high_index; i++){
            if(A[i] < pivot_value){
                SwapValuesInArray.swap(A, i, pivot_location);
                pivot_location++;
            }
        }

        // Put the pivot_value at the location of the pivot_location, so that:
        // All items to the left of pivot_location are < pivot_value
        // All items to the right of pivot_location are > pivot_value
        SwapValuesInArray.swap(A, high_index, pivot_location);

        return pivot_location;
    }

}

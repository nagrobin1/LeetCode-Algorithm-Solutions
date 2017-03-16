/**
 * Created by test on 1/24/17.
 */
import AuxFunctions.PrintArray;

public class MergeSort {

    public static void main(String[] args){

        int [] A = {2,9,3,4};
        mergesort(A);
        System.out.println("Sorted :");
        PrintArray.print_array(A);
    }

    // A is the input array
    public static void mergesort(int [] input){
        int len = input.length;
        // Base Case
        //length 0 or 1 already sorted
        if(len < 2){
            return;
        }

        int midPoint = Math.floorDiv(len,2);
        System.out.println("Midpoint index is " + midPoint);
        int [] left = new int[midPoint];
        int [] right = new int[len - midPoint];

        // fill in the left subarray
        for (int i = 0; i < midPoint; i++){
            left[i] = input[i];
        }
        System.out.println("Left Array: ");
        PrintArray.print_array(left);

        // fill in the right sub-array
        for(int i = midPoint; i < len; i++){
            right[i-midPoint] = input[i];
        }
        System.out.println("Right Array: ");
        PrintArray.print_array(right);

        // Recurse of left sub-array
        mergesort(left);

        // Recurse of left sub-array
        mergesort(right);

        // merge the sorted left and right and sub-arrays,
        // The A we are passing is the current version of A, not the initial A
        merge(left, right, input);

    }

    // This will sort the left and right arrays and place them back
    // into the originial array. Since the original array is unsorted, we
    // are reusing it to put in the sorted numbers.
    public static void merge(int[] left, int [] right, int [] originial) {

        int leftLen = left.length;
        int rightLen = right.length;

        // i for left sub-array
        // j for right sub-array
        // k for merged array
        int i, j, k;
        i = j = k = 0;

        while (i < leftLen && j < rightLen) {
            if (left[i] < right[j]) {
                originial[k++] = left[i++];
            } else {
                originial[k++] = right[j++];
            }
        }

        // Fill in the rest of left over values to mergedArray

        if (i == leftLen) {
            // The right sub-array still has some values left-over
            while (j < rightLen) {
                originial[k++] = right[j++];
            }
        } else {
            // The left sub-array still has some values left-over
            while (i < leftLen) {
                originial[k++] = left[i++];
            }
        }

        System.out.println("Merged:");
        PrintArray.print_array(originial);
    }

}
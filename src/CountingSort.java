import java.util.Arrays;

/**
 * Created by test on 1/17/17.
 */
public class CountingSort {

    public static void main(String[] args) {

        int[] A = {-2,-3,-5, 1, 3, 4};
        int k = findMaxMin(A)[0];
        int min = findMaxMin(A)[1];

        if(Math.signum(min) == 1){
            int[] B = countingSort(A,k);
            System.out.println("After Positive Sorting:");
            for (int e: B){
                System.out.println(e);
            }

        }else{
            int[] B = countingSortNegValues(A, k, min);
            System.out.println("After Negative Sorting:");
            for (int e: B){
                System.out.println(e);
            }
        }

    }

    public static int[] findMaxMin(int [] A){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int [] results = new int[2];

        for (int i = 0; i < A.length; i++) {
            if (max < A[i]) {
                max = A[i];
            }

            if (min > A[i]) {
                min = A[i];
            }

        }

        results[0] =  max;
        results[1] = min;

        return results;
    }

    // A is the array to be sorted
    // k is the largest number in array A
    public static int[] countingSort(int[] A, int k) {

        // The counting array
        int[] C = new int[k + 1];
        // The resulting array
        int[] B = new int[A.length];

        // Initializes C to 0
        Arrays.fill(C, 0);

        // Set C[i] = number of elements = i.
        for (int i = 0; i < A.length; i++) {
            C[A[i]] = C[A[i]] + 1;
        }

        // Set C[i] = number of elements ≤ i.
        for (int j = 1; j <= k; j++) {
            C[j] = C[j] + C[j - 1];
        }

        // start at end cause we want to keep stability
        for (int i = A.length - 1; i >= 0; i--) {
            //Place A[i] at right location
            B[C[A[i]] - 1] = A[i];
            //Decrease for equal elements
            C[A[i]] = C[A[i]] - 1;
        }

        return B;
    }


    public static int[] countingSortNegValues(int [] A, int k, int smallestNeg){

        int shiftValue = -1*(smallestNeg);
        // The counting array, shift by the smallest Neg value
        int[] C = new int[k + 1 + shiftValue];
        // The resulting array
        int[] B = new int[A.length];

        // Initializes C to 0
        Arrays.fill(C, 0);

        // Set C[i] = number of elements = i.
        for (int i = 0; i < A.length; i++) {
            C[A[i] + shiftValue] = C[A[i] + shiftValue] + 1;
        }

        // Set C[i] = number of elements ≤ i.
        for (int j = 1; j <= k+shiftValue; j++) {
            C[j] = C[j] + C[j - 1];
        }

        for (int i = A.length - 1; i >= 0; i--) {
            //Place A[i] at right location
            B[C[A[i] + shiftValue] - 1] = A[i];
            //Decrease for equal elements
            C[A[i] + shiftValue] = C[A[i] + shiftValue] - 1;
        }

        return B;
    }
}
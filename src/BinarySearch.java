/**
 * Created by test on 1/28/17.
 */
public class BinarySearch {

    // only works if A is sorted already
    // returns the index of the item we are looking for from 0 to n-1 if the item is located in the array
    // otherwise returns -1
    public static int binarySearch(int[] A, int lookUpValue) {
        return BinarySearch(A, 0, A.length - 1, lookUpValue);
    }

    public static int BinarySearch(int[] A, int low_index, int high_index, int lookUpValue) {

        //  find the mid-point index of the array
        int mid_index = Math.floorDiv((high_index + low_index), 2);

        // the search only works as long as the low index is equal to or less
        // than the high index.
        if(low_index <= high_index) {

            // checks if the midpoint item is the same as the lookUpValue
            if (A[mid_index] == lookUpValue) {
                return mid_index;
                // we can also return True if using booleans
            }
            // If the lookUpValue is larger than mid, then it can only
            // be present in right sub-array
            if (lookUpValue > A[mid_index]) {
                return BinarySearch(A, mid_index + 1, high_index, lookUpValue);
            }
            // If the lookUpValue is less than mid, then it can only
            // be present in left sub-array
            if (lookUpValue < A[mid_index]) {
                return BinarySearch(A, low_index, mid_index - 1, lookUpValue);
            }
        }

        // This means that low index  > high index
        return -1;
        // we can also return False if using booleans

    }
}




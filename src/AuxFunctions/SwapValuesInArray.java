package AuxFunctions;

/**
 * Created by test on 1/27/17.
 */
public class SwapValuesInArray {

    public static void swap(int [] input, int i, int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}

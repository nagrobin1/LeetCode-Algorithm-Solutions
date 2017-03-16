import java.util.Arrays;

/**
 * Created by test on 2/3/17.
 */
public class binary_search_insert {

    public static int index_to_insert_n_into_sorted_array(int [] input, int n){

        int mid_index = Math.floorDiv(input.length, 2);

        int mid_value = input[mid_index];

        if (mid_index == 0){
            if(n > mid_value){
                return 1;
            }else {
                return 0;
            }
        }

        if (mid_value == n){
            return mid_index;
        }

        if (n > mid_value){
            int [] rightside = Arrays.copyOfRange(input, mid_index + 1, input.length-1);
            return mid_index + index_to_insert_n_into_sorted_array(rightside, n);
        }else{
            int [] leftside = Arrays.copyOfRange(input, 0, mid_index);
            return mid_index - index_to_insert_n_into_sorted_array(leftside, n);
        }

    }
    


    public static void main(String [] args){
        int [] a = {1,3,5,7};
        int n = 9;
        System.out.println(index_to_insert_n_into_sorted_array(a,n));




    }

}

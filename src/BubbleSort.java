import java.util.ArrayList;

/**
 * Created by test on 1/17/17.
 */
public class BubbleSort {

    public static void main(String[] args){

        ArrayList<Integer> a = new ArrayList<Integer>(){{
            add(2);
            add(3);
            add(1);
        }};

        System.out.println("Before Bubble Sorting");
        System.out.println(a);
        System.out.println("After Bubble Sorting");
        BubbleSort.bubbleSort(a);
        System.out.println(a);
    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> input){

        // if
        Boolean inOrder = true;

        for(int i = input.size()-1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(input.get(j) > input.get(j+1)){
                    int temp = input.get(j);
                    // Swap Values
                    input.set(j,input.get(j+1));
                    input.set(j+1, temp);
                    inOrder = false;
                }
            }
            // after one pass of inner loop, if no items were swapped, this indicates that
            // the items are already in order. Hence, no need to process any further.
            if(inOrder == true){
                System.out.println("Already In Order");
                return input;
            }
        }

        return input;

    }
}
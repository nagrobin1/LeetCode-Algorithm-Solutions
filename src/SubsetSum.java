import java.util.ArrayList;
import java.util.Collections;

/**
 * <p>
 * SubSetSum solves the following problem.
 * Given a set of non-negative integers, and a desired sum value,
 * the algorithm determines if there is a subset of the given set
 * with sum equal to the desired sum.
 * <p>
 *
 * @author Robin Nag
 * @version 2.3
 */

public class SubSetSum {

    /**
     * a non-negative integer value
     */
    private int requestedSum;
    /**
     * a collection of non-negative integers
     */
    private ArrayList<Integer> valuesCollection;
    /**
     * the matrix that is generated after performing the subset sum algorithm
     * with the requestedSum and the set of items in valuesCollection
     */
    private boolean[][] subSetSumMatrix;

    /**
     * Constructs a SubSetSum object. Initializes the requestedSum and valuesCollection fields.
     * @param requestedSum a non-negative integer value
     * @param valuesCollection a collection of non-negative integers
     */
    public SubSetSum(int requestedSum, ArrayList<Integer> valuesCollection){
        if(requestedSum >= 0 && requestedSum < Integer.MAX_VALUE - 8 && isAllPositiveIntegers(valuesCollection)){
            subSetSumMatrix = new boolean[valuesCollection.size() + 1][requestedSum + 1];
            this.requestedSum = requestedSum;
            this.valuesCollection = new ArrayList<Integer>(valuesCollection);
        }else{
            throw new IllegalArgumentException("requested sum and values in collection must be >= 0 and less than " +
                    "Integer.MAX_VALUE - 8");
        }
    }

    /**
     * Checks if all the integers in a list are positive.
     * @param valuesCollection a collection of integers
     * @return true if all the integers in the collection are positive, else false
     */
    protected static boolean isAllPositiveIntegers(ArrayList<Integer> valuesCollection) {

        boolean allPositive = true;
        for (Integer item: valuesCollection){
            if(item < 0){
                allPositive = false;}}

        return allPositive;
    }

    /**
     * Determines if there is a subset in valuesCollection
     * with sum equal to requestedSum.
     * @return true if there is a subset of valuesCollection
     * with sum equal to requestedSum, else false
     */
    public boolean isSumPossible() {

        // 0 sum can be made with any values of collection
        for (int i = 0; i <= valuesCollection.size(); i++) {
            subSetSumMatrix[i][0] = true;
        }

        for (int i = 1; i <= valuesCollection.size(); i++) {
            for (int currentSum = 1; currentSum <= requestedSum; currentSum++) {
                // If the current integer is bigger than the currentTotal, then
                // just copy the value from the previous integer
                if(valuesCollection.get(i - 1) > currentSum){
                    subSetSumMatrix[i][currentSum] = subSetSumMatrix[i - 1][currentSum];
                }
                // Else if the current integer is equal or smaller than currentTotal,
                // then we have two options:
                // 1. Possible to make currentTotal by only using past integers, OR
                // 2. Possible to make currentTotal by using the past integers and current integer
                else{
                    subSetSumMatrix[i][currentSum] = subSetSumMatrix[i - 1][currentSum] ||
                            subSetSumMatrix[i - 1][currentSum - valuesCollection.get(i - 1)];
                }
            }
        }

        // the last item in the matrix represents the answer
        return subSetSumMatrix[valuesCollection.size()][requestedSum];
    }

    /**
     * Returns a list of numbers that satisfy the subset sum problem
     * for the given requestedSum and valuesCollection fields.
     * @return a list of numbers if the sum is possible, else an empty list
     */
    public ArrayList<Integer> sumSolutionList(){

        ArrayList<Integer> solutionList = new ArrayList<>();

        if(this.isSumPossible()){
            // Edge Case: Only 0 in list and want 0
            if(subSetSumMatrix[subSetSumMatrix.length-1].length == 1 && valuesCollection.contains(0)){
                solutionList.add(0);
            }else{
                // Start from the bottom-right corner and backtrack and check from the true is coming
                this.backTrackSubSetSumMatrix(subSetSumMatrix, subSetSumMatrix.length-1,
                        subSetSumMatrix[subSetSumMatrix.length-1].length - 1, solutionList, valuesCollection);
            }
        }

        Collections.sort(solutionList);
        return solutionList;
    }

    /**
     * EFFECT: inserts integers to solutionList based on backtracking
     * @param subSetSumMatrix the solved boolean matrix for subset sum algorithm
     * @param i row index
     * @param j column index
     * @param solutionList the result list that holds the integers that sum to requestedSum from valuesCollection
     * @param valuesCollection a list of integers
     */
    private void backTrackSubSetSumMatrix(boolean [][] subSetSumMatrix, int i, int j,
                                                 ArrayList<Integer> solutionList, ArrayList <Integer> valuesCollection){
        // Base Case
        if(j == 0){
            return;}
        // If value in the cell above if false that means current cell has become true after including the current
        // element. Thus, include the current element and repeat process.
        else if(subSetSumMatrix[i-1][j] == false){
            solutionList.add(valuesCollection.get(i-1));
            backTrackSubSetSumMatrix(subSetSumMatrix, i-1, j-valuesCollection.get(i-1), solutionList, valuesCollection);
        }else{
            backTrackSubSetSumMatrix(subSetSumMatrix, i-1, j, solutionList, valuesCollection);
        }
    }
}

/**
 * Created by test on 4/4/17.
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

 Given two integers x and y, calculate the Hamming distance.

 Note:
 0 ≤ x, y < 2^31
 */
public class HammingDistance {

    public static int hammingDistance(int x, int y) {

        // ^ is the xor operator
        // z holds the result of x XOR y
        int z = x ^ y;

        // When we convert z to binary, all the
        // positions that have 1 are the locations
        // where x and y were different. This happens when the bits
        // compare in the following manner:
        // X = 0 ,Y = 1.... X^Y = 1
        // X = 1, Y = 0...  X^Y = 1

        // If we know the count of 1's that appear in the binary
        // form of z, we will know the number of conflicting bits
        // bitCount returns the number of 1's in the binary form of an integer

        int numberOfBitDifferences = Integer.bitCount(z);

        return numberOfBitDifferences;

        /*
        Example:
        1 =  (0 0 0 1)
        4 =  (0 1 0 0)
        -------------- APPLY XOR ^. 1 ^ 4 = 5
        5 =  (0 1 0 1)
                *   *
        So 2 positions at which the corresponding bits are different in x and y.
        The * positions are where the bits of x and y differed, since the XOR output is 1
        only when the two operands are different (1,0) or (0,1).

        */
    }

    public static void main(String [] args){

        // Should give 2
        System.out.println(hammingDistance(1,4));


    }
}

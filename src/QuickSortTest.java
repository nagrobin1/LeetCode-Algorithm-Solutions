import org.junit.Assert;

import java.util.Arrays;

/**
 * Created by test on 1/26/17.
 */
public class QuickSortTest {

    public void quickSort() throws Exception {
        System.out.println("Test");
        int [] a = {8,9,-9,0};
        QuickSort.quickSort(a,0, a.length-1);
        int [] b = a.clone();
        Arrays.sort(b);
        Assert.assertArrayEquals( b, a );
    }

    public void quickSort2() throws Exception {
        System.out.println("Test");
        int [] b = {3,2};
        QuickSort.quickSort(b,0, b.length-1);
        int [] c = b.clone();
        Arrays.sort(c);
        Assert.assertArrayEquals( c, b );

    }

}
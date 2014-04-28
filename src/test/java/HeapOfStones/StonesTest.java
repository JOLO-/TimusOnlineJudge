package HeapOfStones;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class StonesTest {

    @Test
    public void getOptimalSum_test() {
        Integer[] array1 = new Integer[] {15, 14, 8, 7, 6, 5, 3};
        Integer[] array2 = new Integer[] {27, 14, 13, 8, 5};
        Integer[] array3 = new Integer[] {15, 9, 7, 4, 3, 2};
        Integer[] array4 = new Integer[] {24, 16, 9, 7, 6, 4, 2, 1};
        Integer[] array5 = new Integer[] {24};
        Integer[] array6 = new Integer[] {95, 24};

        assertEquals(29, Stones.getOptimalSum(array1));
        assertEquals(32, Stones.getOptimalSum(array2));
        assertEquals(20, Stones.getOptimalSum(array3));
        assertEquals(34, Stones.getOptimalSum(array4));
        assertEquals(0, Stones.getOptimalSum(array5));
        assertEquals(24, Stones.getOptimalSum(array6));
    }

    @Test
    public void calDifference_test() {
        Integer[] array1 = new Integer[] {15, 14, 8, 7, 6, 5, 3};
        Integer[] array2 = new Integer[] {27, 14, 13, 8, 5};
        Integer[] array3 = new Integer[] {15, 9, 7, 4, 3, 2};
        Integer[] array4 = new Integer[] {24, 16, 9, 7, 6, 4, 2, 1};
        Integer[] array5 = new Integer[] {24};
        Integer[] array6 = new Integer[] {95, 24};

        assertEquals(0, Stones.calcDifference(array1));
        assertEquals(3, Stones.calcDifference(array2));
        assertEquals(0, Stones.calcDifference(array3));
        assertEquals(1, Stones.calcDifference(array4));
        assertEquals(24, Stones.calcDifference(array5));
        assertEquals(71, Stones.calcDifference(array6));
    }
}

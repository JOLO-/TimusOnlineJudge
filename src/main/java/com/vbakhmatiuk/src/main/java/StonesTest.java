import junit.framework.Assert;
import org.junit.Test;

public class StonesTest {

    @Test
    public void getOptimalSum_test() {
        Integer[] array1 = new Integer[] {15, 14, 8, 7, 6, 5, 3};
        Integer[] array2 = new Integer[] {27, 14, 13, 8, 5};
        Integer[] array3 = new Integer[] {15, 9, 7, 4, 3, 2};

        Assert.assertEquals(29, Stones.getOptimalSum(array1));
        Assert.assertEquals(32, Stones.getOptimalSum(array2));
        Assert.assertEquals(20, Stones.getOptimalSum(array3));
    }

    @Test
    public void calDifference_test() {
        Integer[] array1 = new Integer[] {15, 14, 8, 7, 6, 5, 3};
        Integer[] array2 = new Integer[] {27, 14, 13, 8, 5};
        Integer[] array3 = new Integer[] {15, 9, 7, 4, 3, 2};

        Assert.assertEquals(0, Stones.calcDifference(array1));
        Assert.assertEquals(3, Stones.calcDifference(array2));
        Assert.assertEquals(0, Stones.calcDifference(array3));

    }
}

package ProductOfDigits;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;

public class ProductOfDigitsTest {

    @Test
    public void factoring_test() {
        List<Integer> list1 = new LinkedList<Integer>() {{
            add(2);
            add(5);
            add(10);
        }};
        assertEquals(list1, ProductOfDigits.factoring(10));

        List<Integer> list2 = new LinkedList<Integer>() {{
            add(2); add(3); add(5); add(6); add(7);
            add(10); add(14); add(15); add(21); add(30);
            add(35); add(42); add(70); add(105); add(210);
        }};
        assertEquals(list2, ProductOfDigits.factoring(210));
    }

    @Test
    public void getResult_test() {
        assertEquals(0, ProductOfDigits.getResult(0));
        assertEquals(1, ProductOfDigits.getResult(1));
        assertEquals(25, ProductOfDigits.getResult(10));
    }
}

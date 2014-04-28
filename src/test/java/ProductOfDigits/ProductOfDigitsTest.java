package ProductOfDigits;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;

public class ProductOfDigitsTest {

    @Test
    public void isFactorialPrime_test() {
        List<Integer> factorials1 = new LinkedList<Integer>() {{
            add(2);
            add(3);
        }};
        assertTrue(ProductOfDigits.isFactorialPrime(factorials1, 7));
        assertFalse(ProductOfDigits.isFactorialPrime(factorials1, 6));
    }

    @Test
    public void factoring_test() {
        List<Integer> list1 = new LinkedList<Integer>() {{
            add(2);
            add(5);
        }};
        assertEquals(list1, ProductOfDigits.factoring(10));
    }
}

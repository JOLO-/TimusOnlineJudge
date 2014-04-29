package ProductOfDigits;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static junit.framework.Assert.assertEquals;

public class ProductOfDigitsTest {

    @Test
    @Ignore
    public void getResult_test() {
        assertEquals(new Long(-1), ProductOfDigits.getQForN(997));
        assertEquals(new Long(10), ProductOfDigits.getQForN(0));
        assertEquals(new Long(1), ProductOfDigits.getQForN(1));
        assertEquals(new Long(2), ProductOfDigits.getQForN(2));
        assertEquals(new Long(3), ProductOfDigits.getQForN(3));
        assertEquals(new Long(4), ProductOfDigits.getQForN(4));
        assertEquals(new Long(25), ProductOfDigits.getQForN(10));
        assertEquals(new Long(26), ProductOfDigits.getQForN(12));
        assertEquals(new Long(457), ProductOfDigits.getQForN(140));
        assertEquals(new Long(2578899), ProductOfDigits.getQForN(362880));
        assertEquals(new Long("555555555888"), ProductOfDigits.getQForN(1000000000));

    }
}

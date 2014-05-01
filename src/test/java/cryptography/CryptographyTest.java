package cryptography;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class CryptographyTest {

    @Test
    public void getNextPrime_test() {
        assertEquals(2, Cryptography.getNPrime(1));
        assertEquals(3, Cryptography.getNPrime(2));
        assertEquals(5, Cryptography.getNPrime(3));
        assertEquals(7, Cryptography.getNPrime(4));
        assertEquals(11, Cryptography.getNPrime(5));
        assertEquals(71, Cryptography.getNPrime(20));
        assertEquals(173, Cryptography.getNPrime(40));
        assertEquals(7919, Cryptography.getNPrime(1000));
        assertEquals(17389, Cryptography.getNPrime(2000));
        assertEquals(27449, Cryptography.getNPrime(3000));
        assertEquals(37813, Cryptography.getNPrime(4000));
        assertEquals(48611, Cryptography.getNPrime(5000));
        assertEquals(59359, Cryptography.getNPrime(6000));
        assertEquals(70657, Cryptography.getNPrime(7000));
        assertEquals(81799, Cryptography.getNPrime(8000));
        assertEquals(93179, Cryptography.getNPrime(9000));
        assertEquals(104729, Cryptography.getNPrime(10000));
        assertEquals(110597, Cryptography.getNPrime(10500));
        assertEquals(116447, Cryptography.getNPrime(11000));
        assertEquals(122251, Cryptography.getNPrime(11500));
        assertEquals(128189, Cryptography.getNPrime(12000));
        assertEquals(134053, Cryptography.getNPrime(12500));
        assertEquals(139901, Cryptography.getNPrime(13000));
        assertEquals(145931, Cryptography.getNPrime(13500));
        assertEquals(151703, Cryptography.getNPrime(14000));
        assertEquals(157739, Cryptography.getNPrime(14500));
        assertEquals(163841, Cryptography.getNPrime(15000));
    }

    @Test
    public void performance_test() {
        long beg = System.nanoTime();
        Cryptography.getNPrime(14996);
        Cryptography.getNPrime(14997);
        Cryptography.getNPrime(14998);
        Cryptography.getNPrime(14999);
        Cryptography.getNPrime(15000);
        long end = System.nanoTime();
        long time = TimeUnit.MILLISECONDS.convert(end - beg, TimeUnit.NANOSECONDS);
        System.out.println(time + " milliseconds");
        assertTrue(time < 2000);
    }
}
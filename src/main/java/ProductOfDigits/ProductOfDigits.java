package ProductOfDigits;

import java.io.PrintWriter;
import java.util.*;

public class ProductOfDigits {

    private final static int[] primes = new int[] {11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67,
                                      71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149,
                                      151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229,
                                      233, 239,	241, 251, 257, 263,	269, 271, 277, 281, 283, 293, 307, 311,	313,
                                      317, 331,	337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409,
                                      419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499,
                                      503, 509,	521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601,
                                      607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691,
                                      701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809,
                                      811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907,
                                      911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int number = in.nextInt();

        int answer = getResult(number);
        out.println(answer);
        out.flush();
    }

    /**
     * Returns the smallest natural, product of numbers of which equals {@code number}
     * @param number
     * @return
     */
    protected static int getResult(int number) {
        if (number == 0) return 0;
        if (number == 1) return 1;
        List<Integer> result = new LinkedList<Integer>();
        List<Integer> factorials = factoring(number);
        while (!factorials.isEmpty()) {
            int next = -1;
            for (int i = 0; i < factorials.size() && factorials.get(i) < 10; i++) next = factorials.get(i);
            if (next != -1) {
                result.add(0, next);
                number = number / next;
                factorials = factoring(number);
            } else  {
                throw new IllegalStateException("Can represent those number as product of numbers. " +
                        "Reason: it contains at least on prime multiplier greater than 10.");
            }
        }
        //make number from list of integers
        StringBuilder builder = new StringBuilder();
        for (Integer i : result) {
            builder.append(i);
        }
        return new Integer(builder.toString());
    }

    /**
     * Returns all factorials of {@code number} except of 1 and number
     * @param number
     * @return
     */
    protected static List<Integer> factoring(int number) {
        List<Integer> factorials = new ArrayList<Integer>();
        int factoringNumber = 2;
        while (factoringNumber <= number / 2) {
            if (number % factoringNumber == 0) {
                addMultiplier(factorials, factoringNumber);
            }
            factoringNumber++;
        }
        if (number != 1) addMultiplier(factorials, number);
        return factorials;
    }

    private static void addMultiplier(List<Integer> list, int multiplier) {
        if (!hasPrime(list, multiplier)) {
            list.add(multiplier);
        } else {
            throw new IllegalArgumentException("Can represent those number as product of numbers. " +
                    "Reason: it contains at least on prime multiplier greater than 10.");
        }
    }

    /**
     * Check if {@code number} has prime multiplier which is greater than 7. If number has that multiplier it means
     * that we can't represent it as product of numbers.
     * @param factorials
     * @param number
     * @return {@code true} if has, {@code false} otherwise.
     */
    private static boolean hasPrime(List<Integer> factorials, int number) {
        if (isPrimeRelPrevFactorials(factorials, number)) return false;
        else {
            if (number < 1000) {
                for (int i = 0; i < primes.length && number >= primes[i] ; i++) {
                    if (number % primes[i] == 0) return true;
                }
                return false;
            } else {
                //TODO: implement checking if number is prime
                throw new IllegalArgumentException("This program doesn't support so big prime numbers");
            }
        }
    }

    /**
     * Checks whether current number is divided minimum by one of the numbers in {@code factorials} collection
     * @param factorials
     * @param number natural number to check
     * @return {@code true} if {@code number} is prime relatively all elements in {@code factorials} collection
     */
    private static boolean isPrimeRelPrevFactorials(List<Integer> factorials, int number) {
        for (int i : factorials) {
            if (number % i == 0) return false;
        }
        return true;
    }

}

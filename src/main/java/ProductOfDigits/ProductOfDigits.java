package ProductOfDigits;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ProductOfDigits {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int number = in.nextInt();

//        int answer = getProductOfDigitsNumber(number);

//        out.println(answer);
        out.flush();
    }

    protected static int formMinimumNaturalFromFactorials(List<Integer> factorials, int number) {
        if (factorials.isEmpty()) {
            if (number > 9) throw new IllegalArgumentException("You pass an prime number that is more than 9");
            else return number;
        }

        return 0; //TODO: remove
    }


    /**
     * Returns all factorials of {@code number} except of 1 and number
     * @param number
     * @return
     */
    protected static List<Integer> factoring(int number) {
        List<Integer> factorials = new ArrayList<Integer>();
        int factoringNumber = 2;
        while (factoringNumber < number) {
            if (number % factoringNumber == 0) {
                if (isFactorialPrime(factorials, factoringNumber)) {
                    factorials.add(factoringNumber);
                }
            }
            factoringNumber++;
        }
        return factorials;
    }

    /**
     * Check whether factorial is a multiplication of already added factorials
     * @param factorials
     * @param factorial
     * @return
     */
    protected static boolean isFactorialPrime(List<Integer> factorials, int factorial) {
        for (Integer num : factorials) {
            if (factorial % num == 0) {
                if (factorials.contains(factorial / num))
                    return false;
            }
        }
        return true;
    }
}

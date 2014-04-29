package ProductOfDigits;

import java.io.PrintWriter;
import java.util.*;

public class ProductOfDigits {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int number = in.nextInt();

        long answer = getQForN(number);
        out.println(answer);
        out.flush();
    }

    /**
     * Returns the smallest natural, product of numbers of which equals {@code number}
     * @param number
     * @return
     */
    protected static Long getQForN(int number) {
        if (number < 0) return new Long(-1);
        if (number == 0) return new Long(10);
        if (number == 1) return new Long(1);

        int N = number;
        List<Integer> multipliers = new LinkedList<Integer>();
        for (int i = 9; i > 1; i--) {
            while (N % i == 0) {
                multipliers.add(0, i);
                N = N / i;
            }
        }
        String Q = "";
        for (int i : multipliers) Q += i;
        return (N == 1) ? new Long(Q) : -1;
    }
}

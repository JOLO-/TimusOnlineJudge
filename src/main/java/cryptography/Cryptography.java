package cryptography;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cryptography {

    private final static int FIRST_PRIME = 2;
    private final static int SECOND_PRIME = 3;
    private final static int ADVANCE = 2;

    private final static Map<Integer, Integer> primesByOrder = new HashMap<Integer, Integer>();

    static {
        primesByOrder.put(1000, 7919);
        primesByOrder.put(2000, 17389);
        primesByOrder.put(3000, 27449);
        primesByOrder.put(4000, 37813);
        primesByOrder.put(5000, 48611);
        primesByOrder.put(6000, 59359);
        primesByOrder.put(7000, 70657);
        primesByOrder.put(8000, 81799);
        primesByOrder.put(9000, 93179);
        primesByOrder.put(10000, 104729);
        primesByOrder.put(10500, 110597);
        primesByOrder.put(11000, 116447);
        primesByOrder.put(11500, 122251);
        primesByOrder.put(12000, 128189);
        primesByOrder.put(12500, 134053);
        primesByOrder.put(13000, 139901);
        primesByOrder.put(13500, 145931);
        primesByOrder.put(14000, 151703);
        primesByOrder.put(14500, 157739);
        primesByOrder.put(15000, 163841);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int size = in.nextInt();
        for (int i = 0; i < size; i++) {
            int serialNumber = in.nextInt();
            int nPrime = getNPrime(serialNumber);
            primesByOrder.put(serialNumber, nPrime);
            out.println(nPrime);
        }
        out.flush();
    }

    protected static int getNPrime(int n) {
        if (n == 1) return FIRST_PRIME;
        if (n == 2) return SECOND_PRIME;

        int prime = SECOND_PRIME;
        int count = 2;
        for (int i : primesByOrder.keySet()) {
            if (n > i) {
                count = i;
                prime = primesByOrder.get(i);
            } else break;
        }

        while (count < n) {
            prime += ADVANCE;
            boolean isPrime = true;
            for (int i = FIRST_PRIME; i * i <= prime; i++) {
                if (prime % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) count++;
        }
        return prime;
    }
}

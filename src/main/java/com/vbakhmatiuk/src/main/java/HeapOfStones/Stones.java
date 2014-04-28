package HeapOfStones;

import java.io.*;
import java.util.*;

public class Stones {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int amount = in.nextInt();
        Integer[] weight = new Integer[amount];
        for (int i = 0; i < amount; i++)
            weight[i] = in.nextInt();

        int answer = calcDifference(weight);

        out.println(answer);
        out.flush();
    }

    protected static int calcDifference(Integer[] array) {
        int sum = sum(array);
        int med = sum / 2;
        int optimalSum = getOptimalSum(array, med);
        int answer = Math.abs(sum - 2 * optimalSum);
        return answer;
    }


    protected static int getOptimalSum(Integer[] array) {
        int median = sum(array) / 2;
        return getOptimalSum(array, median);
    }

    private static int getOptimalSum(Integer[] array, int median) {
        sortInReverseOrder(array); //TODO: check if necessary
        return getOptimalSum(array, median, 0, 0);
    }

    private static int sum(Integer[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++)
            sum += array[i];
        return sum;
    }

    private static void sortInReverseOrder(Integer[] array) {
        Arrays.sort(array, Collections.reverseOrder());
    }

    /**
     * Find the most close but less than {@code arrayMedian} summary of the array's elements
     *
     * @param array
     * @param arrayMedian  equals {@sum}/2, where {@code sum} equals to the summary of all array elements
     * @param currentSum
     * @param currentIndex
     * @return
     */
    private static int getOptimalSum(Integer[] array, int arrayMedian, int currentSum, int currentIndex) {
        if (currentIndex >= array.length) return currentSum;

        int nextSum = currentSum + array[currentIndex];

        if (nextSum > arrayMedian) { //just skip current element
            return getOptimalSum(array, arrayMedian, currentSum, currentIndex + 1);
        } else if (nextSum == arrayMedian) { //we find the median!
            return arrayMedian;
        } else { // if (nextSum < arrayMedian) { //check whether current element belongs to median
            int sum1 = getOptimalSum(array, arrayMedian, nextSum, currentIndex + 1);
            int sum2 = getOptimalSum(array, arrayMedian, currentSum, currentIndex + 1);
            return Math.max(sum1, sum2);
        }
    }
}
import java.util.Arrays;
import java.util.Scanner;

/*

https://www.hackerrank.com/challenges/mini-max-sum

Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers.
Then print the respective minimum and maximum values as a single line of two space-separated long integers.

 * Input Format

A single line of five space-separated integers.

 * Constraints

Each integer is in the inclusive range [1,10^9].

 * Output Format

Print two space-separated long integers denoting the respective minimum and maximum values that can be
calculated by summing exactly four of the five integers.
(The output can be greater than 32 bit integer.)
 */

public class MinMaxSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }

        long min = minSum(arr);
        long max = maxSum(arr);

        System.out.println(min + " " + max);
    }

    public static long maxSum(int[] arr) {
        return Arrays.stream(arr)
                .sorted()
                .skip(1)
                .asLongStream()
                .reduce(0, (a, b) -> a + b);
    }

    public static long minSum(int[] arr) {
        return Arrays.stream(arr)
                .sorted()
                .limit(arr.length - 1)
                .asLongStream()
                .reduce(0, (a, b) -> a + b);
    }
}
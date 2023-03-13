package io.github.paul66666.pe;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static io.github.paul66666.pe.Utl.msg;

// Multiples of 3 or 5
//
// Problem 1
// If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
// The sum of these multiples is 23.
//
// Find the sum of all the multiples of 3 or 5 below 1000.
public class Problem1 {
    public static void main(String[] args) {
        msg("Started");
        int belowThis = 1000;

        long ans1 = attempt1(belowThis);
        msg("1 sum of natural numbers below %d is %d", belowThis, ans1);
        long ans2 = attempt2(belowThis);
        msg("2 sum of natural numbers below %d is %d", belowThis, ans2);
    }

    static long attempt1(int belowThis) {
        long sum = 0;
        for(int i = 0; i < belowThis; i++) {
            if (isMultipleOf(i, 3) || isMultipleOf(i, 5)) {
                sum += i;
            }
        }
        return sum;
    }

    static long attempt2(int belowThis) {
        long sum3 = LongStream.iterate(0, i -> i<belowThis, i -> i+3).sum();
        long sum5 = LongStream.iterate(0, i -> i<belowThis, i -> i+5).sum();
        long sum15 = IntStream.iterate(0, i -> i<belowThis, i -> i+15).sum();
        msg("sum3=%d, sum5=%d, sum15=%d", sum3, sum5, sum15);
        return sum3+sum5-sum15;
    }

    static boolean isMultipleOf(int i, int multiple) {
        return (i%multiple == 0);
    }
}

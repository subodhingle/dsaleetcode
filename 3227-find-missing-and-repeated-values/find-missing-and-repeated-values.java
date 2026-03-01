import java.util.*;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long actualSum = 0, actualSquareSum = 0;
        int n = grid.length;
        long N = (long) n * n;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                actualSum += num;
                actualSquareSum += (long) num * num;
            }
        }

        long expectedSum = (N * (N + 1)) / 2;
        long expectedSquareSum = (N * (N + 1) * (2 * N + 1)) / 6;

        long sumDifference = actualSum - expectedSum;
        long squareSumDifference = actualSquareSum - expectedSquareSum;

        long sumAB = squareSumDifference / sumDifference;

        int repeated = (int) ((sumAB + sumDifference) / 2);
        int missing = (int) ((sumAB - sumDifference) / 2);

        return new int[]{repeated, missing};
    }
}
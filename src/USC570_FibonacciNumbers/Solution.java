package USC570_FibonacciNumbers;

/**
 * Tabulation
 */
public class Solution {
    int fibonacci(int n) {
        int[] res = new int[n];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i < n; i ++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n - 1];
    }
}


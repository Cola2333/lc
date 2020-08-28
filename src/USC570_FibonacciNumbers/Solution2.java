package USC570_FibonacciNumbers;

/**
 * memorization
 */
public class Solution2 {
    int fibonacci(int n) {
        int[] res = new int[n];
        res[0] = 1;
        res[1] = 1;
        return fibonacci(n - 1, res);
    }

    int fibonacci(int n, int[] res) {
        if (res[n] != 0) {
            return res[n];
        }
        return fibonacci(n - 1, res) + fibonacci(n - 2, res);
    }
}

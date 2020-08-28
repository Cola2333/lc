package USC570_FibonacciNumbers;

public class Solution3 {
    int fibonacci(int n) {
        int a = 1;
        int b = 1;
        int c = 0;
        for (int i = 3; i <= n; i ++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}

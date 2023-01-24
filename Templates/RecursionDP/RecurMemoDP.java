package RecursionDP;
import java.util.*;
public class RecurMemoDP {
    /*
        Recursion:
            - Slow and requires lots of memory
            - Simple to implement
            - Generally a "top-down" approach
        Dynamic Programming:
            - Better Time and Space Complexity
            - Could be harder to implement due to the "bottom-up" approach
        Memoization:
            - Improves time complexity
            - Could still require lots of memory
        Recursion --> Recursion + Memo --> Dynamic Programming -->  Dynamic Programming + Memo
        Example: Fibonacci
     */
// =====================================================================================================================
    public int fibRecur(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        return fibRecur(n-1) + fibRecur(n-2);
    }
// =====================================================================================================================
    public int fibRecurMemo(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1); // Initialize the memo array with -1
        return fibRecurMemo(n, memo);
    }
    public int fibRecurMemo(int n, int[] memo) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        // Check if it has been Calculated
        if (memo[n] != -1) return memo[n];
        memo[n] = fibRecurMemo(n-1, memo) + fibRecurMemo(n-2, memo);

        return memo[n];
    }
// =====================================================================================================================
    public int fibDP(int n) {
        int[] dp = new int[n + 1];
        // Start from the bottom
        dp[0] = 0;
        dp[1] = 1;
        // Go-Up
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
// =====================================================================================================================
    public int fibDPMemo(int n) {
        // Using Map for memoization | Array Implementation is Similar to Recursion + Memo
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 0);
        memo.put(1, 1);
        return fibDPMemo(n, memo);
    }

    private int fibDPMemo(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        memo.put(n, fibDPMemo(n-1, memo) + fibDPMemo(n-2, memo));
        return memo.get(n);
    }
}

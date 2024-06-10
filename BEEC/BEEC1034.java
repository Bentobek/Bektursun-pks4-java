import java.util.Arrays;
import java.util.Scanner;

public class BEEC1034 {

    static final int N = 1000002;

    static int[] dp = new int[N];

    static int blocks(int[] values, int n, int m) {
        int i, j, k;

        if (m % values[n - 1] == 0) return m / values[n - 1];

        Arrays.fill(dp, 999999);
        dp[0] = 0;

        for (i = 0; i < n; i++) {
            k = values[i];
            for (j = k; j <= m; j++) {
                dp[j] = Math.min(dp[j], dp[j - k] + 1);
            }
        }

        return dp[m];
    }

    static class CustomComparator implements java.util.Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return a - b;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] values = new int[26];
        int t, n, m;
        int i, j;

        t = scanner.nextInt();
        for (i = 0; i < t; i++) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            for (j = 0; j < n; j++) values[j] = scanner.nextInt();
            Arrays.sort(values, 0, n);
            System.out.println(blocks(values, n, m));
        }
    }
}

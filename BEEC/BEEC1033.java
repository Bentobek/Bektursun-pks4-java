import java.util.Scanner;

class BEEC1033 {

    static class Matrix {
        long[][] mat = new long[2][2];
    }

    static Matrix matMul(Matrix a, Matrix b, long m) {
        Matrix ans = new Matrix();
        for (int i = 0; i < 2; ++i)
            for (int j = 0; j < 2; ++j)
                for (int k = 0; k < 2; ++k)
                    ans.mat[i][j] = (ans.mat[i][j] + (a.mat[i][k] * b.mat[k][j]) % m) % m;
        return ans;
    }

    static long matPow(Matrix base, long p, long m) {
        Matrix ans = new Matrix();
        for (int i = 0; i < 2; ++i)
            for (int j = 0; j < 2; ++j)
                ans.mat[i][j] = (i == j) ? 1 : 0;
        while (p > 0) {
            if ((p & 1) == 1)
                ans = matMul(ans, base, m);
            base = matMul(base, base, m);
            p >>= 1;
        }
        return ans.mat[0][0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = 1;
        while (true) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            if (a + b == 0)
                break;
            Matrix ans = new Matrix();
            ans.mat[0][0] = ans.mat[0][1] = ans.mat[1][0] = 1;
            ans.mat[1][1] = 0;
            if (a <= 1)
                System.out.printf("Case %d: %d %d 1\n", t++, a, b);
            else
                System.out.printf("Case %d: %d %d %d\n", t++, a, b, (2 * matPow(ans, a, b) - 1 + b) % b);
        }
        scanner.close();
    }
}

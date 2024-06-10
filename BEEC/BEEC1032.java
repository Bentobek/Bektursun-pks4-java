import java.util.Scanner;

public class BEEC1032 {
    static int[] prime = new int[32650];

    public static int flavious(int n) {
        int r = 0;
        for (int i = 1; i <= n; i++) {
            r = (r + prime[n - i]) % i;
        }
        return r;
    }

    public static boolean isPrime(int n) {
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void primeNumbers() {
        int a = 0;
        for (int j = 2; j < prime.length; j++) {
            if (isPrime(j)) {
                prime[a] = j;
                a++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        primeNumbers();

        while (true) {
            int x = scanner.nextInt();
            if (x == 0) break;
            System.out.println(flavious(x) + 1);
        }
        scanner.close();
    }
}

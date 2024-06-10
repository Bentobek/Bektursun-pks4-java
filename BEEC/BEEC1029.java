import java.util.Scanner;

public class BEEC1029 {

    static int calls;
    static int fib(int n) {
        calls++;
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            calls = -1;
            int X = scanner.nextInt();
            int result = fib(X);
            System.out.println("fib(" + X + ") = " + calls + " calls = " + result);
        }

        scanner.close();
    }
}
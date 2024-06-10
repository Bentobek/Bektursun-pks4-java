import java.util.Scanner;

public class BEEC1030 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int NC = scanner.nextInt();

        for (int i = 1; i <= NC; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int survivor = josephus(n, k);

            System.out.println("Case " + i + ": " + survivor);
        }

        scanner.close();
    }

    public static int josephus(int n, int k) {
        if (n == 1)
            return 1;
        else
            return (josephus(n - 1, k) + k - 1) % n + 1;
    }
}

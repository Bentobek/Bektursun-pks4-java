import java.util.Scanner;

public class BEEC1028 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int f1 = scanner.nextInt();
            int f2 = scanner.nextInt();
            int gcd = gcd(f1, f2);

            int maxStackSize = gcd;
            System.out.println(maxStackSize);
        }

        scanner.close();
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

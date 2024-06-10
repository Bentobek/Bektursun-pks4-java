import java.util.Scanner;

public class BEEC1021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double value = scanner.nextDouble();

        int cents = (int) (value * 100);

        int[] notes = {10000, 5000, 2000, 1000, 500, 200};
        int[] coins = {100, 50, 25, 10, 5, 1};

        System.out.println("NOTAS:");
        for (int note : notes) {
            int count = cents / note;
            System.out.printf("%d nota(s) de R$ %.2f\n", count, note / 100.0);
            cents %= note;
        }

        System.out.println("MOEDAS:");
        for (int coin : coins) {
            int count = cents / coin;
            System.out.printf("%d moeda(s) de R$ %.2f\n", count, coin / 100.0);
            cents %= coin;
        }

        scanner.close();
    }
}

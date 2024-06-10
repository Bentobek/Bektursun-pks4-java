import java.util.Scanner;

public class BEEC1010 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int codeProduct1 = scanner.nextInt();
        int unitsProduct1 = scanner.nextInt();
        double priceProduct1 = scanner.nextDouble();

        int codeProduct2 = scanner.nextInt();
        int unitsProduct2 = scanner.nextInt();
        double priceProduct2 = scanner.nextDouble();

        double totalAmount = (unitsProduct1 * priceProduct1) + (unitsProduct2 * priceProduct2);

        System.out.printf("VALOR A PAGAR: R$ %.2f%n", totalAmount);

        scanner.close();
    }
}

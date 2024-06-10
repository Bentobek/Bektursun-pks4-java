import java.util.Scanner;

public class BEEC1011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double radius = scanner.nextDouble();

        double volume = (4.0 / 3.0) * 3.14159 * Math.pow(radius, 3);

        System.out.printf("VOLUME = %.3f\n", volume);

        scanner.close();
    }
}

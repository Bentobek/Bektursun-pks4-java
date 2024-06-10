import java.util.Scanner;

public class BEEC1017 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int time = scanner.nextInt();
        int speed = scanner.nextInt();

        double distance = time * speed;

        double fuelNeeded = distance / 12.0;

        System.out.printf("%.3f\n", fuelNeeded);

        scanner.close();
    }
}

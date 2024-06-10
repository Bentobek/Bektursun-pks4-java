import java.util.Scanner;

public class BEEC1019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int seconds = scanner.nextInt();

        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int remainingSeconds = seconds % 60;

        System.out.printf("%d:%02d:%02d\n", hours, minutes, remainingSeconds);

        scanner.close();
    }
}

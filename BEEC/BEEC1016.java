import java.util.Scanner;

public class BEEC1016 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int distance = scanner.nextInt();

        int time = distance * 2;

        System.out.println(time + " minutos");

        scanner.close();
    }
}

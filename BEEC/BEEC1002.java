import java.util.Scanner;

public class BEEC1002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double R = scanner.nextDouble();
        double pi = 3.14159;
        double A = pi * Math.pow(R, 2);
        System.out.printf("A=%.4f\n", A);
    }
}

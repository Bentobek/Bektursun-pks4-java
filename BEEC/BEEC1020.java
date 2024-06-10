import java.util.Scanner;

public class BEEC1020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ageInDays = scanner.nextInt();

        int years = ageInDays / 365;
        int months = (ageInDays % 365) / 30;
        int days = (ageInDays % 365) % 30;

        System.out.println(years + " ano(s)");
        System.out.println(months + " mes(es)");
        System.out.println(days + " dia(s)");

        scanner.close();
    }
}

import java.util.Scanner;

public class BEEC1009 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String name = input.nextLine();
        double salary = Double.parseDouble(input.nextLine());
        double totalSales = Double.parseDouble(input.nextLine());

        double totalSalary = salary + (totalSales * 0.15);

        System.out.printf("TOTAL = R$ %.2f%n", totalSalary);

        input.close();
    }
}

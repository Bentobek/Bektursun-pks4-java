import java.util.Scanner;

public class BEEC1031 {
    public static int res(int x, int aux) {
        int aux1 = 0;
        for (int i = 1; i < x; i++) {
            aux1 = (aux1 + aux) % i;
        }
        return aux1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int x = scanner.nextInt();
            if (x == 0) break;
            int aux = 1;
            while (res(x, aux) + 2 != 13) {
                aux++;
            }
            System.out.println(aux);
        }
    }
}

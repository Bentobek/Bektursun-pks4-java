import java.util.Scanner;
public class BEEC1018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(N);
        int[] banknotes = {100, 50, 20, 10, 5, 2, 1};
        for (int note : banknotes) {
            int count = N / note;
            System.out.println(count + " nota(s) de R$ " + note + ",00");
            N %= note;
        }
    }
}

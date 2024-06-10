import java.util.Arrays;
import java.util.Scanner;

public class BEEC1027 {
    static final int MAX = 1010;
    static int[] t = new int[MAX];
    static int[] b = new int[MAX];
    static Pair[] coord = new Pair[MAX];

    static class Pair implements Comparable<Pair> {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int compareTo(Pair other) {
            if (this.first != other.first)
                return this.first - other.first;
            return this.second - other.second;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                coord[i] = new Pair(x, y);
            }
            Arrays.sort(coord, 0, n);

            t[0] = 1;
            b[0] = 1;

            for (int i = 1; i < n; i++) {
                int maxtop = 1;
                int maxbot = 1;
                for (int j = 0; j < i; j++) {
                    if (coord[i].first > coord[j].first && coord[i].second == coord[j].second + 2)
                        maxtop = Math.max(maxtop, b[j] + 1);
                    if (coord[i].first > coord[j].first && coord[i].second == coord[j].second - 2)
                        maxbot = Math.max(maxbot, t[j] + 1);
                }
                t[i] = maxtop;
                b[i] = maxbot;
            }

            int maximo = 1;
            for (int i = 0; i < n; i++) {
                maximo = Math.max(maximo, t[i]);
                maximo = Math.max(maximo, b[i]);
            }

            System.out.println(maximo);
        }
    }
}

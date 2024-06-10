import java.util.*;

public class BEEC1025 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = 1;

        while (true) {
            int N = scanner.nextInt();
            int Q = scanner.nextInt();

            if (N == 0 && Q == 0)
                break;

            int[] marbles = new int[N];
            for (int i = 0; i < N; i++) {
                marbles[i] = scanner.nextInt();
            }

            Arrays.sort(marbles);

            System.out.println("CASE# " + testCase++ + ":");

            for (int i = 0; i < Q; i++) {
                int query = scanner.nextInt();
                int position = binarySearch(marbles, query);

                if (position != -1) {
                    System.out.println(query + " found at " + (position + 1));
                } else {
                    System.out.println(query + " not found");
                }
            }
        }
        scanner.close();
    }

    private static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                while (mid > 0 && arr[mid - 1] == target) {
                    mid--;
                }
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
